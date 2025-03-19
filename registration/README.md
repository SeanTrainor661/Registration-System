AeroParker Registration System

Overview
This is a Spring Boot web application with MySQL integration that allows users to register their details through a web form. It includes:

•	Form validation (ensuring required fields are filled correctly).
•	Duplicate email prevention.
•	Persistent MySQL database storage.
•	A success page after registration.
________________________________________
Setup & Installation

Follow these steps to set up and run the application on your local machine.

1️. Install Dependencies

Ensure you have the following installed:

•	Java 17+
•	Maven
•	MySQL Server

2️. Create the MySQL Database

Run the provided SQL script, “setup-database.sql”, to set up the required database and table
This will:

•	Create a MySQL database called aeroparker.
•	Create a customers table with the required fields.

3️. Set Up Environment Variables

Instead of hardcoding database credentials, set an environment variable for the MySQL password:

•	Windows (PowerShell):
$env:DB_PASSWORD="MyPassword1"
•	macOS/Linux:
export DB_PASSWORD=" MyPassword1 "

4. Run the Application
5. 
Start the Spring Boot server using Maven:

./mvnw.cmd spring-boot:run   # Windows
./mvnw spring-boot:run       # macOS/Linux

Once running, visit:
http://localhost:8080/registration
________________________________________
 Project Structure

Here's an overview of the key files and their functions:

src/main/java/com/aeroparker/registration/: Main Java package for the application

controller/CustomerController.java: Handles HTTP requests and form submission

model/Customer.java: Represents the Customer entity for the database

repository/CustomerRepository.java: Interface for database interactions

resources/templates/registration.html: Thymeleaf template for the registration form

resources/templates/success.html: Confirmation page after successful registration

resources/application.properties: Configuration file for database connection (password is stored as an environment variable)

setup-database.sql: SQL script to create the database and table

