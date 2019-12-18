# 目录


1. [](#)
- 1.1

2. [](#)

- 2.0 [](#)
  - 2.0.1 [ ](#)
    - 2.0.1.1 [](#)
    - 2.0.1.2 [](#)





### 数据库驱动

```

mysql-connector-java

https://dev.mysql.com/downloads/connector/j/5.1.html

```



### 从 JDBC3 开始，目前已经普遍使用的版本。可以不用注册驱动而直接使用。Class.forName 这句话可以省略。

```

Class.forName("com.mysql.jdbc.Driver");


```


### JDBC 基本连接


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



