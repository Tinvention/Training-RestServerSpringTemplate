Example/Template of a server side REST Web Application using SpringFramework
========

Requirements
--------
* Docker & docker compose
* JDK 1.8 , Maven 3.3.x

Instructions
--------
* Clone the repo
* `` $ docker-compose up ``
* Create, and use, a wildfly configuration without faces extension and module ( es. comment-out from standalone.xml and save as standalone-nofaces.xml )
* Configure the JNDI DataSource , see the name used in web.xml file, and check it is working
* Now you can use it, creating the war file and deploying it  (es. in Wildfly or tomcat ) or import it "as maven project" in your IDE ( es. Eclipse ) 
* Hint: to skip tests `` $ mvn clean package -DskipTests `` 


Usage
--------

* in order to add some content , you can invoke a POST Rest HTTP Request, for example using _curl_ tool:

	`` $ curl -d '{"name":"Customer Name", "note":"The note text about the customer"}' -H "Content-Type: application/json" -X POST http://localhost:8080/restAppTemplate/customers ``

* in order to check content , you can invoke a GET Rest HTTP Request, for example using _curl_ tool: 

	`` $ curl -X GET http://localhost:8080/restAppTemplate/customers ``
	

Jmeter
--------	
*  if the GUI is not readable, see here https://jmeter.apache.org/usermanual/hints_and_tips.html the "22.4 JMeter with a HiDPI screen on Linux or Windows" cap. , the file to modify is jmeter.properties ( search for hidpi there are already suggested configs )
  