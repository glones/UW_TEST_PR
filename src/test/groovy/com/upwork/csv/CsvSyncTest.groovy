package com.upwork.csv

import com.upwork.controllers.SyncController
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.reactivestreams.Publisher
import spock.lang.Specification

@MicronautTest
class CsvSyncTest extends Specification {

    @Inject
    SyncController syncController

    void 'successful csv sync'() {
        when:
        def result = syncController.doSync("csv-catalog")

        then:
        result instanceof Publisher
    }

}
