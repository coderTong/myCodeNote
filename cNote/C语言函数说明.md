
`memset`是计算机中C/C++语言函数。将s所指向的某一块内存中的前n个 字节的内容全部设置为ch指定的ASCII值， 第一个值为指定的内存地址，块的大小由第三个参数指定，这个函数通常为新申请的内存做初始化工作， 其返回值为指向s的指针。

void *memset(void *s, int ch, size_t n);
函数解释：将s中当前位置后面的n个字节 （typedef unsigned int size_t ）用 ch 替换并返回 s 。
memset：作用是在一段内存块中填充某个给定的值，它是对较大的结构体或数组进行清零操作的一种最快方法[1]  。




# memcpy

 编辑

`memcpy`指的是c和c++使用的内存拷贝函数，memcpy函数的功能是从源src所指的内存地址的起始位置开始拷贝n个字节到目标dest所指的内存地址的起始位置中。

`void *memcpy(void *dest, const void *src, size_t n);`




# calloc

 编辑

calloc是一个ISO C函数

函数名： calloc

函数原型：void *calloc(size_t n, size_t size)；

功 能： 在内存的[动态存储](https://baike.baidu.com/item/%E5%8A%A8%E6%80%81%E5%AD%98%E5%82%A8)区中分配n个长度为size的连续空间，函数返回一个指向分配起始地址的[指针](https://baike.baidu.com/item/%E6%8C%87%E9%92%88)；如果分配不成功，返回NULL。

n: Number of elements成员数量 size: Length in bytes of each element每个成员字节长度
