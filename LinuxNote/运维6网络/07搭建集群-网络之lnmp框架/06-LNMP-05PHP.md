# PHP连接


简单说就是配一个location就行了,  以blog为例

# nginx.conf

```
worker_processes 1;

events {

 worker_connections 1024;

}

http {

 include  mime.types;

 default_type application/octet-stream;

 sendfile on;

 keepalive_timeout 65;

 include extra/www.conf;

 include extra/blog.conf;

 include extra/status.conf;

}

```
# blog.conf

```

server {

 listen 80;

 server_name blog.codertomwu.win;

 location / {

 root html/blog;

 index index.html index.htm;

 }

 location ~ .*\.(php|php5)?$ {

 root  html/blog;

 fastcgi_pass  127.0.0.1:9000;

 fastcgi_index index.php;

 include fastcgi.conf;

 }

}


```

# 配完以后

```

/application/nginx/sbin/nginx -t
/application/nginx/sbin/nginx -s reload

```


# 验证一下

```

 cd /application/nginx/html/blog


echo "<?php phpinfo(); ?>" >test_info.php

然后浏览它, 
```

# 写个程序看看到数据库是不是通了


```

cd /application/nginx/html/blog

touch xxxtset.php

<?php

$link_id=mysql_connect('localhost', 'root', '123456') or mysql_error();

if($link_id){

echo "mysql successful by www.codertomwu.win!";

}else{

echo mysql_error();

}

?>


```








