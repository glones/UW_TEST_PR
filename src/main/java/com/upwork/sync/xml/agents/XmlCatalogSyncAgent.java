package com.upwork.sync.xml.agents;

import com.upwork.sync.SyncTypes;
import com.upwork.sync.facade.SyncAgent;
import com.upwork.sync.xml.services.XmlHttpClient;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class XmlCatalogSyncAgent implements SyncAgent {

    private static final String API_URL = "https://some-xml-api";

    @Inject
    private XmlHttpClient xmlHttpClient;

    @Override
    public Publisher<?> doSync() {
        return xmlHttpClient.fetchData(API_URL);
    }

    @Override
    public String getSupportedSubType() {
        return SyncTypes.XML_CATALOG_SYNC_AGENT;
    }
}
