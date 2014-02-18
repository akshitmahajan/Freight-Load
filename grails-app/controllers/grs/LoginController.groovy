package grs

class LoginController {

    def index() { }
    
    def authenticate(){
        
        def user = UserAuth.findByUserNameAndPassword(params.username, params.password)
        if(user){
            //session.user = user
            flash.message = "Hello ${user.fullName}!"
            redirect(controller: "form", action:"displayForm")
            
        }else{
        flash.message = "Invalid Username/Password Please try again."
        redirect(url: "http://localhost:8080/GRS")
        }
        
    }
    
    def logout(){
        flash.message = "Goodbye ${session.user.fullName}"
        //session.user = null
        redirect(url: "http://localhost:8080/GRS")
    }
}
