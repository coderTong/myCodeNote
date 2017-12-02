官网
http://nginx.org/en/docs/http/ngx_http_auth_basic_module.html

```

location / {
    auth_basic           "closed site";
    auth_basic_user_file conf/htpasswd;
}


```


```

server {

 listen 80;

 server_name wwww.codertomwu.win codertomwu.win;

 location / {

 	auth_basic  "show.........";

 	auth_basic_user_file /application/nginx/conf/htpasswd;

	root html/www;

	 index index.html;

 }

 location ^~ /images/ {

 rewrite ^/(.*) http://www.codertomwu.com/$1 permanent;

 }

 access_log logs/www_access.log main;

 }


```

# Nginx没有htpasswd:  yum install httpd -y

```
yum install httpd -y

which htpasswd

/usr/bin/htpasswd

```


# 添加密码

下面两条都可以
```
/usr/bin/htpasswd -cb /application/nginx/conf/htpasswd testUser 123456

/usr/bin/htpasswd -c /application/nginx/conf/htpasswd testUser 123456

```

# 重启Nginx就ok了



# 某个路径要密码

```

server {

 listen 80;

 server_name wwww.codertomwu.win codertomwu.win;

 location / {

 root html/www;

 index index.html;

 }

 location /passwordtest/ {

 auth_basic  "show.........";

 auth_basic_user_file /application/nginx/conf/htpasswd;

root html/www;

 index index.html;

 }

 location ^~ /images/ {

 rewrite ^/(.*) http://www.codertomwu.com/$1 permanent;

 }

 access_log logs/www_access.log main;

 }

```