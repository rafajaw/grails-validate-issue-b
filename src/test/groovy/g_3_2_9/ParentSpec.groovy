package g_3_2_9

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Parent)
class ParentSpec extends Specification {

    void "child cannot be null"() {
        expect:"fix me"
        !new Parent(child: null).validate(['child'])
    }

    void "test as described in readme"() {
        when:
        def map = [
                "child": ["dummy": "populated"]
        ]
        Parent parent  =  new Parent( map )

        then:
        parent.validate()
    }
}
