# 先安装nginx


# 安装证书相关

```shell

sudo yum install epel-release -y
sudo yum update -y

sudo yum install certbot python2-certbot-nginx -y


启动nginx
netstat -lntup|grep 80

ln -s /application/nginx/sbin/nginx /usr/bin/nginx

如果是二级域名(不知道顶级域名会不会更改) 先修改nginx配置文件server_name bbs.xxx.com;


然后
certbot --nginx --nginx-server-root=/application/nginx/conf -d www.itopengl.com


http://www.itopengl.com/

www.domanshow.com
/application/nginx/sbin/nginx -t
/application/nginx/sbin/nginx -s  reload



```
