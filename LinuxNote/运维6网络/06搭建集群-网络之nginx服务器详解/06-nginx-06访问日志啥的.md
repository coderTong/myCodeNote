#  访问日志

控制参数

| 参数 | 说明 |
|---|---|
| log_format | 用来定义记录日志的格式(可以定义多种日志格式, 去不同名字即可) |
| access_log | 用来指定日志文件的路径及使用的何种日志格式记录日志 |


# 默认长这样
```

 #log_format main '$remote_addr - $remote_user [$time_local] "$request" '

 # 				  '$status $body_bytes_sent "$http_referer" '

 # 				  '"$http_user_agent" "$http_x_forwarded_for"';


```

# 默认存放地方展示(http标签内)

```

#user nobody;

worker_processes 1;

#error_log logs/error.log;

#error_log logs/error.log notice;

#error_log logs/error.log info;

#pid logs/nginx.pid;

events {

 worker_connections 1024;

}

http {

 include  mime.types;

 default_type application/octet-stream;

  #log_format main '$remote_addr - $remote_user [$time_local] "$request" '

  # 				'$status $body_bytes_sent "$http_referer" '

  # 				'"$http_user_agent" "$http_x_forwarded_for"';

  #access_log logs/access.log main;

 sendfile on;

  #tcp_nopush  on;

  #keepalive_timeout 0;

 keepalive_timeout 65;

  #gzip on;

 server {

 listen  80;

 server_name www.codertomwu.win;

  #charset koi8-r;

  #access_log logs/host.access.log main;

 location / {

 root  html/www;

```


# 参数说明



| Nginx日志变量 | 说明 |
|---|---|
| $remote_addr | 记录访问网站的客户端地址 |
| $http_x_forwarded_for | 当前段有代理服务器时，设置web节点记录客户端地址的配置，此参数生效的前提是代理服务器上也要进行相关的x_forwarded_for 设置 |
| $remote_user | 远程客户端用户名称 |
| $time_local | 记录访问时间与时区 |
| $request | 用户的http请求起始行信息 |
| $status | http状态码，记录请求返回的状志,例如:200.404.301等 |
| $body_bytes_sent | 服务器发送给客户端的响应body字节数 |
| $http_referer | 记录此次请求是从哪个链按访问过来的，可以根据referer进行防盗链设置 |
| $http_user_agent | 记录客户端访问信息,例如:浏览器, 手机客户端等 |

$http_referer// 你让百度帮你推广, 你怎么知道是从百度过来的....., 通过它可以知道你点这个页面的上一个页面是什么



# 上面只是定义

# 怎么使用? : access_log标签, 在server标签里面写

# vim www.conf

```
server {

 listen 80;

 server_name wwww.codertomwu.win codertomwu.win;

 location / {

 root html/www;

 index index.html index.htm;

 }

 access_log logs/www_access.log main;

 }

```
logs 还是说放在了/application/nginx/logs 里面的意思
main 是说我们用 上面写得那个格式记录  ( #log_format main,   $log_format 可以写好多种格式main1 main2 main3随便啦)

# 去logs文件夹下面看看, 是没有www_access.log的

# 设置完成了看看格式对不对, 然后重启

```

/application/nginx/sbin/nginx -t
/application/nginx/sbin/nginx -s reload

```


# 重启后再去看有了

```
ls

access.log error.log nginx.pid www_access.log

```






```

101.33.87.11 - - [02/Dec/2017:02:01:41 +0000] "GET / HTTP/1.1" 200 4 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5" "-"

101.33.87.11 - - [02/Dec/2017:02:07:44 +0000] "GET / HTTP/1.1" 200 4 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5" "-"

101.33.87.11 - - [02/Dec/2017:02:07:55 +0000] "GET / HTTP/1.1" 200 4 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36" "-"

101.33.87.11 - - [02/Dec/2017:02:08:50 +0000] "GET / HTTP/1.1" 200 4 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5" "-"

125.101.99.87 - - [02/Dec/2017:02:15:43 +0000] "GET / HTTP/1.1" 200 4 "-" "Wget/1.14 (linux-gnu)" "-"

125.101.99.87 - - [02/Dec/2017:02:16:28 +0000] "GET / HTTP/1.1" 200 4 "-" "Wget/1.14 (linux-gnu)" "-"

125.101.99.87 - - [02/Dec/2017:02:17:25 +0000] "GET / HTTP/1.1" 200 4 "-" "Wget/1.14 (linux-gnu)" "-"

125.101.99.87 - - [02/Dec/2017:02:17:28 +0000] "GET / HTTP/1.1" 200 4 "-" "Wget/1.14 (linux-gnu)" "-"

101.33.87.11 - - [02/Dec/2017:02:18:06 +0000] "GET / HTTP/1.1" 304 0 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36" "-"

```


#log_format main '$remote_addr - $remote_user [$time_local] "$request" '

 # 				  '$status $body_bytes_sent "$http_referer" '

 # 				  '"$http_user_agent" "$http_x_forwarded_for"';


101.33.87.11 - - [02/Dec/2017:02:01:41 +0000] "GET / HTTP/1.1" 200 4 "-" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5" "-"

125.101.99.87 - - [02/Dec/2017:02:17:28 +0000] "GET / HTTP/1.1" 200 4 "-" "Wget/1.14 (linux-gnu)" "-"

>1. $ remote_addr -  // $remote_addr

>2. '-' // 第二个- 是用户没有用户就是 -    $remote_user

>3. [02/Dec/2017:02:18:06 +0000] // 时间 [$time_local]

>4. "GET / HTTP/1.1"    //  "$request", 地址和协议

>5.  200  // $status  状态码

>6.  4 //  $body_bytes_sent 响应的主体

>7.  "-"  //  "$http_referer"   直接输入地址打开的所以没有


>8.  "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5"  //  "$http_user_agent" 客户端

>9. "-"    // "$http_x_forwarded_for" 没有使用代理 所以-




# http_referer 从简书过来就是如下

101.33.87.11 - - [02/Dec/2017:03:23:24 +0000] "GET / HTTP/1.1" 200 4 "http://www.jianshu.com/writer" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/604.3.5 (KHTML, like Gecko) Version/11.0.1 Safari/604.3.5" "-"


### 手机过来的情况

101.33.87.11 - - [02/Dec/2017:03:28:16 +0000] "GET / HTTP/1.1" 200 4 "http://www.jianshu.com/p/f30545809f3a" "Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_2 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13F69 QQ/7.2.9.404 V1_IPH_SQ_7.2.9_1_APP_A Pixel/750 Core/UIWebView Device/Apple(iPhone 6s) NetType/WIFI QBWebViewType/1" "-"


