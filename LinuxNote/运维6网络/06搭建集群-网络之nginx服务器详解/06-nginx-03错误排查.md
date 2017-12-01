下面介绍客户端排查的思路。
第一步，在客户端上ping 服务器端IP,命令如下。

ping10.0.0.8<排除物理线路司题影响

第二步，在客户端上telnet 服务器端IP、端口，命令如下:

telnet 10.0.0.8 80 排除防火墙等得影响

第三步，在客户端使用wget 命令检测，如下:
rget 10.0.0.8(curl 10.0.0.8)<模拟用户访问，排除http服务自身问题，根据输出在排错除
提示:以上三步是客户端访问网站异常排查的重要三部曲，







# nginx 配置文件目录

```

vim /application/nginx/conf/nginx.conf




```

# // 改完以后检查语法错没
```

/application/nginx/sbin/nginx -t

nginx: the configuration file /application/nginx-1.6.3//conf/nginx.conf syntax is ok

nginx: configuration file /application/nginx-1.6.3//conf/nginx.conf test is successful

```


# Nginx 平滑重启

```

/application/nginx/sbin/nginx -s reload

```


# diff nginx.conf nginx.conf.default



