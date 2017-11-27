
![06-net-nfs01](image2/06-net-nfs01.png)


# 什么是NFS , 用来存图片视频文件的, 搞存储的.  共享存储



```

Network File System 
网络文件系统

让不同主机系统之间可以共享文件或者目录


```


# NFS 是独立的文件系统, 网络文件系统



#  NFS 是一台,   后面别人用的是Moosefs(mfs), GlusterFS, FastDFS

# NFS 效率不高, 用啥啊mfs, GlusterFS, 

# 公共的NFS系统


# NFS 每次重启它的端口都是不一样的 

# 每次重启端口都不一样, 又想让用户找到它, 这时候就需要RPC服务 



# NFS工作流程图(形象)



![06-net-nfs02](image2/06-net-nfs02.png)



# NFS工作流程图(具体)


![06-net-nfs03](image2/06-net-nfs03.png)


# centos6 RPC叫rpcbind.   centos7叫啥? 





# 开搞========================



#  NFS 软件列表

###  要部署NFS服务,  需要安装下面的软件包

>  nfs-utils : NFS服务的主程序, 包括rpc.nfsd, rpc.mountd这两个daemons和相关文档说明, 以及执行命令文件等.


>  rpcbind: CentOS6.X 下面RPC的主程序, NFS可以视为一个RPC程序, 在启动任何一个RPC程序之前, 需要做好端口和功能的对应映射工作, 这个映射工作就是有rpcbind服务来完成的. 因此,在提供NFS服务之前I必须先启动rpcbind服务才行.