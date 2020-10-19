
# free 函数在`#include <stdlib.h>`里面哈

# 什么样, 有些啥

```c

struct stu
{
  成员列表;
}Mike, Bob;


```


- 结构体类型: `struct stu`
- 结构体变量: `Mike, Bob`



# `.`和`->`

- **结构体普通变量用.**
- **结构体指针变量用->**

```c

//

// main.c

// 5复合类型

//

// Created by codew on 8/4/20.

// Copyright © 2020 codertom. All rights reserved.

//

#include <stdio.h>

void  test1(void);

void  test2(void);

void  test3(void);

void  test4(void);

void  test5(void);

struct  stu

{

 char name[20];

 int age;

}Bob;

int main(int argc, const char * argv[]) {

  // insert code here...

  printf("Hello, World!\n");

 test2();

 return 0;

}

/**

 结构体普通变量用.

 */

void  test1()

{

 Bob.age = 90;

 strcpy(Bob.name, "abc");

  printf("age %d \n", Bob.age);

  printf("name %s \n", Bob.name);

  memset(Bob.name,99,sizeof(Bob.name));

  printf("name %s \n", Bob.name);

  // 居然没有越界错误.....

  char name2[30] = "abcdefghij abcdefghij abcdefghij";

 memcpy(Bob.name, name2, sizeof(name2));

  printf("name %s \n", Bob.name);

}

/**

 结构体指针变量用->

 */

void  test2()

{

 struct stu yaojun;

 (&yaojun)->age = 27;

 strcpy((&yaojun)->name, "yaojun");

 printf("age %d \n", (&yaojun)->age);

 printf("name %s \n", (&yaojun)->name);

 char name2[20] = "yaojun666";

 memcpy((&yaojun)->name, name2, sizeof(name2));

 printf("name %s \n", (&yaojun)->name);

}

```



# 结构体套结构体


```c


struct  person

{

 char name[20];

 char sex;

};

struct  coder

{

 int id;

 struct person info;

};



/**

 结构体套结构体

 */

void  test4()

{

 struct coder tomwu = {1, "wutong", 'M'};

 printf("id: %d, name: %s, sex: %c \n", tomwu.id, tomwu.info.name, tomwu.info.sex);

 struct coder coderS[3] = {

 1, "wutong", 'M',

 2, "lipeng", 'M',

 3, "shuaige", 'M',

 };

  printf("结构体数组=======\n");

 for (int i = 0; i < 3; i++) {

 printf("id: %d, name: %s, sex: %c \n", coderS[i].id, coderS[i].info.name, coderS[i].info.sex);

 }

}


```



# 结构体相互赋值

- 相同类型的两个结构体变量，可以相互赋值

 - 把s1成员变量的值拷贝给s2成员变量的内存

 - s1和s2只是成员变量的值一样而已，它们还是没有关系的两个变量
```c

/**

 结构体相互赋值

 //相同类型的两个结构体变量，可以相互赋值

 //把s1成员变量的值拷贝给s2成员变量的内存

 //s1和s2只是成员变量的值一样而已，它们还是没有关系的两个变量

 */

void  test5()

{

 struct coder tomwu = {1, "wutong", 'M'};

 struct coder lipeng;

 lipeng = tomwu;

  printf("tomwu: id: %d, name: %s, sex: %c \n", tomwu.id, tomwu.info.name, tomwu.info.sex);

  printf("lipeng: id: %d, name: %s, sex: %c \n", lipeng.id, lipeng.info.name, lipeng.info.sex);

 lipeng.id = 90;

  printf("tomwu: id: %d, name: %s, sex: %c \n", tomwu.id, tomwu.info.name, tomwu.info.sex);

  printf("lipeng: id: %d, name: %s, sex: %c \n", lipeng.id, lipeng.info.name, lipeng.info.sex);

}

```


# 结构体参数--值传递不能修改

```c

void  test9(void)

{

 struct coder iOSer = {99};

  printf("最初: iOSer.name = %d, iOSer.age=%s\n", iOSer.id, iOSer.info.name);

 test9a(iOSer);

  printf("最终: iOSer.name = %d, iOSer.age=%s\n", iOSer.id, iOSer.info.name);

}

/**

 值传递是无法修改返回的

 */

void test9a(struct coder iOSer)

{

 strcpy(iOSer.info.name, "tomwu");

 iOSer.id = 100;

  printf("函数里面: iOSer.name = %d, iOSer.age=%s\n", iOSer.id, iOSer.info.name);

}

```

# 结构体参数--指针

见代码


# 共用体(联合体)

略


# 枚举





