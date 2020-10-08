#include <iostream>

using namespace std;

class BaseClass
{
	
	public:
		BaseClass()
		{
			mParam = 0;
		}
		
		void func()
		{
			cout << "BaseClass::func()" << endl;
		}
	
	public:
		int mParam;
};

class Child1 : public BaseClass {};
class Child2 : public BaseClass {};


class SubClass : public Child1, public Child2 {};


int main()
{
	
	cout << "hello cpp" << endl;
	
	SubClass subClass;
	
	cout << subClass.Child1::mParam << endl;
	cout << subClass.Child2::mParam << endl;
	
	// error
	//cout << subClass.mParam << endl;
	// error
	//subClass.func();
	
	// error
	//cout << subClass.Child2::func() << endl;
	
	cout << sizeof(SubClass) <<endl;
	
	return 0;
}
