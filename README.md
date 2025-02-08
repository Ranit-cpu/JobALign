# JobALign
The JobAlign is an application designed to efficiently manage employee records, including details such as personal information, job roles, salaries, and attendance. This system provides a user-friendly interface for HR departments to streamline employee-related operations.

 Features
Add, update, and delete employee records
Manage job roles and departments
Track attendance and leave records
Generate reports and analytics
Secure authentication and role-based access
Responsive UI for seamless experience

I have used JAVA for both backend and frontend

Create a database named JobAlign with two tables Login and Employee and insert the password and username you prefer through sql query in the Login table
Login Table:

create table Login(
  username varchar(50),
  password varchar(50)
);

create table Employee(
  Name varchar(50),
  FatherName varchar(50),
  DOB varchar(50),
  Salary varchar(50),
  Address varchar(200),
  PhoneNo varchar(50),
  Email varchar(50),
  Qualification varchar(50),
  Designation varchar(50),
  AadhaarNo varchar(12),
  EmployeeID varchar(10)
);
