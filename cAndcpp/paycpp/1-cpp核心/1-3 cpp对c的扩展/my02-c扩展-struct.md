# c中定义结构体变量需要加上struct关键字，`c++`不需要。


# c中的结构体只能定义成员变量，不能定义成员函数。`c++`即可以定义成员变量，也可以定义成员函数。

# `c++`可以成员变量

# `c++`可以函数

# `c++`成员函数


# 更严格的类型转换

```cpp

/**

 更严格的类型转换

 */

void  test2(void)

{

 color mycolor = YELLOW; // ok

// mycolor = 10; // 错误

 mycolor = (color)0; // ok

 printf("mycolor:%d\n", mycolor);

  //char* p = malloc(10); // 错误

 char* p = (char*)malloc(10); // ok

}

```


# 三目运算加强


