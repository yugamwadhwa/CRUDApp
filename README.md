# CRUDApp - Employee Managment 
A basic CRUD App using Spring boot, REST API, and CRUD with Maven using using H2 database.

This Application is based on MVC architecture. It is made using spring boot, H2 database, Hibernate and Junit.

API Endpoints.

1. GET - / - return the list of employees in database.

2. POST - /addemp - add new employee to the database.

3. GET - /getemp/{id} - return the employee on the base of id.

5. DELETE - /delemp/{id} - delete the user with specific employee Id.

6. PUT - /updateemp/{id} - update the employee details.

The entity is Employee with various details.

Service class has the main logic.

Controller handles the API endpints.

To handle the CRUD operations JPA repository is used.

The App architecture can be understood by this flowchart below




![Untitled Diagram](https://user-images.githubusercontent.com/66165348/208292497-f5f73719-e994-4710-9ea3-5017c83aaa7e.jpg)
