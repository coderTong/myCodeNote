/*
 * 2020-09-13 16:53:30
 * 
 * 推导
 * 
 * 3.类模版和函数模版的区别
 * 类模版不会自动推导数据类型，要显示的告诉编译器是什么类型
 * 函数模版可以根据实参来推导数据类型
 * 
 * 4.类模版的默认参数(了解)
 * */



#include <iostream>

using namespace std;

//类模版的默认类型
template<class NameType, class AgeType=int>
class Maker2
{
public:
	Maker2(NameType name, AgeType age)
	{
		this->name = name;
		this->age = age;
	}

	void printMaker()
	{
		cout << "Name:" << this->name << " Age:" << this->age << endl;
	}
public:
	NameType name;
	AgeType age;
};

void test02()
{
	//如果有默认类型，那么<>里可以少写类型
	Maker2<string> m("贝吉塔", 20);

	m.printMaker();
	//以传入的类型为准
	Maker2<string, double> m2("wukong", 20.22);
	m2.printMaker();
}

int main()
{
	test02();
	
	return 0;
}
