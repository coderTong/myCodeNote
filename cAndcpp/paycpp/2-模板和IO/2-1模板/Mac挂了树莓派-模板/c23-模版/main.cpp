
/*
 * 编译器会对函数模版和类模版进行二次编译
 * 
 * */
#include <iostream>

using namespace std;


//T代表泛型的数据类型，不是只能写T，
template <class T>//让编译器看到这句话后面紧跟着的函数里有T不要报错
void mySwap(T &a, T &b)//第一次编译
{
	T tmp = a;
	a = b;
	b = tmp;
}



int main()
{
	//使用函数模版
	int a = 10;
	int b = 20;
	
	//1.编译器会根据实参来自动推导数据类型
	mySwap(a, b);//编译器在函数模版被调用时，进行第二次编译
	
	cout << "a=" << a << endl;
	cout << "b=" << b << endl;
	
	
	return 0;
}
