package com.upwork.sync.json.agents;

import com.upwork.sync.SyncTypes;
import com.upwork.sync.facade.SyncAgent;
import com.upwork.sync.json.services.JsonHttpClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class JsonCatalogDataSyncAgent implements SyncAgent {

    private static final String API_URL = "https://catfact.ninja/fact";

    @Inject
    private JsonHttpClient jsonHttpClient;

    @Override
    public Publisher<?> doSync() {
        return jsonHttpClient.fetchData(API_URL);
    }

    @Override
    public String getSupportedSubType() {
        return SyncTypes.JSON_CATALOG_SYNC_AGENT;
    }
}
