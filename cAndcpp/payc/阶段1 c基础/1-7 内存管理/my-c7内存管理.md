- `extern int a;`声明一个变量，这个全局变量在别的文件中已经定义了，这里只是声明，而不是定义。


- C代码经过`预处理`、`编译`、`汇编`、`链接`4步后生成一个可执行程序。
- 通过上图可以得知，在没有运行程序前，也就是说`程序没有加载到内存前`，可执行程序内部已经分好3段信息，分别为`代码区（text）`、`数据区（data）`和`未初始化数据区（bss）`3 个部分（有些人直接把data和bss合起来叫做静态区或全局区）。

-  **代码区（text segment）**
-  **未初始化数据区（BSS）**  
- **全局初始化数据区/静态数据区（data segment）**  
- **栈区（stack）**  
- **堆区（heap）**


### memset
**你给具体的内容**
```c

#include <string.h>
void *memset(void *s, int c, size_t n);
功能：将s的内存区域的前n个字节以参数c填入
参数：
	s：需要操作内存s的首地址
	c：填充的字符，c虽然参数为int，但必须是unsigned char , 范围为0~255
	n：指定需要设置的大小
返回值：s的首地址


```

```c

	int a[10];

	memset(a, 0, sizeof(a));
	memset(a, 97, sizeof(a));
	int i = 0;
	for (i = 0; i < 10; i++)
	{
		printf("%c\n", a[i]);
	}




void  fun1()

{

 int a[10];

 memset(a, 88, sizeof(int)*6);

// memset(a, 97, sizeof(a));

 int i = 0;

 for (i = 0; i < 10; i++)

 {

 printf("%c\n", a[i]);

 }

// printf("a = %d\n", a);

}

```

### memcpy 

**把第二的东西复制到第一个, 具体复制多少, 是第三参数 , 第三个参数说的是复制第二的前多少个字节**

**从哪里个那里拿, 拿多少**

```c

#include <string.h>

void *memcpy(void *dest, const void *src, size_t n);

功能：拷贝src所指的内存内容的前n个字节到dest所值的内存地址上。

参数：

  dest：目的内存首地址

  src：源内存首地址，注意：dest和src所指的内存空间不可重叠，可能会导致程序报错

  n：需要拷贝的字节数

返回值：dest的首地址

```

```c

int a[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

int b[10];

memcpy(b, a, sizeof(a));

int i = 0;

for (i = 0; i < 10; i++)

{

 printf("%d, ", b[i]);

}

printf("\n");

//memcpy(&a[3], a, 5 * sizeof(int)); //err, 内存重叠

```



### memmove()

`memmove()`功能用法和`memcpy()`一样，区别在于：`dest`和`src`所指的内存空间重叠时，`memmove()`仍然能处理，不过执行效率比`memcpy()`低些。



### memcmp

比较两个内存区域前n个字节, 一个字节字节的比较, 最后返回值有相等,大于,小于.....

```c

#include <string.h>

int memcmp(const void *s1, const void *s2, size_t n);

功能：比较s1和s2所指向内存区域的前n个字节

参数：

  s1：内存首地址1

  s2：内存首地址2

  n：需比较的前n个字节

返回值：

 相等：=0

 大于：>0

 小于：<0

```

```c

int a[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

int b[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

int flag = memcmp(a, b, sizeof(a));

printf("flag = %d\n", flag);

```



### malloc

```c

#include <stdlib.h>

void *malloc(size_t size);

功能：在内存的动态存储区(堆区)中分配一块长度为size字节的连续区域，用来存放类型说明符指定的类型。分配的内存空间内容不确定，一般使用memset初始化。

参数：

  size：需要分配内存大小(单位：字节)

返回值：

成功：分配空间的起始地址

失败：NULL

```


```c

#include <stdlib.h>

#include <stdio.h>

#include <string.h>

int  main()

{

 int count, *array, n;

 printf("请输入要申请数组的个数:\n");

 scanf("%d", &n);

 array = (int *)malloc(n * sizeof (int));

 if (array == NULL)

 {

 printf("申请空间失败!\n");

 return -1;

 }

  //将申请到空间清0

 memset(array, 0, sizeof(int)*n);

 for (count = 0; count < n; count++) /*给数组赋值*/

 array[count] = count;

 for (count = 0; count < n; count++) /*打印数组元素*/

 printf("%2d", array[count]);

 free(array);

 return 0;

}

```

### free


```c

#include <stdlib.h>

void free(void *ptr);

功能：释放ptr所指向的一块内存空间，ptr是一个任意类型的指针变量，指向被释放区域的首地址。对同一内存空间多次释放会出错。

参数：

ptr：需要释放空间的首地址，被释放区应是由malloc函数所分配的区域。

返回值：无

```









