远程拷贝程序

rsync差不多

# scp拷贝文件

```
scp -P34256 /Users/codew/Desktop/yum/128点使用过的命令.md root@118.22.177.156:/wt

```

# scp拷贝文件夹保持属性

```

scp -P34256 -rp /Users/codew/Desktop/yum/128点使用过的命令.md root@118.22.177.156:/wt
```

# 和rsync一样反过来就是拉



# scp 注意点, 不要沾满带宽

```

--P( 大写，注意和ssh 命令的不同)接端口，默认22 端口时可以省略一P22;
--r 递归，表示拷贝目录
--p表示在拷贝前后保持文件或目录属性
-l  limit 限制速度。1
一tmp oldboy为本地的目录。“@”前为用户名，“@”后为要连接的服务器的IP.IP 后的: /tmp 目录，为远端的目标目录。#-以上命令作用是把本地top oldboy拷贝到远端服务器10.0.0.14的/tep 目录
一还可以把远端目录抓到本地，具体命令为scp -P22 -r oldboy@10.0.0.150:/tpm /top/ oldboy 对调下原目录和目标目录即可。更多用法，请canscp
注意: 拷贝权限为连接的用户对应的权限。

```


# scp  小结

```

SCP 知识小结:
1.SCP 是加密的远程拷贝，而CP仅为本地拷贝。
2、可以把数据从一台机器推送到另一台机器，也可以从其它服务器把数据拉回到本地执行命令的服务器。
3、每次都是全量完整拷贝，因此，效率不高，适合第一次拷贝用，如果需要增量拷贝用rsync,

```


# 命令小结

```

74、partprobe 把分区表的修改变化通知内核↓
75、mkfs.ext4(mkfs -t ext4)格式化 -bblock -Iinode↓
76、mkswap 格式化swap分区↓
77、swapon/swapoff 使用swap分区，例如: swapon /dev/sdb1↓
78、mount -ttype -o选项
79、umount 卸载(-1F) 强制卸载↓
80、df 查看磁盘信息 -i -h -T文件类型↓
81、dumpe2fs 查看ext文件系统信息↓
82、fsck (e2fsck) 磁盘检查↓
83、parted 分区工具(常用大于2T) ↓
84、tune2fs修改文件系统信息
85、megacli de1l服务器查看raid信息↓
86、ipmitools 查看硬件信息工具
87、resize2fs调整文件系统大小(LVM,drbd)↓
88、watch 周期性执行程序，打印到目录，默认2秒，一n指定秒↓
89、ssh linux ssh客户端-p port,-t打开终端↓
90、SCP secure cp -P port,-r目录 -P保持属性↓

```







