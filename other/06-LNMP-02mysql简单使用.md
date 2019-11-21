```

mysql -u root -p

use mysql;

update user set host = '%'  where user = 'root';




select host from user where user = 'root';

# mysql> select host,user from user where user='root';






==================

一般情况下
mysql -u root -p
mysql>use mysql;
mysql>select 'host' from user where user='root';
mysql>update user set host = '%' where user ='root';
mysql>flush privileges;
mysql>select 'host'   from user where user='root';




# RROR 1062 (23000): Duplicate entry '%-root' for key 'PRIMARY' 

如果执行update语句时出现ERROR 1062 (23000): Duplicate entry '%-root' for key 'PRIMARY' 错误，说明有多个ROOT用户纪录在USER表中了.
需要select host from user where user = 'root';
查看一下host是否已经有了%这个值，有了就可以了.
mysql> select host,user from user where user='root';


```

# 刚刚安装完成试试如下命令

```

mysql -uroot -p

```
没有密码直接进去了

没有密码直接回车就进去了
#  加密码

```

mysqladmin -u root password '1'23456

```

# 密码登录

```

mysql -uroot -p123456


```


# 有密码了怎么改密码了?如下

```

mysqladmin -uroot -p123456a password 1234567a

mysql -u root -p

```


# 带密码的登录像上面那样输入登录会有记录,  怎么解决? 如下

清空
```

history -c 


history -d


```


