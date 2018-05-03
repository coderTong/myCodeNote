# 下载Nginx服务器和RTMP模块

http://nginx.org/en/download.html

https://github.com/arut/nginx-rtmp-module.git


```

yum install pcre pcre-devel openssl openssl-devel gcc -y



wget http://nginx.org/download/nginx-1.10.3.tar.gz

git clone https://github.com/arut/nginx-rtmp-module.git



tar xf nginx-1.10.3.tar.gz

cd nginx-1.10.3


useradd www -s /sbin/nologin -M



./configure --user=www --group=www --with-http_ssl_module --with-http_stub_status_module --add-module=../nginx-rtmp-module --prefix=/application/nginx-rtmp/


make

make install

```

# Nginx 平滑重启

```

/application/nginx/sbin/nginx -s reload

```

# // 改完以后检查语法错没
```

/application/nginx/sbin/nginx -t

nginx: the configuration file /application/nginx-1.6.3//conf/nginx.conf syntax is ok

nginx: configuration file /application/nginx-1.6.3//conf/nginx.conf test is successful

```



## 点播配置



```


rtmp {                #RTMP服务
   server {
       listen 1935;  #//服务端口
       chunk_size 4096;   #//数据传输块的大小


   application vod {
       play /wt/testv; #//视频文件存放位置。
   	}

   }
}


/**

## 用VLC播放一个看看

rtmp://206.189.128.41/vod/moov.mp4

*/


```


### 直播配置


```


/**

接着我们就在点播服务器配置文件的基础之上添加直播服务器的配置。一共2个位置，第一处就是给RTMP服务添加一个application这个名字可以任意起，也可以起多个名字，由于是直播我就叫做它live吧，如果打算弄多个频道的直播就可以live_cctv1、live_cctv2名字任意。第二处就是添加两个location字段，字段的内容请直接看文件吧。

*/



#user  nobody;
worker_processes  1;

#error_log  logs/error.log;
#error_log  logs/error.log  notice;
#error_log  logs/error.log  info;

#pid        logs/nginx.pid;


events {
    worker_connections  1024;
}


rtmp {
    server {
        listen 1935;
        chunk_size 4096;
        
        
        application vod {
            play /wt/testv;  
        }
        
        application live{ #第一处添加的直播字段
            live on;
			record off; // 关闭录制
			allow play all; // 允许任何人发起请求
        }
        
        
        
    }
}

http {
    include       mime.types;
    default_type  application/octet-stream;

    #log_format  main  '$remote_addr - $remote_user [$time_local] "$request" '
    #                  '$status $body_bytes_sent "$http_referer" '
    #                  '"$http_user_agent" "$http_x_forwarded_for"';

    #access_log  logs/access.log  main;

    sendfile        on;
    #tcp_nopush     on;

    #keepalive_timeout  0;
    keepalive_timeout  65;

    #gzip  on;

    server {
        listen       80;
        server_name  localhost;

        #charset koi8-r;

        #access_log  logs/host.access.log  main;
        
        location /stat {    #第二处添加的location字段。
            rtmp_stat all;
            rtmp_stat_stylesheet stat.xsl;
        }
        
        location /stat.xsl { #第二处添加的location字段。
            root /wt/code/nginx/nginx-rtmp-module;
        }
        

        location / {
            root   html;
            index  index.html index.htm;
        }

        #error_page  404              /404.html;

        # redirect server error pages to the static page /50x.html
        #
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }

        # proxy the PHP scripts to Apache listening on 127.0.0.1:80
        #
        #location ~ \.php$ {
        #    proxy_pass   http://127.0.0.1;
        #}

        # pass the PHP scripts to FastCGI server listening on 127.0.0.1:9000
        #
        #location ~ \.php$ {
        #    root           html;
        #    fastcgi_pass   127.0.0.1:9000;
        #    fastcgi_index  index.php;
        #    fastcgi_param  SCRIPT_FILENAME  /scripts$fastcgi_script_name;
        #    include        fastcgi_params;
        #}

        # deny access to .htaccess files, if Apache's document root
        # concurs with nginx's one
        #
        #location ~ /\.ht {
        #    deny  all;
        #}
    }


    # another virtual host using mix of IP-, name-, and port-based configuration
    #
    #server {
    #    listen       8000;
    #    listen       somename:8080;
    #    server_name  somename  alias  another.alias;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}


    # HTTPS server
    #
    #server {
    #    listen       443 ssl;
    #    server_name  localhost;

    #    ssl_certificate      cert.pem;
    #    ssl_certificate_key  cert.key;

    #    ssl_session_cache    shared:SSL:1m;
    #    ssl_session_timeout  5m;

    #    ssl_ciphers  HIGH:!aNULL:!MD5;
    #    ssl_prefer_server_ciphers  on;

    #    location / {
    #        root   html;
    #        index  index.html index.htm;
    #    }
    #}

}


```

http://106.189.18.41/stat
![05-FFmpeg流媒体-01-rtmp](image/05-FFmpeg%E6%B5%81%E5%AA%92%E4%BD%93-01-rtmp.png)


看到图中的live, 我们的直播服务就ok了.  下一步就用FFmpeg推一个上去.


我们把直播的名字取叫live, 然后我们以后用VLC,或者其他支持rtmp的播放器播放地址就是"rtmp://xx.xx.xx.xx/live"


## 看看服务起来没

```

netstat -lntup|grep 80

```



