# Insurance-Management-Platform
Insurance management platform that allows users to manage insurance policies, clients, and claims using Spring Boot and Java.

## Description:

Insurance management platform is a web-based application that allows users to manage insurance policies, clients, and claims. The application is built using Spring Boot and Java, and it uses Spring Data JPA to interact with an embedded database.

This project has three main domain models: Client, InsurancePolicy, and Claim. Each domain model has its properties, and there are relationships between them. For example, each insurance policy is associated with a client, and each claim is associated with an insurance policy.

This application exposes RESTful APIs to perform CRUD operations for clients, insurance policies, and claims. The APIs use HTTP methods like GET, POST, PUT, and DELETE, and they follow a standard naming convention.

## Project Structure:

the project has a pretty standard Maven directory structure. You'll find all the source code files located in the 'src/main/java' directory, and any resource files will be in the 'src/main/resources' directory.

Now, the main application class that you'll be working with is called InsuranceManagementPlatformApplication.java, and you can find it in the src/main/java/com/example/insurancemanagementplatform directory. This class is pretty important since it's responsible for starting the application, loading Spring Boot, and configuring all the necessary beans.

There are also three subdirectories in the project - one for each domain model. Each of these directories contains all the Java classes and interfaces needed to define the model and its interactions with the database. This is where you'll define the models for clients, insurance policies, and claims, and create all the necessary relationships between them

## Project Features:

The insurance management platform has the following features:

- Manage insurance policies, clients, and claims in one place
- Built with Spring Boot and Java for reliability and efficiency
- Uses Spring Data JPA to interact with an embedded database for easy data management
- Three main domain models - Client, InsurancePolicy, and Claim - each with their properties and relationships
- Exposes RESTful APIs for CRUD operations on clients, insurance policies, and claims using HTTP methods
- Follows a standard naming convention for easy understanding and usage of APIs
- Follows a standard Maven directory structure for easy navigation and management of code
- Easy to run by cloning or downloading the source code and importing it into any IDE
- Supports multiple databases such as MySQL or PostgreSQL for flexibility and adaptability
- Includes proper exception handling for error management
- Provides endpoint testing using tools such as Postman or cURL, with various endpoints available for testing.

## Tech stack includes:

Spring boot 3.0.5 latest used in this application
MySQL database
Maven

## Requirements
- Java - 18
- Maven - 3.8.x
- MySQL - 8.0.x
  
## Run this Application

Clone or download source code from Github. You can download it directly.

Using Clone this Repository

* First, open up a terminal or command prompt window on your local machine.
* Navigate to the directory where you want to clone the repository using the cd command. For example, if you want to clone it to your desktop, you can use cd ~/Desktop
* Next, use the git clone command to clone the repository Copy the Following Command and past it into Command prompt
 

```
git clone -b master https://github.com/rajeshdp22/Insurance-Management-Platform.git
```



* Press Enter to execute the command. Git will start cloning the repository to your local machine
* Once the cloning process is complete, you should see a new directory on your local machine with the same name as the repository (in this case, insurance-management-platform)


After cloning the repository:

* Open IntelliJ IDEA or Any Your Favourite Ide and select "Import Project" from the welcome screen.
* In the file browser, navigate to the directory where you cloned the repository and select the project's root directory.
* IntelliJ IDEA will detect the project's settings and prompt you to import it as a Maven project. Click "Import" to continue.
* Wait for IntelliJ IDEA to download and import all the project dependencies, which may take a few minutes.
* After Import is complete, navigate to the InsuranceManagementPlatformApplication class and right-click it. Then select "Run InsuranceManagementPlatformApplication" from the context menu. (got to src/main/java/ then you can see InsuranceManagementPlatformApplication)
* IntelliJ IDEA will start the Spring Boot application, and you should see the console output in the Run tool window.

## To run this Appllication in Different Databases 
  * First you have add dependency of that database in Pom.xml
  * And also change database configurations in application.properties file
  * Change driver, ulr of the database,driver-class and enter username and password(if having)
  * Set the name of database in my case y database name is "insurancemanagement" you can change it.
 
 Just like below,
  
```
#database configuration
  database.driver=com.mysql.jdbc.Driver
  spring.datasource.url=jdbc:mysql://localhost:3306/insurancemanagement
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
  spring.datasource.username=root
  spring.datasource.password=Pass@123  
  spring.jpa.hibernate.ddl-auto=update
```

