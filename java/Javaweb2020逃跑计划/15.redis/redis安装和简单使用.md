```

cd /wt && \
wget http://download.redis.io/releases/redis-3.0.4.tar.gz && \
ls redis-3.0.4.tar.gz -sh && \
tar xf redis-3.0.4.tar.gz && \
cd redis-3.0.4 && \
make MALLOC=jemalloc && \
make PREFIX=/application/redis-3.0.4 install && \
ln -s /application/redis-3.0.4/ /application/redis && \
echo 'export PATH=/application/redis/bin:$PATH'>>/etc/profile && \
tail -1 /etc/profile && \
source /etc/profile && \
echo $PATH && \
mkdir /application/redis/conf && \
cd /wt/redis-3.0.4 && \
cp /wt/redis-3.0.4/redis.conf /application/redis/conf && \
sysctl vm.overcommit_memory=1 && \
redis-server /application/redis/conf/redis.conf &


```





# 下载地址

```

http://download.redis.io/releases/

我们下载

wget http://download.redis.io/releases/redis-3.0.4.tar.gz

```


# 看看多大
```txt

ls redis-3.0.4.tar.gz -sh

```


# 解压

```

tar xf redis-3.0.4.tar.gz


```

# 进去

```

cd redis-3.0.4

```




# 编译

```

make MALLOC=jemalloc

```


# 安装

```

make PREFIX=/application/redis-3.0.4 install

```


# 做个软连接

```

 ln -s /application/redis-3.0.4/ /application/redis
 
```



# 做个环境变量

```
// 临时生效
export PATH=/application/redis/bin:$PATH

// 永久生效
echo 'export PATH=/application/redis/bin:$PATH'>>/etc/profile
tail -1 /etc/profile
source /etc/profile
echo $PATH

```


# redis配置文件相关

0. 先创建一个conf目录:
```

mkdir /application/redis/conf

```

1. 去解压目录的当前目录:

```

cd /wt/redis-3.0.4

```

2. 拷贝解压目录下的conf到新建的conf目录中去:

```
cp /wt/redis-3.0.4/redis.conf /application/redis/conf

```


# 启动试一下

```

redis-server /application/redis/conf/redis.conf &

```



# 问题一

```

**➜** **redis-3.0.4** redis-server /application/redis/conf/redis.conf

10067:M 01 May 14:07:33.245 * Increased maximum number of open files to 10032 (it was originally set to 1024).

 _._

 _.-``__ ''-._

 _.-`` `. `_. ''-._  Redis 3.0.4 (00000000/0) 64 bit

 .-`` .-```. ```\/ _.,_ ''-._

 ( ' ,  .-` | `, )  Running in standalone mode

 |`-._`-...-` __...-.``-._|'` _.-'|  Port: 6379

 | `-._  `._ /  _.-' |  PID: 10067

 `-._ `-._ `-./ _.-' _.-'

 |`-._`-._ `-.__.-' _.-'_.-'|                                  

 | `-._`-._ _.-'_.-' |  http://redis.io        

 `-._ `-._`-.__.-'_.-' _.-'

 |`-._`-._ `-.__.-' _.-'_.-'|                                  

 | `-._`-._ _.-'_.-' |                                  

 `-._ `-._`-.__.-'_.-' _.-'

 `-._ `-.__.-' _.-'

 `-._ _.-'

 `-.__.-'

10067:M 01 May 14:07:33.246 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.

10067:M 01 May 14:07:33.246 # Server started, Redis version 3.0.4

10067:M 01 May 14:07:33.246 # WARNING overcommit_memory is set to 0! Background save may fail under low memory condition. To fix this issue add 'vm.overcommit_memory = 1' to /etc/sysctl.conf and then reboot or run the command 'sysctl vm.overcommit_memory=1' for this to take effect.

10067:M 01 May 14:07:33.246 # WARNING you have Transparent Huge Pages (THP) support enabled in your kernel. This will create latency and memory usage issues with Redis. To fix this issue run the command 'echo never > /sys/kernel/mm/transparent_hugepage/enabled' as root, and add it to your /etc/rc.local in order to retain the setting after a reboot. Redis must be restarted after THP is disabled.

10067:M 01 May 14:07:33.246 * The server is now ready to accept connections on port 6379


```


# 先退出来

```

killall redis-server

```


# 按照人家的提示执行

```

sysctl vm.overcommit_memory=1

```


# 执行完了再启动

```

redis-server /application/redis/conf/redis.conf &





---------------------
➜  redis-3.0.4 redis-server /application/redis/conf/redis.conf &
[1] 10186
10186:M 01 May 14:17:41.998 * Increased maximum number of open files to 10032 (it was originally set to 1024).                                                                                                
                _._                                                  
           _.-``__ ''-._                                             
      _.-``    `.  `_.  ''-._           Redis 3.0.4 (00000000/0) 64 bit
  .-`` .-```.  ```\/    _.,_ ''-._                                   
 (    '      ,       .-`  | `,    )     Running in standalone mode
 |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
 |    `-._   `._    /     _.-'    |     PID: 10186
  `-._    `-._  `-./  _.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |           http://redis.io        
  `-._    `-._`-.__.-'_.-'    _.-'                                   
 |`-._`-._    `-.__.-'    _.-'_.-'|                                  
 |    `-._`-._        _.-'_.-'    |                                  
  `-._    `-._`-.__.-'_.-'    _.-'                                   
      `-._    `-.__.-'    _.-'                                       
          `-._        _.-'                                           
➜  redis-3.0.4               `-.__.-'                                               

10186:M 01 May 14:17:42.001 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
10186:M 01 May 14:17:42.001 # Server started, Redis version 3.0.4
10186:M 01 May 14:17:42.001 # WARNING you have Transparent Huge Pages (THP) support enabled in your kernel. This will create latency and memory usage issues with Redis. To fix this issue run the command 'echo never > /sys/kernel/mm/transparent_hugepage/enabled' as root, and add it to your /etc/rc.local in order to retain the setting after a reboot. Redis must be restarted after THP is disabled.
10186:M 01 May 14:17:42.001 * DB loaded from disk: 0.000 seconds
10186:M 01 May 14:17:42.001 * The server is now ready to accept connections on port 6379

```


# 查看一下

redis-3.0.4 netstat -lntup

```

➜  redis-3.0.4 netstat -lntup
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address               Foreign Address             State       PID/Program name   
tcp        0      0 0.0.0.0:3306                0.0.0.0:*                   LISTEN      29668/mysqld        
tcp        0      0 0.0.0.0:6379                0.0.0.0:*                   LISTEN      10186/redis-server  
tcp        0      0 0.0.0.0:22                  0.0.0.0:*                   LISTEN      1796/sshd           
tcp        0      0 127.0.0.1:25                0.0.0.0:*                   LISTEN      1722/master         
tcp        0      0 :::6379                     :::*                        LISTEN      10186/redis-server  
tcp        0      0 :::22                       :::*                        LISTEN      1796/sshd           
tcp        0      0 ::1:25                      :::*                        LISTEN      1722/master 

```


# redis正确关闭方法

```

redis-cli shutdown


```


# 目录简单介绍



`redis-benchmark`:  性能测试
`redis-check-aof`: 更新日志检查
`redis-check-dump`: 用于本地数据库检查
`redis-cli`: 命令行操作工具
redis-sentinel -> redis-server
`redis-server`: 启动程序


