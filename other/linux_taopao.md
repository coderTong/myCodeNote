# 查看linux支持的字符集

```

locale -a


// 这个是正在使用
locale

```

#
# 安装中文

```

yum groupinstall chinese-support


```



# 查看支持的语言....

```

ls -l /usr/share/locale/


```

# 查看当前字符集

```
echo $LANG

```

# 临时修改字符集 

```

LANG=zh_CN.utf8

```


#  永久生效

```

cat  /etc/sysconfig/i18n    ###   查看字符集配置文件

vim /etc/sysconfig/i18n





```






