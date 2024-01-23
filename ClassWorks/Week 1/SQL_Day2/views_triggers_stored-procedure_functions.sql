use fsd;
call getDepartment(10);

call inandout(101,@name);
select @name;

call updateEmployeeComm(102);

call pro_case(102,@job);
select @job;

call while_demo(101);

-- Function call
select getsalary(101);

-- Trigger
CREATE TABLE account (acct_num INT, amount DECIMAL(10,2));
SET @sum = 0;
CREATE TRIGGER insert_sum BEFORE INSERT ON account FOR EACH ROW SET @sum = @sum + NEW.amount;
INSERT INTO account VALUES(137,14.98),(141,1937.50),(97,-100.00);
SELECT @sum AS 'Total amount inserted';

set @data='';
create trigger update_dept after update on dept for each row set @data = 'Record updated successfuly';
update dept set location='Delhi' where dno=70;
select @data;

-- Views
create view emp_info as select * from employees where job in ('Developer','Tester','HR','Intern');
select * from emp_info;
update employees set dno=70 where job='Intern';
select * from dept;
insert into dept values(70,'Intern','Patna');
