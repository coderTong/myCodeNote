# 约束

## 简单约束
- 不能为空
  - not null ：规定字段的值不能为null
- 不能重复
  - unique ：规定字段的值必须唯一
- 默认值
  - default ：指定字段的默认值
- 示例
  - create table t_student (id integer, name text not null unique, age integer not null default 1) ;
  - name字段不能为null，并且唯一
  - age字段不能为null，并且默认为1

## 主键约束
- 添加主键约束的原因?
  - 如果t_student表中就name和age两个字段，而且有些记录的name和age字段的值都一样时，那么就没法区分这些数据，造成数据库的记录不唯一，这样就不方便管理数据
  - 良好的数据库编程规范应该要保证每条记录的唯一性，为此，增加了主键约束
  - 也就是说，每张表都必须有一个主键，用来标识记录的唯一性

- 什么是主键?
  - 主键（Primary Key，简称PK）用来唯一地标识某一条记录
  	- 例如t_student可以增加一个id字段作为主键，相当于人的身份证
  - 主键可以是一个字段或多个字段

- 主键的设计原则?
  - 主键应当是对用户没有意义的
  - 永远也不要更新主键
  - 主键不应包含动态变化的数据
  - 主键应当由计算机自动生成


- 主键的声明?
  - 在创表的时候用primary key声明一个主键
  	- create table t_student (id integer primary key, name text, age integer) ;
  	- integer类型的id作为t_student表的主键
 
 - 主键字段
  	- 只要声明为primary key，就说明是一个主键字段
  	- 主键字段默认就包含了not null 和 unique 两个约束

  - 如果想要让主键自动增长（必须是integer类型），应该增加autoincrement
  	- create table t_student (id integer primary key autoincrement, name text, age integer) ;


# self Test


