# Korty - reservation of squash courts

##### Simple back-end application with REST API

### Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
#

##### General info
This project is a simple reservation system meant to provide the 
user with options such as booking a squash court for a specified
time, adding new court and centers or deleting any of manshioned.
The project has been created during apprenticeship conducted by
Euvic Inc. within July and June 2020.

##### Technologies
The project has been created using technologies such as:
* Java 11
* Spring Framework 2.3.2
* MySQL 8.0
* Maven
* Lombok

The project has been created according to standards such as:
* REST API
* JSON Web Token

##### Setup
In order to run the application a local database server is required.
After starting the application it is running on port 8080. This and
other database properties can be checked or changed in file 
"application.properties". The Application can be used via internet
browser (displaying data from the database) or programs like Postman
(any action). Making any actions requires the user to login first.
Valid username and password for current version of the application are:
* username - "test"
* password - "test".
