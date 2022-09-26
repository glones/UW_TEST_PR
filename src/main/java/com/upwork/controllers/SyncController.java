
package com.upwork.controllers;

import com.upwork.sync.facade.SyncFacade;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;

@Controller("/sync")
public class SyncController {

    @Inject
    private SyncFacade syncFacade;

    @Get(uri = "/{syncType}")
    public Publisher<?> doSync(String syncType) {
        return syncFacade.sync(syncType);
    }
}