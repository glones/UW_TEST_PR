package com.upwork.sync.csv.agents;

import com.upwork.sync.SyncTypes;
import com.upwork.sync.csv.services.CsvHttpClient;
import com.upwork.sync.facade.SyncAgent;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

@Singleton
public class CsvCatalogSyncAgent implements SyncAgent {

    private static final String API_URL = "https://some-csv-api";

    @Inject
    private CsvHttpClient csvHttpClient;

    @Override
    public Publisher<?> doSync() {
        return csvHttpClient.fetchData(API_URL);
    }

    @Override
    public String getSupportedSubType() {
        return SyncTypes.CSV_CATALOG_SYNC_AGENT;
    }
}
