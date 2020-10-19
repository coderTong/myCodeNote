
/*
 * 重写 重载 重定义
 * */

#include <iostream>

using namespace std;

class A
{
	public:
		
		//同一作用域下，func1函数重载
		void func1(){}
		void func1(int a){}
		void func1(int a, int b){}
		void func2(){}
		virtual void func3(){}
};

class B : public A
{
	public:
	
	    //重定义基类的func2,隐藏了基类的func2方法
		void func2(){}
		//重写基类的func3函数，也可以覆盖基类func3
		virtual void func3(){}
};

int main()
{
	
	
	return 0;
}
