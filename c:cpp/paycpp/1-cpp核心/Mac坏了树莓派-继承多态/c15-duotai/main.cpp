
/*
 
 4.9.2 向上类型转换及问题
cpp1data004i2a
4.9.2.1 问题抛出
对象可以作为自己的类或者作为它的基类的对象来使用。还能通过基类的地址来操作它。取一个对象的地址(指针或引用)，并将其作为基类的地址来处理，这种称为向上类型转换。

也就是说：父类引用或指针可以指向子类对象，通过父类指针或引用来操作子类对象。
 
 
 早绑定(early binding)
 * 
 */
#include <iostream>

using namespace std;

class Animal
{
	
	public:
		void speak()
		{
			cout << "Animal speak" << endl;
		}
	
};


class Dog : public Animal
{
	public:
		void speak()
		{
			cout << "Dog speak" << endl;
		}
	
};



void doBussiness(Animal& animal)
{
	animal.speak();
}

void test()
{
	Dog dog;
	doBussiness(dog);
}

int main()
{
	test();
	
	return 0;
}
