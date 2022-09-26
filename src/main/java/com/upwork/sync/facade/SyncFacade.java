package com.upwork.sync.facade;

import jakarta.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Singleton
public class SyncFacade {

    private final Map<String, SyncAgent> agents;

    public SyncFacade(List<SyncAgent> syncAgents) {
        agents = buildAgentDictionary(syncAgents);
    }

    private Map<String, SyncAgent> buildAgentDictionary(final List<SyncAgent> syncAgents) {
        return syncAgents.stream().collect(Collectors.toMap(SyncAgent::getSupportedSubType, Function.identity()));
    }

    public Publisher<?> sync(String syncType) {
        SyncAgent syncAgent = resolveAgent(syncType);

        if (syncAgent == null) {
            throw new IllegalArgumentException("Unable to resolve sync type " + syncType);
        }

        return syncAgent.doSync();
    }

    private SyncAgent resolveAgent(String subType) {
        String syncType = StringUtils.trim(subType);

        return agents.get(syncType);
    }
}
