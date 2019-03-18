# lscpu

```




```

```
sudo yum install zsh git -y && sh -c "$(wget https://raw.github.com/robbyrussell/oh-my-zsh/master/tools/install.sh -O -)" && cd /  && mkdir wt && cd wt && 

wget http://mirror.pnl.gov/epel/6/x86_64/epel-release-6-8.noarch.rpm && rpm -Uvh epel-release-6-8.noarch.rpm && yum -y update && yum -y install transmission transmission-daemon && service transmission-daemon start && service transmission-daemon stop

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




