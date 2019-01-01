# 用户登录案例


# 需求分析

1. 编写登录html页面
2. 使用druid数据库连接池技术,连接数据库
3. 使用`JdbcTemplate`技术封装JDBC
4. 登录成功跳转到`SuccessServlet`展示: 提示成功
5. 登录失败跳转到`FailServlet`展示: 提示登录失败

# 分析开发步骤


### 1. 创建项目, 创建登录html, 配置文件, jar包
### 2. 创建数据库环境

```mysql

CREATE DATABASE if NOT EXISTS `loginExample`;
USE `loginExample`;

CREATE TABLE  if NOT EXISTS t_user(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(32) UNIQUE NOT NULL,
	`password` varchar(32) NOT NULL
);


```

### 3. 创建`JDBCUtils`工具类

```java

package com.domanshow.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource dataSource;

    static {

        try {
            // 1. 加载配置文件
  Properties pro = new Properties();

            // 2. 获取配置文件 字节流
  InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(inputStream);

            // 2.初始化连接池对象
  dataSource = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
 * 获取连接池对象 * */    
 
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
 * 获取连接Connection对象 * * */    
 
 public static Connection getConnection() throws SQLException {

        return dataSource.getConnection();
    }
}


```


### 4. 创建`User`类 

```java

package com.domanshow.domain;

public class User {

    private int id;
    private String username;
    private String password;

    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
  public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

```



### 5. 创建`DAO`

```java


package com.domanshow.dao;

import com.domanshow.domain.User;
import com.domanshow.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    public User login(User loginUser){

        try {

            String sql = "select * from user where username = ? and password = ?";

            User user = template.queryForObject(
                    sql, 
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),
                    loginUser.getPassword());

            return user;

        } catch (DataAccessException e) {

            e.printStackTrace();

            return null;
        }
    }

}


```



### 6. 创建`LoginServlet`



### 7. 创建失败/成功 Servlet
### 8. `login.html` 表单`action`路径说道说道...
### 9. `JDBCUtils`工具类, 简化数据封装

