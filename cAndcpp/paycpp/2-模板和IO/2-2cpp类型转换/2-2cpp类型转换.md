# 2-2cpp类型转换

# 目录

1. [静态转换(static_cast)](#cpp2data201)
2. [动态转换(dynamic_cast)](#cpp2data202)
3. [常量转换(const_cast)](#cpp2data203)
4. [重新解释转换(reinterpret_cast)。。。。。](#cpp2data204)


### cpp2data201
# 2.1 静态转换(static_cast)

- 用于[类层次结构](http://baike.baidu.com/view/2405425.htm)中基类（父类）和[派生类](http://baike.baidu.com/view/535532.htm)（子类）之间指针或引用的转换。

  - 进行上行转换（把派生类的指针或引用转换成基类表示）是安全的；

  - 进行下行转换（把基类指针或引用转换成派生类表示）时，由于没有动态类型检查，所以是不安全的。
  
- 用于基本数据类型之间的转换，如把int转换成char，把char转换成int。这种转换的安全性也要开发人员来保证。

```cpp

class Animal{};
class Dog : public Animal{};
class Other{};

//基础数据类型转换
void test01(){
	char a = 'a';
	double b = static_cast<double>(a);
}

//继承关系指针互相转换
void test02(){
	//继承关系指针转换
	Animal* animal01 = NULL;
	Dog* dog01 = NULL;
	//子类指针转成父类指针,安全
	Animal* animal02 = static_cast<Animal*>(dog01);
	//父类指针转成子类指针，不安全
	Dog* dog02 = static_cast<Dog*>(animal01);
}

//继承关系引用相互转换
void test03(){

	Animal ani_ref;
	Dog dog_ref;
	//继承关系指针转换
	Animal& animal01 = ani_ref;
	Dog& dog01 = dog_ref;
	//子类指针转成父类指针,安全
	Animal& animal02 = static_cast<Animal&>(dog01);
	//父类指针转成子类指针，不安全
	Dog& dog02 = static_cast<Dog&>(animal01);
}

//无继承关系指针转换
void test04(){
	
	Animal* animal01 = NULL;
	Other* other01 = NULL;

	//转换失败
	//Animal* animal02 = static_cast<Animal*>(other01);
}


```


### cpp2data202
# 2.2 动态转换(dynamic_cast)

- ynamic_cast主要用于类层次间的上行转换和下行转换；

- 在类层次间进行上行转换时，dynamic_cast和static_cast的效果是一样的；

- 在进行下行转换时，`dynamic_cast`具有类型检查的功能，比`static_cast`更安全；


```cpp

class Animal {
public:
	virtual void ShowName() = 0;
};
class Dog : public Animal{
	virtual void ShowName(){
		cout << "I am a dog!" << endl;
	}
};
class Other {
public:
	void PrintSomething(){
		cout << "我是其他类!" << endl;
	}
};

//普通类型转换
void test01(){

	//不支持基础数据类型
	int a = 10;
	//double a = dynamic_cast<double>(a);
}

//继承关系指针
void test02(){

	Animal* animal01 = NULL;
	Dog* dog01 = new Dog;

	//子类指针转换成父类指针 可以
	Animal* animal02 = dynamic_cast<Animal*>(dog01);
	animal02->ShowName();
	//父类指针转换成子类指针 不可以
	//Dog* dog02 = dynamic_cast<Dog*>(animal01);
}

//继承关系引用
void test03(){

	Dog dog_ref;
	Dog& dog01 = dog_ref;

	//子类引用转换成父类引用 可以
	Animal& animal02 = dynamic_cast<Animal&>(dog01);
	animal02.ShowName();
}

//无继承关系指针转换
void test04(){
	
	Animal* animal01 = NULL;
	Other* other = NULL;

	//不可以
	//Animal* animal02 = dynamic_cast<Animal*>(other);
}


```


### cpp2data203
# 2.3 常量转换(const_cast)


该运算符用来修改类型的const属性。。

- 常量指针被转化成非常量指针，并且仍然指向原来的对象；
- 常量引用被转换成非常量引用，并且仍然指向原来的对象；

**注意:**不能直接对非指针和非引用的变量使用const_cast操作符去直接移除它的const.

```cpp

//常量指针转换成非常量指针
void test01(){
	
	const int* p = NULL;
	int* np = const_cast<int*>(p);

	int* pp = NULL;
	const int* npp = const_cast<const int*>(pp);

	const int a = 10;  //不能对非指针或非引用进行转换
	//int b = const_cast<int>(a); }

//常量引用转换成非常量引用
void test02(){

int num = 10;
	int & refNum = num;

	const int& refNum2 = const_cast<const int&>(refNum);
	
}


```


### cpp2data204
# 2.4 重新解释转换(reinterpret_cast)。。。。。


这是最不安全的一种转换机制，最有可能出问题。

主要用于将一种数据类型从一种类型转换为另一种类型。它可以将一个指针转换成一个整数，也可以将一个整数转换成一个指针.

