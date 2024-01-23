use hexaware;
# Master Table
create table course(cid int , cname varchar(20), duration int, primary key(cid));
insert into course values(123,'Java',36),(234,'Python',24),(345,'C#',28),(456,'Dot NET',30);

# Creating Child Table
create table stud(sid int, sname varchar(50),scid int, foreign key (scid) references course(cid));
insert into stud values(633,'Suraj',123),(684,'Shyam',234),(649,'NoOne',345),(539,'Dont Know',456);
insert into stud values(829,'Anoop',567);
select cname as Course from course where cid = (select scid from stud where sid=633);