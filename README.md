# API-s
This Repo is for the capture of API's, as well as to outline a few api templates for quick use and manipulation moving forward
-------------------------------------------------------------------
#Spring Boot Rest API Components
-------------------------------------------------------------------
THIS REST API WILL SIT BETWEEN DATABASE AND FRONT END APPLICATION.
CLIENT <-> Service <-> Data Layer
In terms of mapping out the process
CLIENT -> HTTP Request -> Service -> API Call to Database -> Database -> Return Data to service -> Service -> Make Data Avaliable to Service -> Service
-------------------------------------------------------------------
#Spring Boot Rest API Components
-------------------------------------------------------------------
Every rest API will have the following components
1. Model
2. Controller
3. Service

-------------------------------------------------------------------
#Spring Boot Rest API Components - In Detail
-------------------------------------------------------------------
1. Model: 
The model is an important part of creating the REST API as it will model what data we expect to recieve. For example, If we expect a response wiht username an dpasssword, we would want to see String username, String password. If we did not model it, spring will be unable to read the data form API

1a. Initialization
We need to have the initial class created for the model. We will need to package it in our spring boot application, as well as provide a simple outline for the class to exist

# Syntax
package <path>.<to>.<directory>.<of>.<class>

public class <name_of_java_file> {


}
# Example
package base.template.template.api.model;

public class User{

}





# A Model will consist of
1b. Variables
In order to ensure our model matches what we expect from the restAPI, we need to declare the variables and there data types that we expect to see as a response form the API

# Example
int id;
String name;
int age;
String email;

1b. A Constructor
A Constructor is a method that alows us to create an instance of the class(Essentially, alow us to create a new object from this class). We could create a simple Constructor for a user
#Syntax
public User{
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
}

*We are only expecting a response form thease 4 fields, so we will only create the constructorfor thease 4 fields

1c. Getters
Getters + Setters are created for security purposes so that someone can get/set the value of the data while protecting thr variable itself

#Example
public getId(){
    return id;
}

1d. Setters
Getters + Setters are created for security purposes so that someone can get/set the value of the data while protecting thr variable itself

#Example
public void setId(int id){
    this.id = id;
}








2. Controller

3. Service
The Service is for business Logic:
It will include