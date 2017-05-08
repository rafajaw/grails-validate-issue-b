package g_3_2_9

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Child)
class ChildSpec extends Specification {

    void "dummy cannot be null"() {
        expect:"fix me"
        !new Child(dummy: null).validate(['dummy'])
    }

    void "parent cannot be null"() {
        expect:"fix me"
        !new Child(parent: null).validate(['parent'])
    }
}
