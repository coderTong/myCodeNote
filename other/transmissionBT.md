
# 6
# lscpu

```

sudo apt-get update

sudo apt-get install zsh -y
sudo apt-get install cmake -y

sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)" -y


sudo apt-get install build-essential automake autoconf libtool pkg-config intltool libcurl4-openssl-dev libglib2.0-dev libevent-dev libminiupnpc-dev libgtk-3-dev libappindicator3-dev -y


wget https://github.com/transmission/transmission/archive/2.11.tar.gz



tar xf 2.11.tar.gz
cd transmission-2.11


```

```

yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel wget vim zsh -y 


wget https://github.com/git/git/archive/v2.24.0.tar.gz


tar -zxf v2.24.0.tar.gz


make prefix=/usr/local all && sudo make prefix=/usr/local install

sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"




yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel wget vim zsh gcc -y && wget https://github.com/git/git/archive/v2.24.0.tar.gz && tar -zxf v2.24.0.tar.gz && cd git-2.24.0 && make prefix=/usr/local all && sudo make prefix=/usr/local install && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)"




cd /  && mkdir wt && cd /wt && wget http://mirror.pnl.gov/epel/6/x86_64/epel-release-6-8.noarch.rpm && rpm -Uvh epel-release-6-8.noarch.rpm && yum -y update && yum -y install transmission transmission-daemon && service transmission-daemon start && service transmission-daemon stop

```

wget http://mirror.pnl.gov/epel/6/x86_64/epel-release-6-8.noarch.rpm


 rpm -Uvh epel-release-6-8.noarch.rpm


yum -y update 


yum -y install transmission transmission-daemon


service transmission-daemon start

```
xxx.xxx.xxx.xxx:9091

```

service transmission-daemon stop




```
find / -name settings.json
 vim /var/lib/transmission/.config/transmission/settings.json


rpc-whitelist-enabled”: false,
“rpc-password”: “yourpassword”,
“rpc-username”: “yourusername”,

rpc-whitelist-enabled": false

```


```

vim /etc/init.d/transmission-daemon 这个文件里面，默认调用了参数 -T

如：

TRANSMISSION_HOME=/var/lib/transmission

DAEMON_USER="transmission"

DAEMON_ARGS="-T --blocklist -g $TRANSMISSION_HOME/.config/transmission"

而在

 transmission-daemon -help

有帮助说明的

-t   --auth                             Require authentication

-T   --no-auth                          Don't require authentication

```




