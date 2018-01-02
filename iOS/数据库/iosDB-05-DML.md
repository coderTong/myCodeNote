# DML语句
- 1. 插入数据（insert）
  - 格式
			insert into 表名 (字段1, 字段2, …) values (字段1的值, 字段2的值, …) ;
  - 示例
			insert into t_student (name, age) values (‘sz’, 10) ;
  - 注意
			数据库中的字符串内容应该用单引号 ’ 括住
- 2. 更新数据（update）
  - 格式
			update 表名 set 字段1 = 字段1的值, 字段2 = 字段2的值, … ; 
  - 示例
			update t_student set name = ‘wex’, age = 20 ; 
  - 注意
			上面的示例会将t_student表中所有记录的name都改为wex，age都改为20
- 3. 删除数据（delete）
  - 格式
			delete from 表名 ;
  - 示例
			delete from t_student ;
  - 注意
			上面的示例会将t_student表中所有记录都删掉


# self test

插入
```

INSERT INTO t_dbStudy01(name, age, score) VALUES('lm', 20, 100);

```


更新

```

// 卧槽将表里的age字段全部改为20了, 危险
UPDATE t_dbStudy01 SET age = 21;


```


删除

```

// 删除表里所有数据
DELETE FROM t_dbstu;

```



# 条件语句

- 作用
  - 如果只想更新或者删除某些固定的记录，那就必须在DML语句后加上一些条件
- 条件语句的常见格式
	- where 字段 = 某个值 ;   // 不能用两个 =
	- where 字段 is 某个值 ;   // is 相当于 = 
	- where 字段 != 某个值 ; 
	- where 字段 is not 某个值 ;   // is not 相当于 != 
	- where 字段 > 某个值 ; 
	- where 字段1 = 某个值 and 字段2 > 某个值 ;  // and相当于C语言中的 &&
	- where 字段1 = 某个值 or 字段2 = 某个值 ;  //  or 相当于C语言中的 ||
- 条件语句练习
	- 示例
		- 将t_student表中年龄大于10 并且 姓名不等于wex的记录，年龄都改为 5
		- 删除t_student表中年龄小于等于10 或者 年龄大于30的记录
	- 猜猜下面语句的作用
			update t_student set score = age where name = ‘wex’ ;


# self test

```

DELETE FROM t_dbstu WHERE name is 'lm';
DELETE FROM t_dbstu WHERE age is 88;

```

```

UPDATE t_dbstu SET score = 55 WHERE id > 30; 

```

