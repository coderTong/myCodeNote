# 2019年12月01日23:05:19

又双叒,来搞java了, 并做了计划, 这次必须完成. 

#  2019年12月02日22:42:20

### 命令执行记录;

create database mytest002;

create database if not exists mytest002;

create database myutf8 character set utf8;

create database if not exists db4 character set utf8;
drop database db4;
drop database if exists db4;

select database();

use mytest002;

show create database myutf8;

// 修改 数据库字符集
alter database mytest1 character set utf8;


```

mysql> create table t_person(

 -> id int,

 -> name varchar(100),

 -> age int

 -> );

Query OK, 0 rows affected (0.02 sec)

mysql> show tables;
```



create table t_person02 like t_person;



```

mysql> desc t_person02;

+-------+--------------+------+-----+---------+-------+

| Field | Type  | Null | Key | Default | Extra |

+-------+--------------+------+-----+---------+-------+

| id | int(11) | YES |  | NULL |  |

| name | varchar(100) | YES |  | NULL |  |

| age  | int(11) | YES |  | NULL |  |

+-------+--------------+------+-----+---------+-------+

3 rows in set (0.00 sec)



```



```


mysql> desc t_person02;

ERROR 1146 (42S02): Table 'mytest002.t_person02' doesn't exist

mysql> show tables;

+---------------------+

| Tables_in_mytest002 |

+---------------------+

| t_person |

+---------------------+

1 row in set (0.00 sec)

```



 insert into t_person(id,name,age) values(1,'tom',20);

insert into t_person(id,name,age) values(6,'万户侯',20);

insert into student(id,name,age) values(9,'哈哈哈',20);


insert into student(id,name,age) values(9,'操你大爷',20);


insert into student(id,name,age) values(19,'赶紧写月子二吧',20);


select * from t_person;

select * from student;


### delete from student where id=8;

```

mysql> select * from student;

+------+-----------------------+------+

| id  | name | age |

+------+-----------------------+------+

| 9 | 哈哈哈  |  20 |

| 8 | 坑爹玩意儿  |  90 |

|  90 | 你大爷累死了 | NULL |

| 9 | 操你大爷 |  20 |

|  19 | 赶紧写月子二吧 |  20 |

+------+-----------------------+------+

5 rows in set (0.00 sec)

mysql> delete from student where id=8;

Query OK, 1 row affected (0.01 sec)

mysql> select * from student;

+------+-----------------------+------+

| id  | name | age |

+------+-----------------------+------+

| 9 | 哈哈哈  |  20 |

|  90 | 你大爷累死了 | NULL |

| 9 | 操你大爷 |  20 |

|  19 | 赶紧写月子二吧 |  20 |

+------+-----------------------+------+

4 rows in set (0.00 sec)

mysql>


```



# update student set name='要啥自行车', age=22  where id=9;
```

update student set name='要啥自行车', age=22  where id=9;

```




# select name from student;
# select name,age from student;



```


mysql> select name from student;

+-----------------------+

| name |

+-----------------------+

| 要啥自行车  |

| 你大爷累死了 |

| 要啥自行车  |

| 赶紧写月子二吧 |

+-----------------------+

4 rows in set (0.00 sec)

mysql> select name,age from student;

+-----------------------+------+

| name | age |

+-----------------------+------+

| 要啥自行车  |  22 |

| 你大爷累死了 | NULL |

| 要啥自行车  |  22 |

| 赶紧写月子二吧 |  20 |

+-----------------------+------+

4 rows in set (0.00 sec)


```


# select * from student where age > 20;
# select * from student where age >= 20;


```

mysql> select * from student where age > 20;

+------+-----------------------------+------+

| id  | name | age |

+------+-----------------------------+------+

| 9 | 要啥自行车  |  22 |

| 9 | 要啥自行车  |  22 |

| 2 | 穿上马甲照样认识你 |  35 |

+------+-----------------------------+------+

3 rows in set (0.00 sec)

mysql> select * from student where age >= 20;

+------+-----------------------------+------+

| id  | name | age |

+------+-----------------------------+------+

| 9 | 要啥自行车  |  22 |

| 9 | 要啥自行车  |  22 |

|  19 | 赶紧写月子二吧  |  20 |

| 2 | 穿上马甲照样认识你 |  35 |

+------+-----------------------------+------+

4 rows in set (0.00 sec)


```


# select * from student where age >= 20 && age <= 30;

# mysql> select * from student where age = 22 or age = 14;

# select * from student where age in(22,14); 

```

mysql> select * from student where age = 22 or age = 14;

+------+-----------------+------+

| id  | name | age |

+------+-----------------+------+

| 9 | 要啥自行车 |  22 |

| 9 | 要啥自行车 |  22 |

| 3 | oc牛逼 |  14 |

+------+-----------------+------+

3 rows in set (0.00 sec)


mysql> select * from student where age in(22,14);                             

+------+-----------------+------+

| id  | name | age |

+------+-----------------+------+

| 9 | 要啥自行车 |  22 |

| 9 | 要啥自行车 |  22 |

| 3 | oc牛逼 |  14 |

+------+-----------------+------+

3 rows in set (0.00 sec)


```

# select * from student where name is NULL;


