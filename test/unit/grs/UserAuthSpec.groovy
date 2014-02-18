package grs

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(UserAuth)
class UserAuthSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "authenticate user"() {
    
    setup:
    mockDomain(UserAuth)

    when:
    (userName!=null) && (password!=null) 

    then:
    UserAuth.findByUserNameAndPassword(userName,password) != null

    where:
    userName = "admin"
    password = "root123"
    }
    
    def "userName constraints"() {
    setup:
    mockForConstraintsTests(UserAuth)

    when:
    def user = new UserAuth(password: "root123", fullName: "System Admin")
    //Assignment of possible NULL values must be done via property assignment because assignment via map and constructor now leads to NULL if String is ""
    //See http://grails.org/doc/latest/ref/Constraints/nullable.html for more details
    user.userName = userName
    user.validate()

    then:
    user.hasErrors() == !valid

    where:

    userName | valid
    "123456789012345678901" | false //Firstname must not have more than 20 characters 
    "12345678901234567890" | true
    "" | false //Firstname must not be blank

  }
  
}
