


![06-LNMP-01](image/06-LNMP-01.png)

![06-LNMP-02](image/06-LNMP-02.png)

![06-LNMP-03](image/06-LNMP-03.png)



```



yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel wget vim zsh gcc -y && wget https://github.com/git/git/archive/v2.24.0.tar.gz && tar -zxf v2.24.0.tar.gz && cd git-2.24.0 && make prefix=/usr/local all && sudo make prefix=/usr/local install && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"



cd / && mkdir application wt

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







cd / && mkdir application wt && yum install libaio -y && wget https://dev.mysql.com/get/Downloads/MySQL-5.5/mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz && useradd -s /sbin/nologin mysql -M && tar xf mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz && mv mysql-5.5.58-linux-glibc2.12-x86_64 /application/mysql-5.5.58 && ln -s /application/mysql-5.5.58/ /application/mysql &&  cd /application/mysql && chown -R mysql.mysql /application/mysql && ./scripts/mysql_install_db --basedir=/application/mysql/ --datadir=/application/mysql/data --user=mysql && cd /application/mysql/bin && sed -i 's#/usr/local/#/application/#g' mysqld_safe && cd /application/mysql && cp support-files/my-small.cnf /etc/my.cnf && cd /application/mysql/support-files && sed -i 's#/usr/local/#/application/#g' mysql.server && cp ./mysql.server /etc/init.d/mysqld && /etc/init.d/mysqld start && echo 'export PATH=/application/mysql/bin:$PATH'>>/etc/profile && tail -1 /etc/profile && source /etc/profile && echo $PATH





```






# MySQL安装

# 0. 先下载MySQL二进制安装包

```

wget -q https://dev.mysql.com/get/Downloads/MySQL-5.5/mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz




```


# 1. 添加用户

```

useradd -s /sbin/nologin mysql -M



```

# 2. 解压

```

tar xf mysql-5.5.58-linux-glibc2.12-x86_64.tar.gz



ls mysql-5.5.58-linux-glibc2.12-x86_64

bin  data  include  lib  mysql-test  scripts  sql-bench

COPYING docs INSTALL-BINARY man README share  support-files




```


# 3. 移动

```

mv mysql-5.5.58-linux-glibc2.12-x86_64 /application/mysql-5.5.58


```

# 4. 做一个link(我们的目的很简单就是通过/application/mysql就能访问到)


```

ln -s /application/mysql-5.5.58/ /application/mysql


```


# 5. 做个授权

```

cd /application/mysql

chown -R mysql.mysql /application/mysql

&& 
```


# 5.2 yum install libaio

# ubuntu 的话是: apt install libaio-dev
```

/**
要先装一个libaio, 不然会报错, 如下

*/

Installing MySQL system tables...

/application/mysql//bin/mysqld: error while loading shared libraries: libaio.so.1: cannot open shared object file: No such file or directory

Installation of system tables failed! Examine the logs in

/application/mysql/data/ for more information.

You can try to start the mysqld daemon with:

 shell> /application/mysql//bin/mysqld --skip-grant &

and use the command line tool /application/mysql//bin/mysql

to connect to the mysql database and look at the grant tables:

 shell> /application/mysql//bin/mysql -u root mysql

 mysql> show tables

Try 'mysqld --help' if you have problems with paths. Using --log

gives you a log in /application/mysql/data/ that may be helpful.

Please consult the MySQL manual section

'Problems running mysql_install_db', and the manual section that

describes problems on your OS. Another information source are the

MySQL email archives available at http://lists.mysql.com/.

Please check all of the above before submitting a bug report

at http://bugs.mysql.com/
```


# 6. 安装

```

./scripts/mysql_install_db --basedir=/application/mysql/ --datadir=/application/mysql/data --user=mysql





```

# 看到两个ok就ok了
```

./scripts/mysql_install_db --basedir=/application/mysql/ --datadir=/application/mysql/data/ --user=mysql

Installing MySQL system tables...

171202 18:02:33 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.

171202 18:02:33 [Note] /application/mysql//bin/mysqld (mysqld 5.5.58) starting as process 23707 ...

OK

Filling help tables...

171202 18:02:33 [Note] Ignoring --secure-file-priv value as server is running with --bootstrap.

171202 18:02:33 [Note] /application/mysql//bin/mysqld (mysqld 5.5.58) starting as process 23714 ...

OK

To start mysqld at boot time you have to copy

support-files/mysql.server to the right place for your system

PLEASE REMEMBER TO SET A PASSWORD FOR THE MySQL root USER !

To do so, start the server, then issue the following commands:

/application/mysql//bin/mysqladmin -u root password 'new-password'

/application/mysql//bin/mysqladmin -u root -h wtstovel password 'new-password'

Alternatively you can run:

/application/mysql//bin/mysql_secure_installation

which will also give you the option of removing the test

databases and anonymous user created by default. This is

strongly recommended for production servers.

See the manual for more instructions.

You can start the MySQL daemon with:

cd /application/mysql/ ; /application/mysql//bin/mysqld_safe &

You can test the MySQL daemon with mysql-test-run.pl

cd /application/mysql//mysql-test ; perl mysql-test-run.pl

Please report any problems at http://bugs.mysql.com/


```


# 最终会在data目录下面生成如下

```

cd data

ls

mysql  performance_schema  test

```

# 7.做一个调整

# mysql 默认安装在/usr/local/下了, 我们安装在/application/mysql/ 下面, 我们得做个替换

# 看看是不是真的

