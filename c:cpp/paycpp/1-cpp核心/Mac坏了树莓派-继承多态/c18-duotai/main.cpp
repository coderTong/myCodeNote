/*
 
 虚析构函数作用
 虚析构函数是为了解决基类的指针指向派生类对象，并用基类的指针删除派生类对象。
  
 */

#include <iostream>

using namespace std;

class People
{
	public:
		People()
		{
			cout << "构造函数 People!" <<endl;
		}
		
		virtual void showName() = 0;
		virtual ~People()
		{
			cout << "析构函数 People!" << endl;
		}
};


class Worker : public People
{
	public:
		Worker()
		{
			cout << "构造函数 Worker!" << endl;
		}
		
		~Worker()
		{
			cout << "析构函数  Worker" << endl;
			
			if ( pName != NULL)
			{
				delete pName;
			}
		}
		
		virtual void showName() 
		{
		}
	
	private:
		char * pName;
		
};


void test()
{
	People* people = new Worker;
	people->~People();
}

int main()
{
	
	cout << "虚析构函数作用: " << endl;
	
	test();
	return 0;
}
