# 虚拟主机概念

```

所谓虚拟主机,在Web服务里就是一个独立的网站站点,这个站点对应独立的域名(也可能是IP或端口)，具有独立的程序及资源目录，可以独立地对外提供服务供用户访问。

这个独立的站点在配置里是由一定格式的标签段标记，对于Apache软件来说，一个虚拟主机的标签段通常被包含在<VitualHost><NVutuaHos>内,而Nginx 软件则使用一个server{}标签来标示一个虚拟主机，一个Web 服务里可以有多个虚拟主机标签对，即同时可以支持多个虚拟主机站点。

```

# 在Nginx里就是server{}标签


# 虚拟主机类型

```

2.虚拟主机类型
常见的虚拟主机类型有如下几种。

基于域名的虚拟主机
所谓基于域名的虚拟主机，意思就是通过不同的域名区分不同的虚拟主机，基于域名
的虚拟主机是企业应用最广的虚拟主机类型，几乎所有对外提供服务的网站都是使用基于
域名的虚拟主机，例如: www.etiantin.org




基于端口的虚拟机
同理,所谓基于端口的虚拟主机，意思就是通过不同的端口来区分不同的虚拟主机，
此类虚拟主机对应的企业应用主要为公司内部的网站，例如:一些不希望直接对外提供用
户访问的网站后台等，访问基于端口的虚拟主机地址里要带有端口,例如:
htp://www.etiantian.org:60OO。



基于ip的 -----基本不用

```



#  虚拟主机应用说明

```

一个server标签段就是一个虚拟主机。↓
基于域名的虚拟主机。通过域名来区分虚拟主机↓
a,
== >应用 ;外 部网 站****↓
2、基于端口的虚拟主机。通过端口来区分虚拟主机↓
==>应用: 公司内部网站，网站的后台***↓
3、基于IP的虚拟主机。几乎不用。不支持ifconfig别名，配置文件可以。

```


# vim  /application/nginx/conf/nginx.conf

```

server {

 listen  80;

 server_name www.codertomwu.win;

 location / {

 	root  html/www;

 	index index.html index.htm;

 }

}

server {

 listen  80;

 server_name bbs.codertomwu.win;

 location / {

 	root  html/bbs;

 	index index.html index.htm;

 }

}

```


# 配置完成后stop, start

```

/application/nginx/sbin/nginx -s stop

/application/nginx/sbin/nginx // 这样就代表start

```


# ifconfig eth0:0 10.0.0.101/24 up

# ifconfig

# man ip

# ip addr add 10.0.0.102/24 dev eth0 label eth0:1

# ifconfig

# history






# Nginx 配置虚拟主机步骤如下

http://nginx.org/en/docs/http/request_processing.html

```

Nginx 配置虚拟主机步骤如下(适合各类虚拟主机类型)。
l) 增加一个完整的server标签段到结尾处。注意，要放在咖的结束大括号前，也就是将
server标签段放入http标签。

2) 更改server_name 及对应网页的root根目录，如果需要其他参数，可以增加或修改。
3) 创建server_name域名对应网页的根目录，并且建立测试文件，如果没有index 首页，
访问会出现403错误。
4) 检查Nginx配置文件语法，平滑重启Nginx 服务，快速检查启动结果。
5) 在客户端对server_name处配置的域名做host解析或DNS配置，并检查(ping 域名看
返回的P对不对)。
6) 在Win32 浏览器中输入地址访问，或者在Linux客户端做hosts 解析，用wget或curl
接地址访问。

```



#  企业场景中重启Nginx 后的检测策略

在企业运维实战场景中，每一个配置操作处理完毕后都应该进行快速有效的检查，这
是一个合格运维人员的良好习惯。在老男孩的实际工作中，启动Nginx的同时，还会调用
脚本通过获取header信息或模拟用户访问指定URL(wget 等方式) 来自动检查Nginx 的启
动是不是真的正常，最大限度地保证服务重启后，能迅速确定网站情况，而无需手工敲命
令查看。这样，如果配置有问题(非语法问题,语法问题已经用-1参数检查过了)，就可
以迅速使用上一版备份的配置文件覆盖回来，使得影响用户的时间最短。
下面是一个重启Nginx 服务后，检查启动是否正常的脚本，可以把它包含在Nginx 启动
脚本(需要另行开发) 内部的start等启动位置。





