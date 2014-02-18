package grs

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(FormController)
class FormControllerSpec extends Specification {

    def setup() {
        
    }

    def cleanup() {
    }

    void "test index"() {
        
        when:
        controller.redirectArgs.action == "displayForm"
        
        then:
        view == "/form/binpackDetails"
    }
    
    def "saving a new compound instance and compound"() {
        
        
    }
    
}