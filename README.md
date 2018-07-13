Example/Template of a server side REST Web Application using SpringFramework
========

Requirements
--------
* Postgresql Server 9.4 or newest
** For Linux Ubuntu see here https://www.postgresql.org/download/linux/ubuntu/
* JDK 1.8 , Maven 3.3.x

Instructions
--------
* Clone the repo
* Connect to Postgresql Server with psql client as superuser, and create users using statements in create-user-db.sql 
* Connect to Postgresql Server with each user created before and execute initDb.sql. This will create the dbms schemas in each database for each user

Now you can use it, creating the war file and deploying it  (es. in Tomcat ) or import it "as maven project" in your IDE ( es. Eclipse ) 

Usage
--------

* in order to add some content , you can invoke a POST Rest HTTP Request, for example using _curl_ tool:

`` $ curl -d '{"name":"Customer Name", "note":"The note text about the customer"}' -H "Content-Type: application/json" -X POST http://localhost:8080/restAppTemplate/customers ``

* in order to check content , you can invoke a GET Rest HTTP Request, for example using _curl_ tool: 

`` $ curl -X GET http://localhost:8080/restAppTemplate/customers ``