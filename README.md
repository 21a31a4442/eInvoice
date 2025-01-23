# eInvoice Application

This repository contains the source code for an eInvoice application built using Spring MVC, Spring Security, and JPA.

## Features

* eInvoice Generation: [Describe the core functionality of eInvoice generation]
* User Management:
* User authentication and authorization using Spring Security
* Roles: Admin and User (with appropriate permissions)
   * Admin Panel:
     * CRUD operations for:
         * Status
         * Contact Type
         * Cost Center Type
         * State
         * City
         * Country
         * Cost Center
         * Entity
         * Department
         * Designation
     * Approve user requests / new requests


## Technologies Used

**Spring MVC**: For building the web application
**Spring Security**: For user authentication and authorization
**JPA**: For data access and persistence
**MySQL**: As the database
**HTML, CSS, JavaScript**: For the front-end

## Installation

1. **Clone the repository:**
```
Bash
git clone <repository_url>
```
2. **Set up the database:**
Create a MySQL database.
Import the necessary SQL scripts to create tables and populate initial data.
3. **Configure the application:**
Update the application.properties file with database connection details and other necessary configurations.
4. **Build the project:**
Use Maven or Gradle to build the project.
5. **Run the application:**
Start the Spring Boot application.
## Usage
* Access the application: Open a web browser and navigate to the application URL.
* Login: Use the provided credentials to login as an admin or user.
* redirect to /admin page and you can add or update the details present in the admin panel. You can also approve requests made by the users

## Contributing
If you'd like to contribute to this repository, feel free to fork it and submit a pull request. Here's how you can contribute:

* Fork the repository.
* Create a feature branch (git checkout -b feature-branch).
* Make changes and commit them (git commit -am 'Add new feature').
* Push to the branch (git push origin feature-branch).
* Open a pull request.


## License
This project is licensed under the MIT License.

