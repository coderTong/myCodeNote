#include <iostream>

using namespace std;


class BaseClass
{
	public:
		int mA;
		int mB;
};

class SubA : BaseClass
{
	public:
		int mC;
};


class SubB : SubA
{
	public:
		int mD;
};


void test()
{
	
	cout << "BaseClass size:" << sizeof(BaseClass) << endl;
	cout << "A size:" << sizeof(SubA) << endl;
	cout << "B size:" << sizeof(SubB) << endl;
}

int main()
{
	
	cout << "hello model" <<endl;
	
	test();
	
	return 0;
}
