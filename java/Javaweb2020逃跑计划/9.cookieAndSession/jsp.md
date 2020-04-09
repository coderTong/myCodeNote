# JSP


# 1. 概念:

## Java Server Pages: java服务器页面

- 特殊的页面, 可以html, 又可以java code
- 用来简化书写


# 2. 原理:
他本质上就是一个`Servlet`

# 3. JSP的脚本
实际上就是在html里像JS那样写代码

`<% %>`: 作用范围较小.  定义的java代码,在service方法中. service方法中可以定义什么, 这个脚本中就可以定义什么.
`<%! %> `:可能会有线程问题. 作用范围大.  定义的java代码, 在jsp转换后的java类的成员位置.
`<%= %>`: 输出用的

# 4. JSP的内置对象
一共9个, 下面先来三个

- request
- response
- out: 字符输出流对象. 可以将数据输出到页面上. 和`response.getWriter`类似


## response.getWriter()和out.write()的区别

- 1.  `tomcat`服务器真正给客户端做出响应之前, 会先找`response`缓冲区数据, 再找out缓冲区
- 2.  `response.getWriter()` 数据输出永远在`out.write()`之前

# 5. 案例:




# myNote
<% %>: 作用范围较小
<%! %> : 可能会有线程问题. 作用范围大
<%= %>: 输出用的
