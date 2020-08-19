## `::`作用域运算符

## **命名空间只能全局范围内定义**

# **命名空间可嵌套命名空间**

# 命名空间里面不只放变量, 也可以函数

# **无名命名空间，意味着命名空间中的标识符只能在本文件内访问，相当于给这个标识符加上了static，使得其可以作为内部连接**


```c


namespace{

 int a = 10;

 void func(){ cout << "hello namespace" << endl; }

}

void test(){

 cout << "a : " << a << endl;

 func();

}

```


# **命名空间别名**

**namespace 新名字 = 老名字;**



# using声明--使用`using  namespace  std;`



# **using声明碰到函数重载**

**如果命名空间包含一组用相同名字重载的函数，using声明就声明了这个重载函数的所有集合。**
