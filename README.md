# Insurance-Management-Platform
Insurance management platform that allows users to manage insurance policies, clients, and claims using Spring Boot and Java.

Description:

Project Description:
Insurance management platform is a web-based application that allows users to manage insurance policies, clients, and claims. The application is built using Spring Boot and Java, and it uses Spring Data JPA to interact with an embedded database.
This project has three main domain models: Client, InsurancePolicy, and Claim. Each domain model has its properties, and there are relationships between them. For example, each insurance policy is associated with a client, and each claim is associated with an insurance policy.
This application exposes RESTful APIs to perform CRUD operations for clients, insurance policies, and claims. The APIs use HTTP methods like GET, POST, PUT, and DELETE, and they follow a standard naming convention.

Project Structure:
the project has a pretty standard Maven directory structure. You'll find all the source code files located in the src/main/java directory, and any resource files will be in the src/main/resources directory.
Now, the main application class that you'll be working with is called InsuranceManagementPlatformApplication.java, and you can find it in the src/main/java/com/example/insurancemanagementplatform directory. This class is pretty important since it's responsible for starting the application, loading Spring Boot, and configuring all the necessary beans.
There are also three subdirectories in the project - one for each domain model. Each of these directories contains all the Java classes and interfaces needed to define the model and its interactions with the database. This is where you'll define the models for clients, insurance policies, and claims, and create all the necessary relationships between them

Project Features:
The insurance management platform has the following features:

Allows users to create, update, and delete clients, insurance policies, and claims using RESTful APIs.
Supports the retrieval of individual clients, insurance policies, and claims by their ID, as well as the retrieval of all clients, insurance policies, and claims.
Ensures data integrity and proper API usage by validating input data and handling exceptions.

--------------------------------

Requirements
  Java - 17
  Maven - 3.x.x
  Mysql - 5.x.x
  
Run this Application

Using Clone this Repository

1.First, open up a terminal or command prompt window on your local machine.
2.Navigate to the directory where you want to clone the repository using the cd command. For example, if you want to clone it to your desktop, you can use cd ~/Desktop
3.Next, use the git clone command to clone the repository 
Follow this command 

git clone https://github.com/username/insurance-management-platform.git

4.Press Enter to execute the command. Git will start cloning the repository to your local machine
5.Once the cloning process is complete, you should see a new directory on your local machine with the same name as the repository (in this case, insurance-management-platform)

=========================================

After cloning the repository, you can follow these steps to run the project using IntelliJ IDEA:

1.Open IntelliJ IDEA or Any You Favourite Ide and select "Import Project" from the welcome screen.
2.In the file browser, navigate to the directory where you cloned the repository and select the project's root directory.
3.IntelliJ IDEA will detect the project's settings and prompt you to import it as a Maven project. Click "Import" to continue.
4.Wait for IntelliJ IDEA to download and import all the project dependencies, which may take a few minutes.
5.Once the import is complete, navigate to the InsuranceManagementPlatformApplication class (located in the com.example.insurancemanagementplatform package) and right-click it. Then select "Run InsuranceManagementPlatformApplication" from the context menu.
6.IntelliJ IDEA will start the Spring Boot application, and you should see the console output in the Run tool window.

To run this appllication Different Databases 
  1. First you have add dependency of that database in Pom.xml
  2. And also change database configurations in application.properties file
  3. Change spring.database.driver Url=enter your database driver name
  4. set the name of database
  5. set username and password of your database

  below is application.properties file structure

  #database configuration
  database.driver=com.mysql.jdbc.Driver
  spring.datasource.url=jdbc:mysql://localhost:3306/insurancemanagement
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.username=root
  spring.datasource.password=Pass@123  

  spring.jpa.hibernate.ddl-auto=update

 That's it! You should now be able to access the API endpoints by sending HTTP requests to localhost:8080/api/{endpoint} in your preferred API client or web browser
 By Default this application running on port no 8080 you can also change port no using application.propertes 
 
Once you have the project up and running, you can test the APIs using a tool like Postman or cURL. Here's how you can test the APIs using Postman:

Open Postman and create a new request.

Set the request method to the desired HTTP method (e.g., GET, POST, PUT, DELETE).
Enter the API endpoint URL (e.g., http://localhost:8080/api/clients).

Enter the following end points
Clients:

- GET : Fetch all clients. http://localhost:8080/api/clients/
- GET : Fetch a specific client by ID. http://localhost:8080/api/clients/{enter id}
- POST : Create a new client. http://localhost:8080/api/clients/
- PUT : Update a client's information. http://localhost:8080/api/clients/{enter id}
- DELETE : Delete a client. http://localhost:8080/api/clients/{1}

Insurance Policies:

- GET : Fetch all insurance policies. http://localhost:8080/api/policies/ 
- GET : Fetch a specific insurance policy by ID. http://localhost:8080/api/policies/{enter id}
- POST : Create a new insurance policy. http://localhost:8080/api/policies/
- PUT : Update an insurance policy. http://localhost:8080/api/policies/{enter id}
- DELETE : Delete an insurance policy. http://localhost:8080/api/policies/{enter id} 

Claims:

- GET : Fetch all claims. http://localhost:8080/api/claims/
- GET : Fetch a specific claim by ID. http://localhost:8080/api/claims/{enter id}
- POST: Create a new claim. http://localhost:8080/api/claims/
- PUT : Update a claim's information. http://localhost:8080/api/claims/{enter id}
- DELETE : Delete a claim http://localhost:8080/api/claims/{enter id}
 
Policy add to the Client -
- PUT : http://localhost:8080/api/clients/policypurchase/{enter policyId}/{enter Client id}

claim add to the policy 
- PUT : http://localhost:8080/api/policies/addclaims/{enter claimID}/{enter policyId}

I have handled exceptions and also provided proper validation for each endpoint.







  




