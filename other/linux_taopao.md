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





# 输入重定向 追加到最后面

```c

echo kkk >>rr.txt

```

# 拷贝就是cp


# 强制删除目录以及文件 rm -fr 

# find

```

find /wt -type f -name "ee.exe"

-type f // 文件类型是文件

-name "ee.exe" 文件名字叫xx


// 找到某个文件夹下面的某个文件并且删除他
find /wt/ -type f -name "tt.txt" -exec rm {} \;


// 找到哈删除
find /wt -type f -name "*.txt" |xargs rm -f;

```


# find -mtime
### +7 七天以前
### 7 第七天
### -7 最近7天
```


find / -type f -name "*.log" -mtime 1;
find / -type f -name "*.log" -mtime +1;
find / -type f -name "*.log" -mtime -1;
```



