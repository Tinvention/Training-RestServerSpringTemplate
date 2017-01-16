var app = angular.module("myApp", ["ngResource"]);

app.factory("Customer", ["$resource", function ($resource) {
    return $resource("http://localhost:8080/spring4-1/info/Customer/:CustomerId", {CustomerId: "@pid"},
	{
		updateCustomer: {method: "PUT"}
	}
    );
}]);

app.controller("CustomerController", ["$scope", "Customer", function($scope, Customer) {
    var ob = this;
    ob.Customers=[];
    ob.Customer = new Customer(); 
    ob.fetchAllCustomers = function(){
        ob.Customers = Customer.query();
    };
    ob.fetchAllCustomers();
    ob.addCustomer = function(){
	console.log("Inside save");
	if($scope.CustomerForm.$valid) {
	  ob.Customer.$save(function(Customer){
	     console.log(Customer); 
	     ob.flag= "created";	
	     ob.reset();	
	     ob.fetchAllCustomers();
	  },
	  function(err){
	     console.log(err.status);
	     ob.flag="failed";
	  }
          );
        }
    }; 
    ob.editCustomer = function(id){
	    console.log("Inside edit");
        ob.Customer = Customer.get({ CustomerId: id}, function() {
	       ob.flag = "edit"; 
	    });
    };    
    ob.updateCustomerDetail = function(){
	console.log("Inside update");
	if($scope.CustomerForm.$valid) {
    	   ob.Customer.$updateCustomer(function(Customer){
    		console.log(Customer); 
		ob.updatedId = Customer.pid;
				ob.reset();
		ob.flag = "updated"; 
    		ob.fetchAllCustomers();
           });
	}
    };	
    ob.deleteCustomer = function(id){
	    console.log("Inside delete");
	    ob.Customer = Customer.delete({ CustomerId: id}, function() {
		ob.reset();  
		ob.flag = "deleted";
    		ob.fetchAllCustomers(); 
	    });
    };		
    ob.reset = function(){
    	ob.Customer = new Customer();
        $scope.CustomerForm.$setPristine();
    };	
    ob.cancelUpdate = function(id){
	    ob.Customer = new Customer();
	    ob.flag= "";	
   	    ob.fetchAllCustomers();
    };    
}]);    
   