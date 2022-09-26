package com.upwork.sync.facade;

import org.reactivestreams.Publisher;

public interface SyncAgent {

    Publisher<?> doSync();

    String getSupportedSubType();
}