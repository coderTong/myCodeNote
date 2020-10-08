/*
 * 
 * 2020-09-13 11:24:13
 * 
 * 类模版（重点）
 * */
 
#include <iostream>

using namespace std;

template<class NameType, class AgeType>
class Maker
{
	public:
		Maker(NameType name, AgeType age)
		{
			this->name = name;
			this->age = age;
		}
		
		void showInfo()
		{
			cout << "name: " << this->name << "  age: " << this->age << endl;
		}
		
	public:
		NameType name;
		AgeType age;
};

// 2.类模版的使用
void test()
{
	//1.类模版不会自动推导数据类型，要显示的告诉编译器是什么类型
	Maker<string, int> maker("tom", 18);
	maker.showInfo();
	
	
	//2.注意传入的参数,传入参数类型要程序员自己把握
	Maker<int, int> maker2(33, 18);
	maker2.showInfo();
	
	
	//Maker<> m3("aaa", 18); // err,必须通过参数列表告诉编译器是什么类型
		
}


int main()
{
	
	cout << "类模版（重点）" << endl;
	test();
		
	return 0;
}
