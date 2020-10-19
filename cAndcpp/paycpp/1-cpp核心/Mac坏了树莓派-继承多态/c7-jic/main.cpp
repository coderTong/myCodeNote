#include <iostream>

using namespace std;

class BaseClase
{
	public:
		void func1()
		{
			cout << "BaseClase: func1()" << endl;
		}
		
		void func1(int param)
		{
			cout << "BaseClase: func1(int param)" << endl;
		}
		
		void myFunc()
		{
			cout << "BaseClase: myFunc()" << endl;
		}
};

class Derived1 : public BaseClase {};

class Derived2 : public BaseClase {
	
	public:
	
		void myFunc()
		{
			cout << "Derived2 :myFunc()" << endl;
		}
};

class Derived3 : public BaseClase {
	
	public:
	
		void func1(int param1, int param2)
		{
			cout << "Derived3: func1(int param1, int param2)" << endl;
		}
};

class Derived4 : public BaseClase {
	
	public:
	
		int func1(int param1, int param2)
		{
			BaseClase::func1(10);
			cout << "Derived4: func1" << endl;
			
			return 0;
		}
};

void test()
{
	Derived1 derived1;
	
	derived1.func1();
	derived1.func1(2);
	
	Derived2 derived2;
	derived2.myFunc();
	
	Derived3 derived3;
	derived3.myFunc();
	derived3.func1(2,6);
	
	Derived4 derived4;
	derived4.func1(2,6);
}

int main()
{
	
	cout << "hello cpp" << endl;
	test();
	return 0;
}
