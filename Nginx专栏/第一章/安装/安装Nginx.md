### 一句代码

```

cd /wt && useradd www -s /sbin/nologin -M && yum install pcre pcre-devel  openssl openssl-devel gcc -y && wget -q http://nginx.org/download/nginx-1.16.0.tar.gz && tar xf nginx-1.16.0.tar.gz && cd nginx-1.16.0 && ./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --prefix=/application/nginx-1.16.0 && make && make install && ln -s /application/nginx-1.16.0/ /application/nginx

```


### 前期准备

```c


yum install pcre pcre-devel  openssl openssl-devel gcc -y


```


### 下载


```c

wget -q http://nginx.org/download/nginx-1.16.0.tar.gz

```

### 解压源文件进入源码文件夹

```

tar xf nginx-1.16.0.tar.gz && cd nginx-1.16.0


```

### 创建用户

```c

useradd www -s /sbin/nologin -M

```



### 开启相关模块

```c

./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --prefix=/application/nginx-1.16.0


```


### 编译并安装


```

make && make install


```


### 创建一个软链接

```

ln -s /application/nginx-1.16.0/ /application/nginx


```



### 看看服务起来没

```
netstat -lntup


```