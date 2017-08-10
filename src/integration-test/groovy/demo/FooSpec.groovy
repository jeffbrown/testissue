package demo

import grails.plugins.rest.client.RestBuilder
import grails.testing.mixin.integration.Integration
import spock.lang.Shared
import spock.lang.Specification

import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.OK

@Integration
class FooSpec extends Specification {

    @Shared
    def rest = new RestBuilder()

    void 'test a valid end point'() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/demo")

        then:
        resp.status == OK.value()
    }

    void 'test an invalid end point'() {
        when:
        def resp = rest.get("http://localhost:${serverPort}/foo")

        then:
        resp.status == NOT_FOUND.value()
    }
}
