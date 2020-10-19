#include <iostream>

using namespace std;


class BaseClass 
{
	public:
		BaseClass():mParam(99),id(33)
		{
		}
		
		void showInfo()
		{
			cout << "mParam:" << mParam << endl;
			cout << "id:"<< id << endl;
		}
		
	public:
		int mParam;
		int id;
};

class Derived : public  BaseClass
{
	public:
		Derived():mParam(10){}
		
		void showInfo()
		{
			BaseClass::showInfo();
			//在派生类中使用和基类的同名成员,显示使用类名限定符
			cout << "Derived say BaseClass::mParam:" << BaseClass::mParam << endl;
			cout << "Derived say mParam:" << mParam << endl;
		}
		
		//返回基类重名成员
		int& getBaseParam()
		{
			return BaseClass::mParam;
		}
		
		public:
		int mParam;
};

int main()
{
	cout << "vvv" << endl;
	
	
	Derived derived;
	
	//派生类和基类成员属性重名，子类访问成员默认是子类成员
	
	cout << derived.mParam << endl;
	derived.showInfo();
	
	//类外如何获得基类重名成员属性
	
	derived.getBaseParam() = 100;
	
	cout << "BaseClass::mParam" << derived.getBaseParam() << endl;
	
	derived.showInfo();
	return 0;
}
