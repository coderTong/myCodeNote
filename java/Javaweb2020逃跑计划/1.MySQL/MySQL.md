# 目录

1. [linux 安装](#1-linux-安装)
2. [MySQL基础](#2-mysql-基础)
3. [MySQL约束](#3-MySQL-约束)
4. [MySQL多表&事务](#4-MySQL-多表-事务)
                1.[查看-mysql-的历史记录](#查看-mysql-的历史记录) 
5. [](#)
6. [](#)
7. [](#)



### 1-linux 安装


1.yum 一键安装

```

// 安装myzsh
yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel wget vim zsh gcc -y && wget https://github.com/git/git/archive/v2.24.0.tar.gz && tar -zxf v2.24.0.tar.gz && cd git-2.24.0 && make prefix=/usr/local all && sudo make prefix=/usr/local install && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"



// 分布
cd / && mkdir application wt
&&
yum install libaio -y
&&
wget https://dev.mysql.com/get/Downloads/MySQL-5.5/mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz
&&
useradd -s /sbin/nologin mysql -M
&&
tar xf mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz
&&
mv mysql-5.5.58-linux-glibc2.12-x86_64 /application/mysql-5.5.58
&&
ln -s /application/mysql-5.5.58/ /application/mysql
&&
cd /application/mysql && chown -R mysql.mysql /application/mysql
&&
./scripts/mysql_install_db --basedir=/application/mysql/ --datadir=/application/mysql/data --user=mysql
&&
cd /application/mysql/bin
&&
sed -i 's#/usr/local/#/application/#g' mysqld_safe
&&
cd /application/mysql 
&&
cp support-files/my-small.cnf /etc/my.cnf
&&
cd /application/mysql/support-files
&&
sed -i 's#/usr/local/#/application/#g' mysql.server
&&
cp ./mysql.server /etc/init.d/mysqld
&&
/etc/init.d/mysqld start
&&
echo 'export PATH=/application/mysql/bin:$PATH'>>/etc/profile && tail -1 /etc/profile && source /etc/profile && echo $PATH





//  一键安装

yum install libaio -y && wget https://dev.mysql.com/get/Downloads/MySQL-5.5/mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz && useradd -s /sbin/nologin mysql -M && tar xf mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz && mv mysql-5.5.58-linux-glibc2.12-x86_64 /application/mysql-5.5.58 && ln -s /application/mysql-5.5.58/ /application/mysql &&  cd /application/mysql && chown -R mysql.mysql /application/mysql && ./scripts/mysql_install_db --basedir=/application/mysql/ --datadir=/application/mysql/data --user=mysql && cd /application/mysql/bin && sed -i 's#/usr/local/#/application/#g' mysqld_safe && cd /application/mysql && cp support-files/my-small.cnf /etc/my.cnf && cd /application/mysql/support-files && sed -i 's#/usr/local/#/application/#g' mysql.server && cp ./mysql.server /etc/init.d/mysqld && /etc/init.d/mysqld start && echo 'export PATH=/application/mysql/bin:$PATH'>>/etc/profile && tail -1 /etc/profile && source /etc/profile && echo $PATH



```



# 2 mysql 基础

### 查看-mysql-的历史记录

```

cat /root/.mysql_history

```


### 改变mysql输出样式

```

prompt \u@root \r:\m:\s->


在my.cnf 配置文件[mysql] 中配置.  永久
[mysql]
prompt=\\u@root \\r:\\m:\\s->

```

### 远程登录

```

mysql -u root -p -h 192.22.22.22 -P3306


```

### 模糊show

```

show databases like 'my%';


```



### 查看主机名和权限

```

select user.host from mysql.user;


```


### SHOW GRANTS;

```

SHOW GRANTS;

root@root 04:11:14->SHOW GRANTS;

+---------------------------------------------------------------------+

| Grants for root@localhost  |

+---------------------------------------------------------------------+

| GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION |

| GRANT PROXY ON ''@'' TO 'root'@'localhost' WITH GRANT OPTION |

+---------------------------------------------------------------------+


// 查看某个用户 的权限

show grants for 'root'@'localhost';

+---------------------------------------------------------------------+

| Grants for root@localhost  |

+---------------------------------------------------------------------+

| GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION |

| GRANT PROXY ON ''@'' TO 'root'@'localhost' WITH GRANT OPTION |

+---------------------------------------------------------------------+


添加codetom为超级管理员. 等价root
grants all

GRANT ALL PRIVILEGES ON *.* TO 'codetom'@'localhost' WITH GRANT OPTION

GRANT ALL PRIVILEGES ON *.* TO 'codetom'@'%' WITH GRANT OPTION

```


### 加密码

```

mysqladmin -u root password 123456a

//改密码
mysqladmin -u root -p '123456a' password 'qazwsx'



// mysql 里面修改密码

UPDATE mysql.user SET password=PASSWORD("qwerty") WHERE user='root';
flush PRIVILEGES;


```




### 刷新提交

```

flush PRIVILEGES


```



### 忘记 密码然后忽略验证登录进去修改密码

```

/etc/init.d/mysqld stop

mysqld_safe --skip-grant-tables --user=mysql &

mysql

UPDATE mysql.user SET password=PASSWORD("abc") WHERE user='root';

flush PRIVILEGES;

quit;

mysqladmin -uroot -pabc shutdown

/etc/init.d/mysqld start
```


### 查看mysql启动方式

```

➜  /wt ps -ef|grep mysql
root     21441 20626  0 16:35 pts/0    00:00:00 /bin/sh /application/mysql/bin/mysqld_safe --skip-grant-tables --user=mysql
mysql    21682 21441  0 16:35 pts/0    00:00:00 /application/mysql/bin/mysqld --basedir=/application/mysql --datadir=/application/mysql/data --plugin-dir=/application/mysql/lib/plugin --user=mysql --skip-grant-tables --log-error=sanfan.err --pid-file=sanfan.pid --socket=/tmp/mysql.sock --port=3306


```


### 密码登录

```

mysql -u root -p


```


### 查看库的建表语句

```

mysql> show create database mysql\G

*************************** 1\. row ***************************

 Database: mysql

Create Database: CREATE DATABASE `mysql` /*!40100 DEFAULT CHARACTER SET latin1 */

1 row in set (0.01 sec)



```

### 编译的时候没有指定字符集或者指定了和程序不同的字符集,如何解决..  指定字符集创建 数据库即可

```

create database wutong_utf8 CHARACTER SET utf8 COLLATE utf8_general_ci;


create database wutong_utf8 CHARACTER SET gbk COLLATE gbk_general_ci;

mysql> show create database wutong_utf8\G

*************************** 1\. row ***************************

 Database: wutong_utf8

Create Database: CREATE DATABASE `wutong_utf8` /*!40100 DEFAULT CHARACTER SET utf8 */

1 row in set (0.00 sec)


```



### 进入数据库

```

use mysql;


```


### 显示当前数据库


```

mysql> select database();

+------------+

| database() |

+------------+

| mysql |

+------------+

1 row in set (0.00 sec)

```


### 删库跑路

```

drop database wutg_utf8;

```


### 查看用户

```

mysql> select user,host from mysql.user;

+---------+-----------+

| user | host |

+---------+-----------+

| root | 127.0.0.1 |

| root | ::1  |

|  | localhost |

| codetom | localhost |

| root | localhost |

|  | sanfan |

| root | sanfan |

+---------+-----------+

7 rows in set (0.00 sec)


```


### 删除多余的用户

```
// 语法
drop  user "user"@"主机域";


mysql> drop user "codetom"@"localhost";

Query OK, 0 rows affected (0.01 sec)


如果的drop 删除不了(一般是特殊字符或大写), 可以哦用下面

delete from mysql.user where user='root' and host='name';
flush PRIVILEGES;
```


### 创建用户并授权

```

CREATE USER 'jeffrey'@'localhost' IDENTIFIED BY 'mypass';

GRANT ALL ON db1.* TO 'jeffrey'@'localhost';

GRANT SELECT ON db2.invoice TO 'jeffrey'@'localhost';

GRANT USAGE ON *.* TO 'jeffrey'@'localhost' WITH MAX_QUERIES_PER_HOUR 90;



// 1. 创建用户 + 授权
// 创建用户
CREATE USER 'jeffrey'@'localhost' IDENTIFIED BY 'mypass';
// 授权
GRANT ALL ON db1.* TO 'jeffrey'@'localhost';


//  2. 上面两条相当于下面一条
GRANT ALL ON db1.* TO 'jeffrey'@'localhost' IDENTIFIED BY 'mypass';


GRANT: 授权命令
all privileges: 对应权限
on dbname.* : 目标:库和表
to username@'localhost': 用户名和客户端主机
IDENTIFIED BY 'mypass': 用户密码


// 3. 创建一个doukeyi用户密码是123456a7, 从哪里 都可以登录, 所有库所有表都可以访问
grant all on *.* to 'doukeyi'@'%' identified by '123456a7'

grant all on *.* to 'mytest1'@'111.194.40.169' identified by '123456a78';
```


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


### 3-MySQL 约束

### 4-MySQL 多表 事务

