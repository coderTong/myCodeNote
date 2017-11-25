# rsync 特性

![06-jiqun11](image/06-jiqun11.png)


# 实时备份
![06-jiqun12](image/06-jiqun12.png)


# 关于rsync的项目(运维简历上可以写)

![06-jiqun13](image/06-jiqun13.png)



# rsync 三种工作方式


![06-jiqun14](image/06-jiqun14.png)



# rsync -vzrtopg wwo.txt /tmp  ------相当于copy

```
rsync -vzrtopg wwo.txt /tmp 

sending incremental file list

wwo.txt

sent 167 bytes received 31 bytes 396.00 bytes/sec

total size is 228 speedup is 1.15


-v是答应过程好像

```



# rsync  参数


![06-jiqun15](image/06-jiqun15.png)

![06-jiqun15](image/06-jiqun16.png)


# rsync 不带/拷贝只拷贝文件夹下的文件




# rsync -avz /Users/XXX/Desktop/Test/1rsync -e 'ssh -p 22' root@109.29.33.16:/wt/dir3




# vim /etc/ssh/sshd_config

```

( GSSAPIAuthentication 改为NO加 UseDNS no   速度就快了?)
vim /etc/ssh/sshd_config





78 # GSSAPI options

79 GSSAPIAuthentication  yes

80 GSSAPICleanupCredentials  no

81 #GSSAPIStrictAcceptorCheck yes

82 #GSSAPIKeyExchange no

83 #GSSAPIEnablek5users no







#ShowPatchLevel no

#UseDNS yes

#PidFile /var/run/sshd.pid

#MaxStartups 10:30:100

```




# =======================================重要知识分界线

# 服务就是daemon


# daemon 是配在备份服务器上的.


# cat /etc/rsyncd.conf

```

cat /etc/rsyncd.conf   

# /etc/rsyncd: configuration file for rsync daemon mode

# See rsyncd.conf man page for more options.

# configuration example:

# uid = nobody

# gid = nobody

# use chroot = yes

# max connections = 4

# pid file = /var/run/rsyncd.pid

# exclude = lost+found/

# transfer logging = yes

# timeout = 900

# ignore nonreadable = yes

# dont compress  = *.gz *.tgz *.zip *.z *.Z *.rpm *.deb *.bz2

# [ftp]

# path = /home/ftp
 
# comment = ftp export area









````


// 解释说明

***uid = rsync***    // 用户, 远端的命令使用rsync访问共享目录
***gid = rsync***  // 用户组
***use chroot = no***  // 安全相关
***max connections = 200***   // 最大连接数
***timeout = 300***   // 超时时间
***pid file = /var/run/rsyncd.pid***   // 进程对应的进程号文件
***lock file = /var/log/rsync.log***    // 锁文件
***log file = /var/log/rsyncd.log***   // 日志文件  出错
***[backup]***  // 模块名称
***path = /backup***   // 服务器提供访问的目录
***ignore errors***    // 忽略错误
***read only = false***      // 可写
***list = false***   // 不能列表  不能ls啥的~

hosts allow = xx.xx.xx.xx // 允许哪些机器过来连
hosts deny = 0.0.0.0/32  // 拒绝哪些机器过来连,  0.0.0.0/32 表示谁都可以过来 
auth users = rsync_backup    //虚拟用户,   独立于系统用户以外的虚拟用户 , 和系统账号没什么关系
secrets file = /ect/rsync.password  // 虚拟用户的密码, 虚拟账户对应的账号和密码

```

vim /etc/rsyncd.conf 

uid = rsync
gid = rsync
use chroot = no
max connections = 4
timeout = 300
pid file = /var/run/rsyncd.pid
lock file = /var/run/rsync.lock
log file = /var/log/rsyncd.log
[backup]
path = /backup
ignore errors
read only = false
list = false


hosts allow = xx.xx.xx.xx
hosts deny = 0.0.0.0/32
auth users = rsync_backup
secrets file = /ect/rsync.password
```


# 'rsync' 用户不存在


```
id rsync

id: rsync: no such user




useradd rsync -s /sbin/nologin -M  // 创建一个不需要登录, 没有家目录的虚拟用户

useradd rsync -s /sbin/nologin -M

 **~sync**  [05:11:58]

**root$** tail -1 /etc/passwd

rsync:x:1004:1005::/home/rsync:/sbin/nologin






```




# rsync --daemon (rsync 启动服务)


# 怎么看启动服务

```
ps -ef|grep rsync|grep -v grep

root  21918  1 0 17:13 ? 00:00:00 rsync --daemon

```





# 创建backup目录

```
mkdir /backup

```


# 改backup权限

```
chown rsync.rsync /backup/

```