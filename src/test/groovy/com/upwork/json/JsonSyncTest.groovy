package com.upwork.json

import com.upwork.controllers.SyncController
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.reactivestreams.Publisher
import spock.lang.Specification

@MicronautTest
class JsonSyncTest extends Specification {

    @Inject
    SyncController syncController

    void 'successful json sync'() {
        when:
        def result = syncController.doSync("json-catalog")

        then:
        result instanceof Publisher
    }

}
