#include <iostream>

/*
 
 抽象基类和纯虚函数
 
 基类中加入至少一个纯虚函数(pure virtual function),使得基类称为抽象类(abstract class).


 */ 

using namespace std;

// 抽象制作饮品 - 抽象类(abstract class).
class AbstractDrinking
{
	public:
		
		// 烧水 纯虚函数(pure virtual function)
		virtual void boil() = 0;
		//冲泡 纯虚函数(pure virtual function)
		virtual void brew() = 0;
		//倒入杯中 纯虚函数(pure virtual function)
		virtual void pourInCup() = 0;
		//加入辅料 纯虚函数(pure virtual function)
		virtual void putSomething() = 0;
		//规定流程
		void makeDrink()
		{
			boil();
			brew();
			pourInCup();
			putSomething();
		}
};

//制作咖啡

class Coffee : public AbstractDrinking
{
	public:
		
		// 烧水
		virtual void boil()
		{
			cout << "煮农夫山泉!" << endl;
		}
		//冲泡
		virtual void brew()
		{
			cout << "冲泡咖啡!" << endl;
		}
		//倒入杯中
		virtual void pourInCup()
		{
			cout << "将咖啡倒入杯中!" << endl;
		}
		//加入辅料
		virtual void putSomething()
		{
			cout << "加入牛奶!" << endl;
		}
};

//制作茶水
class Tea : public AbstractDrinking
{
	public:
		// 烧水
		virtual void boil()
		{
			cout << "煮自来水!" << endl;
		}
		//冲泡
		virtual void brew()
		{
			cout << "冲泡茶叶!" << endl;
		}
		//倒入杯中
		virtual void pourInCup()
		{
			cout << "将茶水倒入杯中!" << endl;
		}
		
		//加入辅料
		virtual void putSomething()
		{
			cout << "加入食盐!" << endl;
		}
};


void doBussiness(AbstractDrinking* drink)
{
	drink->makeDrink();
	delete drink;
}

void test()
{
	doBussiness(new Coffee);
	
	cout << "------" << endl;
	
	doBussiness(new Tea);
}

int main()
{
	cout << "抽象基类和纯虚函数" << endl;
	
	cout << "------" << endl;
	
	test();
	
	return 0;
}
