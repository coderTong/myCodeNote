# Request



# HTTP:

### 请求消息数据格式

1. 请求行
2. 请求头
3. 请求空行
4. 请求体

- 请求行
```text

请求方式 请求url 请求协议/版本
GET /login.html	HTTP/1.1

```



- 请求头

```html

Host: 192.168.31.147:8080
User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10.15; rv:72.0) Gecko/20100101 Firefox/72.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8
Accept-Language: zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
Accept-Encoding: gzip, deflate
Connection: keep-alive
Referer: http://www.domanshow.com/
Upgrade-Insecure-Requests: 1


```

`User-Agent`: 浏览器信息
`Referer` : 从哪来..




## Request:

```java

@Override public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

}

```

1. `request`和`response`对象都是服务器创建的

2. 集成结构
ServletRequest ---接口
          |
HttpServletRequest------接口
			|	实现
org.apache.catalina.connector.RequestFacade 类(tomcat)


3. Request功能:

- 获取请求行数据
```java


// 1.获取请求方式 

String method = request.getMethod();
System.out.println(method);

// 2.(*) 获取虚拟目录: 

String contextPath = request.getContextPath();
System.out.println(contextPath);

// 3.获取Servlet 路径 : 
/api/gunnidaye System.out.println(request.getServletPath());

// 4.(*) 获取请求URI: 

/RequestDemo_war_exploded/api/gunnidaye System.out.println(request.getRequestURI());

// 5.URL: http://localhost:8080/RequestDemo_war_exploded/api/gunnidaye 

System.out.println(request.getRequestURL());

// 6. 获取访问Ip 
System.out.println(request.getRemoteAddr());

```


- 获取请求头 

```java


String agent = request.getHeader("user-agent");
System.out.println(agent);


```


- 请求体


```java


package com.domanshow.web.reuqest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/api/mmpk")
public class RequestDemo05 extends HttpServlet {

    @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        // post 获取请求参数2    System.out.println("--------来了老弟");
        /**
 * ======================================================================== * 单个单个的获取 * ======================================================================== * */         // 根据参数名称获取

 String username = req.getParameter("username");
        System.out.println("username:" + username);
        System.out.println("--------");

        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {

            System.out.println(hobby);
        }
// // //        System.out.println("--------");
 /** * ======================================================================== * 获取所有的 * ======================================================================== * */     /** * * 这个有个缺点: 只能拿到字符串, 如果是数组的话就拿不到 * * */         
 Enumeration<String> parameterNames = req.getParameterNames();

        while (parameterNames.hasMoreElements()){

            String name = parameterNames.nextElement();
            System.out.println("name: " + name);

            String value = req.getParameter(name);
            System.out.println("value: " + value);
            System.out.println("--------");

        }

        /**
 * * 这个可以拿到数组 * */    Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String name : keyset) {

            String[] values =parameterMap.get(name);
            System.out.println(name);

            for (String value : values) {
                System.out.println(value);
            }

            System.out.println("--------");
        }

    }
}


```

# 获取请求参数中文乱码

```java

request.setCharacterEncoding("utf-8");

```




# 请求转发

```java


package com.domanshow.web.reuqest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/RequestDemo06")
public class RequestDemo06 extends HttpServlet {

    @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        /**
 * 转发 * * */  
 
 System.out.println("RequestDemo06: 来了老弟~");

        /**
 * 设置存储数据Request * */  
 req.setAttribute("msg", "hello");
        req.getRequestDispatcher("/RequestDemo07").forward(req,resp);
    }

    @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}

```



```java


package com.domanshow.web.reuqest;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo07")
public class RequestDemo07 extends HttpServlet {

    @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        // 来了老弟
  System.out.println("RequestDemo07:  来了老弟");

        Object msg = req.getAttribute("msg");
        System.out.println(msg);

        ServletContext servletContext = req.getServletContext();

        System.out.println(servletContext);
    }

    @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}


```



# 共享数据

1. `void setAttribute(String name,Object obj)`:存储数据
2. `Object getAttitude(String name)`:通过键获取值
3. `void removeAttribute(String name)`:通过键移除键值对


# 获取ServletContext:

```java

ServletContext getServletContext()

```
