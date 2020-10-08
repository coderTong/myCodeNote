#include <iostream>

using namespace std;

//计算器

class Caculator
{
	public:
		void setA(int a)
		{
			this->mA = a;
		}
		
		void setB(int b)
		{
			this->mB = b;
		}
		
		void setOperator(string oper)
		{
			this->mOperator = oper;
		}
		
		int getResult()
		{
			if (this->mOperator == "+")
			{
				return mA + mB;
				
			}else if (this->mOperator == "-")
			{
				return mA - mB;
				
			}else if (this->mOperator == "*")
			{
				return mA * mB;
				
			}else if (this->mOperator == "/")
			{
				return mA / mB;
				
			}
		}
	
	private:
		int mA;
		int mB;
		string mOperator;
};

//这种程序不利于扩展，维护困难，如果修改功能或者扩展功能需要在源代码基础上修改

//面向对象程序设计一个基本原则:开闭原则(对修改关闭，对扩展开放)

//抽象基类

class AbstractCaculator
{
	public:
		void setA(int a)
		{
			this->mA = a;
		}
		
		virtual void setB(int b)
		{
			this->mB = b;
		}
		
		virtual int geResult() = 0;
		
	
	protected:
		int mA;
		int mB;
};

//加法计算器
class PlusCaculator : public  AbstractCaculator{
	
	public:
		virtual int geResult()
		{
			return mA + mB;
		}
};


//减法计算器
class  MinusCaculator : public  AbstractCaculator
{
	public:
		virtual int geResult()
		{
			return mA - mB;
		}
};


//乘法计算器
class MultipliesCaculator : public  AbstractCaculator
{
	public:
		virtual int geResult()
		{
			return mA * mB;
		}
		
};


void doBussiness(AbstractCaculator * caculator)
{
	int a = 10;
	int b = 20;
	
	caculator->setA(a);
	caculator->setB(b);
	
	cout << "计算结果：" << caculator->geResult() << endl;
	
	delete caculator;
}


int main()
{
	cout << "hello duo tai" << endl;
	
	// 乘法计算器
	//AbstractCaculator * caculator = new MultipliesCaculator();
	
	// 减法计算器
	//AbstractCaculator * caculator = new MinusCaculator();
	
	// 加法计算器
	AbstractCaculator * caculator = new PlusCaculator();
	
	doBussiness(caculator);
	
	return 0;
}














































