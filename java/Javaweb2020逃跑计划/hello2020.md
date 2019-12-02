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


select * from t_person;
