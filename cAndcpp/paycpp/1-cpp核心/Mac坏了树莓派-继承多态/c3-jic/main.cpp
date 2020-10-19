#include <iostream>

using namespace std;

class BaseClass
{
	public:
		int mA;
	protected:
		int mB;
	private:
		int mC;
};

// 1. 公有继承 public
class ChildB : public BaseClass
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
			//cout << mC << endl;
		}
};

class SubB : public ChildB
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
			//cout << mC << endl;
		}
};

// 2. 私有继承 private

class ChildC : private BaseClass
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
            
			//不可访问基类private属性
			//cout << mC << endl;
        
		}
};

class SubC : public ChildC
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
            
			cout << mC << endl;
		}
		
};


// 3. 保护继承(protected)
class ChildD : protected BaseClass
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
            
            // error
			//cout << mC << endl;
		}
};

class SubD : ChildD
{
	public:
		void showInfo()
		{
			cout << mA << endl;
			cout << mB << endl;
            
            // error
			//cout << mC << endl;
		}
};


int main()
{
	cout << "hello cpp" <<endl;
	return 0;
}
