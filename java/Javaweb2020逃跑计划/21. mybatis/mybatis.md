# 目录

1. [第1节 Mybatis快速入门](#mybatis001)
    1. [1.1 Mybatis 简介](#mybatis001a) 
    2. [1.2 Mybatis 快速入门](#mybatis001b) 
    3. [1.3 Mybatis 映射文件概述](#mybatis001c) 
    4. [1.4 Mybatis 增删改查操作](#mybatis001d) 
    5. [1.5 Mybatis 核心配置文件概述](#mybatis001e) 
    6. [1.6 Mybatis 相应API](#mybatis001f) 
2. [第2节 Mybatis的dao层实现原理](#mybatis002)
    1. [Mybatis的Dao层实现](#mybatis002a)
    2. [MyBatis映射文件深入](#mybatis002b)
    3. [MyBatis核心配置文件深入](#mybatis002c)
3. [第3节 Mybatis的多表操作](#mybatis003)





### mybatis001
# 第1节 Mybatis快速入门

### mybatis001a
## 1.1 Mybatis 简介

### 1.1.1 原始jdbc操作

大概介绍了下**原始jdbc操作**的相关弊端


弊端
- 数据库`连接创建`、`释放`**频繁**造成**系统资源浪费**从而影响系统性能
- `sql 语句`在代码中`硬编码`，造成代码**不易维护**，实际应用 sql 变化的可能较大，sql 变动需要改变java代码。
- 查询操作时，需要**手动**将**结果集**中的数据手动封装到实体中。插入操作时，需要**手动**将实体的数据设置到**sql语句的占位符位置**


**应对上述问题给出的解决方案：**
- 使用**数据库连接池**初始化连接资源
- 将`sql语句`**抽取**到**xml配置文件**中
- 使用`反射`、`内省`等底层技术，自动将**实体**与**表**进行属性与字段的自动映射


### 1.1.2 什么是Mybatis

- `mybatis 是`一个优秀的基于java的`持久层框架`，它内部`封装了jdbc`，使开发者`只需要关注sql`语句本身，而不需要花费精力去处理加载驱动、创建连接、创建statement等繁杂的过程。

- mybatis通过`xml`或`注解`的方式将要执行的各种 statement`配置`起来，并通过java对象和statement中sql的动态参数进行映射生成最终执行的sql语句。

- 最后mybatis框架执行sql并将结果映射为java对象并返回。采用`ORM`思想解决了**实体**和**数据库****映射**的问题，对**jdbc **进行了**封装**，**屏蔽**了**jdbc api** `底层访问细节`，使我们不用与jdbc api 打交道，就可以完成对数据库的持久化操作。



### mybatis001b
## 1.2 Mybatis 快速入门

MyBatis官网地址：http://www.mybatis.org/mybatis-3/ 

Mybatis开发步骤

1. 添加MyBatis 的坐标
2. 创建User数据表
3. 编写User实体类
4. 编写映射文件 xxxx.xml
5. 编写核心文件 SqlMapConfig.xml
6. 编写测试类

### 1.2.1 准备1- 创建resources文件夹
![mybatis001](images/mybatis001.png)
![mybatis002](images/mybatis002.png)

### 1.2.2 准备2- mybatis约束头

```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

```

### 1.2.3 准备3- 核心文件约束头
![mybatis003](images/mybatis003.png)

```xml

<?xml version="1.0" encoding="UTF-8" ?>

<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"  "http://mybatis.org/dtd/mybatis-3-config.dtd">

```


### 1.2.4 准备4- 核心文件加载配置文件复制路径

![mybatis004](images/mybatis004.png)
![mybatis005](images/mybatis005.png)

### 1.2.5 添加坐标

```xml

<dependencies>
    <!--mybatis坐标-->
  <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.4.5</version>
    </dependency>
    <!--mysql驱动坐标-->
  <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.32</version>
    </dependency>
    <!--单元测试坐标-->
  <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.12</version>
        <scope>test</scope>
    </dependency>
    <!--日志坐标-->
  <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>1.7.7</version>
    </dependency>
    <dependency>
        <groupId>log4j</groupId>
        <artifactId>log4j</artifactId>
        <version>1.2.17</version>
    </dependency>

</dependencies>

```


### 1.2.6 创建User数据表

略
![mybatis006](images/mybatis006.png)


### 1.2.7 User实体类

```java

package com.domanshow.domain;

public class User {

    private int id;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
  public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

```

### 1.2.8 映射文件UserMapper.xml

```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">


<mapper namespace="userMapper">
    <select id="findAll" resultType="com.domanshow.domain.User">
        select * from t_mybatis1
    </select>
</mapper>

```


### 1.2.9 核心文件 SqlMapConfig.xml

```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">

<configuration>

<!--    配数据源环境-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"></transactionManager>
            <dataSource type="POOLED">

                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://138.68.220.88:3306/mybatis001?characterEncoding=utf8"/>
                <property name="username" value="keyi"/>
                <property name="password" value="a23456a7"/>


            </dataSource>
        </environment>
    </environments>



<!--    加载映射文件-->
    <mappers>
        <mapper resource="com/domanshow/mapper/UserMapper.xml"></mapper>
    </mappers>

</configuration>

```


### 1.2.10 编写测试类

```java

package com.domanshow.test;

import com.domanshow.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    @Test
    public void test1() throws IOException {

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数userMapper+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        // 打印数据
        System.out.println(userList);

        sqlSession.close();

    }
}

```



### mybatis001c
## 1.3 Mybatis 映射文件概述

![mybatis007](images/mybatis007.png)

### mybatis001d
## 1.4 Mybatis 增删改查操作



### 1.4.1 插入操作注意问题

1. 插入语句使用insert标签
2. 在映射文件中使用`parameterType`属性指定要插入的数据类型
3. Sql语句中使用`#{实体属性名}`方式引用实体中的属性值
4. 插入操作使用的API是sqlSession.insert(“命名空间.id”,实体对象);
5. 插入操作涉及数据库数据变化，所以要使用sqlSession对象显示的**提交事务**，即`sqlSession.commit()`

### 1.4.2 修改操作注意问题

1. 修改语句使用`update`标签
2. 修改操作使用的API是`sqlSession.update`(“命名空间.id”,实体对象);

### 1.4.3 删除操作注意问题

1. 删除语句使用delete标签
2. Sql语句中使用#{任意字符串}方式引用传递的单个参数
3. 删除操作使用的API是sqlSession.delete(“命名空间.id”,Object);
4. 

### 映射文件
```xml

<!--    删除操作-->
    <delete id="delete" parameterType="int">
        delete from t_mybatis1 where id=#{id}
    </delete>
    
<!--    修改-->
    <update id="update" parameterType="user">
        update t_mybatis1 set userName=#{userName}, password=#{password} where id=#{id}
    </update>
<!--    插入-->
    <insert id="insert" parameterType="user">
        insert into t_mybatis1 values(#{id},#{userName},#{password})
    </insert>

```


java测试代码

```java

/**
     * 删除----某个对象
     * @throws IOException
     */
    @Test
    public void test5() throws IOException {

        User user = new User();
        user.setId(5);
        user.setUserName("phm666");
        user.setPassword("abc");

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数userMapper+id
        int insert = sqlSession.delete("userMapper.delete", user.getId());

        sqlSession.commit();
        // 打印数据
        System.out.println(insert);

        sqlSession.close();

    }


    /**
     * 更改----某个对象
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {

        User user = new User();
        user.setId(5);
        user.setUserName("phm666");
        user.setPassword("abc");

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数userMapper+id
        int insert = sqlSession.update("userMapper.update", user);

        sqlSession.commit();
        // 打印数据
        System.out.println(insert);

        sqlSession.close();

    }

    /**
     * 插入----某个对象
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {

        User user = new User();
        user.setId(0);
        user.setUserName("phm");
        user.setPassword("123");

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 执行操作  参数userMapper+id
        int insert = sqlSession.insert("userMapper.insert", user);

        sqlSession.commit();
        // 打印数据
        System.out.println(insert);

        sqlSession.close();

    }

```



### mybatis001e
## 1.5 Mybatis 核心配置文件概述


### 1.5.1 MyBatis核心配置文件层级关系

![mybatis008](images/mybatis008.png)


### 1.5.2 MyBatis常用配置解析


#### 1.5.2.1 environments标签

数据库环境配置的配置, 支持多环境配置

![mybatis009](images/mybatis009.png)


- 事务管理器（`transactionManager`）类型有**两种**：
    - •**JDBC**：这个配置就是直接使用了JDBC 的提交和回滚设置，它依赖于从数据源得到的连接来管理事务作用域。
    - •MANAGED：这个配置几乎没做什么。它从来不提交或回滚一个连接，而是让容器来管理事务的整个生命周期（比如 JEE 应用服务器的上下文）。 默认情况下它会关闭连接，然而一些容器并不希望这样，因此需要将 closeConnection 属性设置为 false 来阻止它默认的关闭行为。




- 数据源（`dataSource`）类型有`三种`：

    - •UNPOOLED：这个数据源的实现只是每次被请求时打开和关闭连接。

    - •**POOLED**：这种数据源的实现利用“池”的概念将 JDBC 连接对象组织起来。

    - •JNDI：这个数据源的实现是为了能在如 EJB 或应用服务器这类容器中使用，容器可以集中或在外部配置数据源，然后放置一个 JNDI 上下文的引用。


#### 1.5.2.2 mapper标签


该标签的作用是**加载映射**的，加载方式有如下几种：


1. 使用**相对于类路径**的资源引用，例如：

```xml

<mapper resource="org/mybatis/builder/AuthorMapper.xml"/>

```



2. 使用**完全限定资源定位符**（`URL`），例如：

```xml

<mapper url="file:///var/mappers/AuthorMapper.xml"/>

```



3. 使用**映射器接口实现类**的完全限定类名，例如：

注解的时候可能用到

```xml

<mapper class="org.mybatis.builder.AuthorMapper"/>

```


4. 将包内的映射器接口实现全部注册为映射器，例如：


```xml

<package name="org.mybatis.builder"/>

```



#### 1.5.2.3 Properties标签

实际开发中，习惯将数据源的配置信息`单独`**抽取**成一个**properties文件**，该标签可以加载额外配置的properties文件

![mybatis010](images/mybatis010.png)


#### 1.5.2.4 typeAliases标签

- 类型别名是为Java 类型设置一个短的名字。原来的类型名称配置如下

![mybatis011](images/mybatis011.png)


- 配置typeAliases，为com.itheima.domain.User定义别名为user

![mybatis012](images/mybatis012.png)

- 上面我们是自定义的别名，mybatis框架已经为我们设置好的一些常用的类型的别名

![mybatis013](images/mybatis013.png)



### mybatis001f
## 1.6 Mybatis 相应API

### 1.6.1 SqlSession工厂构建器SqlSessionFactoryBuilder

常用API：`SqlSessionFactory  build(InputStream inputStream)`

通过加载`mybatis`的**核心文件**的输入流的形式构建一个**SqlSessionFactory**对象

```java

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

```


其中， `Resources` 工具类，这个类在 `org.apache.ibatis.io` 包中。`Resources` 类帮助你从类路径下、文件系统或一个 web URL 中加载资源文件。


### 1.6.2 SqlSession工厂对象SqlSessionFactory

`SqlSessionFactory` 有多个个方法创建`SqlSession` 实例。常用的有如下两个：

![mybatis014](images/mybatis014.png)


```java

// 获得Session会话对象 
SqlSession sqlSession = sqlSessionFactory.openSession();

```


### 1.6.3  SqlSession会话对象

`SqlSession` 实例在 `MyBatis` 中是非常强大的一个类。在这里你会看到所有`执行语句`、`提交`或`回滚事务`和`获取映射器`实例的方法。

执行语句的方法主要有：

```java

<T> T selectOne(String statement, Object parameter) 
<E> List<E> selectList(String statement, Object parameter) 
int insert(String statement, Object parameter) 
int update(String statement, Object parameter) 
int delete(String statement, Object parameter)

```

操作事务的方法主要有：

```java

void commit()  
void rollback() 

```


### mybatis002
# 第2节 Mybatis的dao层实现原理

### mybatis002a
## 2.1 Mybatis的Dao层实现

### 2.1.1 先看看传统的DAO

- 1编写UserDao接口
```java

public interface UserDao {
    List<User> findAll() throws IOException;
}

```

- 2.编写UserDaoImpl实现

```java

public class UserDaoImpl implements UserDao {
    public List<User> findAll() throws IOException {
        InputStream resourceAsStream = 
                    Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new 
                    SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        sqlSession.close();
        return userList;
    }
}

```

- 3 测试传统方式

```java

@Test
public void testTraditionDao() throws IOException {
    UserDao userDao = new UserDaoImpl();
    List<User> all = userDao.findAll();
    System.out.println(all);
}

```


### 2.1.2 代理开发方式

1. 简介

采用 Mybatis 的代理开发方式实现 DAO 层的开发，这种方式是我们后面进入企业的主流。

`Mapper` 接口 **开发方法** 只需要 **程序员** 编写 `Mapper` 接口(相当于Dao接口), 由 `Mybatis` 框架根据`接口`**定义** `创建` 接口的 `动态代理对象`, **代理对象**的`方法体`同上边Dao**接口实现类**方法.

Mapper 接口开发需要遵循以下规范

1. `Mapper.xml`文件中的`namespace`与`mapper`接口的`全限定名`相同
2. **Mapper**`接口方法名`和`Mapper.xml`中定义的每个`statement`的`id`相同
3. **Mapper**`接口方法名` 的 **输入参数类型** 和 `Mapper.xml`中定义的每个sql的`parameterType` 的类型相同
4. **Mapper**`接口方法名` 的 **输出参数类型** 和`Mapper.xml` 中定义的每个sql的`resultType`的类型相同


![mybatis015](images/mybatis015.png)

```java

package com.domanshow.service;

import com.domanshow.dao.UserMapper;
import com.domanshow.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ServiceDemo {

    public static void main(String[] args) throws IOException {

        // 获得核心配置文件
  InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
  SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得Session会话对象
  SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行操作  参数userMapper+id
  List<User> userList = mapper.findAll();
        // 打印数据
  System.out.println(userList);

        User user = mapper.findWithId(1);
        System.out.println(user);

    }
}

```


### 2.1.3 小结

Mybatis的 Dao层实现的两种方式

1. 手动Dao
2. 代理方式

### mybatis002b
## 2.2 MyBatis映射文件深入


### 2.2.0 添加log4j文件, 改info为debug, 就能打印 sql语句日志

![mybatis016](images/mybatis016.png)
![mybatis017](images/mybatis017.png)


### 2.2.1 动态sql语句

Mybatis 的映射文件中，前面我们的 SQL 都是比较简单的，有些时候业务`逻辑复杂时`，我们的 SQL是`动态变化`的，此时在前面的学习中我们的 SQL 就不能满足要求了。


1. if

我们根据实体类的不同取值, 使用不同的SQL语句来进行查询, 比如在`id`不为空时, 可以根据`id`查询, 如果userName不为空时, 还要加入用户名作为作为条件


```xml

<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">


<mapper namespace="com.domanshow.dao.UserMapper">



    <select id="findWithCondition" parameterType="user" resultType="user">
        select * from t_mybatis1
        <where>
            <if test="id!=0">
                and id=#{id}
            </if>
            <if test="userName!=null">
                and userName=#{userName}
            </if>
        </where>
    </select>


<!--    简单sql分界 ******************************************************************************** -->
<!--    删除操作-->
    <delete id="delete" parameterType="int">
        delete from t_mybatis1 where id=#{id}
    </delete>

<!--    修改-->
    <update id="update" parameterType="user">
        update t_mybatis1 set userName=#{userName}, password=#{password} where id=#{id}
    </update>
<!--    插入-->
    <insert id="insert" parameterType="user">
        insert into t_mybatis1 values(#{id},#{userName},#{password})
    </insert>

<!--    查询单个-->
    <select id="findWithId" resultType="com.domanshow.domain.User" parameterType="int">
        select * from t_mybatis1 where id=#{id}
    </select>

<!--    查询全部-->
    <select id="findAll" resultType="com.domanshow.domain.User">
        select * from t_mybatis1
    </select>
</mapper>

```


![mybatis018](images/mybatis018.png)


2. foreach

循环执行sql的拼接操作.

传给人家是什么就写什么, 传的是list,  `collection="list"`
![mybatis019](images/mybatis019.png)

foreach语句说明
![mybatis020](images/mybatis020.png)

```sql

select * from t_mybatis1 where id IN(1,2,4);

```


```java

    @Test
    public void test6() throws IOException {

        List<Integer> requestList = new ArrayList<Integer>();

        requestList.add(1);
        requestList.add(2);

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.findWithIds(requestList);
        System.out.println(users);
        sqlSession.close();

    }

```


```xml

<select id="findWithIds" parameterType="list" resultType="user">
    select * from t_mybatis1
    <where>
        <foreach collection="list" open="id IN(" close=")" item="id" separator=",">
            #{id}
        </foreach>
    </where>
</select>

```




### 2.2.2 sql片段抽取

经过上面下来看到了有如下图一样的重复sql语句, 然后我们要抽取
![mybatis021](images/mybatis021.png)

抽取后
![mybatis022](images/mybatis022.png)

### 2.2.3 小结

MyBatis映射文件配置：
- <select>：查询
- <insert>：插入
- <update>：修改
- <delete>：删除
- <where>：where条件
- <if>：if判断
- <foreach>：循环
- <sql>：sql片段抽取

### mybatis002c
## 2.3 MyBatis核心配置文件深入


### 2.3.1 typeHandlers标签

无论是 `MyBatis` 在预处理语句（**PreparedStatement**）中`设置`一个参数时，还是从`结果集`中`取出`一个值时， 都会用`类型处理器`将获取的值以合适的方式`转换`成 `Java 类型`。下表描述了一些默认的类型处理器（截取部分）。

![mybatis023](images/mybatis023.png)

**复写**老的**新建**自己的

- 你可以重写类型处理器或创建你自己的类型处理器来处理不支持的或非标准的类型。
- 具体做法为：**实现** `org.apache.ibatis.type.TypeHandler` 接口， 或**继承**一个很便利的类`org.apache.ibatis.type.BaseTypeHandler`， 然后可以选择性地将它映射到一个JDBC类型。

例如需求：一个Java中的Date数据类型，我想将之存到数据库的时候存成一个1970年至今的毫秒数，取出来时转换成java的Date，即java的Date与数据库的varchar毫秒值之间转换。


开发步骤:
1. 定义转换类继承类`BaseTypeHandler<T>`
2. 覆盖4个未实现的方法, 其中
3. 在Mybatis核心配置文件中进行注册
4. 测试

1. 创建转换类,  并实现4个未实现方法

```java

package com.domanshow.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    /**
     * 将java类型 转换成 数据库类型
     * @param ps
     * @param i
     * @param date
     * @param jdbcType
     * @throws SQLException
     */
    public void setNonNullParameter(PreparedStatement ps, int i, Date date, JdbcType jdbcType) throws SQLException {

        long time = date.getTime();
        ps.setLong(i,time);
    }


    /**
     * 将数据库中类型 转换成java类型
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(ResultSet rs, String columnName) throws SQLException {

        long aLong = rs.getLong(columnName);
        Date date = new Date(aLong);

        return date;
    }

    /**
     * 将数据库中类型 转换成java类型
     * @param rs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(ResultSet rs, int columnIndex) throws SQLException {

        long aLong = rs.getLong(columnIndex);
        Date date = new Date(aLong);

        return date;
    }

    /**
     * 将数据库中类型 转换成java类型
     * @param cs
     * @param columnIndex
     * @return
     * @throws SQLException
     */
    public Date getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {

        long aLong = cs.getLong(columnIndex);
        Date date = new Date(aLong);

        return date;
    }
}

```

2. 注册实现类

![mybatis024](images/mybatis024.png)

3. 测试
```java


    /**
     * 核心-typeHandlers标签-创建
     * @throws IOException
     */
    @Test
    public void test8() throws IOException {

        User userRq = new User();
        userRq.setUserName("zhoujielun");
        userRq.setPassword("324");
        userRq.setBirthday(new Date());

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.save(userRq);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 核心-typeHandlers标签-查询
     * @throws IOException
     */
    @Test
    public void test7() throws IOException {

        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.findWithId(7);

        System.out.println(user);
        sqlSession.close();

    }

```


### 2.3.2 plugins标签

这是一个扩展插件标签

`MyBatis`可以使用`第三方的插件`来对功能进行`扩展`，**分页助手**PageHelper是将分页的复杂操作进行封装，使用简单的方式即可获得分页的相关数据

#### 2.3.2.1 开发步骤

1. 导入通用PageHelper的坐标
2. 在mybatis核心配置文件中配置PageHelper插件
3. 测试分页数据获取


1. 导入坐标

```xml

        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
            <version>3.7.5</version>
        </dependency>
        <dependency>
            <groupId>com.github.jsqlparser</groupId>
            <artifactId>jsqlparser</artifactId>
            <version>0.9.1</version>
        </dependency>

```

2. 核心文件进行配置
![mybatis025](images/mybatis025.png)

3. 测试

```java

    /**
     * 核心-plugins标签-创建
     * @throws IOException
     */
    @Test
    public void test9() throws IOException {


        // 获得核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 获得Session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获得Session会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        PageHelper.startPage(2,3);

        List<User> userList = mapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获得与分页相关参数
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个："+pageInfo.isIsLastPage());

        sqlSession.close();

    }

```



### 2.3.3  小结

MyBatis核心配置文件常用标签：

1. properties标签：该标签可以加载外部的properties文件
2. typeAliases标签：设置类型别名
3. environments标签：数据源环境配置标签
4. typeHandlers标签：配置自定义类型处理器
5. plugins标签：配置MyBatis的插件


### mybatis003
# 第3节 Mybatis的多表操作