# sftp -oPort=61516 root@101.225.177.23

```

sftp -oPort=61516 root@101.225.177.23

Connected to 128.199.177.156.

sftp> ls

anaconda-ks.cfg  original-ks.cfg     

sftp> pwd

Remote working directory: /root

sftp> cd /wt    

sftp> pwd

Remote working directory: /wt

sftp> ls

128点使用过的命令.md  wo.txt                                  

sftp>


// 将本地的文件传到服务器
sftp> put /Users/wodeMac/Desktop/yum/33/Tomcat.xmind

// 将本地的文件夹传到服务器
sftp> put -r /Users/codew/Desktop/yum/22

// 后面也可以指定路径
sftp> put -r /Users/codew/Desktop/yum/22  /tmp/xxx


```

# quit 退出sftp



# get 拉数据到本地 


```
// 拉文件
 get  /wt/xxx.txt /Users/xxx/Desktop/yum/cc

// 拉文件夹
 get -r /wt /Users/xxx/Desktop/yum/cc

```

