/*
 * 2020-09-13 10:39:21
 * 
 * 普通函数与函数模板的调用规则（重点）
 * 
 * 
 * */

#include <iostream>

using namespace std;


void myPlus(int a, int b)
{
	cout << "普通函数" << endl;
}

void myPlus(char a, char b)
{
	cout << "char普通函数" << endl;
}

template<class T>
void myPlus(T a, T b)
{
	cout << "函数模版" << endl;
}

// error
/*
template<class T>
int myPlus(T a, T b)
{
	cout << "函数模版 int" << endl;
	
	return 0;
}
* 
*/


//4.函数模版之间也可以进行重载
template<class T>
void myPlus(T a, T b, T c)
{
	cout << "函数模版  T c" << endl;
}

//1.函数模版和普通函数可以重载
void test()
{
	
	int a = 10;
	int b = 20;
	
	//2.如果普通函数和函数模版都可以实现的功能，普通函数优先调用
	myPlus(a, b);
	
	//3.可以使用<>空参数列表强制调用函数模版
	myPlus<int>(a, b);
	
	//5.如果函数模版可以产生更好的匹配，那么优先使用函数模版
	char c1 = 'a';
	char c2 = 'b';
	
	myPlus(c1, c2);
}

int main()
{
	
	cout << "普通函数与函数模板的调用规则" << endl;
	
	test();
	
	return 0;
}
