/*
 * 
 * 2020-09-13 11:04:24
 * 
 * 模版的局限性及解决方法（了解）
 * */


#include <iostream>

using namespace std;

/*
template<class T>
void func(T a, T b)
{
	if (a > b)
	{
		cout << "a>b" << endl;
	}
	else
	{
		cout << "a<=b" << endl;
	}
}
void test()
{
//如果传入的是数组名，那么函数模版中比较函数名的大小就没有意义
	int arr[20];
	int arr2[100];

	func(arr, arr2);
}

*/


// 2.解决方法，使用函数模版具体化
// 不建议具体化函数模版，因为没有通用性

class Maker
{
	
	public:
		Maker(string name, int age)
		{
			this->age = age;
			this->name = name;
		}
	
	public:
		string name;
		int age;
};

template<class T>
void myfunc(T &a, T &b)
{
	if (a > b)
	{
		cout << "a>b" << endl;
	}
	else
	{
		cout << "a<=b" << endl;
	}
}


//不建议具体化函数模版，因为没有通用性
//具体化函数模版，注意上面的函数模版要有，才能具体化
template<>void myfunc<Maker>(Maker &a, Maker &b)
{
	
	cout << "函数模版的具体化" << endl;
	if (a.age > b.age)
	{
		cout << "a>b" << endl;
	}
	else
	{
		cout << "a<=b" << endl;
	}
}

void test02()
{
	Maker m1("aaa", 10);
	Maker m2("bbb", 90);
	
	
	
	myfunc(m1, m2);
}

int main()
{
	
	test02();
	return 0;
}
