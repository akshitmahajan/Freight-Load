package grs

class UserAuth {

    String userName
    String password
    String fullName
    
    static constraints = {
        userName (blank:false, nullable:false, size:3..20, matches:"[a-zA-Z1-9_]+")
	password (blank:false, nullable:false, size:3..10, matches:"[a-zA-Z1-9_]+")
        fullName (blank:false, nullable:false, size:3..20, matches:"[a-zA-Z1-9_]+")
                
    }
}
