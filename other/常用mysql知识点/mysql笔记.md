# mytest002

## 建表语句

```sql


CREATE TABLE IF not EXISTS `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(20) DEFAULT NULL,
  `dep_location` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



CREATE TABLE IF not EXISTS `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dep_id` int(11) DEFAULT NULL,
  `weihao` varchar(20) DEFAULT NULL,
  `dep_id2` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_depid_fk` (`dep_id`),
  KEY `dep_key_tes` (`dep_id2`),
  CONSTRAINT `emp_depid_fk` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;


CREATE TABLE IF not EXISTS  `sex` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `dep_id` int(11) DEFAULT NULL,
  KEY `dep_name` (`dep_id`),
  CONSTRAINT `dep_name` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;




CREATE TABLE IF not EXISTS   `stu` (
  `id` int(11) NOT NULL,
  `name` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF not EXISTS   `stu2` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF not EXISTS `stu3` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF not EXISTS  `stu4` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `phoneNumber` (`phoneNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;




CREATE TABLE IF not EXISTS `student` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `math` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF not EXISTS `t_category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) NOT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;



CREATE TABLE IF not EXISTS `t_person` (
  `id` int(11) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `age` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF not EXISTS `tab_route` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(100) NOT NULL,
  `price` double DEFAULT NULL,
  `rdate` date DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `rname` (`rname`),
  KEY `cid` (`cid`),
  CONSTRAINT `tab_route_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `t_category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;




ALTER TABLE sex MODIFY `id` int(11) PRIMARY KEY AUTO_INCREMENT;



```


## 数据插入

```sql


INSERT INTO department(id, dep_name, dep_location) VALUES(NULL, "研发部", "广州");
INSERT INTO department(id, dep_name, dep_location) VALUES(NULL, "技术部", "北京");
INSERT INTO department(id, dep_name, dep_location) VALUES(NULL, "销售部", "深圳");



INSERT INTO employee(id, `name`, `age`,`dep_id`, `weihao`) VALUES(NULL, "张三", 18, 3, "小c");
INSERT INTO employee(id, `name`, `age`,`dep_id`, `weihao`) VALUES(NULL, "王八蛋", 22, 4, "乌龟");
INSERT INTO employee(id, `name`, `age`,`dep_id`, `weihao`) VALUES(NULL, "畜生", 38, 5, "猪");
INSERT INTO employee(id, `name`, `age`,`dep_id`, `weihao`) VALUES(NULL, "鬼畜", 44, 3, "弹幕");
INSERT INTO employee(id, `name`, `age`,`dep_id`, `weihao`) VALUES(NULL, "傻逼", 21, 3, "狗日的");




INSERT INTO sex(`id`, `name`, `age`, `sex`, `dep_id`) VALUES(NULL, "王大锤", 21, 1, "3");

```





# loginExample

```sql

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1

```


# myutf8

## 多表查询

