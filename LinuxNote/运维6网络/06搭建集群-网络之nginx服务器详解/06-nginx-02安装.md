# l.安装Nginx所需的pcre库
Pcre 全称(PerlCompatible RegularExpessions)，中文“perl 兼容正则表达式”，官
方站点为tp://www.pcre.org/,安装pcre 库是为了使Nginx 皮持具备URI重写功能的
Rewrite 模块，如果不安装pcre 库，则Nginx 无法使用Rewite 模块功能，Nginx 的Rewrite
模块功能几乎是企业应用必须。安装pcre库的过程如下。

```

yum install pcre pcre-devel -y

// 操作完检查
rpm -qa pcre pcre-devel

rpm -qa pcre pcre-devel
pcre-8.32-17.el7.x86_64
pcre-devel-8.32-17.el7.x86_64

```



# 下载Nginx

http://nginx.org/en/download.html

```
创建一个目录tools

下载到tools里

wget -q http://nginx.org/download/nginx-1.6.3.tar.gz


```
创建用户
```

useradd www -s /sbin/nologin -M
```


解压下载的Nginx
```

tar xf nginx-1.6.3.tar.gz

```

进入文件看看

```

cd nginx-1.6.3

ls

auto CHANGES.ru configure  html  man  src

CHANGES conf  contrib LICENSE README

```
先来一个OpenSSL和gcc
```

yum install openssl openssl-devel gcc -y
yum install gcc -y
```

每个软件都要对应一个用户和组

```

./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --prefix=/application/nginx-1.6.3/
 


./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --prefix=/application/nginx-1.10.3/
```

### WebDAV服务器
```


./configure --user=www --group=www --with-http_ssl_module --with-http_dav_module --with-http_stub_status_module --prefix=/application/nginxWebDAV/

```


到上一步位置都是配置过程,还没有涉及到安装

看看配置有没有成功, 返回0就是成功
```
echo $?                      

0
```


编译安装
```
make


make[1]: Leaving directory `/wt/tools/nginx-1.6.3'

make -f objs/Makefile manpage

make[1]: Entering directory `/wt/tools/nginx-1.6.3'

sed -e "s|%%PREFIX%%|/application/nginx-1.6.3/|" \

-e "s|%%PID_PATH%%|/application/nginx-1.6.3//logs/nginx.pid|" \

-e "s|%%CONF_PATH%%|/application/nginx-1.6.3//conf/nginx.conf|" \

-e "s|%%ERROR_LOG_PATH%%|/application/nginx-1.6.3//logs/error.log|" \

< man/nginx.8 > objs/nginx.8

make[1]: Leaving directory `/wt/tools/nginx-1.6.3'
```
安装
```

make install
```


把带版本号的去掉, 我真正使用的就是/application/nginx/,  然后访问到的就是/application/nginx-1.6.3/
 
```

ln -s /application/nginx-1.6.3/ /application/nginx

ll /application/nginx                             

lrwxrwxrwx. 1 root root 25 Nov 30 17:00 /application/nginx -> /application/nginx-1.6.3/




ln -s /application/nginx-1.10.3/ /application/nginxBt


```

将来我看

```

ls -l /application

total 0

lrwxrwxrwx. 1 root root 25 Nov 30 17:00 nginx -> /application/nginx-1.6.3/

drwxr-xr-x. 6 root root 54 Nov 30 16:58 nginx-1.6.3

```

将来升级就爽了 

跑一下, 没反应就是好的[苦笑]
```
/application/nginx/sbin/nginx

```

看看服务起来没

```
netstat -lntup|grep 80

tcp 0 0 0.0.0.0:**80** 0.0.0.0:*  LISTEN 12627/nginx: master


lsof -i :80          

COMMAND  PID USER  FD  TYPE DEVICE SIZE/OFF NODE NAME

nginx  12627 root 6u IPv4 1806327 0t0 TCP *:http (LISTEN)
nginx  12629 www 6u IPv4 1806327 0t0 TCP *:http (LISTEN)
```



/application/nginx/sbin/nginx -t


