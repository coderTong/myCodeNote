
```
查看防火墙状态
systemctl status firewalld.service

关闭运行的防火墙
systemctl stop firewalld.service    

install net-tools




yum install wget vim zsh git -y net-tools && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)" -Y

curl "https://bootstrap.pypa.io/get-pip.py" -o "get-pip.py" && python get-pip.py && pip install --upgrade pip && pip install shadowsocks


vim /etc/shadowsocks.json
{
  "server": "0.0.0.0",
  "server_port": 9388,
  "password": "a469t7w",
  "method": "aes-256-cfb"
}



vim /etc/systemd/system/shadowsocks.service
[Unit]
Description=Shadowsocks

[Service]
TimeoutStartSec=0
ExecStart=/usr/bin/ssserver -c /etc/shadowsocks.json

[Install]
WantedBy=multi-user.target





systemctl enable shadowsocks && systemctl start shadowsocks && systemctl status shadowsocks -l


cat /etc/shadowsocks.json

```



CentOS 7 开始默认使用[Systemd](https://en.wikipedia.org/wiki/Systemd)作为开启启动脚本的管理工具，[Shadowsocks](https://github.com/shadowsocks/)则是当前比较受欢迎的科学上网工具，本文将介绍如何在 CentOS 下安装和配置 Shadowsocks 服务。


## 安装 pip

[pip](https://pip.pypa.io/en/stable/installing/)是 python 的包管理工具。在本文中将使用 python 版本的 shadowsocks，此版本的 shadowsocks 已发布到 pip 上，因此我们需要通过 pip 命令来安装。

在控制台执行以下命令安装 pip：

```
curl "https://bootstrap.pypa.io/get-pip.py" -o "get-pip.py"
python get-pip.py

```



## 安装配置 shadowsocks

在控制台执行以下命令安装 shadowsocks：

```
pip install --upgrade pip
pip install shadowsocks

```

安装完成后，需要创建配置文件`/etc/shadowsocks.json`，内容如下：

```
{
  "server": "0.0.0.0",
  "server_port": 8388,
  "password": "uzon57jd0v869t7w",
  "method": "aes-256-cfb"
}

```

说明：

*   `method`为加密方法，可选`aes-128-cfb, aes-192-cfb, aes-256-cfb, bf-cfb, cast5-cfb, des-cfb, rc4-md5, chacha20, salsa20, rc4, table`
*   `server_port`为服务监听端口
*   `password`为密码，可使用[密码生成工具](http://ucdok.com/project/generate_password.html)生成一个随机密码

以上三项信息在配置 shadowsocks 客户端时需要配置一致，具体说明可查看 shadowsocks 的帮助文档。




## 配置自启动

新建启动脚本文件`/etc/systemd/system/shadowsocks.service`，内容如下：

```
[Unit]
Description=Shadowsocks

[Service]
TimeoutStartSec=0
ExecStart=/usr/bin/ssserver -c /etc/shadowsocks.json

[Install]
WantedBy=multi-user.target

```

执行以下命令启动 shadowsocks 服务：

```
systemctl enable shadowsocks
systemctl start shadowsocks

```

为了检查 shadowsocks 服务是否已成功启动，可以执行以下命令查看服务的状态：

```
systemctl status shadowsocks -l

```

如果服务启动成功，则控制台显示的信息可能类似这样：

```
● shadowsocks.service - Shadowsocks
   Loaded: loaded (/etc/systemd/system/shadowsocks.service; enabled; vendor preset: disabled)
   Active: active (running) since Mon 2015-12-21 23:51:48 CST; 11min ago
 Main PID: 19334 (ssserver)
   CGroup: /system.slice/shadowsocks.service
           └─19334 /usr/bin/python /usr/bin/ssserver -c /etc/shadowsocks.json

Dec 21 23:51:48 morning.work systemd[1]: Started Shadowsocks.
Dec 21 23:51:48 morning.work systemd[1]: Starting Shadowsocks...
Dec 21 23:51:48 morning.work ssserver[19334]: INFO: loading config from /etc/shadowsocks.json
Dec 21 23:51:48 morning.work ssserver[19334]: 2015-12-21 23:51:48 INFO     loading libcrypto from libcrypto.so.10
Dec 21 23:51:48 morning.work ssserver[19334]: 2015-12-21 23:51:48 INFO     starting server at 0.0.0.0:8388

```







## 一键安装脚本

新建文件`install-shadowsocks.sh`，内容如下：

```
#!/bin/bash
# Install Shadowsocks on CentOS 7

echo "Installing Shadowsocks..."

random-string()
{
    cat /dev/urandom | tr -dc 'a-zA-Z0-9' | fold -w ${1:-32} | head -n 1
}

CONFIG_FILE=/etc/shadowsocks.json
SERVICE_FILE=/etc/systemd/system/shadowsocks.service
SS_PASSWORD=$(random-string 32)
SS_PORT=8388
SS_METHOD=aes-256-cfb
SS_IP=`ip route get 1 | awk '{print $NF;exit}'`
GET_PIP_FILE=/tmp/get-pip.py

# install pip
curl "https://bootstrap.pypa.io/get-pip.py" -o "${GET_PIP_FILE}"
python ${GET_PIP_FILE}

# install shadowsocks
pip install --upgrade pip
pip install shadowsocks

# create shadowsocls config
cat <<EOF | sudo tee ${CONFIG_FILE}
{
  "server": "0.0.0.0",
  "server_port": ${SS_PORT},
  "password": "${SS_PASSWORD}",
  "method": "${SS_METHOD}"
}
EOF

# create service
cat <<EOF | sudo tee ${SERVICE_FILE}
[Unit]
Description=Shadowsocks

[Service]
TimeoutStartSec=0
ExecStart=/usr/bin/ssserver -c ${CONFIG_FILE}

[Install]
WantedBy=multi-user.target
EOF

# start service
systemctl enable shadowsocks
systemctl start shadowsocks

# view service status
sleep 5
systemctl status shadowsocks -l

echo "================================"
echo ""
echo "Congratulations! Shadowsocks has been installed on your system."
echo "You shadowsocks connection info:"
echo "--------------------------------"
echo "server:      ${SS_IP}"
echo "server_port: ${SS_PORT}"
echo "password:    ${SS_PASSWORD}"
echo "method:      ${SS_METHOD}"
echo "--------------------------------"

```

执行以下命令一键安装：

```
chmod +x install-shadowsocks.sh
./install-shadowsocks.sh

```

也可以直接执行以下命令从 GitHub 下载安装脚本并执行：

```
bash <(curl -s http://morning.work/examples/2015-12/install-shadowsocks.sh)

```

安装完成后会自动打印出 Shadowsocks 的连接配置信息。比如：

```
Congratulations! Shadowsocks has been installed on your system.
You shadowsocks connection info:
--------------------------------
server:      10.0.2.15
server_port: 8388
password:    RaskAAcW0IQrVcA7n0QLCEphhng7K4Yc
method:      aes-256-cfb
--------------------------------
```
