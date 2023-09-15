User:
CREATE TABLE users ( userId int PRIMARY KEY Auto_Increment, userName VARCHAR(255) NOT NULL UNIQUE, name VARCHAR(255), password VARCHAR(255), dateOfBirth DATE, mobileNumber VARCHAR(20), email VARCHAR(255), location VARCHAR(255), status BOOLEAN DEFAULT FALSE, loginStatus boolean Default false );

Vendor:
create table vendor(vendorId int AUTO_INCREMENT primary key,name varchar(50) not null,address varchar(100) not null,email varchar(50) not null,contact_number varchar(20) not null);

Package:
CREATE TABLE package ( packageId INT PRIMARY KEY AUTO_INCREMENT, type varchar(255),services varchar(255),amount decimal(8,2), vendorId INT, FOREIGN KEY (vendor_id) REFERENCES vendors(vendorId));

PlanRequest:
create table planrequest(planRequestId int AUTO_INCREMENT primary key, fromdate date, todate date, services varchar(255), numberpeople int, otherservices varchar(255), packageId int, userId int, constraint package_frkey foreign key (package_id) references package(package_id), constraint user_frkey foreign key (user_id) references users(userId));

Quotation:
CREATE TABLE quotation ( quotationId INT PRIMARY KEY AUTO_INCREMENT, package ENUM('Basic', 'Premium', 'Classic'), estimated_amount DECIMAL(10, 2), vendorId INT, userId INT, planRequestId int, status ENUM('accept', 'reject', 'pending') DEFAULT 'pending', FOREIGN KEY (vendorId) REFERENCES vendors(vendorId), FOREIGN KEY (userId) REFERENCES users(userId), FOREIGN KEY (planRequestId) REFERENCES planrequest(planRequestId) );