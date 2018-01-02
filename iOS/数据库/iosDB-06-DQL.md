# DQL
- 格式
	- select 字段1, 字段2, … from 表名 ;
	- select * from 表名;   //  查询所有的字段
- 示例
	- select name, age from t_student ;
	- select * from t_student ;
	- select * from t_student where age > 10 ;  //  条件查询


# self test

```

SELECT name, age from t_dbStudy01;

```




# 查询相关语句
- 统计
  - count(X)
 	 - select count(*) from t_student
 	 - select count(age) from t_student
  - avg(X)
 	 - 计算某个字段的平均值
  - sum(X)
 	 - 计算某个字段的总和
  - max(X)
 	 - 计算某个字段的最大值
  - min(X)
 	 - 计算某个字段的最小值

- 排序
  - 查询出来的结果可以用order by进行排序
 	 - select 字段1, 字段2 from 表名 order by 字段 ;
 	 - select * from t_student order by age ;
  - 默认是按照升序排序（由小到大），也可以变为降序（由大到小）
 	 - select * from t_student order by age desc ;  //降序
 	 - select * from t_student order by age asc ;   // 升序（默认）
  - 也可以用多个字段进行排序
 	 - select * from t_student order by age asc, height desc ;
 	 - 先按照年龄排序（升序），年龄相等就按照身高排序（降序）


- limit分页
  - 使用limit可以精确地控制查询结果的数量，比如每次只查询10条数据
  - 格式
 	 - select * from 表名 limit 数值1, 数值2 ;
  - 示例
 	 - select * from t_student limit 4, 8 ;
 	 - 可以理解为：跳过最前面4条语句，然后取8条记录
  - 分页
 	 - limit常用来做分页查询，比如每页固定显示5条数据，那么应该这样取数据
 	 	- 第1页：limit 0, 5
 	 	- 第2页：limit 5, 5
 	 	- 第3页：limit 10, 5
 	 	- 第n页：limit 5*(n-1), 5
 	 - 特殊案例
				select * from t_student limit 7 ;
				相当于select * from t_student limit 0, 7 ;
				表示取最前面的7条记录

# self  test

count(age) 得到的是不为null的个数

```

-- SELECT name, age from t_dbStudy01;
-- SELECT * from t_dbStudy01;

SELECT count(address) from t_dbStudy01;

SELECT avg(address) from t_dbStudy01;

```

排序

```
// 降序-大的在前
SELECT * from t_dbStudy01 ORDER BY score DESC;

// 升序
SELECT * from t_dbStudy01 ORDER BY score ASC;

// 分数相同再按年龄 --升序
SELECT * from t_dbStudy01 ORDER BY score ASC, age ASC;
// 分数相同再按年龄 --降序
SELECT * from t_dbStudy01 ORDER BY score ASC, age DESC;

```