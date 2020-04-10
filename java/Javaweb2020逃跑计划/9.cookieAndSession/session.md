# Session

# 1. 概念
和`cookie`形成对比的是它是存在服务端的一个针对会话存储`共享数据`的技术


# 2. 快速入门

1. 获取 `HttpSession`对象

```java

package com.domanshow.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 获取Session
  HttpSession session = request.getSession();

        // 2. 存储数据
  session.setAttribute("msg", "hello session 吃了没"+ new Date().toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

```


2. 使用`HttpSession`对象

```java


package com.domanshow.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servletTest02")
public class ServletTest02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. 获取Session
  HttpSession session = request.getSession();

        Object msg = session.getAttribute("msg");

        System.out.println("你猜怎么着Content----->:"+ msg);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

```


# 3. 原理
![Session原理](images/Session%E5%8E%9F%E7%90%86.png)
- `Session`的实现是依赖于Cookie
![QQ20200409-221157@2x](images/QQ20200409-221157@2x.png)
![QQ20200409-220822@2x](images/QQ20200409-220822@2x.png)
![QQ20200409-220918@2x](images/QQ20200409-220918@2x.png)

```

Host: 192.168.2.176:8080
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate
Connection: keep-alive
Cookie: JSESSIONID=C0244A48B3743227DB3D91679E94EA37
Upgrade-Insecure-Requests: 1
Cache-Control: max-age=0


```

# 4. 细节



## 1. 客户端关闭, 服务器不关闭, 两次获取Session是否为同一个?

- 默认不是
- 创建cookie 持久化

```java


package com.domanshow.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Date;


/**
 * 添加Session
 *
 * */

@WebServlet("/servletTest")
public class ServletTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 1. 获取Session
        HttpSession session = request.getSession();
        // 2. 存储数据
        session.setAttribute("msg", "hello session 吃了没"+ new Date().toString());

        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        /** 单位:秒 */
        cookie.setMaxAge(60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}


```

## 2. 客户端不关闭, 服务器关闭后, 两次获取Session是同一吗?

- 不是同一个, 但是为了保证数据不丢失, Tomcat会做钝化和活化
- Session钝化
  - 服务器正常关闭前,会将Session对象序列化到硬盘上
- Session的活化
  - 在服务器启动后,将Session文件转化为内存中的Session对象


## 3. Session什么时候被销毁的?

- 1. 服务器关闭
- 2. Session对象调用`invalidate() `
- 3. Session默认失效时间30分钟

可以去这个路径下`CATALINA_BASE:         /Users/codew/Library/Caches/IntelliJIdea2019.3/tomcat/Tomcat_8_5_50_MyJavaEE_9/conf/web.xml`修改如下

```xml


<session-config>

  <session-timeout>30</session-timeout>

  </session-config>


```



# 5. Session的特点

1. Session用于存储一次会话的多次请求的数据, 存在服务端
2. Session可以存储`任意类型`, `任意大小`数据

## Session和Cookie的区别

1. Session存储数据在服务端,  Cookie在客户端
2. Session没有数据大小限制, Cookie有
3. Session数据安全, Cookie相对不安全



# 案例:



