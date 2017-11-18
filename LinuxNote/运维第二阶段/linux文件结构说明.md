/    //放系统程序

/usr     // 放用户自己的程序
 
/home     // 用于存放用户的数据

/usr/local     // 存放用户自己安装的程序

/bin

/dev 

/etc // 二进制软件包(yum, rpm, apt?)的***配置文件***默认路径


```

目录结构多了,然后就有了标准.........FHS(目录层次标准)

```



![FHS规范](FHS%E8%A7%84%E8%8C%83.png)


```
/etc/fstab  ---开机挂载磁盘的

/etc/issue    //系统相关信息

/etc/motd       //  登录后显示的提示信息

/etc/profile   // 全局环境变量


/etc/resolv.conf   // DNS 文件


/etc  // 下面还有启动文件

/etc/init.d  // 下面好多启动相关文件, ssh  防火墙啥的, 启动命令
````



```

home 普通用户的家目录

什么是普通用户?>   答:除了root用户以外.....


 su - shuT

$ pwd

/home/shuT

```




