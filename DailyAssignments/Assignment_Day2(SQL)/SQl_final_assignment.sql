use hexaware;
create table Ex_Employee (eid int,ename varchar(50),annual_sal int,email varchar(50),dept_id int,join_year int,manager_id int);
insert into ex_employee values(1,'Sunil',350000,'sunil@hexaware.com',52,2019,111),
(2,'Susil',450000,'susil@hexaware.com',53,2019,112),(3,'Suraj',650000,'suraj@hexaware.com',23,2023,121),(4,'Praveen',150000,'praveen@hexaware.com',55,2021,116),(6,'subodh',440000,'subodh@hexaware.com',34,2023,131),(7,'Sonu',350000,'Sonu@hexaware.com',69,2022,141),(8,'Soni',450000,'Soni@hexaware.com',42,2019,152),(9,'Sheshank',380000,'Sheshank@hexaware.com',53,2010,151),(10,'Sher',205000,'Sher@hexaware.com',58,2011,109),(15,'Samosa',3150000,'Samosa@hexaware.com',19,2017,112),(16,'Shayri',310000,'Shayri@hexaware.com',75,2019,162),(19,'Shekhar',380000,'Shekhar@hexaware.com',22,2012,172),(20,'Sona',780000,'Sona@hexaware.com',62,2013,156),(31,'Saket',3150000,'Saket@hexaware.com',82,2014,134),(38,'System',430000,'System@hexaware.com',43,2015,134),(39,'Sysstum',790000,'Sysstum@hexaware.com',90,2016,132),(49,'Sooraj',3050000,'Sooraj@hexaware.com',32,2017,125),(55,'Surbhi',630000,'Surbhi@hexaware.com',62,2018,129),(60,'Saneha',350800,'Saneha@hexaware.com',02,2021,149),(61,'Sanya',380000,'Sanya@hexaware.com',59,2020,134),(63,'Shakshi',750000,'Shakshi@hexaware.com',07,2022,191),(71,'Shivani',359000,'Shivani@hexaware.com',39,2019,131);
desc ex_employee;
select * from ex_employee order by annual_sal desc;
select * from ex_employee order by annual_sal;

# 1. Second Highest salary of employee
#set sql_mode=(select replace(@@sql_mode,'only_full_group_by',''));
#select max(annual_sal),ename from ex_employee where annual_sal<(select max(annual_sal) from ex_employee);
select ename,annual_sal from ex_employee where annual_sal = (select max(annual_sal) from ex_employee where annual_sal<(select max(annual_sal) from ex_employee));

# 2. Duplicate rows in the table
-- insert into ex_employee values(39,'Praveen',450000,'praveen@hexaware.com',108,2009,108),(36,'Anil',400000,'anil@hexaware.com',208,2019,100);
select eid,ename,annual_sal,email,dept_id,join_year,manager_id from ex_employee group by eid,ename,email,dept_id,manager_id having count(*)>1;

# 3. Fetch monthly salary of employee
select ename,annual_sal div 12 as monthly_sal from ex_employee;

# 4. Fetch first record from the table
select * from ex_employee limit 1;

# 5. Fetch last record from the table 
select * from ex_employee order by eid desc limit 1;

# 6. Display first 5 records from the table
select * from ex_employee limit 5;

# 7. Display Nth from the table.  --- let n = 10;
select * from ex_employee limit 1 offset 9; -- offset (n-1)

# 8. Dispay 3 highest salaries
select annual_sal from ex_employee order by annual_sal desc limit 3;

# 9. Display odd rows from the table
select * from ex_employee;
SELECT * FROM (SELECT ex_employee.*,ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) as row_num FROM ex_employee) AS numbered_rows WHERE row_num % 2 <> 0;


# 10. Display even rows from the table
select * from ex_employee;
SELECT * FROM (SELECT ex_employee.*,ROW_NUMBER() OVER (ORDER BY (SELECT NULL)) as row_num FROM ex_employee) AS numbered_rows WHERE row_num % 2 = 0;


# 11. Fetch 3rd highest salary from the table using rank function().
-- RANK() function is a window function that assigns a rank to each row within the result set based on the values of one or more columns. The ranking is determined based on the ordering specified in the ORDER BY clause.
SELECT * FROM (SELECT eid,ename, annual_sal, RANK() OVER (ORDER BY annual_sal DESC) AS salary_rank FROM ex_employee) AS ranked_salaries WHERE salary_rank = 3;

# 12. Create a table with same structure as ex_employee
create table new_table as select * from ex_employee where 1=0;
select * from new_table;
drop table new_table;

# 13. Display first 50% records from the table
-- SET @total_records = (SELECT COUNT(*) FROM ex_employee);
-- SET @limit_value = ROUND(@total_records * 0.5);

-- PREPARE stmt FROM 'SELECT * FROM ex_employee LIMIT ?';
-- EXECUTE stmt USING @limit_value;
-- DEALLOCATE PREPARE stmt;
DROP PROCEDURE IF EXISTS GetTopFiftyPercentRecords;

DELIMITER //
CREATE PROCEDURE GetTopFiftyPercentRecords()
BEGIN
    SET @total_records = (SELECT COUNT(*) FROM ex_employee);
    SET @limit_value = ROUND(@total_records * 0.5);
    SET @sql_query = CONCAT('SELECT * FROM ex_employee LIMIT ', @limit_value);    
    PREPARE stmt FROM @sql_query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;

call GetTopFiftyPercentRecords();

# 14. Display last 50% records from the table
DROP PROCEDURE IF EXISTS GetBottomFiftyPercentRecords;

