create database hexa_assignment;
use hexa_assignment;
-- Given Table
create table tab1(first_name varchar(10),last_name varchar(10),age int,dept varchar(10));
insert into tab1 values ('Mesa','Loop',30,'Acct'),('Smith','Oak',27,'Devl'),('John','Joez',37,'QA'),('Hary','Gaga',32,'QA');
# 1.Write a mysql statement to find the concatenated first_name, last_name where the age of the employee is greater than 30.
select concat(first_name,' ',last_name) as Full_name, age from tab1 where age>30;


# 2. Write a mysql statement to get user, current date and mysql version.
select user(),current_date(),version();


-- Given Table
create table item (item_id int,item_price int,item_name varchar(50));
insert into item values(1, 19, 'Laptop'),(2, 9, 'Mouse'),(3, 49, 'Printer'),(4, 29, 'Headphones'),(5, 5, 'USB Drive'),(6, 79, 'External Hard Drive');
select * from item;
# 3. Write a mysql statement to get item id, item, price of the most expensive item.
select item_id,item_name as item,item_price as price from item order by item_price desc limit 1;


# 4. Write a mysql statement to create a new user and set a password and privileges for an existing database.
-- Existing Database - hexa_assignment
create user 'sooraj'@'localhost' identified by'Sooraj@123';
grant all privileges on hexa_assignment.* to 'sooraj'@'localhost';
flush privileges;



-- Given Table
create table tab2 (id int, name varchar(50),department varchar(10),age int);
insert into tab2 values(1,'Maria Gloria','CS',22),(2,'John Smith','IT',23),(3,'Gal Rao','CS',22),(4,'Jakey Smith','EC',24),(5,'Rama Saho','IT',22),(6,'Maria Gaga','EC',23);
# 5.Write a mysql statement to select data of only CS and IT departments.
select * from tab2 where department in ('CS','IT');


 # 6. Write a MySQL statement to select data of all departments in descending order by age.alter
 select * from tab2 order by age desc;
 
 
 
 -- Given table
create table tab3 (id int, name varchar(50),department varchar(10),birth date);
insert into tab3 values(1,'Maria Gloria','CS','1994-03-12'),(2,'John Smith','IT','1993-02-07'),(3,'Gal Rao','CS','1992-09-11'),(4,'Jakey Smith','EC','1990-08-31'),(5,'Rama Saho','IT','1994-12-09'),(6,'Maria Gaga','EC','1993-10-09');
 # 7. Write a mysql statement to determine the age of each of the students.
 select id,name,timestampdiff(year, birth, curdate()) as age from tab3;
 
 # 8.Write a mysql statement to retrieve name beginning with 'm'.
 select name from tab3 where name like 'm%';
 
 
 -- Given Table
 # Employee Table
create table tab4 (id int, name varchar(50),dept_id int,birth date);
insert into tab4 values(1,'Maria Gloria',2,'1994-03-12'),(2,'John Smith',1,'1993-02-07'),(3,'Gal Rao',4,'1992-09-11'),(4,'Jakey Smith',2,'1990-08-31'),(5,'Rama Saho',1,'1994-12-09'),(6,'Maria Gaga',4,'1993-10-09');
# Department Table
create table dept(dept_id int,dept_name varchar(50),dept_block varchar(10));
insert into dept values(1,'Computer Science','B-Block'),(2,'Information Technology','C-Block'),(3,'Mechanical','A-Block'),(4,'Electronic Communication','D-Block');
# 9.Write a mysql statement to find the name, birth, department name, department block from the given tables.
select e.name,e.birth,d.dept_name,d.dept_block from tab4 e left join dept d on e.dept_id = d.dept_id;
-- select name,birth,dept_name,dept_block from tab4 left join dept on tab4.dept_id = dept.dept_id;


-- Given Table
create table tab5 (id int, name varchar(50),dept_id int,birth date);
insert into tab5 values(1,'Maria',2,'1994-03-12'),(2,'John',1,'1993-02-07'),(3,'Gal',4,'1992-09-11'),(4,'Jakey',2,'1990-08-31'),(5,'Rama',1,'1994-12-09'),(6,'Maria',4,'1993-10-09');
# 10.  Write a mysql statement to get name of students containing exactly four characters.
select name from tab5 where length(name) = 4;




# 11. Delete duplicate row from the table.  
-- insert into tab1 values ('Mesa','Loop',30,'Acct'),('John','Joez',37,'QA');
-- select * from tab1;
delete tab1 from tab1 join(select first_name,last_name,age,dept from tab1 group by first_name,last_name,age,dept having count(*) > 1) duplicate_records on tab1.first_name = duplicate_records.first_name;


# 12. Display the alternate rows from MySQL table.
-- insert into tab1 values ('Suraj','Kumar',30,'Devl'),('Shivam','Bak',37,'QA'),('Pranay','Devl',30,'Devl'),('Ratnesh','Joez',37,'SWE'),('Sheshank','Loop',30,'Guard'),('Ritik','Joez',37,'QA');
select * from (select*,row_number() over(order by first_name) as row_num from tab1) numbered_rows where row_num % 2 = 1; 


# 13. Delete alternate rows from MySQL table.
-- select * from tab1;
delete from tab1 where first_name in(select first_name from (select first_name, row_number() over(order by first_name) as row_num from tab1) numbered_rows where row_num % 2 = 1);


# 14. MySQL update multiple rows in one query.
update tab1 set first_name= 'Suraj', last_name='Kumar'WHERE dept='Devl';



-- Given Table
-- Create the emp table
create table emp (id int primary key,name varchar(255),department varchar(255),age int,salary int);
insert into emp (id, name, department, age, salary)VALUES(11, 'John Doe', 'IT', 30, 60000),(12, 'Jane Smith', 'HR', 35, 55000),(13, 'Bob Johnson', 'Marketing', 28, 70000),(14, 'Alice Williams', 'Finance', 40, 80000),(15, 'Charlie Brown', 'IT', 32, 65000);

# 15. MySQL get nth highest paid and nth lowest paid salary.
-- let n = 10, limit n-1 = limit 9
select * from emp order by salary;
# nth lowest_salary
select distinct salary from emp order by salary desc limit 3, 1;
# nth highest_salary
select distinct salary from emp order by salary limit 3, 1;


 