
#  Nginx Rewrite  (伪静态)

和Apachc 等Web 服务软件一样，Nginx Rewrite 的主要功能也是 ***实现URL地址重写***，
Nginx的Rewrite规则需要PCRE软件的支持，即通过Perl 兼容正则表达式语法进行规则匹
配的,前文在安装Nginx软件时就已经安装了这个PCRE软件，以及让Nginx支持Rewrite
的功能，默认参数编译Nginx 就会安装支持Rewrite 的模块，但是，也必须要PCRE 软件
的支持。



#  Rewrite 语法

```

指令语法: rewrite regex replacement[flag];
默认值: none
应用位置: server , location,  if

```

# 简单例子

```
/**
PER正则

你输入一个地址, 甭管你输入啥我都要把地址改成http://www.codertomwu.win/$1 ,  permanent永久的每次都是要这样做. 



*/ 

rewrite ^/(.*) http://www.codertomwu.win/$1 permanent;


rewrite ^/(.*) http://www.codertomwu.com/$1 permanent;
```

在上述指令中，rewrite 为固定关键字,表示开启一条rewrite匹配规则，regex部分是^(.*),
这是一个正则表达式，匹配所有，匹配成功后跳转到http://www.codertomwu.win/$1,这里的$1
是取前面regex 部分()里的内容，结尾permanent,表示永久301重定向标记,即跳转到后面
http://www.codertomwu.win/$1地址上。




# 实战, (~ 实测有效)


```

server {

 listen 80;

 server_name wwww.codertomwu.win codertomwu.win;

 location / {

 	rewrite ^/(.*) http://www.codertomwu.com/$1 permanent;

 }

 access_log logs/www_access.log main;

 }

```


# 实战二, 只有图片的时候匹配, 默认你还走你的


```

server {

 	listen 80;

 	server_name wwww.codertomwu.win codertomwu.win;

	location / {

 		root html/www;
    	index index.html;

 	}

	location  ^~  /images/  {

 	   rewrite ^/(.*) http://www.codertomwu.com/$1 permanent;

	}

 

 access_log logs/www_access.log main;

 }


```




# Rewrite 尾部标记




| fag标记符号 | 说明 |
|---|---|
| last | 本条规则匹配完成后，继续向下匹配新的locationURI规则 |
| break | 本条规则匹配完成即终止。不再匹配后面的任何规则; |
| redirect | 返回302临时重定向，浏览器地址栏会显示跳转后的URL地址; |
| permanent | 返回301永久重定向，浏览器地址栏会显示跳转后的URL地址。 |






