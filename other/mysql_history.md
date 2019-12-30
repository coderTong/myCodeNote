```



show tables;

show databases;

help show

help SHOW GRANTS

help show;

help

help use

show a

;

show %a%;

show %a%

;

help %a%;

help %ad%;

help %adm%;

ls

;

help select

help select user

select user.host from mysql.user;

;

help grant;

quitt

;

quit;

grant all on *.* to 'tom'@'localhost' identified by '123456a7';

flush privileges;

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a7';

flush privileges;

select user,host from mysql.user;

flush privileges;

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a7';

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

drop user 'tom'@'localhost';

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

quit;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

select user,host from mysql.user;

show database;

show databases;

grant all on *.* to 'doukeyi'@'%' identified by '123456a7';

flush privileges;

select user,host from mysql.useer;

select user,host from mysql.user;

show databases;

use mytest1;

show tables;

exit;

create database mytest002;

show databases;

create database if not exists mytest002;

show databases;

create database mytest002;

ls

;

create database if not exists mytest002 character set utf8;

create database myutf8 character set utf8;

create database if not exists db4 character seet utf8;

create database if not exists db4 character set utf8;

show databases;

drop database db4;

show databases;

drop database if exists db4;

select database();

use mytest002;

select database();

show databases;

show create database mytest002;

show create database mytest1;

show create database t_taopaojihua001;

show create database myutf8;

alter database mytest1 character set utf8;

show create database mytest1;

select database();

show tables;

create table t_person(

id int

name varchar(100)

;

create table t_person( id int name varchar(100);

create table t_person(

id int,

name varchar(100),

age int

);

create table t_person( id int, name varchar(100), age int );

show tables;

create table t_person02 like t_person;

show tables;

desc t_person02;

drop table t_person02;

desc t_person02;

show tables;

insert into t_person(id,name,age) values(1,tom,20);

insert into t_person(id,name,age) values(1,'tom',20);

show t_person;

show table t_person;

show create table t_person;

show create database mytest002;

alter database mytest002 character set utf8;

show databases;

use mytest002;

select database();

show tables;

insert into t_person(id,name,age) values(6,'万户侯',20);

insert into t_person(id,name,age) values(6,'7,?,"周杰伦",20);

;

use mytest002;

show create table t_person;

select * from t_person;

insert into t_person(id,name,age) values(6,'万户侯',20);

select * from t_person;

set names utf8;

insert into t_person(id,name,age) values(9,'哈哈哈',20);

select * from t_person;

alter table t_person character set utf8;

select * from t_person;

show create table t_person;

insert into t_person(id,name,age) values(9,'哈哈哈',20);

show create table t_person;

select * from t_person;

create table t_pp2;

select database();

create table student(

id int,

name varchar(32),

age int

);

create table student( id int, name varchar(32), age int );

select * from student;

show create table student;

insert into t_pstudentname,age) values(9,'哈哈哈',20);

insert into student(id,name,age) values(9,'哈哈哈',20);

show create table student;

select * from student;

show create table student;

select * from student;

insert into student(id,name,age) values(990,'你好 '20)

;

insert into student(id,name,age) values(9,'操你大爷',20);

select * from student;

ls;

show databases;

select database();

use mytest002;

select database();

show tables;

desc student;

select * from student;

set names utf8;

select * from student;

show create table student;

select * from student;

insert into student(id,name,age) values(19,'赶紧写月子二吧',20);

select * from student;

delete from student where id=8;

select * from student;

update student set name='要啥自行车', age=22 where id=9;

select * from student;

select name from student;

select name,age from student;

select name where age=20 from student;

select name ,age=20 from student;

select * from student;

show databases;

use mytest002;

show tables;

select * from ç mytest002;

select * from mytest002;

select * from student;

select * from student;;

select * from t_person;

select * from student;;

set names utf8;

select * from student;;

select * from student where age > 20;

select * from student where age >= 20;

select * from student where age = 14;

select * from student where age != 14;

select * from student where age <> 14;

select * from student where age >= 20 age <= 30;

select * from student where age >= 20 && age <= 30;

select * from student where age = 22 or age = 14;

select * from student where age in(22,14);

select * from student where name is NULL;

select * from student where name is not NULL;

select * from student where name like '要%';

select * from student where name like '?_啥%';

select * from student where name like '?啥%';

select * from student where name like '?_啥%';

select * from student where name like '_啥%';

select * from studennt;

select * from student;

select * from student where name likee '___';

select * from student where name like '___';

select * from student where name like '____';

select * from student where name like '%要%';

show databses;

show databases;

use mytest002;

show tables;

select * from student;

set names utf8;

select * from student;

select * from student order by ASC;

select * from student order by id ASC;

select * from student order by id;

select * from student order by id DESC;

select * from student order by id DESC, age ;

select * from student;

update student set `id`='12' where `id`='19';

select * from student;

update student set `id`='12' where `id`='19';

select count(age) from student;

select max(age) from student;

select min(age) from student;

select avg(age) from student;   

select * from student; ;

select sex from student group by 0;

Select from student group by sex;

select from student group by sex;

select sex, AVG(age) from student group by sex;

select sex, from student group by sex;

select sex from student group by sex;

select sex, AVG(age) from student group by sex;

select age from student group by age;

select * from student;

select sex, avg(math), count(id) from student group by sex;

show databases;

use mytest002;

show tables;

select * from student;

set names utf8;

select * from student;

inster 

;

insert into student(id,name,age,sex,math) values(7,'tom',22,1,87);

select * from student;

select age, avg(math),count(id) from student group by age;

select age, avg(math),count(id) from student having select age, avg(math),count(id) from student group by age; group by age;

select age, avg(math),count(id) from student having count(id) > 1 group by age;

select age, avg(math),count(id) from student group by age having count(id) > 1;

select age, avg(math),count(id) from student where age>18 group by age having count(id) > 1;

select * from student limit 0,3;

select * from student limit 3,3;

select * from student limit 6,3;

select * from student;

show create table stu;l

;

show create table stu;

alter table stu modify `id` int not NULL;

show create table stu;

alter table stu modify `name` varchar(20);

show create table stu;

show create table stu2;

alter table stu2 modify name varchar(20) unique;

show create table stu2;

alter table stu2 drop index name;

show create table stu2;

show create table stu3;

alter table stu3 drop primary key;

show create table stu3;

alter table stu3 modify id int primary keyl

;

alter table stu3 modify id int primary key;

show create table stu3;

show create table stu4;

alter table stu4 modify id int;

show create table stu4;

alter table stu4 modify id int AUTO_INCREMENT;

show create table stu4;

exit;

show databases;

use mytest002

use myutf8;

use mytest002

show tables;

show create table employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom', 21, 2);

select * from employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom2', 21, 1);

select * from employee;

set names utf8;

select * from employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom22', 21, 3);

insert into employee(`name`, `age`, `dep_id`) values ('tom22', 21, 2);

select * from employee;

alter table employee ADD `weihao` varchar(20);

select * from employee;

alter table employee ADD dep_id2 int;

select * from employee;

alter table employee ADD constraint `dep_key2` foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint 'dep_key2' foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key dep_id2 references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key dep_id2 references department(id);

alter table employee ADD constraint dep_key_tes foreign key (dep_id2) references department(id);

select * from employee;

alter table employee drop foreign key dep_id2;

show create table employee;

alter table employee drop foreign key dep_key_tes;

show create table employee;

show databases;

use myutf8;

show tables;

drop table department;

delete from department where id=2;

drop table department;

show tables;

select * from department;

select * from employee;

drop table department;

drop table employee;

drop table department;

show databasesl

;

show databases;

use mytest002;

show tablesl

;

show tablesl show tablesl show tablesl;

show tables;

x

;

\

select * from t_category;

set names t_category;

set names utf8;

select * from t_category;

create table tab_route(

rid int primary key auto_increment,

rname varchar

(20);

create table tab_route( rid int primary key auto_increment, rname varchar (20);

create table tab_route(

rid int primary key auto_increment,

rname varchar(100) not NULL unique,

price double,

rdate date,

cid int,

foreign key (cid) references t_category(cid)

);

create table tab_route( rid int primary key auto_increment, rname varchar(100) not NULL unique, price double, rdate date, cid int, foreign key (cid) references t_category(cid) );

select * from tab_route;

show databasees;

show databases;

show create database mysql\G;

show databasesl

;

show databases;

show create database mytest002;

show databases;

use myutf8;

show tables;

ls

;

show create table t_notnull;

alter table t_notnull modify `name` varchar(200);

show create table t_notnull;

alter table t_notnull modify `name` varchar(200) not null;

show create table t_notnull;

alter table t_notnull ADD `age` int not NULL;

show create table t_notnull;

select * from t_notnull;

alter table t_notnull ADD `addr` varchar(100) not null UNIQUE;

show create table t_notnull;

alter table t_notnull drop index `addr`;

alteerr table t_notnull `addr` varchar(100) UNIQUE;

alteerr table modify t_notnull `addr` varchar(100) UNIQUE;

alter table modify t_notnull `addr` varchar(100) UNIQUE;

alter table t_notnull modify `addr` varchar(100) UNIQUE;

show create table t_notnull;

alter table t_notnull modify `id` int primary key;

show create table t_notnull;

alter table t_notnull drop `addr`;

show create table t_notnull;

alter table t_notnull drop primary key;

show databasesl

;

show databases;

use mytest002;

show tables;

alter table t_person modify `name` varchar(100) CHARACTER SET utf8;

ls

;

select database();

show tables;

use myutf8;

show tables;

select * from dept,emp;

set names utf8;

select * from dept,emp;

SELECT * from emp, dept WHERE id=5;

SELECT * from emp, dept WHERE `emp`.`dept_id` = `dept`.`id`;

SELECT * from dept d, (SELECT * FROM emp WHERE join_date >='2011-1-1') e WHERE d.`id` = e.`dept_id`;

SELECT * FROM emp INNER JOIN dept ON emp.dept_id = dept.id AND join_date >= '2011-1-1'; 

show databases;

use myutf8;

show tales;

shoow tables;

show tables;

select * from myutf8;

select * from account;

set names uttf8;

set names utf8;

select * from account;

update balance=1000 from account;

update account set balance=1000;

select * from account;

show databasesl

;

show databases;

use myutf8;

select * from account;

update account set balance=1000;

select * from account;

set names utf8;

select * from account;

update account set balance=1000;

select * from account;

start trransaction;

start transaction;

update account set balance = balance - 500 where name='张三';

start transaction;

select * from account;

show databases;

use myutf8;

select * from account;

start  transaction;

update account set balance = balance - 500 where name='张

;

';

update account set balance = balance - 500 where name='张

;

;

';

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

set names utf8;

select * from account;

commit;

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

start transaction;

update account set balance = balance - 500 where name='张三';

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

commit;

select * from account;

show databases;

use myutf8;

show tables;

strat transaction;

start transaction;

update account set balance = balance - 500 where name='李四';

update account set balance = balance + 500 where name='张三';

select * frrom account;

select * from account;

set names uutf8;

set names utf8;

select * from account;

update account set balance = balance - 500 where name='李四';

select * from account;

update account set balance = balance + 500 where name='张三';

select * from account;

rollback;

select * from account;

select @@autocommit;

set @@autocommit;

set @@autocommit = 0;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

flush PRIVILEGES;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

flush PRIVILEGES;

select @@autocommit;

set @@autocommit = 0;

show databases;

use myutf8

set names utf8;

selecct 

* from acccount

;

selecct * from acccount;

show tables;

select * from account;

;

select @@autocommit;

update account set balance = balance - 500 where id=2;

select * from account;

exit;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

show databses;

show databales;

show databases;

use myutf8;

show tables;

select * from account;

set namesl 

;

set names utf8;

select * from account;

update account set balance=balance-500 where id=2;

select * from account;

commit;

select @@tx_isolation;

select user,host from mysql.user;

set password for 'doukeyi'@'%' =password('123456a');

show databases;

use myutf8;

show tables;

select * from t_jdbcStuudent;

show databases;

use myutf8;

show tables;

show create table t_user;

show create table t_jdbcStuudent3;

select * from t_jdbcStuudent3;

set names utf8;

select * from t_jdbcStuudent3;

show databasesl

;

show databases;

use myutf8;

show tables;

select *from account;

set names utf8;

select *from account;

show databases;

use myutf8;

show tablesl

;

show tables;

select * from account;

set names utf8;

select * from account;

select * from String sql = "select * from account where id = ? or id = ?;";

select * from account where id = 1 or id = 2;

show databases;

show create mytest002;

show create database mytest002;

```


