SQL语句的种类
- 数据定义语句（DDL：Data Definition Language）
			
```
包括create和drop, Alert等操作
在数据库中创建新表或删除表（create table或 drop table）

```
# 1. 创表
- 格式

```

create table 表名 (字段名1 字段类型1, 字段名2 字段类型2, …) ;

```
- 示例

```

create table t_student (id integer, name text, age inetger, score real) ;

```
- 经验
   - 实际上SQLite是无类型的
     - 就算声明为integer类型，还是能存储字符串文本（主键除外）
     - 建表时声明啥类型或者不声明类型都可以，也就意味着创表语句可以这么写：
     - create table t_student(name, age);
     - 为了保持良好的编程规范、方便程序员之间的交流，编写建表语句的时候最好加上每个字段的具体类型
   - 语句优化
     - 创建表格时, 最好加个表格是否已经存在的判断, 这个防止语句多次执行时发生错误
     - create table if not exists 表名 (字段名1 字段类型1, 字段名2 字段类型2, …) ;


# 2. 删除表

- 格式
   - drop table 表名 ;
   - drop table if exists 表名 ;
- 示例
   - drop table t_student ;
- 语句优化
   - 删除表格时, 最好加个表格是否已经存在的判断, 这个防止语句多次执行时发生错误
   - drop table if  exists 表名 ;


# 3. 修改表
- 注意: sqlite里面只能实现Alter Table的部分功能
   - 不能删除一列, 修改一个已经存在的列名
- 修改表名
   - ALTER TABLE 旧表名 RENAME TO 新表名 
- 新增属性
   - ALTER TABLE 表名 ADD COLUMN 列名 数据类型 限定符




# self test

创建表
```

CREATE TABLE t_dbstudy02 (id integer, name text, age integer, score real);

CREATE TABLE IF NOT EXISTS t_dbstudy02 (id integer, name text, age integer, score real);

// 主键自动增长
CREATE TABLE IF NOT EXISTS t_dbstu2 (id integer PRIMARY KEY AUTOINCREMENT, name text, age integer, score real DEFAULT 80);


```

删除表


```

DROP TABLE t_dbStudy02

DROP TABLE IF EXISTS t_dbStudy02;

```
修改

```

ALTER TABLE t_dbStudy02 RENAME TO t_dbStudyTemp

// 新增属性
ALTER TABLE t_dbStudytemp ADD COLUMN address text;

```