```sql



/*
创建部门表
*/

-- CREATE TABLE if not EXISTS dept(
-- 
-- `id` int PRIMARY KEY auto_increment,
-- `name` VARCHAR(20)
-- 
-- );
-- 
-- /*
-- 
-- 创建员工表
-- */
-- 
-- CREATE TABLE if not EXISTS emp(
-- 
-- `id` int primary key auto_increment, 
-- `name` varchar(10),
-- `gender` char(1), -- 性别 
-- `salary` double, -- 工资
-- join_date date, -- 入职日期
-- dept_id int,
-- foreign key (dept_id) references dept(id) -- 外键，关联部门表(部门表的主键)
-- 
-- );

-- INSERT into dept (name) VALUES ('开发部'), ('市场部'), ('财务部');

-- INSERT INTO emp (name, gender, salary, join_date, dept_id) VALUES('孙悟空', '男', 7200, '2013-02-24', 1);
/*
错误外键测试
INSERT INTO emp (name, gender, salary, join_date, dept_id) VALUES('孙悟空', '男', 7200, '2013-02-24', 9);
*/

-- insert into emp(name,gender,salary,join_date,dept_id) values('猪八戒','男 ',3600,'2010-12-02',2);
-- insert into emp(name,gender,salary,join_date,dept_id) values('唐僧','男',9000,'2008-08-08',2);
-- insert into emp(name,gender,salary,join_date,dept_id) values('白骨精','女 ',5000,'2015-10-07',3);
-- insert into emp(name,gender,salary,join_date,dept_id) values('蜘蛛精','女 ',4500,'2011-03-14',1);




-- SELECT * from emp, dept; 

-- UPDATE emp set join_date='2008-08-08'  WHERE `name`='唐僧';



-- SELECT * from emp, dept WHERE id=5;


-- SELECT emp.`name`, dept.`name` FROM  emp,dept WHERE emp.`dept_id` = dept.`id`;



--  隐式内连接

-- SELECT * from emp,dept WHERE emp.dept_id = dept.id;

--  显示内连接

-- SELECT * from emp INNER JOIN dept;


-- SELECT * from emp e INNER JOIN dept d on e.dept_id=d.id;

-- SELECT * from emp e INNER JOIN dept d on e.dept_id = d.id WHERE e.`name`='唐僧';

-- SELECT e.`id`, e.`name`, e.``
-- 
-- -- 不用别名 
-- SELECT emp.`id`,emp.`name`,emp.`gender`,emp.`salary`, dept.`name` FROM emp  JOIN dept on emp.dept_id = dept.id WHERE emp.`name` = '唐僧';
-- /*
-- 取了别名, 又 只有 后面用前面不用
-- 这样是不行的=======================Error
-- SELECT emp.`id`,emp.`name`,emp.`gender`,emp.`salary`, dept.`name` FROM emp  e  JOIN dept d on e.dept_id = d.id WHERE e.`name` = '唐僧';
-- */
-- 
-- -- 全用别名
-- SELECT e.`id`,e.`name`,e.`gender`,e.`salary`, d.`name` FROM emp  e  JOIN dept d on e.dept_id = d.id WHERE e.`name` = '唐僧';
-- 
-- 
-- --  给显示的样子也取个别名
-- 
-- SELECT e.`id` 员工编号,e.`name` 员工名字,e.`gender` 员工性别,e.`salary` 员工工资, d.`name` 部门名称 FROM emp  e  JOIN dept d on e.dept_id = d.id WHERE e.`name` = '唐僧';
-- 
-- 




-- 左外连接

-- INSERT INTO dept (name) VALUES ('销售部');

-- SELECT * FROM dept;

-- 先用内连接试一下

-- SELECT * FROM dept d INNER JOIN emp e on d.`id` = e.`dept_id`; 


-- 用外连接试一下

-- SELECT * FROM dept d LEFT JOIN emp e ON d.`id` = e.`dept_id`;








```



## 联合主键

```sql


CREATE TABLE if not EXISTS tab_user(

`uid` int PRIMARY KEY auto_increment,
`userName` VARCHAR(100) UNIQUE NOT NULL,
`passWord` VARCHAR(100) NOT NULL,
`name` VARCHAR(100),
`birthday` date,
`sex` char(1) DEFAULT '男',
`telephone` VARCHAR(11),
`email` VARCHAR(100) 

);

-- INSERT INTO  tab_user VALUES (NULL, 'cz110', 123456, '老王', '1977-07-07', '男', '13888888888', '66666@qq.com'), 
-- 							 (NULL, 'cz119', 654321, '小王', '1999-09-09', '男', '13999999999', '99999@qq.com');


CREATE TABLE if not EXISTS tab_route(

`rid` int PRIMARY KEY auto_increment,
`rname` varchar(100) not NULL UNIQUE,
`price` DOUBLE,
`rdate` date,
`cid` int -- 分类id

);


INSERT INTO tab_route VALUES  (NULL, '【厦门+鼓浪屿+南普陀寺+曾厝垵 高铁 3 天 惠贵团】尝味友鸭面线 住 1 晚鼓浪屿', 1499, '2018-01-27', 1),
							  (NULL, '【浪漫桂林 阳朔西街高铁 3 天纯玩 高级团】城徽象鼻山 兴坪漓江 西山公园', 699, '2018-02- 22', 3),
							  (NULL, '【爆款¥1699 秒杀】泰国 曼谷 芭堤雅 金沙岛 杜拉拉水上市场 双飞六天【含送签费 泰风情 广州 往返 特价团】', 1699, '2018-01-27', 2),
							  (NULL, '【经典•狮航 ¥2399 秒杀】巴厘岛双飞五天 抵玩【广州往返 特价团】', 2399, '2017-12-23', 2),
							  (NULL, '香港迪士尼乐园自由行2天【永东跨境巴士广东至迪士尼去程交通+迪士尼一日门票+香港如心海景酒店 暨会议中心标准房1晚住宿】', 799, '2018-04-10', 4);





/*

创建收藏表
rid 旅游线路id, 外键
date 收藏时间
uid 用户id, 外键
rid和uid 不能重复, 设置复合主键, 同一个用户不能收藏用一个线路两次

*/ 

CREATE TABLE  if not EXISTS  tab_favorite(

`rid` int,
`date` datetime,
`uid` int,
-- 创建复合主键
PRIMARY KEY(rid, uid),

FOREIGN KEY (rid) REFERENCES tab_route(rid),
FOREIGN KEY (uid) REFERENCES tab_user(uid)
);


INSERT INTO tab_favorite VALUES (1, '2018-01-01', 1), -- 老王选择厦门
								(2, '2018-02-11', 1), -- 老王选择桂林 
								(3, '2018-03-21', 1), -- 老王选择泰国
								(2, '2018-04-21', 2), -- 小王选择桂林
								(3, '2018-05-08', 2), -- 小王选择泰国
								(5, '2018-06-02', 2); -- 小王选择迪士尼


```


