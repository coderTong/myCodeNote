
```c

sudo apt-get install python-pip python-m2cryptosudo 
sudo pip install shadowsocks

```


```c

sudo vim /etc/shadowsocks.json

```

```c

{
    "server":"45.77.107.174",
    "server_port":9806,
    "local_address": "127.0.0.1",
    "local_port":1080,
    "password":"a469ASDas%$@%@afaf@%2t7w",
    "timeout":600,
    "method":"aes-256-cfb",
    "fast_open": false
}

```



# Step3：添加开机启动


```c

sudo vim /etc/rc.local



 sudo vim /usr/local/lib/python2.7/dist-packages/shadowsocks/crypto/openssl.py


```







```c


| 

sudo apt update && sudo apt install -y gettext build-essential autoconf libtool libpcre3-dev asciidoc xmlto libev-dev libc-ares-dev automake libmbedtls-dev libsodium-dev pkg-config
wget https://github.com/shadowsocks/shadowsocks-libev/releases/download/v3.3.2/shadowsocks-libev-3.3.2.tar.gz
tar zxf shadowsocks-libev-3.3.2.tar.gz && rm -f shadowsocks-libev-3.3.2.tar.gz
cd shadowsocks-libev-3.3.2
./configure && make && sudo make install

 |

```


