package grs

import grails.util.Environment;
import aa.bb.Hello
import aa.bb.Item
import aa.ee.BinPackingHelloWorld

class FormController {

        def index() { 
		//link to display form action
		//render "Welcome to Globar Registration System"
		redirect(action:'displayForm')
	}
	
	def displayForm() {
		
		println Environment.getCurrent()
		render (view: 'binpackDetails.gsp')
	}
	
	def pack(){
         
        int truck_count=params.int('truck_count')
        int truck_capacity=params.int('truck_capacity')
        int freight_count=params.int('freight_count')
        int freight_weight=params.int('freight_weight')
        
        println truck_count
        println freight_count
 
        BinPackingHelloWorld a = new BinPackingHelloWorld()
        //Boolean b = a.optaController()
	def result = a.optaController(truck_count, truck_capacity, freight_count, freight_weight);
        
        if(result!=null){
        //render (view: 'loadSuccess.gsp')
        //render result 
        render(view: "binpackDetails", model: [result_title:'Freight Load Result:', result:result])

        }
        
        else render (view: 'loadError.gsp')
		
		/*user.firstName = request.getParameter("firstName")
		user.lastName = request.getParameter("lastName")
		user.age = Integer.parseInt(request.getParameter("age"))
		user.save()
		int numberOfRecords = User.count();
		println numberOfRecords
		
		numberOfRecords = User.countByLastName("Mahajan")
		println numberOfRecords
		
		numberOfRecords = User.countByFirstName("Daakshi")
		println numberOfRecords*/
		
	}
        
    def binpackDetails(){
        User user = new User(firstName: 'John', lastName:'Doe', age:55)
        [ user:user ]
    }
        /*def addTruck() {
            
            render(view: 'loadError.gsp')
        }*/
	
        /*def addFreight() {
            render(view: 'loadError.gsp')
        }*/
}
