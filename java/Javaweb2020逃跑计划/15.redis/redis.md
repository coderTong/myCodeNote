# 目录

1. [概念](#redis1)
2. [下载安装](#redis2)
3. [命令操作](#redis3)
4. [持久化操作](#redis4)
5. [使用java客户端操作redis](#redis5)



# redis1
# 概念

1. 概念: `redis`是一款高性能的`NOSQL`系列的非关系型数据库

## 1.2 NOSQL和关系型数据库比较

1. 成本: `NOSQL`免费开源,易部署
2. 查询速度: `NOSQL`快
3. 存储数据格式: `NOSQL`key,value形式
4. 扩展性: `NOSQL`

## 1.3 `NOSQL` 缺点
1. 维护的工具和资料有限
2. 不提供sql支持
3. 不提供关系型数据库事务的处理


## 1.4 主流`NOSQL`产品

1. 键值(`key-value`)存储数据库: `Tokyo Cabinet/Tyrant`、`Redis`、`Voldemort`、`Berkeley DB`
2. 列存储数据库: `Cassandra`, `HBase`, `Riak`
3. 文档型数据库: `CouchDB`、`MongoDB`
4. 图像(`Graph`)数据库: `Neo4J`、`InfoGrid`、`Infinite Graph`



## 1.5 redis支持的键值数据类型
1. 字符串类型 `String`
2. 哈希类型 `hash`
3. 列表类型 `list`
4. 集合类型 `set`
5. 有序集合类型 `sortedset`


## 1.6 应用场景

1. 缓存
2. 任务队列
3. 数据过期处理
4. 分布式集群架构中的Session分离

##  总结
`NOSQL`是对关系型数据库的补充



# redis2
# 下载安装

见同文件夹的`redis安装和简单使用.md`



# redis3
# 命令操作

## 3.1 redis数据结构


1. 字符串类型 `string`
2. 哈希类型 `hash` : map 格式
3. 列表类型 `list`: linkedlist 格式 支持重复元素
4. 集合类型 `set`: 不允许元素重复
5. 有序集合类型 `sortedset`: 不允许元素重复, 且元素有序

## 3.2 字符串类型

1. 存储:`set userName wu`
2. 获取:`get userName`
3. 删除:`del userName`

```

127.0.0.1:6379> set userName wu
OK
127.0.0.1:6379> get userName
"wu"
127.0.0.1:6379> del userName
(integer) 1
127.0.0.1:6379> get userName
(nil)

```

## 3.3 哈希类型
1. 存储:`hset myHash userName lisi`
2. 获取:`hget myHash userName`  , `hgetall myHash`
3. 删除:`hdel myHash userName`


```

127.0.0.1:6379> hset myHash userName lisi
(integer) 1
127.0.0.1:6379> hset myHash psw 123
(integer) 1
127.0.0.1:6379> hget myHash userName
"lisi"
127.0.0.1:6379> hgetall myHash
1) "userName"
2) "lisi"
3) "psw"
4) "123"
127.0.0.1:6379> hdel myHash userName
(integer) 1
127.0.0.1:6379> hgetall myHash
1) "psw"
2) "123"
127.0.0.1:6379>

```


## 3.4 列表类型 list
1. 存储:``
    1.  `lpush`加入最左边
    2. `rpush`加入最右边
2. 获取:`lrange myList001 0 -1`
3. 删除:``
    1. `lpop` 删除最左边
    2. `rpop` 删除最右边
     

```

127.0.0.1:6379> lpush myList001 a
(integer) 1
127.0.0.1:6379> lpush myList001 b
(integer) 2
127.0.0.1:6379> rpush myList001 f
(integer) 3
127.0.0.1:6379> rpush myList001 g
(integer) 4
127.0.0.1:6379> lrange myList001 0 -1
1) "b"
2) "a"
3) "f"
4) "g"
127.0.0.1:6379> lpop myList001
"b"
127.0.0.1:6379> lrange myList001 0 -1
1) "a"
2) "f"
3) "g"
127.0.0.1:6379> rpop myList001
"g"
127.0.0.1:6379> lrange myList001 0 -1
1) "a"
2) "f"
127.0.0.1:6379> 

```

## 3.5 集合类型set, 不重复无序
1. 存储:`sadd mySet a`
2. 获取:`smembers mySet`
3. 删除:`srem mySet a`

```

127.0.0.1:6379> sadd mySet a
(integer) 1
127.0.0.1:6379> sadd mySet a
(integer) 0
127.0.0.1:6379> sadd mySet b
(integer) 1
127.0.0.1:6379> sadd mySet c
(integer) 1
127.0.0.1:6379> smembers mySet
1) "c"
2) "b"
3) "a"
127.0.0.1:6379> srem mySet a
(integer) 1
127.0.0.1:6379> smembers mySet
1) "c"
2) "b"

```


## 3.6 有序集合类型
1. 存储:`zadd mySort002 60 zhangsan`
2. 获取:`zrange mySort002 0 -1`
3. 删除:`zrem mySort002 zhangsan`

```
127.0.0.1:6379> zadd mySort002 60 zhangsan
(integer) 1
127.0.0.1:6379> zadd mySort002 88 lisi
(integer) 1
127.0.0.1:6379> zadd mySort002 34 kl
(integer) 1
127.0.0.1:6379> zadd mySort002 1000 wangwu
(integer) 1
127.0.0.1:6379> zrange mySort002 0 -1
1) "kl"
2) "zhangsan"
3) "lisi"
4) "wangwu"
127.0.0.1:6379> zrem mySort002 zhangsan
(integer) 1
127.0.0.1:6379> zrange mySort002 0 -1
1) "kl"
2) "lisi"
3) "wangwu"
127.0.0.1:6379> 


```


## 3.7 通用命令
1. keys * : 查询所有的键
2. type key ： 获取键对应的value的类型
3. del key：删除指定的key value

```
127.0.0.1:6379> keys *
1) "mySet"
2) "myList001"
3) "mySort002"
4) "myHash"
127.0.0.1:6379> type mySort002
zset
127.0.0.1:6379> set userName oppo
OK
127.0.0.1:6379> keys *
1) "myList001"
2) "userName"
3) "mySet"
4) "myHash"
5) "mySort002"
127.0.0.1:6379> del myList001
(integer) 1
127.0.0.1:6379> keys *
1) "userName"
2) "mySet"
3) "myHash"
4) "mySort002"
127.0.0.1:6379> 

```


# redis4
# 持久化操作

1. redis是一个内存数据库，当redis服务器重启，获取电脑重启，数据会丢失，我们可以将redis内存中的数据持久化保存到硬盘的文件中。
2. redis持久化机制：`RDB`：默认方式，不需要进行配置，默认就使用这种机制


```

cd /application/redis/conf

################################ SNAPSHOTTING  ################################
#
# Save the DB on disk:
#
#   save <seconds> <changes>
#
#   Will save the DB if both the given number of seconds and the given
#   number of write operations against the DB occurred.
#
#   In the example below the behaviour will be to save:
#   after 900 sec (15 min) if at least 1 key changed
#   after 300 sec (5 min) if at least 10 keys changed
#   after 60 sec if at least 10000 keys changed
#
#   Note: you can disable saving completely by commenting out all "save" lines.
#
#   It is also possible to remove all the previously configured save
#   points by adding a save directive with a single empty string argument
#   like in the following example:
#
#   save ""

save 900 1
save 300 10
save 60 10000

```


# redis5
# 使用java客户端操作redis