## 事务

```sql

-- 创建数据表
CREATE TABLE IF NOT EXISTS account (
   id INT PRIMARY KEY AUTO_INCREMENT,
   NAME VARCHAR(10),
   balance DOUBLE
);
-- 添加数据
-- INSERT INTO account (NAME, balance) VALUES ('张三', 1000), ('李四', 1000);

-- update account set balance = balance + 500 where name='张三';

-- 李四账号+500
-- update account set balance = balance - 500 where name='李四';

-- 
-- START TRANSACTION;
-- 
-- update account set balance = balance - 500 where name='张三';

-- SELECT * FROM account;


-- START TRANSACTION;
-- 
-- update account set balance = balance - 500 where name='张三';

-- SELECT * FROM account;


select @@autocommit;

```


## 子查询

```sql

-- -- select id from dept where name='开发部' ;
-- -- select * from emp where dept_id = 1;
-- 
-- -- 子查询
-- 
-- SELECT * FROM emp WHERE dept_id = (SELECT id FROM dept WHERE name='市场部'); 


-- 
-- -- 单行单列
-- 
-- --  查询工资最高的是多少
-- 
-- -- SELECT MAX(salary) FROM emp;
-- 
-- -- 查询最高工资那个家伙是谁
-- 
-- -- SELECT * from emp WHERE salary = (SELECT MAX(salary) FROM emp);
-- 
-- 
-- /*
-- avg(salary) 正确
-- avg(salary ) 正确?
-- avg( salary) 正确?
-- avg( salary ) 正确?
-- */
-- -- 查询员工小于平均工资的员工
-- 
-- SELECT * from emp where salary < ( SELECT avg( salary ) FROM emp ); 
-- 




-- 
-- -- 多行单列
-- 
-- -- 查询工资大于5000的员工, 来至哪个部门, 输出名字
-- 
-- -- select name from dept where id in (select dept_id from emp where salary > 5000);
-- 
-- -- SELECT name FROM dept WHERE id IN (SELECT dept_id FROM emp WHERE salary > 5000);
--  
-- 
-- --  查询开发部与财务部所有的员工信息
-- 
-- SELECT * FROM emp WHERE dept_id in ( SELECT id FROM dept WHERE `name` in ('开发部', '财务部') );






-- 多行多列

-- 查询2011年以后入职的员工信息, 包括部门名称

-- SELECT * from dept d, (SELECT * FROM emp WHERE join_date >='2011-1-1') e  WHERE d.`id` = e.`dept_id`;

-- 也可以使用表连接


-- SELECT * FROM emp INNER JOIN dept ON emp.dept_id = dept.id WHERE join_date >= '2011-1-1';

-- SELECT * FROM emp INNER JOIN dept ON emp.dept_id = dept.id AND join_date >= '2011-1-1'; 


```


## myutf8 建库

```sql

CREATE TABLE IF NOT EXISTS `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(10) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF NOT EXISTS `dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `join_date` date DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dept_id` (`dept_id`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `t_jdbcStuudent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `t_jdbcStuudent2` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `t_jdbcStuudent3` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `t_notnull` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `age` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `tab_favorite` (
  `rid` int(11) NOT NULL DEFAULT '0',
  `date` datetime DEFAULT NULL,
  `uid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rid`,`uid`),
  KEY `uid` (`uid`),
  CONSTRAINT `tab_favorite_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `tab_route` (`rid`),
  CONSTRAINT `tab_favorite_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `tab_user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE IF NOT EXISTS `tab_route` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(100) NOT NULL,
  `price` double DEFAULT NULL,
  `rdate` date DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rid`),
  UNIQUE KEY `rname` (`rname`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `tab_user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `passWord` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT '男',
  `telephone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;








```




# t_taopaojihua001

```sql

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(20) DEFAULT NULL,
  `dep_location` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dep_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `emp_depid_fk` (`dep_id`),
  CONSTRAINT `emp_depid_fk` FOREIGN KEY (`dep_id`) REFERENCES `department` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

```