```

mysql> select * from student where name is NULL;

+------+------+------+

| id  | name | age |

+------+------+------+

| 4 | NULL |  16 |

+------+------+------+

1 row in set (0.00 sec)


```


# select * from student where name is not NULL;



```

mysql> select * from student where name is not NULL;

+------+-----------------------------+------+

| id  | name | age |

+------+-----------------------------+------+

| 9 | 要啥自行车  |  22 |

|  90 | 你大爷累死了 | NULL |

| 9 | 要啥自行车  |  22 |

|  19 | 赶紧写月子二吧  |  20 |

| 1 | 悄悄的打枪的不要 |  18 |

| 2 | 穿上马甲照样认识你 |  35 |

| 3 | oc牛逼 |  14 |

+------+-----------------------------+------+

7 rows in set (0.00 sec)


```



# select * from student where name like '要%';

```

select * from student where name like '要%';

+------+-----------------+------+

| id  | name | age |

+------+-----------------+------+

| 9 | 要啥自行车 |  22 |

| 9 | 要啥自行车 |  22 |

| 5 | 要啥手表 | NULL |

+------+-----------------+------+

3 rows in set (0.00 sec)






mysql> select * from student where name like '_啥%';

+------+-----------------+------+

| id  | name | age |

+------+-----------------+------+

| 9 | 要啥自行车 |  22 |

| 9 | 要啥自行车 |  22 |

| 5 | 要啥手表 | NULL |

+------+-----------------+------+

3 rows in set (0.00 sec)





mysql> select * from student where name like '____';

+------+--------------+------+

| id  | name  | age |

+------+--------------+------+

| 3 | oc牛逼  |  14 |

| 5 | 要啥手表 | NULL |

+------+--------------+------+

2 rows in set (0.00 sec)

mysql> select * from student where name like '%???%';

+------+--------------------------+------+

| id  | name  | age |

+------+--------------------------+------+

| 9 | 要啥自行车 |  22 |

| 9 | 要啥自行车 |  22 |

| 1 | 悄悄的打枪的不要 |  18 |

| 5 | 要啥手表  | NULL |

+------+--------------------------+------+

4 rows in set (0.00 sec)


```




select * from student order by id DESC;


select count(age) from student;
select max(age) from student;
select min(age) from student;
select avg(age) from student;



```


select sex, AVG(age) from student group by sex;

select sex from student group by sex;

mysql> select sex from student group by sex;

+------+

| sex |

+------+

| 0 |

| 1 |

+------+

2 rows in set (0.00 sec)

mysql> select sex, AVG(age) from student group by sex;

+------+----------+

| sex | AVG(age) |

+------+----------+

| 0 | 26.3333 |

| 1 | 17.0000 |

+------+----------+

2 rows in set (0.00 sec)


```





```

mysql> select sex, avg(math), count(id) from student group by sex;

+------+-----------+-----------+

| sex | avg(math) | count(id) |

+------+-----------+-----------+

| 0 |  80.4000 |  5 |

| 1 |  64.4000 |  5 |

+------+-----------+-----------+

2 rows in set (0.00 sec)




年龄相同的站一排, 算出每一排的数学平均成绩.并说出没一排的人数.
mysql> select age, avg(math),count(id) from student group by age;

+------+-----------+-----------+

| age | avg(math) | count(id) |

+------+-----------+-----------+

|  14 |  64.5000 |  2 |

|  16 |  99.0000 |  1 |

|  18 |  45.0000 |  1 |

|  20 |  66.0000 |  1 |

|  22 |  79.0000 |  3 |

|  26 |  80.0000 |  1 |

|  28 |  78.0000 |  1 |

|  35 |  77.0000 |  1 |

+------+-----------+-----------+


年龄相同的站一排, 算出每一排的数学平均成绩.并说出没一排的人数.
说人数小于2的不要了, 看看还有哪些人
having 要在分组之后

mysql> select age, avg(math),count(id) from student group by age having count(id) > 1;

+------+-----------+-----------+

| age | avg(math) | count(id) |

+------+-----------+-----------+

|  14 |  64.5000 |  2 |

|  22 |  79.0000 |  3 |

+------+-----------+-----------+

2 rows in set (0.00 sec)


年龄相同的站一排, 要成年人, 算出每一排的数学平均成绩.并说出没一排的人数.
说人数小于2的不要了, 看看还有哪些人
where 要在分组前

select age, avg(math),count(id) from student where age>18 group by age having count(id) > 1;
mysql> select age, avg(math),count(id) from student where age>18 group by age having count(id) > 1;

+------+-----------+-----------+

| age | avg(math) | count(id) |

+------+-----------+-----------+

|  22 |  79.0000 |  3 |

+------+-----------+-----------+

1 row in set (0.00 sec)


```



# 2019年12月06日00:38:38


```


create table if not EXISTS department(
 id int primary key auto_increment,
 dep_name varchar(20),
 dep_location varchar(20)
);


create table  if not EXISTS employee(
id int primary key auto_increment, name varchar(20),
age int,
dep_id int, -- 外键对应主表的主键
-- 创建外键约束
constraint emp_depid_fk foreign key (dep_id) references
  department(id) on update cascade on delete cascade
);

insert into department values(null, '研发部','广州'),(null, '销售部', '深圳'); select * from department;


INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1); INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1); INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);

INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2); INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2); INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);


```
