package grs

class User {

	String firstName
	String lastName
	Integer age
	
    static constraints = {
		firstName (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z1-9_]+")
		lastName (blank:false, nullable:false, size:3..30, matches:"[a-zA-Z1-9_]+")
		age (blank:false, nullable:false)
    }
}
