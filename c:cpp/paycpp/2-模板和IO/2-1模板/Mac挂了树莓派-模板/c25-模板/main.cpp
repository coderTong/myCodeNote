/*
 * 2020-09-13 10:17:26
 * 普通函数与函数模板区别（重点）
 * 
 * 1.普通函数可以进行隐式转换,函数模版不能直接的进行隐式转换
 * */


#include <iostream>

using namespace std;

int myPlus(int a, int b)
{
	
	return a + b;
}


template<class T>
int myPlus2(T a, T b)
{
	
	return a + b;
}

void test()
{
	
	int a = 10;
	int b = 20;
	
	char c = 'a';
	
	//普通函数可以进行隐式转换
	int value = myPlus(a, c);
	cout << value << endl;
	
	//函数模版不能直接的进行隐式转换
	//myPlus2(a, c); // error
	
	
	//如果要进行隐性转换，必须加上参数列表
	myPlus2<int>(b, c);
	
}


int main()
{
	
	cout << "普通函数与函数模板区别（重点）" << endl;
	
	test();
	
	return 0;
}
