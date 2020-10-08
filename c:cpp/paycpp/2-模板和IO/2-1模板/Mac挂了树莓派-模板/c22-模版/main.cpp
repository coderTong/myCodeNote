
/*
 * 怎么使用函数模版
 * */

#include <iostream>

using namespace std;

template <class T>
void mySwap(T &a, T &b)
{
	T tmp = a;
	a = b;
	b = tmp;
}

template <typename T>
void func2(T a, T b)
{
}




int main()
{
	
	int a = 10;
	int b = 20;
	
	mySwap(a, b);
	
	cout << "a=" << a << endl;
	cout << "b=" << b << endl;
	
	char ck = 'c';
	
	
	mySwap<int>(a,b);
	
	mySwap<>(a,b);
	
	return 0;
}