# curl -I baidu.com

```

HTTP/1.1 200 OK

Date: Fri, 01 Dec 2017 14:28:08 GMT

Server: Apache

Last-Modified: Tue, 12 Jan 2010 13:48:00 GMT

ETag: "51-47cf7e6ee8400"

Accept-Ranges: bytes

Content-Length: 81

Cache-Control: max-age=86400

Expires: Sat, 02 Dec 2017 14:28:08 GMT

Connection: Keep-Alive

Content-Type: text/html

```

# curl -I 51cto.com

```

curl -I 51cto.com

HTTP/1.1 301 Moved Permanently

Date: Fri, 01 Dec 2017 14:29:06 GMT

Content-Type: text/html

Connection: keep-alive

Location: http://www.51cto.com/

Load-Balancing: web03

Load-Balancing: web03

Load-Balancing: web03

```

# 别名 加多个空格就可以了

```

server {

 listen  80;

 server_name www.codertomwu.win codertomwu.win;

 location / {

 	root  html/www;

 	index index.html index.htm;

 }

}

```


# 用别名监控看看哪个服务器挂没挂



# nginx 状态


```

server {

 listen  80;

 server_name status.codertomwu.win;

 location / {
	stub_status on;
	access_log off;
 }

}


```


# 打开status.codertomwu.win得到

```

Active connections: 5 
server accepts handled requests
 25 25 62 
Reading: 0 Writing: 1 Waiting: 4



解释
Active connections // Nginx正在处理的连接, 单位时间内服务器正在处理的连接数
```
server accepts handled requests
 25 25 62
上面两行看下表解释一一对应
| 从启动到现在一共处理的连接 | 启动到现在成功创建了多少次握手 | 已经处理完毕的请求数 |
|---|---|---|
| server | accepts | handled requests |
| 25 | 25 | 62 |
accepts和server要一样的话就代表没有失败


Reading读取客户端header信息数量

Writing:Nginx返回给客户端header信息数量
Waiting: 已经处理完正在等候下一次请求指令的驻留连接



# 可以不让别人看我们的status

allow 112.95.101.101; // 设置允许的ip
deny all; // 禁止的ip. 除了112.95.101.101其他全部禁止

```

server {

 listen  80;

 server_name status.codertomwu.win;

 location / {
	stub_status on;
	access_log off;
	allow 112.95.10.201;
	deny all;
 }

}

```




# 错误日志



错误日志是Nginx软件发送故障了, 配置错了呀, 等等....
会在一个log里面记载

错误信息属于核心模块

参数是
error_log file level


```

1.Nginx 错误日志信息介绍
配置记录Nginx 的错误信息是调试Nginx 服务的重要手段，属于核心功能模块
(nginx_core_module) 的参数，该参数名字为error_log,可以放在Main 区块中全局配置，
也可以放置不同的虚拟主机中单独记录虚拟主机的错误信息.
eror_log的语法格式及参数语法说明如下:

eror_1og file level 
关键字 日志文件错误 日志级别

其中，关键字error_log不能改变，日志文件可以指定任意存放日志的目录，错误日志级别
常见的有[debug |info|notice |error | warn....],级别越高记录的信息越少，生产一般看error warn

```
例子

vim /application/nginx/conf/nginx.conf

```
worker_processes 1;

events {

 worker_connections 1024;

}

error_log logs/error.log error;

http {

 include  mime.types;

 default_type application/octet-stream;

 sendfile on;

 keepalive_timeout 65;

 include  extra/*.conf;

}

```
```

/**
logs 是安装目录下的logs

/application/nginx

client_body_temp  fastcgi_temp  logs  sbin  uwsgi_temp

conf  html  proxy_temp  scgi_temp
*/
error_log logs/error.log error;  

```

# 其实我们不加人家默认也是有的,,,,,,,,,,,,,,,,,

```

cd /application/nginx/logs
ls
access.log error.log nginx.pid


```


# 日志一定不要加info!!!!!!!!!!!!!info会带来巨大的磁盘IO消耗


