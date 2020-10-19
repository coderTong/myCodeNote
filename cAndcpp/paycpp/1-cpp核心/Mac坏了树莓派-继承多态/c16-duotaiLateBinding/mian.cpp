/*
 
 解决方法就是迟绑定(迟捆绑,动态绑定,运行时绑定，late binding),
  
 */

#include <iostream>

using namespace std;

class Animal
{
	
	public:
		virtual void speak()
		{
			cout << "Animal speak" << endl;
		}
	
};


class Dog : public Animal
{
	public:
		virtual void speak()
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
