# 创建数据库


```sql

create database if not exists mybatis001 character set utf8;

```


# 为已有表创建新字段

ALTER TABLE 表名 ADD 列名 类型;

```

alter table employee ADD `weihao` varchar(20);

alter table `user` ADD (`password` varchar(26) , `username` varchar(26));
```


# 建表

```sql

CREATE TABLE IF NOT EXISTS `t_mybatis1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

```
