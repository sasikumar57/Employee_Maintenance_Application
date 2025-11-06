# 👨‍💼 Employee Maintenance Application

A simple yet powerful **Java console-based CRUD application** built to manage employee records efficiently using **MySQL** as the database.  
This project demonstrates the implementation of **JDBC (Java Database Connectivity)** for connecting Java applications with MySQL to perform **Create, Read, Update, and Delete (CRUD)** operations.

---

## 🧾 Project Overview

The **Employee Maintenance Application** allows users to:
- Add new employees
- View all employees
- Update employee details (like salary)
- Delete employee records  
This project helps understand how to use **DAO (Data Access Object) design pattern**, separate concerns into logical layers, and interact with MySQL using JDBC.

---

## 🧠 Key Features

✅ Java console-based CRUD operations  
✅ JDBC database connectivity using MySQL  
✅ Follows DAO (Data Access Object) design pattern  
✅ Uses OOP concepts like encapsulation and abstraction  
✅ Exception handling and user-friendly console menus  
✅ Easy to set up and run  

---

## 🧱 SQL Commands (Run These in MySQL First)

Before running the project, create a database and table in MySQL using the following commands:

CREATE DATABASE Empdb;

USE Empdb;

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 18),
    gender VARCHAR(10),
    department VARCHAR(50),
    designation VARCHAR(50),
    salary DECIMAL(10,2) CHECK (salary >= 0),
    contact_no VARCHAR(15),
    email VARCHAR(100) UNIQUE,
    address VARCHAR(255)
);

🗂️ Project Structure
EmployeeMaintenanceApp/
│
├── DBConnection.java        # Establishes connection with MySQL database
├── Employee.java            # Model class (POJO) representing employee entity
├── EmployeeDAO.java         # Handles database CRUD operations
└── MainApp.java             # Main program to run console-based menu

⚙️ Technologies Used
| Category           | Tools / Technologies              |
| ------------------ | --------------------------------- |
| Language           | Java                              |
| Database           | MySQL                             |
| Database Connector | JDBC                              |
| IDE (Recommended)  | Eclipse / IntelliJ IDEA / VS Code |
| Build Tool         | Manual (No Maven required)        |

🧩 File Descriptions
1. DBConnection.java

Responsible for establishing and managing a connection with the MySQL database.

Contains the database URL, username, and password.

Returns a Connection object for use in DAO classes.

Example Snippet:
Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/employeedb", "root", "yourpassword");

2. Employee.java (Model Class)

Represents the Employee entity.

Contains fields like id, name, department, and salary.

Includes constructors, getters, setters, and a toString() method for easy output.

3. EmployeeDAO.java (Data Access Object)

Handles all database-related operations:

addEmployee()

getAllEmployees()

updateEmployeeSalary()

deleteEmployee()

Uses PreparedStatements to prevent SQL injection.

Returns meaningful results and error messages.

4. MainApp.java (Main Program)

Provides an interactive console menu for users:
1. Add Employee
2. View All Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
Calls the respective DAO methods based on user input.

Demonstrates modular Java design.

🪜 How to Run the Project
Prerequisites:

Install Java JDK 8 or above

Install MySQL Server

Add MySQL JDBC Connector (mysql-connector-j.jar) to your classpath

Steps:

Clone this repository:
git clone https://github.com/<yourusername>/EmployeeMaintenanceApp.git

Open the project in your IDE.

Update database credentials in DBConnection.java:

String url = "jdbc:mysql://localhost:3306/employeedb";
String user = "root";
String password = "yourpassword";


Run the SQL commands (given above) in your MySQL console.

Compile and run the project:

javac *.java
java MainApp

🧮 Example Console Output
======= Employee Maintenance Application =======

1. Add Employee
2. View All Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
Enter your choice: 1

Enter Employee Name: John
Enter Department: HR
Enter Salary: 55000
Employee added successfully!

-----------------------------------
Enter your choice: 2
ID: 1 | Name: John | Department: HR | Salary: 55000.0
-----------------------------------

🚀 Future Enhancements

Add employee search by name or department.

Add input validation and data constraints.

Develop GUI version using JavaFX or Swing.

Integrate logging using Log4j.


🧑‍💻 Author

Sasikumar M
📧 sasikumarsk5731@gmail.com