show tables;

show databases;

help show

help SHOW GRANTS

help show;

help

help use

show a

;

show %a%;

show %a%

;

help %a%;

help %ad%;

help %adm%;

ls

;

help select

help select user

select user.host from mysql.user;

;

help grant;

quitt

;

quit;

grant all on *.* to 'tom'@'localhost' identified by '123456a7';

flush privileges;

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a7';

flush privileges;

select user,host from mysql.user;

flush privileges;

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a7';

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

drop user 'tom'@'localhost';

select user,host from mysql.user;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

quit;

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';

select user,host from mysql.user;

show database;

show databases;

grant all on *.* to 'doukeyi'@'%' identified by '123456a7';

flush privileges;

select user,host from mysql.useer;

select user,host from mysql.user;

show databases;

use mytest1;

show tables;

exit;

create database mytest002;

show databases;

create database if not exists mytest002;

show databases;

create database mytest002;

ls

;

create database if not exists mytest002;

create database myutf8 character set utf8;

create database if not exists db4 character seet utf8;

create database if not exists db4 character set utf8;

show databases;

drop database db4;

show databases;

drop database if exists db4;

select database();

use mytest002;

select database();

show databases;

show create database mytest002;

show create database mytest1;

show create database t_taopaojihua001;

show create database myutf8;

