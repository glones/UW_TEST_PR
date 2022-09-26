package com.upwork

import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import jakarta.inject.Inject

@MicronautTest
class PetprSpec extends Specification {

    @Inject
    EmbeddedApplication<?> application

    void 'it works'() {
        expect:
        application.running
    }

}
