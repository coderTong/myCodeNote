#include <iostream>

/**
 * 当使用虚继承时，虚基类是被共享的
 
 */

using namespace std;

class BaseClass
{
	
	public:
		BaseClass()
		{
			mParam = 99;
		}
		
		void func()
		{
			cout << "BaseClass::func()" << endl;
		}
		
		
	public:
		int mParam;
		
};


//虚继承
#if 0


class Sub1 : virtual public BaseClass{};
class Sub2 : virtual public BaseClass{};

#else
//普通继承

class Sub1 :  public BaseClass{};
class Sub2 :  public BaseClass{};


#endif


class Derived : public Sub1, public Sub2{};

int main()
{
	
	cout << "虚继承实现原理" << endl;
	
	return 0;
}
