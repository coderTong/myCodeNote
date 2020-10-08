
/*
 *  隐式转换
 * */
#include <iostream>

using namespace std;

template <class T>
T func(T a, T b)
{
	return a + b;
}


void test03()
{
	int a = 10;
	
	double b = 20.2;
	
	
	//如果使用参数列表指定数据类型，那么实参中可以隐式转换，
	//如果转换成功，就调用，转换不成功就报错
	cout << func<double>(10, 20.2) << endl;
}

int main()
{
	
	test03();
	
	return 0;
}
