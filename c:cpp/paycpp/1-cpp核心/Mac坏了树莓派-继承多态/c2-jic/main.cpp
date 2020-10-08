#include <iostream>

using namespace std;

class Person
{
	public:
		char name[10];
		int age;
		char sex;
		
	public:
		void showInfo()
		{
			cout << this->name << endl;
			cout << this->age << endl;
		}
};

int main()
{
	
	cout << "hi ~" <<endl;
	
	Person * p = new Person;
	//p->name = "cc";
	p->age = 25;
	
	p->showInfo(); 
	
	/*
	Person p2();
	p2.name = "v";
	p2.age = 33;
	p2.showInfo();
	*/
	return 0;
}
