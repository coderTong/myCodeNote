一台机器管理其他机器

SSH  Secure Shell Protocol

知识小结:
l、SSH是安全的加密协议，用于远程连接limux 服务器。
2、SSH 默认端口是22，安全协议版本SSH2,除了2之外还有SSH1I( 漏洞)。
3、SSH 服务端主要包含两个服务功能SSH 远程连接，SFTP 服务。
4.LinuxSSH客户端包含sh远程连接命令，以及远程拷贝SCP命令等。


OpenSSH 同时支持SSH 1.X 和2.X。用SSH 2.X 的客户端程序不能连接到SSH 1.X 的服务程序上。
SSH 服务端是一个守护进程(demon),他在后台运行并响应来自客户端的连接请求。SSH 服务端的进程名为sshd,
负责实时监听远程SSH 客户端的连接请求，并进行处理，一般包括公共密钥认证、密钥交换、对称密钥加密和非安全
连接等。这个SSH服务就是我们前面基础系统优化中保留开机自启动的服务之一。
sh客户端包含ssh以及像scp (远程拷贝)、slogin (远程登陆)、sftp (安全FTP文件传输) 等应用程序。
sh的工作机制大致是本地的ssh客户端先发送一个连接请求到远程的ssh服务端，服务端检查连接的客户端发送
的数据包和P地址，如果确认合法，就会发送密钥给SSH的客户端，此时，客户端本地再将密钥发回给服务端，自
此连接建立。SSH 1.X 和SSH2.X在连接协议上有一些安全方面的差异.




![06-SSH-01](image/06-SSH-01.png)



基于密钥的安全验证:
基于密钥的安全验证方式是指，需要依靠密钥，也就是必须事先建立一对密钥对，然后把公用密钥(Fublickey) 放
在需要访问的目标服务器上，另外，还需要把私有密钥(Privatekey) 放到SSH的客户端或对应的客户端服务器上。
此时，如果要想连接到这个带有公用密钥的SSH 服务器，客户端SSH软件或者客户端服务器就会向SSH 服务器发出
请求，请求用联机的用户密钥进行安全验证。SSH 服务器收到请求之后，会先在该SSH 服务器上连接的用户的家目录下寻
找事先放上去的对应用户的公用密钥，然后把它和连接的SSH客户端发送过来的公用密钥进行比较。如果两个密钥一致,
SSH 服务器就用公用密钥加密“质询”
(challenge) 并把它发送给SSH客户端。



# ssh 秘钥登录==========================



# ls /etc/ssh/sshd_config


# 更改基本配置 改掉不用22端口啥的
 

| 参数 | 说明 |
|---|---|
| Port | 指定sshd进程监听的端口号，默认为22。可以使用多条指令监听多个端口。默认将在本机的所有网络接口上监听，但是可以通过ListenAddress 指定只在某个特定的接口上监听。 |
| PemitEmptyPasswords |  是否允许密码为空的用户远程登录。默认为“"no”。 |
| PermitRootLogin | 是否允许root 登录。可用值如下: "yes"(默认) 表示允许。"no"表示禁止。"without-password"表示禁止使用密码认证登录。"forced-commands-only"表示只有在指定了command选项的情况下才允许使用公钥认证登录。同时其它认证方法全部被禁止。这个值常用于做远程备份之类的事情。 |
| UseDNS | 指定sshd是否应该对远程主机名进行反向解析，以检查此主机名是否与其IP地址真实对应。默认值为"yes"。 |

| GSSAPIAuthentication | 解决Linux之间使用SSH远程连接慢的问题 |
|---|---|


```
vim /etc/ssh/sshd_config
Port 23232
ListenAddress 你的IP:你的端口
PermitRootLogin   no  // 允许root用户登录? ---不允许!
GSSAPIAuthentication no  // 连接慢就是它影响的
UseDNS no   // 
PemitEmptyPasswords no  // 允许空密码登录?

```
# 改完以后sshd reload

service reload sshd
systemctl reload sshd


/etc/init.d/sshd reload

# 登录 ssh -p你设置的端口  root@12.90.102.22

ssh -p12323  root@12.90.102.22


# ssh小结

```

SSH客户端命令小结:
l、切换到别的机器上ssh-p5213user@ip ([user@]lhostname[comand)
2、到其他机器执行命令(不会切到机器上) ssh-p521l3user@ip 命令(全路径)
3.当第一次SSH 连接的时候，本地会产生一个密钥文件~.ssh/known hosts( 多个密钥)。

```

#  客户端存放服务端秘钥的 .ssh/known_hosts