alter database mytest1 character set utf8;

show create database mytest1;

select database();

show tables;

create table t_person(

id int

name varchar(100)

;

create table t_person( id int name varchar(100);

create table t_person(

id int,

name varchar(100),

age int

);

create table t_person( id int, name varchar(100), age int );

show tables;

create table t_person02 like t_person;

show tables;

desc t_person02;

drop table t_person02;

desc t_person02;

show tables;

insert into t_person(id,name,age) values(1,tom,20);

insert into t_person(id,name,age) values(1,'tom',20);

show t_person;

show table t_person;

show create table t_person;

show create database mytest002;

alter database mytest002 character set utf8;

show databases;

use mytest002;

select database();

show tables;

insert into t_person(id,name,age) values(6,'万户侯',20);

insert into t_person(id,name,age) values(6,'7,?,"周杰伦",20);

;

use mytest002;

show create table t_person;

select * from t_person;

insert into t_person(id,name,age) values(6,'万户侯',20);

select * from t_person;

set names utf8;

insert into t_person(id,name,age) values(9,'哈哈哈',20);

select * from t_person;

alter table t_person character set utf8;

select * from t_person;

show create table t_person;

insert into t_person(id,name,age) values(9,'哈哈哈',20);

show create table t_person;

select * from t_person;

create table t_pp2;

select database();

create table student(

id int,

name varchar(32),

age int

);

create table student( id int, name varchar(32), age int );

select * from student;

show create table student;

insert into t_pstudentname,age) values(9,'哈哈哈',20);

insert into student(id,name,age) values(9,'哈哈哈',20);

show create table student;

select * from student;

show create table student;

select * from student;

insert into student(id,name,age) values(990,'你好 '20)

;

insert into student(id,name,age) values(9,'操你大爷',20);

select * from student;

ls;

show databases;

select database();

use mytest002;

select database();

show tables;

desc student;

select * from student;

set names utf8;

select * from student;

show create table student;

select * from student;

insert into student(id,name,age) values(19,'赶紧写月子二吧',20);

select * from student;

delete from student where id=8;

select * from student;

update student set name='要啥自行车', age=22 where id=9;

select * from student;

select name from student;

select name,age from student;

select name where age=20 from student;

select name ,age=20 from student;

select * from student;

show databases;

use mytest002;

show tables;

select * from ç mytest002;

select * from mytest002;

select * from student;

select * from student;;

select * from t_person;

select * from student;;

set names utf8;

select * from student;;

select * from student where age > 20;

select * from student where age >= 20;

select * from student where age = 14;

select * from student where age != 14;

select * from student where age <> 14;

select * from student where age >= 20 age <= 30;

select * from student where age >= 20 && age <= 30;

select * from student where age = 22 or age = 14;

select * from student where age in(22,14);

select * from student where name is NULL;

select * from student where name is not NULL;

select * from student where name like '要%';

select * from student where name like '?_啥%';

select * from student where name like '?啥%';

select * from student where name like '?_啥%';

select * from student where name like '_啥%';

select * from studennt;

select * from student;

select * from student where name likee '___';

select * from student where name like '___';

select * from student where name like '____';

select * from student where name like '%要%';

show databses;

show databases;

use mytest002;

show tables;

select * from student;

set names utf8;

select * from student;

select * from student order by ASC;

select * from student order by id ASC;

select * from student order by id;

select * from student order by id DESC;

select * from student order by id DESC, age ;

select * from student;

update student set `id`='12' where `id`='19';

select * from student;

update student set `id`='12' where `id`='19';

select count(age) from student;

select max(age) from student;

select min(age) from student;

select avg(age) from student;   

select * from student; ;

select sex from student group by 0;

Select from student group by sex;

select from student group by sex;

select sex, AVG(age) from student group by sex;

select sex, from student group by sex;

select sex from student group by sex;

select sex, AVG(age) from student group by sex;

select age from student group by age;

select * from student;

select sex, avg(math), count(id) from student group by sex;

show databases;

use mytest002;

show tables;

select * from student;

set names utf8;

select * from student;

inster 

;

insert into student(id,name,age,sex,math) values(7,'tom',22,1,87);

select * from student;

select age, avg(math),count(id) from student group by age;

select age, avg(math),count(id) from student having select age, avg(math),count(id) from student group by age; group by age;

select age, avg(math),count(id) from student having count(id) > 1 group by age;

select age, avg(math),count(id) from student group by age having count(id) > 1;

select age, avg(math),count(id) from student where age>18 group by age having count(id) > 1;

select * from student limit 0,3;

select * from student limit 3,3;

select * from student limit 6,3;

select * from student;

show create table stu;l

;

show create table stu;

alter table stu modify `id` int not NULL;

show create table stu;

alter table stu modify `name` varchar(20);

show create table stu;

show create table stu2;

alter table stu2 modify name varchar(20) unique;

show create table stu2;

alter table stu2 drop index name;

show create table stu2;

show create table stu3;

alter table stu3 drop primary key;

show create table stu3;

alter table stu3 modify id int primary keyl

;

alter table stu3 modify id int primary key;

show create table stu3;

show create table stu4;

alter table stu4 modify id int;

show create table stu4;

alter table stu4 modify id int AUTO_INCREMENT;

show create table stu4;

exit;

show databases;

use mytest002

use myutf8;

use mytest002

show tables;

show create table employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom', 21, 2);

select * from employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom2', 21, 1);

select * from employee;

set names utf8;

select * from employee;

insert into employee(`name`, `age`, `dep_id`) values ('tom22', 21, 3);

insert into employee(`name`, `age`, `dep_id`) values ('tom22', 21, 2);

select * from employee;

alter table employee ADD `weihao` varchar(20);

select * from employee;

alter table employee ADD dep_id2 int;

select * from employee;

alter table employee ADD constraint `dep_key2` foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint 'dep_key2' foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key `dep_id2` references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key dep_id2 references department(`id`);

alter table employee ADD constraint dep_key_tes foreign key dep_id2 references department(id);

alter table employee ADD constraint dep_key_tes foreign key (dep_id2) references department(id);

select * from employee;

alter table employee drop foreign key dep_id2;

show create table employee;

alter table employee drop foreign key dep_key_tes;

show create table employee;

show databases;

use myutf8;

show tables;

drop table department;

delete from department where id=2;

drop table department;

show tables;

select * from department;

select * from employee;

drop table department;

drop table employee;

drop table department;

show databasesl

;

show databases;

use mytest002;

show tablesl

;

show tablesl show tablesl show tablesl;

show tables;

x

;

\

select * from t_category;

set names t_category;

set names utf8;

select * from t_category;

create table tab_route(

rid int primary key auto_increment,

rname varchar

(20);

create table tab_route( rid int primary key auto_increment, rname varchar (20);

create table tab_route(

rid int primary key auto_increment,

rname varchar(100) not NULL unique,

price double,

rdate date,

cid int,

foreign key (cid) references t_category(cid)

);

create table tab_route( rid int primary key auto_increment, rname varchar(100) not NULL unique, price double, rdate date, cid int, foreign key (cid) references t_category(cid) );

select * from tab_route;

show databasees;

show databases;

show create database mysql\G;

show databasesl

;

show databases;

show create database mytest002;

show databases;

use myutf8;

show tables;

ls

;

show create table t_notnull;

alter table t_notnull modify `name` varchar(200);

show create table t_notnull;

alter table t_notnull modify `name` varchar(200) not null;

show create table t_notnull;

alter table t_notnull ADD `age` int not NULL;

show create table t_notnull;

select * from t_notnull;

alter table t_notnull ADD `addr` varchar(100) not null UNIQUE;

show create table t_notnull;

alter table t_notnull drop index `addr`;

alteerr table t_notnull `addr` varchar(100) UNIQUE;

alteerr table modify t_notnull `addr` varchar(100) UNIQUE;

alter table modify t_notnull `addr` varchar(100) UNIQUE;

alter table t_notnull modify `addr` varchar(100) UNIQUE;

show create table t_notnull;

alter table t_notnull modify `id` int primary key;

show create table t_notnull;

alter table t_notnull drop `addr`;

show create table t_notnull;

alter table t_notnull drop primary key;

show databasesl

;

show databases;

use mytest002;

show tables;

alter table t_person modify `name` varchar(100) CHARACTER SET utf8;

ls

;

select database();

show tables;

use myutf8;

show tables;

select * from dept,emp;

set names utf8;

select * from dept,emp;

SELECT * from emp, dept WHERE id=5;

SELECT * from emp, dept WHERE `emp`.`dept_id` = `dept`.`id`;

SELECT * from dept d, (SELECT * FROM emp WHERE join_date >='2011-1-1') e WHERE d.`id` = e.`dept_id`;

SELECT * FROM emp INNER JOIN dept ON emp.dept_id = dept.id AND join_date >= '2011-1-1'; 

show databases;

use myutf8;

show tales;

shoow tables;

show tables;

select * from myutf8;

select * from account;

set names uttf8;

set names utf8;

select * from account;

update balance=1000 from account;

update account set balance=1000;

select * from account;

show databasesl

;

show databases;

use myutf8;

select * from account;

update account set balance=1000;

select * from account;

set names utf8;

select * from account;

update account set balance=1000;

select * from account;

start trransaction;

start transaction;

update account set balance = balance - 500 where name='张三';

start transaction;

select * from account;

show databases;

use myutf8;

select * from account;

start  transaction;

update account set balance = balance - 500 where name='张

;

';

update account set balance = balance - 500 where name='张

;

;

';

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

set names utf8;

select * from account;

commit;

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

start transaction;

update account set balance = balance - 500 where name='张三';

select * from account;

update account set balance = balance + 500 where name='李四';

select * from account;

commit;

select * from account;

show databases;

use myutf8;

show tables;

strat transaction;

start transaction;

update account set balance = balance - 500 where name='李四';

update account set balance = balance + 500 where name='张三';

select * frrom account;

select * from account;

set names uutf8;

set names utf8;

select * from account;

update account set balance = balance - 500 where name='李四';

select * from account;

update account set balance = balance + 500 where name='张三';

select * from account;

rollback;

select * from account;

select @@autocommit;

set @@autocommit;

set @@autocommit = 0;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

flush PRIVILEGES;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

flush PRIVILEGES;

select @@autocommit;

set @@autocommit = 0;

show databases;

use myutf8

set names utf8;

selecct 

* from acccount

;

selecct * from acccount;

show tables;

select * from account;

;

select @@autocommit;

update account set balance = balance - 500 where id=2;

select * from account;

exit;

select @@autocommit;

set @@autocommit = 0;

select @@autocommit;

show databses;

show databales;

show databases;

use myutf8;

show tables;

select * from account;

set namesl 

;

set names utf8;

select * from account;

update account set balance=balance-500 where id=2;

select * from account;

commit;

select @@tx_isolation;

select user,host from mysql.user;

set password for 'doukeyi'@'%' =password('123456a');

show databases;

use myutf8;

show tables;

select * from t_jdbcStuudent;

show databases;

use myutf8;

show tables;

show create table t_user;

show create table t_jdbcStuudent3;

select * from t_jdbcStuudent3;

set names utf8;

select * from t_jdbcStuudent3;

show databasesl

;

show databases;

use myutf8;

show tables;

select *from account;

set names utf8;

select *from account;

show databases;

use myutf8;

show tablesl

;

show tables;

select * from account;

set names utf8;

select * from account;

select * from String sql = "select * from account where id = ? or id = ?;";

select * from account where id = 1 or id = 2;

show databases;

show create mytest002;

show create database mytest002;