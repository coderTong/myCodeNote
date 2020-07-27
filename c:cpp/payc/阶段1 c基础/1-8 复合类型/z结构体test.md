

# 1. 结构体(   复合类型)

结构体: 将多个相同或不同类型的数据存在在一块连续的内存空间中

什么叫结构体: 把一些基本类型数据组合在一起, 形成的一个新的复合数据类型, 这个叫做结构体

# 2. 结构体的定义

```c

#include<stdio.h>

#include<string.h>

#include<stdlib.h>

//定义一个结构体数据类型

//关键字 struct 代表这个是一个结构体类型,

//stu   是这个结构的名字

//整个结构体的类型是   struct  stu

// 结构体类型struct  stu   {}中是结构体的成员,一个有3个成员,每个成员的类型可以是

//任意的类型

//定义结构体类型时,{}后面记得加分号

//注意定义结构struct  stu,它只是一个类型,一个模板,没有空间,不可以给结构体成员赋值

struct  stu

{

        int id ;

        int age;

        char name[128];

} a;//定义类型时,同时定义了个结构体变量struct  stu a;

struct  stu c;

int main()

{

        //struct  stu d = {1,20,"ubunqu"};

        //struct  stu d = { .age=20 };//给部分成员初始化,其他成员内容为0

        struct  stu d;

        //如何给结构体成员赋值(如何操作结构体成员)

        //如果通过结构体变量操作结构体成员,使用点域.操作

        /*d.id = 2;

        d.age = 20;

        strcpy(d.name , "world");

        printf("%d %d %s\n",d.id,d.age,d.name);*/

        //如果通过结构体的地址操作结构体成员,使用->

        (&d)->id = 3;

        (&d)->age = 20;

        strcpy((&d)->name, "world");

        printf("%d %d %s\n", (&d)->id,(&d)->age,(&d)->name);

        system("pause");

        return 0;

}

```
