# 刚刚安装完成试试如下命令

```

mysql -uroot -p

```
没有密码直接进去了

没有密码直接回车就进去了
#  加密码

```

mysqladmin -u root password '123456'

```

# 密码登录

```

mysql -uroot -p123456


```


# 有密码了怎么改密码了?如下

```

mysqladmin -uroot -p123456 password 1234567

mysql -u root -p

```


# 带密码的登录像上面那样输入登录会有记录,  怎么解决? 如下

清空
```

history -c 


history -d
```


