#include <iostream>

using namespace std;

class BaseClass1
{
	public:
		void func1()
		{
			cout << "BaseClass1::func1()" << endl;
		}
};

class BaseClass2
{
	public:
		void func1()
		{
			cout << "BaseClass2::func1()" << endl;
		}
		
		void func2()
		{
			cout << "BaseClass2::func2()" << endl;
		}
};

//派生类继承Base1、Base2

class Derived : public BaseClass1, public BaseClass2
{
};

int main()
{
	
	cout << " hello XY" << endl;
	
	Derived derived;
	
	derived.func2();
	//func1是从Base1继承来的还是从Base2继承来的？
	//derived.func1();
	
	derived.BaseClass1::func1();
	derived.BaseClass2::func1();
	
	return 0;
}
