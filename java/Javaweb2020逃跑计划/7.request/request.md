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

获取请求行数据
```




```