DELIMITER //
CREATE PROCEDURE GetBottomFiftyPercentRecords()
BEGIN
    SET @total_records = (SELECT COUNT(*) FROM ex_employee);
    SET @limit_value = ROUND(@total_records * 0.5);
    SET @offset_value = @total_records - @limit_value;
    SET @sql_query = CONCAT('SELECT * FROM ex_employee LIMIT ', @offset_value, ', ', @limit_value);    
    PREPARE stmt FROM @sql_query;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
END //
DELIMITER ;
call GetBottomFiftyPercentRecords();



# 15. Create new table with same structure and the data as ex_employee table;
create table new_table as select * from ex_employee;
select * from new_table;
drop table new_table;


# 16. Fetch common records between 2 tables
delete from new_table where eid in(1,3,4,15,19,31,8,9,10,21,11,13);
select t1.*,t2.* from ex_employee t1 inner join new_table t2 on t1.eid=t2.eid;

# 17. Fetch records of employees who are not assigned to any department
update ex_employee set dept_id = null where eid in(2,22,13,31,19,91,1);
select * from ex_employee;
select * from ex_employee where dept_id is null or dept_id=0;

# 18. How to get distinct records from the table without using distinct keyword.
select eid,ename,annual_sal,email,dept_id,join_year,manager_id from ex_employee group by eid,ename,email,dept_id,manager_id having count(*)>1;
select * from ex_employee group by eid,ename,email,annual_sal,dept_id,manager_id order by eid;

# 19.Select all records from Employee table whose name is ‘Anil and ‘Praveen’
insert into ex_employee values(39,'Praveen',450000,'praveen@hexaware.com',108,2009,108),(36,'Anil',400000,'anil@hexaware.com',208,2019,100);
Select * from ex_employee where ename in('Anil','Praveen');
 
# 20.Select all records from Employee table where name not in ‘Anil and ‘Praveen’
 Select * from ex_employee where ename not in('Anil','Praveen');

# 21.how to write sql query for the below scenario
-- I/p:DATABASE
-- O/p:
-- D
-- A
-- T
-- A
-- B
-- A
-- S
-- E
SELECT 'D' AS Letter
UNION
SELECT 'A'
UNION
SELECT 'T'
UNION
SELECT 'A'
UNION
SELECT 'B'
UNION
SELECT 'A'
UNION
SELECT 'S'
UNION
SELECT 'E';
-- DELIMITER //
-- CREATE PROCEDURE SplitStringToRows(IN input_string VARCHAR(255))
-- BEGIN
--     DECLARE i INT DEFAULT 1;
--     DECLARE char_length INT;--     
--     SET char_length = LENGTH(input_string);
--     WHILE i <= char_length DO
--         SELECT SUBSTRING(input_string, i, 1) AS Letter;
--         SET i = i + 1;
--     END WHILE;
-- END //
-- DELIMITER ;
-- CALL SplitStringToRows('DATABASE');




#. 22.How to fetch all the records from Employee whose joining year is  2017?
 select * from ex_employee where join_year = 2017;
 
# 23.What is SQL Query to find maximum salary of each department?
update ex_employee set annual_sal=null where dept_id is null or 0;
select dept_id, max(annual_sal) as Max_Sal from ex_employee group by dept_id order by annual_sal desc;
 
# 24.How Do you find all Employees with its managers?(Consider there is manager id also in Employee table)
Select ename as Employee, manager_id as Manager from ex_employee where manager_id is not null or 0;
 
# 25.Display the name of employees who have joined in 2016 and salary is greater than 10000?
select * from ex_employee where join_year = 2016;
update ex_employee set join_year = 2016 where eid in(4,6,22,13,31);
select ename,join_year,annual_sal div 12 as Salary from ex_employee where join_year=2016 and annual_sal div 12 >10000;


# 26.How to display following using query?
-- *
-- **
-- ***
SELECT LPAD('*', 1, '*') AS pattern
UNION ALL
SELECT LPAD('*', 2, '*')
UNION ALL
SELECT LPAD('*', 3, '*');


# 27.How to add the email validation using only one query?
alter table ex_employee drop constraint chk_valid_email;
ALTER TABLE ex_employee ADD CONSTRAINT chk_valid_email CHECK (email REGEXP '^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,4}$');

# 28.How to display 1 to 100 Numbers with query?
 WITH RECURSIVE NumbersCTE AS (SELECT 1 AS Number
  UNION
  SELECT Number + 1 FROM NumbersCTE WHERE Number < 100)SELECT Number FROM NumbersCTE;

# 29.How to remove duplicate rows from table?
-- select count(*) as total_records from ex_employee;
-- select eid,ename,annual_sal,email,dept_id,join_year,manager_id from ex_employee group by eid,ename,email,dept_id,manager_id having count(*)>1;
DELETE ex_employee FROM ex_employee JOIN (SELECT eid, ename, dept_id, email FROM ex_employee GROUP BY eid, ename, dept_id, email HAVING COUNT(*) > 1) duplicate_records ON ex_employee.eid = duplicate_records.eid;


# 30.How to find count of duplicate rows? 
-- select eid,ename,annual_sal,email,dept_id,join_year,manager_id from ex_employee group by eid,ename,email,dept_id,manager_id having count(*)>1;
-- insert into ex_employee values(39,'Praveen',450000,'praveen@hexaware.com',108,2009,108),(36,'Anil',400000,'anil@hexaware.com',208,2019,100);

select ename,count(*) as Total_Dup from ex_employee group by eid,ename,email,dept_id,manager_id having count(*)>1;

# Delete all records
delete from ex_employee;
