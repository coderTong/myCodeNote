# `c++`里面const不占用内存?(取它地址,或extern会)

# 全局: 反正`c/c++`都不可以修改, `c++`在一定情况会分配地址



# c修改const的值

linux 下面
```

Hello, World!

constA:300

*p:300

```

我的mac笔记本, 仿佛生出两个变量了
```

constA:10

*p:300

```

```c

/**

 c中const局部

 */

void  test1(void)

{

 const int constA = 10;

 int* p = (int*)&constA;

 *p = 300;

 printf("constA:%d\n",constA);

 printf("*p:%d\n", *p);

}

```


# c const 默认外,  **两个文件中都有const int a**错
# `c++` 默认 内 **两个文件中都有const int a** 不报错


# 尽量以const替换#define


# 宏常量没有类型





