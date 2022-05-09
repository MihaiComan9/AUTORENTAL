# AUTORENTAL

AUTORENTAL - java application with rental purpose.

Project Includes:

->Maven Project;
->OOP principles;
->Custom Exceptions;
->LocalDate;
->Database Connectivity;
->Hibernate Entity Relationships;
->Log4J;
->Spring JPA;
->Spring Security(using B-Crypt);
->Spring Thymeleaf;
->Spring Bootstrap;
->Import.sql;

Landing page/index welcomes users. The endpoints of "about us", "/contact" , "/register", "/login" and 
"/index" 
are accessible without registering. After registration, the user can access all the functionalities of the
application, like : adding a new car, renting a car, updating an existing car, deleting a car. Once the user
decides which car is for him, when he rents it, the quantity of cars is decremented. If the car quantity is 
0, then the renting button/page is disabled until updated.
	The user credentials are safely stored in the database, and the password he assigned to his account
is known only by the user. To make this possible, the password is encripted with B-crypt before saving it 
in the database. B-crypt has a "matches" function which returns T/F if the password is recognized by the app.


Templates:

"/index": 
-if authenticated returns all cars;
-if not authenticated returns landing page/index;

"/all-cars":
-table containing all the cars stored in the database.

"/About-us":
-general information about the bussiness;

"/Contact":
-specific informations about the bussiness: address, phone number, e-mail
-fixed pin with address on responsive google map.

"/Register":
-account registering page

"/Register-success":
-pop-up page that validates the registration process.

"/Login":
-login information saved in registration process;

"/Add car":
-builder which saves cars in the database;

"/Rent-car":
-information about the car, where to get it,current date, return date.

"/Update-car":
-Restocking a car brought back by the client.

