
/*
 * 纯虚析构函数
 * 纯虚析构函数在c++中是合法的，但是在使用的时候有一个额外的限制：必须为纯虚析构函数提供一个函数体。
 */


#include <iostream>

using namespace std;

//非纯虚析构函数

class A
{
	public:
		virtual ~A();
};

// 纯虚析构函数在c++中是合法的，但是在使用的时候有一个额外的限制：必须为纯虚析构函数提供一个函数体。

A::~A(){}

//纯析构函数

class BClass
{
	public:
		virtual ~BClass();
};

BClass::~BClass(){}


void test()
{
	A a;
	BClass b;
}


int main()
{
	test();
	return 0;
}
