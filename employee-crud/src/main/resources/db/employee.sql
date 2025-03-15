CREATE TABLE employeeSB(
id NUMBER GENERATED ALWAYS AS IDENTITY START WITH 1 INCREMENT BY 1 PRIMARY KEY,
name varchar2(255) not null,
email varchar2(255) unique not null,
designation varchar2(255),
age number(10),
address varchar2(500),
dob DATE,
salary number(10,2)
);