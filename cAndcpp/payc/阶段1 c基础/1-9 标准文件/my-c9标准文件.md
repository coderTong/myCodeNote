# 磁盘文件

指一组相关数据的有序集合,通常存储在外部介质(如磁盘)上，使用时才调入内存。


# 设备文件

在操作系统中把每一个与主机相连的输入、输出设备看作是一个文件，把它们的输入、输出等同于对磁盘文件的读和写。

# 以字节为单位进行顺序存储
计算机的存储在物理上是二进制的，所以物理上所有的磁盘文件本质上都是一样的：以字节为单位进行顺序存储。



# `FILE` 在stdio.h里面


# fopen

```c

#include <stdio.h>
FILE * fopen(const char * filename, const char * mode);
功能：打开文件
参数：
	filename：需要打开的文件名，根据需要加上路径
	mode：打开文件的模式设置
返回值：
	成功：文件指针
	失败：NULL


```


# `perror()`是标准出错打印函数，能打印调用库函数出错原因


# fclose

```c

#include <stdio.h>
int fclose(FILE * stream);
功能：关闭先前fopen()打开的文件。此动作让缓冲区的数据写入文件中，并释放系统所提供的文件资源。
参数：
	stream：文件指针
返回值：
	成功：0
	失败：-1


```


# 按照字符读写文件fgetc、fputc

# 按照行读写文件fgets、fputs

# 按照格式化文件fprintf、fscanf

# 按照块读写文件fread、fwrite