## Test this api endpoints

 That's it! You should now be able to access the API endpoints by sending HTTP requests to localhost:8080/api/{endpoint} in your preferred API client or web browser
 By Default this application running on port no 8080 you can also change port no using application.propertes using this command ("server.port=8090")
 
Once you have the project up and running, you can test the APIs using a tool like Postman or cURL. Here's how you can test the APIs using Postman:

Open Postman and create a new request.

Set the request method to the desired HTTP method (e.g., GET, POST, PUT, DELETE).
Enter the API endpoint URL (e.g., http://localhost:8080/api/).

Here are some endpoints you can call:

### All Unique id's are automatically created in database you dont need to take care

## Get information about clients or add client

- Fetch all clients. select GET request ```http://localhost:8080/api/clients/```
- Fetch a specific client by ID. select GET request by specifying id ```http://localhost:8080/api/clients/{enter id}```
- Create a new client. select POST request ```http://localhost:8080/api/clients/```

You must follow this format because i have added validation of each field so that's why data will not be created.
```
Accept: application/json
Content-Type: application/json

{
    "name": "Virat Kohli",
    "dateOfBirth": "1999-07-06",
    "address": "Delhi",
    "contactInformation": "7172596334"
}
```

- Update a client's information. select PUT request ```http://localhost:8080/api/clients/{mentionId}```

```
Accept: application/json
Content-Type: application/json

{
    "name": "Virat Prajapati",
    "dateOfBirth": "1999-07-06",
    "address": "Delhi",
    "contactInformation": "7172596334"
}
```


- Delete a client. select DELETE request ```http://localhost:8080/api/clients/{mentionId}```

- add Polciy to the Client. Select PUT request ```http://localhost:8080/api/clients/policypurchase/{mention policyId}/{mention clientId}```

### I have use OneToMany Relationship with clients and policies (one client is having many policies) so in that case different Table will be automatically created in our Database


## Get information about Insurance Policies or add policies 


- Fetch all insurance policies. select GET request ``` http://localhost:8080/api/policies/ ```
- Fetch a specific insurance policy by ID. select GET request ``` http://localhost:8080/api/policies/{mention policyId} ```
- Create a new insurance policy. select Post request ``` http://localhost:8080/api/policies/ ```

### You must follow this format because i have added validation of each field so that's why data will not be created.

coverageAmount amount should be in double format, startDate must be present or future and endDate is always in future these are the validations

```
Accept: application/json
Content-Type: application/json

{
    "type": "Auto",
    "coverageAmount": 15000.0,
    "premium": 2000.0,
    "startDate": "2023-04-08",
    "endDate": "2024-06-09"
}

```

- Update an insurance policy. select PUT request ```http://localhost:8080/api/policies/{mention policyId}```
```
{
    "type": "Life Insurance",
    "coverageAmount": 20000.0,
    "premium": 2000.0,
    "startDate": "2023-04-08",
    "endDate": "2024-06-09"
}
```

- Delete an insurance policy. select DELETE request ```http://localhost:8080/api/policies/{mention policyId}```

Add claim to the policy  Select PUT requesr ``` http://localhost:8080/api/policies/addclaims/{mention claimID}/{mention policyId}```


## Get information about Claims and add claims details

- Fetch all claims. select GET request ```http://localhost:8080/api/claims/```
- Fetch a specific claim by ID. select GET request ```http://localhost:8080/api/claims/{mention claimId}```
- Create a new claim. select POST request ```http://localhost:8080/api/claims/```

### You must follow this format because i have added validation of each field so that's why data will not be created.

description should be more than 5 chars, claimDate must be present or future and Claim status must be one of: Pending, Approved, Denied these are the validations

```
Accept: application/json
Content-Type: application/json

   {
        "description": "Accidental",
        "claimDate": "2023-04-08",
        "claimStatus": "Pending"
    }

```


- PUT : Update a claim's information. select PUT request ```http://localhost:8080/api/claims/{mention claimId}```
```
Accept: application/json
Content-Type: application/json

   {
        "description": "Accidental",
        "claimDate": "2023-04-08",
        "claimStatus": "Approved"
    }
    
 ```

- DELETE : Delete a claim select DELETE request ```http://localhost:8080/api/claims/{mention claimId}```
 
