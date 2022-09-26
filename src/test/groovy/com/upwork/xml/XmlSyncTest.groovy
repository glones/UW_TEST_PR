package com.upwork.xml

import com.upwork.controllers.SyncController
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import jakarta.inject.Inject
import org.reactivestreams.Publisher
import spock.lang.Specification

@MicronautTest
class XmlSyncTest extends Specification {

    @Inject
    SyncController syncController

    void 'successful xml sync'() {
        when:
        def result = syncController.doSync("xml-catalog")

        then:
        result instanceof Publisher
    }

}