```
cd /application/mysql/bin
cat mysqld_safe | grep /usr/local/

 MY_BASEDIR_VERSION='**/usr/local/**mysql'

 ledir='**/usr/local/**mysql/bin'

 DATADIR=**/usr/local/**mysql/data

elif test -x "**/usr/local/**mysql/bin/my_print_defaults" ; then

 print_defaults="**/usr/local/**mysql/bin/my_print_defaults"

 plugin_dir='**/usr/local/**mysql/lib/plugin'

```
#  果然有默认安装路径, 搞他, 替换掉
```
 
cd /application/mysql/bin 

less mysqld_safe


/**
下来一发看看效果, 我们没有不备份可不能轻易加i, 我们必须测试一下看看效果
*/

sed 's#/usr/local/#/application/mysql/#g' mysqld_safe | grep appli

sed 's#/usr/local/#/application/#g' mysqld_safe | grep appli


    MY_BASEDIR_VERSION='/application/mysql/mysql'
    ledir='/application/mysql/mysql/bin'
  DATADIR=/application/mysql/mysql/data
elif test -x "/application/mysql/mysql/bin/my_print_defaults" ; then
  print_defaults="/application/mysql/mysql/bin/my_print_defaults"
    plugin_dir='/application/mysql/mysql/lib/plugin'



/**

看了没有错
干!
*/

sed -i 's#/usr/local/#/application/mysql/#g' mysqld_safe


sed -i 's#/usr/local/#/application/#g' mysqld_safe




```

# 再看看cat mysqld_safe | grep /usr/local/

```

毛都没了

```


# 再看看cat mysqld_safe | grep /application/mysql/

![06-LNMP-04](image/06-LNMP-04.png)





# centOS6 的替换(其他忽略这个)

```




cd /application/mysql 
cp support-files/my-small.cnf /etc/my.cnf

cd /application/mysql/support-files


/// sed 's#/usr/local/#/application/mysql/#g' mysql.server | grep appli

sed 's#/usr/local/#/application/#g' mysql.server | grep appli



// sed -i 's#/usr/local/#/application/mysql/#g' mysql.server 
sed -i 's#/usr/local/#/application/#g' mysql.server 



cp support-files/mysql.server /etc/init.d/mysqld


cp ./mysql.server /etc/init.d/mysqld

/etc/init.d/mysqld
/etc/init.d/mysqld start





```


# 8. 替换完了, 咱就启动看看




```

/application/mysql/bin/mysqld

171202 18:28:10 [Note] --secure-file-priv is set to NULL. Operations related to importing and exporting data are disabled

171202 18:28:10 [Note] /application/mysql/bin/mysqld (mysqld 5.5.58) starting as process 23914 ...

171202 18:28:10 [ERROR] Can't find messagefile '/usr/local/mysql/share/errmsg.sys'

171202 18:28:10 [Warning] Can't create test file /var/lib/mysql/wtstovel.lower-test

171202 18:28:10 [Warning] Can't create test file /var/lib/mysql/wtstovel.lower-test

/application/mysql/bin/mysqld: Can't change dir to '/var/lib/mysql/' (Errcode: 2)

171202 18:28:10 [ERROR] Aborting

171202 18:28:10 [Note]

```

# 有错误




# ubuntu Systemd 解决错误 

```

cd /usr/lib/systemd/system

touch mysqld.service

编辑它输入如下
-------

[Unit]

Description=MySQL Server

After=network.target syslog.target

[Service]

ExecStart=/application/mysql/bin/mysqld --user=mysql --basedir=/application/mysql/ --datadir=/application/mysql/data/

Type=forking

Restart=on-failure

[Install]

WantedBy=multi-user.target

PIDFile=/application/mysql/mysql.pid


-------





// 然后依次输入如下命令
systemctl enable mysqld.service
systemctl status mysqld.service
systemctl start mysqld.service

```



# centOS7  Systemd 解决错误


```

cd /application/mysql 

cp support-files/my-small.cnf /etc/my.cnf


/**
编辑 /etc/my.cnf
在 [mysqld] 标签下添加如下, 见下面

basedir = /application/mysql
datadir = /application/mysql/data
user = mysql

*/




cd /usr/lib/systemd/system

touch mysqld.service

编辑它输入如下
-------

[Unit]

Description=MySQL Server

After=network.target syslog.target

[Service]

ExecStart=/application/mysql/bin/mysqld --user=mysql --basedir=/application/mysql/ --datadir=/application/mysql/data/

Type=forking

Restart=on-failure

[Install]

WantedBy=multi-user.target

PIDFile=/application/mysql/mysql.pid


-------





// 然后依次输入如下命令
systemctl enable mysqld.service
systemctl status mysqld.service
systemctl start mysqld.service




```




### [mysqld]

```

[mysqld]

port  = 3306

socket  = /tmp/mysql.sock

skip-external-locking

key_buffer_size = 16K

max_allowed_packet = 1M

table_open_cache = 4

sort_buffer_size = 64K

read_buffer_size = 256K

read_rnd_buffer_size = 256K

net_buffer_length = 2K

thread_stack = 128K

basedir = /application/mysql

datadir = /application/mysql/data

user = mysql

```



# 加快捷方式

```

 
echo 'PATH="/application/mysql/bin:$PATH"'>>/etc/profile
. /etc/profile





echo 'export PATH=/application/mysql/bin:$PATH'>>/etc/profile
tail -1 /etc/profile
source /etc/profile
echo $PATH


echo 'export PATH=/application/mysql/bin:$PATH'>>/etc/profile && tail -1 /etc/profile && source /etc/profile && echo $PATH



```



# 替换mysql.server 脚本

```
cd /application/mysql/support-files


sed 's#/usr/local/#/application/mysql/#g' mysql.server | grep appli
sed -i 's#/usr/local/#/application/mysql/#g' mysql.server 
```




# Systemd 相关见下面链接

[Systemd 入门教程](http://www.ruanyifeng.com/blog/2016/03/systemd-tutorial-commands.html)



 






