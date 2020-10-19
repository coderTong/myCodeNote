#include <iostream>

using namespace std;

// 网页类
class IndexPage {
    
    
public:
    
    // 网页头部
    void Header()
    {
        cout << "网页头部" << endl;
    }
    
    // 网页左侧菜单
    void leftNavigation()
    {
        cout << "左侧 导航 菜单" << endl;
    }
    
    // 网页主体部分
    void mainBody()
    {
        cout << "首页 网页 主体 内容!" << endl;
    }
    
    // 网页底部
    void footer()
    {
        cout << "网页底部" << endl;
    }
    
private:
    // 网页标题
    string mTitle;
};


#if 1

// 如果不使用继承, 那么定义 新闻页类,  需要重新写一遍 已经 有的代码

class NewsPage {
    
    
public:
    // 网页头部
    void Header()
    {
        cout << "网页头部" << endl;
    }
    
    // 网页左侧菜单
    void leftNavigation()
    {
        cout << "左侧 导航 菜单" << endl;
    }
    
    // 网页主体部分
    void mainBody()
    {
        cout << "新闻网页的主体内容!" << endl;
    }
    
    // 网页底部
    void footer()
    {
        cout << "网页底部" << endl;
    }
    
private:
    // 网页标题
    string mTitle;
};

void test()
{
    NewsPage * newsPage = new NewsPage;
    newsPage->Header();
    newsPage->mainBody();
    newsPage->leftNavigation();
    newsPage->footer();
}

#else
class NewsPage : public IndexPage {
public:
    // 网页主体部分
    void mainBody()
    {
        cout << "新闻网页的主体内容!" << endl;
    }
};
void test()
{
    NewsPage * newsPage = new NewsPage;
    newsPage->Header();
    newsPage->mainBody();
    newsPage->leftNavigation();
    newsPage->footer();
}
#endif

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    
    
    test();
    
    return 0;
}
