# 目录


1. [](#)
- [数据库驱动](#数据库驱动)
- [数据库驱动加载 ](#数据库驱动加载 )
- [jdbc基本连接](#jdbc基本连接)
- [](#)
- [](#)
- [](#)

2. [JDBC 入门](#JDBC 入门)

- 2.1 [jdbc概念](#jdbc概念)
- 2.2 [核心api](#核心api)
- 2.3 [加载和注册驱动](#加载和注册驱动)

3. [DriverManager 类](#drivermanager类)

- 3.1 [drivermanager作用](#drivermanager作用)
-  3.2 [ 方法参数解析和mysql写法](#方法参数解析和mysql写法)
  

4. [connection接口](#connection接口)

- 4.1 [connection作用和方法](#connection作用和方法)


5. [statement接口](#statement接口)

- 5.1 [jdbc访问数据库的步骤](#jdbc访问数据库的步骤)
- 5.2 [statement的作用和方法](#statement的作用和方法)
- 5.3 [释放资源](#释放资源)
- 5.4 [执行DDL操作](#执行ddl操作)
- 5.5 [执行DML](#执行dml)
- 5.6 [执行DQL](#执行dql)
- 5.7 [resultset接口的注意事项](#resultset接口的注意事项)


6. [数据库工具类jdbcutils](#数据库工具类jdbcutils)
- 6.1 [创建工具类的三个方法](#创建工具类的三个方法)
- 6.1 [登录案例](#登录案例)


7. [PreparedStatement接口](#preparedstatement接口)
- 7.1 [继承结构和作用](#继承结构和作用)
- 7.2 [PreparedStatement的执行原理](#preparedstatement的执行原理)
- 7.3 [Connection创建 PreparedStatement](#connection创建preparedstatement)
- 7.4 [方法和好处](#方法和好处)
- 7.5 [使用步骤](#使用步骤)
- 7.6 [表和类的关系](#表和类的关系)
- 7.7 [PreparedStatement执行DML](#pre执行dml)
- 7.8 [](#)



8. [jdbc处理事务](#jdbc处理事务)
- 8.1 [api介绍](#api介绍)
- 8.2 [开发步骤](#开发步骤)


```
- 2.0.1 [ ](#)
    - 2.0.1.1 [](#)
    - 2.0.1.2 [](#)


```
      
    







### 数据库驱动

```

mysql-connector-java

https://dev.mysql.com/downloads/connector/j/5.1.html

```

### 数据库驱动加载 

![QQ20191218-231831@2x](images/QQ20191218-231831@2x.png)


### 从 JDBC3 开始，目前已经普遍使用的版本。可以不用注册驱动而直接使用。Class.forName 这句话可以省略。

```

Class.forName("com.mysql.jdbc.Driver");


```


### JDBC 基本连接
### jdbc基本连接
```

package com.domanshow.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCDemo1Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");

        System.out.println("hello JDBC");

        jdbcCollection2();

    }

    // 1) 使用用户名、密码、URL得到连接对象
  public static void jdbcCollection1() throws SQLException {

        String url = "jdbc:mysql://65.42.40.36:3306/myutf8"; //1) 使用用户名、密码、URL 得到连接对象
  Connection connection = DriverManager.getConnection(url, "doukeyi", "123456a"); //com.mysql.jdbc.JDBC4Connection@68de145
  System.out.println(connection);
    }

    // 2) 使用属性文件和url得到连接对象
  public static void jdbcCollection2() throws SQLException {

        String url = "jdbc:mysql://65.42.40.36:3306/myutf8";
        // 属性对象
  Properties info = new Properties();
        info.setProperty("user", "doukeyi");
        info.setProperty("password", "123456a");

        Connection connection = DriverManager.getConnection(url, info);

        System.out.println(connection);
    }
}


```




## JDBC 入门

### jdbc概念
###  核心api
### 加载和注册驱动


## drivermanager类

DriverManager 类

### drivermanager作用
### 方法参数解析和mysql写法


## connection接口

### connection作用和方法


## statement接口

###   jdbc访问数据库的步骤
### statement的作用和方法

### 释放资源

### 执行ddl操作

###  执行dml

### 执行dql

### resultset接口的注意事项

ResultSet


## 数据库工具类jdbcutils

### 创建工具类的三个方法

### 登录案例


## preparedstatement接口
PreparedStatement


### 继承结构和作用

### preparedstatement的执行原理
### connection创建preparedstatement

### 方法和好处

### 使用步骤

### 表和类的关系

### pre执行dml


## jdbc处理事务

### api介绍
### 开发步骤

