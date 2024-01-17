show databases;
create Database Hexaware;
use Hexaware;
select * from course;
create table employee(id int, ename varchar(50),location varchar(50),sal int);
insert into employee values(1,'Suraj','Muzaffarpur',42000);
insert into employee values(1,'Suraj','Muzaffarpur',42000),(2,'Palash','Bhopal',24000),(3,'Anoop','Indore',34000),
(4,'Pranay','Hyderabad',44000),(5,'Suraj','Gaya',19000),(6,'Kritik','Bangaore',51000),(7,'Anoop','Chhapra',31000),(8,'Palash','Bangalore',39000)
,(9,'Kedar','Hyderabad',19500),(10,'Sasidhar','Bangalore',57000),(11,'Sam','Pune',54000),
(12,'Viruthik','Mumbai',12000),(13,'Swarna','Nagpur',18000),(14,'Yash','Delhi',34000),(15,'Khalid','Hyderabad',10000),
(16,'Rahul','Chennai',33000),(17,'Prasanna','Mumbai',21000),(18,'Rahul','Jaipur',37500),(19,'Sheshank','Jaipur',34000),
(20,'Neha','Hyderabd',38000),(21,'Nafisa','Hyderabad',13000),(22,'Jayanth','Telangana',45000),(23,'Kritik','Bangalore',18000),
(24,'Gaurav','Hyderabad',2000),(25,'Abhishek','Mumbai',55000),(26,'Ratnesh','Indore',21000),(27,'Veera','Chennai',100000),
(28,'Pranay','Gurgaon',80000),(29,'Suraj','Bangalore',99999),(30,'Swarna','Punjab',31000),(31,'Khalid','Bhopal',37000);
select * from employee;
delete from employee where id=1;
select * from employee order by location;
select ename , sal as salary , count(ename) as total from employee group by sal having count(ename)>1;
select location, ename ,count(*) as total_emp from employee group by location,ename order by location;
select location, ename ,sal,count(*) as total_emp from employee group by location,ename,sal order by location;
select min(sal) from employee;
select max(sal) as sec_min_sal,ename,location from (select sal,ename,location from employee order by sal limit 2) as temp_tabel;
update employee set location='Hyderabad' where id=31;
select ename,location,sal from employee where location='Hyderabad' and sal<20000;
select sal,count(*) as com_sal from employee group by(sal) order by com_sal desc;


select * from employee order by sal;
# 9.Location-wise highest salary
select location as Location,ename, max(sal) as highest_sal from employee group by location ,ename order by highest_sal desc;
# 10.Overall salary given to employees from each location
select location , sum(sal) as total_sal from employee group by location order by total_sal desc;

Alter table employee add (dep_name varchar(50));
desc employee;
update employee set dep_name='Sales' where sal>0 and sal<20000;
update employee set dep_name='Hr' where sal>= 20000 and sal<45000;
update employee set dep_name='IT' where sal>=45000;

# 11. Department-wise salary
select dep_name as Department, sum(sal)  as highest_sal from employee group by dep_name;

# 12. Location and department-wise highest salary
select location,dep_name,max(sal) as highest_sal from employee group by location,dep_name;

# 13. Show salary of each employee
select ename as Name ,sal as salary from employee order by salary;