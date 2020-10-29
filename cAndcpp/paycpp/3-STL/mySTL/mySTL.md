# 1. STL六大组件

六大组件: `容器`、`算法`、`迭代器`、`仿函数`、`适配器`、`空间配置器`。


- **容器** 箱子用来装东西的 实际上是`class template` :  `vector`、`list`、`deque`、`set`、`map`

- **算法(Algorithms)**  实际上是`function tempalte`:  `sort`、`find`、`copy`、`for_each`

- **迭代器** : 关键字`重载`, `class template`, 遍历某个容器怎么遍历?
  -  `operator*`,  `operator->`, `operator++`, `operator--`等
- **仿函数**:  算法的某种策略, 仿函数重载了`operator()`的`class`或者`class template`
- **适配器**: **`修饰`** 某种`点缀`,  修饰什么? 修饰`容器`,`仿函数`,`迭代器`的东西
- **空间适配器**: 负责空间的配置与管理. `class template`, 内存管理相关的东东.


# 2. 容器

总的分类的话呢, 可以分为两类**序列式容器**和**关联式容器**

大概有这些:
- **数组(array):**
- **链表(list):**
- **栈(stack):**
- **队列(queue):**
- **集合(set):**
- **映射表(map):**

具体的`c++`API如下

- **序列式容器:** `vector`, `deque`, `list`, `stack`, `queue`
- **关联式容器:**  `set/multiset`, `map/multimap`


# 3. 关键字意思

- `assign` 
    - v: `assign(n, elem);`//将`n`个`elem`拷贝赋值给本身
    - s: 完全替换
    - d: 完全替换
    - L: 
- `append` s: 追加
- `replace` s: 替换, 替换部分, 
  - v:  替换
- `compare` s: 比较相等没
- `substr` s: 切割
- `insert` s: 插入
  - d: 2/3个参数,第一个都是迭代器
  - L: 3个参数
  - map: 
- `erase` s, v: 删除
  - d: 两个参数
  - set: 一个参数 数字/迭代器, 删除位置
  
- `c_str` s: `c++`的`string`转`c`字符串 
- `iterator, begin, end` s: 迭代器
  - d: 遍历的时候不行
  - set: 可以用这个遍历
  - map:
- `reverse_iterator, rbegin, rend` s, v: 反向迭代器

--
- `vector`: 可变数组
- `const_iterator` v,d: `vector`的正向迭代器
  - L: 
- `swap` v: 交换两个`vector`容器里面的元素
  - d: 交换
  - L: 
- `size` 
  - s:
  - v: 现在有几个
  - d: 有几个
  - stack: 
  - map: 
- `resize` 
  - v:  开辟空间, 并初始化 
  - d: 可以1个也可以2个参数
- `reserve` v: 开辟空间, 但不初始化
- `capacity` v: 可以装几个
- `front` v: 第一个 
  - L: 
- `back` v : 最后一个
  - L:
- `push_back` 
  - v: 装东西
  - d: 装东西,装到屁股后面
  - L: 
- `pop_back` v: 丢出去
  - d: 屁股后面扯出一个
- `clear` v:  清空
  - d:
- `empty`
  - v: 判断容器是否为空
  - d:~
  - L: 1空, 0非空

- `push_front` d: 加到第一个
  - L
- `pop_front` d: 头部扯出去一个
- `push` stack: 
- `top` stack: 栈顶元素
- `pop` stack: 踢出栈顶
- `remove` L : 删除
- `remove_if` L : 传入一个回调函数, 函数里面规定删除规则
- `reverse` L:  没有参数, 颠倒
- `for_each`multiset: 
- `upper_bound` **set**: 查找大于xx的最小的数, 得到一个迭代器, *迭代器就是值
- `equal_range` **set**: 返回容器中key与keyElem相等的上下限的两个迭代器。
  - map: 
- `count` **set**  : **s1.count(4)**, 有几个4? 答xx个
- `find` **map**:
- `first` map: key
- `second` map : value
- `lower_bound` map:  查找大于等于xxxx的最小数
- `binary_function`
- `merge` 不属于容器时算法: 合并5参简单柔和,6参会排序
- `random_shuffle`不属于容器时算法: 打乱容器的顺序
- `copy` : 拷贝到另一个
- `accumulate`: 累计总和, 求和? 
- `fill`: 装东西.替换成第四个参数
- `set_intersection`: 求两个容器中相等的, 但是他是只是相等的, 不相等不要
- `set_union`: 求两个容器中相等的, 相等和不相等最后合并成一份



# 4. 迭代器iterator

# 5. string

仿佛第一个参数都是位置参数....

- `s2.assign(s1)`: 将s1的内容替换s2的内容
- `s.size()`: 拿到字符串 的长度

- `[i]`和`at(i)`:  `[]`访问元素时，越界不抛异常，直接挂，`at`越界，会抛异常

- `+=`, `append`, 两个都是追加, 前者可以追加**字符**和**字符串**, 后者是从给的字符中去扣, 不够就取给的全部

- `find`:  反正就是找出现第一个的位置, 有多个的话不管,反正就是第一个位置
- `replace(2, 4, "AAA")`:  从第二个位置开始数数四个, 将这四个字符替换为后面的东西
- `s1.compare(s2)`:  `s1`等于`s2`没? 表达式等于**0**的话, 就是相等
- `substr(0, pos), substr(pos+1)`, 给两个参数的意思从第一参数开始切,切到第二个位置为止不包括第二参数位置.   ----如果只给一个参数呢就是说从参数位置开始切到最后为止.

- `insert`: 可以两个参数, 可以三个参数, 反正第一个参数都是位置参数, 三参二为个数, 2参2为内容
- `erase(2, 3)`从3个位置开始删除3个, 包括第三, 反正计算机都是从0开始数数的嘛
- `c_str` s: `c++`的`string`转`c`字符串 `const char *str2 = s.c_str();`
- `char &a = s[2];`这个也可以替换, 替换的是字符
- `s.begin()`和`s.end()`是迭代器不是数字, 不能打印



# 6. vector (重点常用)

旧空间不足而重新配置一块更大空间，然后复制元素，再释放旧空间

单向开口
`vector`可以理解为可变数组, 相当于`OC`的`NSMutableArray`



- `v2.push_back(1)`: 相当于`[arrM addObject:@"1"];`
- `v.swap(v2)`: 交换双方元素
- `v2.resize(10)`:  如果超过10,超过部分被抹去, 抹去了但是 `capacity`值不会去掉
- `v2.capacity()`: 可以装几个
- `v.resize(10); vector<int>(v).swap(v);` : swap 的使用, 缩小容量
- `v.pop_back()`: 最后一个往外甩
- `v.erase( )`: 
    - 一个参数: 参数要是迭代器哈, `v.end()`这个不行, 会崩溃, `v.begin()`这okok
    - 两个参数: 也是要迭代器, 但是迭代器可以+-运算我靠

- `v.clear();`: 清空, 但是空间不释放, `v.capacity()`这个不变
- `empty();`//判断容器是否为空


# 7. deque

虽然deque容器也提供了Random Access Iterator,但是它的迭代器并不是普通的指针，其复杂度和vector不是一个量级，这当然影响各个运算的层面。因此，除非有必要，我们应该尽可能的使用vector，而不是deque。对deque进行的排序操作，为了最高效率，可将deque先完整的复制到一个vector中，对vector容器进行排序，再复制回deque.

- 逻辑上是连续的空间, 实际上是由很多块定量的块空间, 通过中控器连接起来
- 迭代器: 随机迭代器


- `deque<int> d2(10, 6)`10个6
- `int arr[] = {1, 3, 8, 9, 2}; deque<int> d1(arr, arr + sizeof(arr) / sizeof(int) );`也可以用数组
- `d2.assign(d1.begin(), d1.end());`完全替换
- `d.resize(10, 7);` 原来没得值就是10个7, 原来大于现在是原来, 原来小于就是大于部分7
- `d.push_back(10)`  屁股
- `d.push_front(20);`: 头
- `insert`
  - `d.insert(d.begin() + 1, 100);`第二位置插入一个100
  - `d.insert(d.begin() + 2, 2, 0);` 第三个位置开始 插入两个0
  - `d2.insert(d2.begin() + 1, d.begin(), d.end() );` 从第二个位置开始讲d的所有东西插进去

- `deque<int>::iterator it = d.erase(d.begin() + 1, d.end() - 1);`有个返回值, 删除第二个开始, 一直删除到倒数第二个开始



# 8. stack（了解）

- `s.push(10);`

1.数据结构：连续的存储空间，只有一个出口，先进后出特性

2.迭代器:没有迭代器

3.常用的api:

​	1.构造函数

​	2.赋值

​	3.数据存取

​	3.大小操作

# 9. list 链表 (常用重点)

- 非连续线性
- `List`容器是一个双向链表。
- `list`容器提供的是`Bidirectional Iterators.`
- **List有一个重要的性质，插入操作和删除操作都不会造成原有list迭代器的失效**这在vector是不成立的
- `list`容器不仅是一个双向链表，而且还是一个循环的`双向链表`。


- `list<int> myList1(10, 6);`: 10个6
- `list<int> myList2( ++myList1.begin(), --myList1.end() );`
- `push_back(10)`
- `myList.insert(myList.begin(), v.begin(), v.end());`后面两个是`vector`迭代器
- `myList.remove(300);` 删除某个元素
- `myList.remove_if(myFunc);` 按个规则删除
- `myList2.empty()` 空的话是1, 非空的话就是0
- `myList.assign(10, 88);` // 搞10个 88
- `myList02.swap(myList);`
- `reverse()`;//反转链表，比如lst包含1,3,5元素，运行此方法后，lst就包含5,3,1元素
- `sort`
  - 无参
  - 函数回调参数
  - 两个参数升序


1.数据结构：双向循环链表

2.迭代器：双向迭代器

3.常用的api:

​	1.构造

​	2.数据元素的插入和删除

​	3.大小操作

​	4.赋值操作

​	5.数据的存取

​	6.反转和排序

4.注意：list容器不能使用常用的sort,只能使用自己的sort


# 10. queue没有迭代器（了解）

- Queue所有元素的进出都必须符合”先进先出”的条件，只有queue的顶端元素，才有机会被外界取用。
- Queue不提供遍历功能，也不提供迭代器。

1.数据结构：连续的存储空间，有两个口，一个是进入数据，一个是出数据，有先进先出的特性

2.迭代器：没有迭代器

3.常用的api:

​	1.构造函数

​	2.存取、插入和删除操作

​	3.赋值

​	4.大小操作



# 11. pair 略


# 12. set/multiset 容器(重点难点)

- Set不允许两个元素有相同的键值。
- 我们可以通过set的迭代器改变set元素的值吗？**不行**
- set的iterator是一种const_iterator.



- `multiset`特性及用法和`set`完全相同，唯一的差别在于它`允许键值重复`。
- `set`和`multiset`的底层实现是`红黑树`，红黑树为平衡二叉树的一种
- `multiset` 自身规则进行排序, 从大到小
- `multiset` 不能通过算法, 排序来 排序关联式 容器的元素
- `erase`
  - 数字参数: `s.erase(2)`
  - 迭代器参数: `s.erase(s.begin())`

- `multiset<int>s; for_each(s.begin(), s.end(), print);`
- **set**的迭代器`s.upper_bound(2)`查找大于2的最小的数
- `pair<set<int>::iterator, set<int>::iterator> ret = s.equal_range(5);` 返回大于等于5的值, 返回两个如果有相等的就有一个相等的. 如果没有就是两个相等的. 如果其中一个是1的话, 如果比较的就是1那么是正常的, 如果不是1那就是没有大于比较的值.
- `s1.count(4)` 有几个4? 答2个


# 13. map/multimap（重点难点）

- `Map`的特性是，所有元素都会根据元素的键值自动排序
- `Map`所有的元素都是`pair`,同时拥有实值和键值
- `pair`的第一元素被视为键值，第二元素被视为实值，`map`不允许两个元素有相同的键值。
- 我们可以通过`map`的迭代器改变`map`的键值吗？答案是**不行**
- `map`**不允许**两个元素有**相同的键值**。
- 如果想要修改元素的实值，那么是可以的。
- `Multimap`和`map`的操作类似，唯一区别`multimap`**键值可重复**。
- `Map`和`multimap`都是以**红黑树**为底层实现机制。




- `mymap.insert( pair<int, string>(3, "aaa") );`
- `mymap.insert( make_pair(6, "bbb") );`
- `mymap.insert( map<int, string>::value_type(2, "ccc") );`
- `mymap[4] = "ddd";`

- `mymap[100]`:// 虽然没得100, 但是这样一搞以后, 就会多一个值
- `map<int, string>::iterator it = myMap.find(3);`
- `myMap.lower_bound(5);` 查找大于等于5的最小数
- `pair<map<int, string>::iterator , map<int, string>::iterator > ret = myMap.equal_range(2);`返回 大于 等于 2的两个最小的数, 如果有2那么就 返回2和大于 2的最小数



# 14. STL容器元素深/浅拷贝问题

STL容器所提供的都是值(value)寓意，而非引用(reference)寓意，也就是说当我们给容器中插入元素的时候，容器内部实施了拷贝动作，将我们要插入的元素再另行拷贝一份放入到容器中，而不是将原数据元素直接放进容器中，也就是说我们提供的元素必须能够被拷贝

我的话:**我们给容器元素, 容器会拷贝一份.它不是它了, 是新它**
**我们要实现拷贝构造函数**

1.把对象放入容器，其实是拷贝一份对象到容器。

2.注意：

​	1.拷贝构造要能被调用
​	2.注意要浅拷贝问题

# 15. 函数对象（重点）

重载函数调用操作符的类，其对象常称为函数对象（function object），即它们是行为类似函数的对象，也叫仿函数(functor),其实就是重载“()”操作符，**使得类对象可以像函数那样调用**。

- 1. 什么是函数对象哦~?
  - 1. 类中重载了`()`, 这个类实例化的对象叫函数对象(仿函数)
  - 2. 一元仿函数(`unary functor`)是`operator()`中只需要一个参数, 二元仿函数(`binary functor`)是`operator()`中需要两个参数


- 2. 有什么用
  - 1. 做为算法的策略


- 函数对象超出了普通函数的概念，可以保存函数的调用状态


# 16. 谓词

`谓词`是指`普通函数`或重载的`operator()`**返回值**是`bool`类型的**函数对象**(仿函数)。如果`operator`接受**一个参数**，那么叫做`一元谓词`,如果接受**两个参数**，那么叫做`二元谓词`，谓词可作为一个判断式。


# 17. 内联函数对象 需要引入头文件 #include<functional>。

STL内建了一些函数对象。

分为:
1. 算数类函数对象
2. 关系运算类函数对象
3. 逻辑运算类仿函数

--
1. 算数类函数对象
```cpp

template<classT>T plus<T>//加法仿函数
template<class T> T minus<T>//减法仿函数
template<class T> T multiplies<T>//乘法仿函数
template<class T> T divides<T>//除法仿函数
template<class T> T modulus<T>//取模仿函数
template<class T> T negate<T>//取反仿函数

```


2. 关系运算类函数对象

```cpp

template<class T>bool equal_to<T>//等于
template<class T>bool not_equal_to<T>//不等于
template<class T>bool greater<T>//大于
template<class T>bool greater_equal<T>//大于等于
template<class T>bool less<T>//小于
template<class T>bool less_equal<T>//小于等于

```


3. 逻辑运算类仿函数


```cpp

template<class T>bool logical_and<T>//逻辑与
template<class T>bool logical_or<T>//逻辑或
template<class T>bool logical_not<T>//逻辑非

```


# 18. 函数对象适配器


- `binary_function` //二元函数对象 所以需要继承 binary_fucntion<参数类型,参数类型,返回值类型>
- `unary_function`: `unary_function<int, bool>`

//总结：  bind1st和bind2nd区别?
- `bind1st` ： 将参数绑定为函数对象的第一个参数
- `bind2nd` ： 将参数绑定为函数对象的第二个参数
- `bind1st` ,`bind2nd`将二元函数对象转为一元函数对象

- not1 对一元函数对象取反  
- not2 对二元函数对象取反

- `ptr_fun`将普通函数变为函数对象
- `mem_fun_ref`: 如果容器存储的是对象, 用其适配他的成员函数,然后拿去遍历操作
- `mem_fun`:  当容器存储的是对象指针, 用其适配他的成员函数,然后拿去遍历操作


`binary_function`, `unary_function`, 这两个是用来继承的,  第一个是正向的的条件, 第二个是取反的. 继承后要重载`()`,  内联函数是给`for_each`和`find_if`的第三个参数用的.



谁要使用
- **for_each**: 
  - `find_if(v.begin(), v.end(), not1( MyNotFunc() ) )`
  - `for_each(v2.begin(), v2.end(), myPrint)`
  - `for_each(v.begin(), v.end(), bind2nd(Myfunc(), 100))`
  - `for_each(v.begin(), v.end(), bind2nd( ptr_fun( myPrint2 ), 100 ) );`
  - 
- **sort**
  - `sort( v2.begin(), v2.end(), not2( less<int>() ) )`
- **find_if**
  - `find_if(v.begin(), v.end(), not1( MyNotFunc() ) )`
  - 
# 19.

# 20. 遍历算法


```cpp

transform算法 将指定容器区间元素搬运到另一容器中

注意 : transform 不会给目标容器分配内存，所以需要我们提前分配好内存

@param beg1 源容器开始迭代器

@param end1 源容器结束迭代器

@param beg2 目标容器开始迭代器

@param _cakkback 回调函数或者函数对象

@return 返回目标容器迭代器

transform(iterator beg1, iterator end1, iterator beg2, _callbakc)


```



- `transform`: 搬运, 把一个容器搬运到另一个, 可以有3个参数, 可以有4个参数, 搬运的时候呢可以三个容器相互搞搞, 可以两个容器互相搞搞, 怎么搞单纯`copy`一下?  可以给个方法方法里面有个规则.加点减点?

# 21. 查找算法


## 基础数据
- `find` : 3个参数, 容器的开始, 结束迭代器 最后一个是要查找的东东
- `find_if`: 3个参数, 容器的开始, 结束迭代器.  最后一个是查找规则

## 查找对象

- `find`: 基本和上面一样, 最后一个参数现在放对象了哈
- `find_if`:  现在对象是哈, 现在是TM的3个参数一样一样的, 第三个是函数对象适配器


查找的时候呢, 查找到是和原容器的`v.end()`迭代器比较卧槽.


新东西出现了

- `adjacent_find` : 看看某个容器里面的有没有一样的元素, 如果有很多一样的, 只会返回前面第一个, 返回的是迭代器哈,
  - 两个参数, 迭代器开始结束
  - 三个参数最后一个参数,是一个函数地址, 函数里面有规则, 规则里面是查找元素相等的规则, 是对象哈, 看看两个对象什么属性一样就可以认为相等的规则




- `binary_search`:  这玩意也是查找哈, 好像叫二分法查找
  - 3个参数, 例子是基础数据, 开始/最后 第三个就是 查找的数据
  - 4个参数, 开始/最后 3是查找对象,   第四个参数是这个类搞一哈


- `count` :  
  - 还是3个参数, 哈, 开始结束迭代器,,,最后一个是值,  说有几个xxx值, 是基本数据哈, 答有几个查找值
  - 也还是3个参数,  第三参数是一个匿名函数好比`OC`的`block` 里面定义了查找规则, 例子是说大于二的元素, 总之还是基础数据



# 22. 排序算法


- `merge`: 合并,啥也不说了,   
  - 5参数, 简单柔和
  - `merge( v1.begin(), v1.end(), v2.begin(), v2.end(), v3.begin(), greater<int>());` 前四要融合的两个家伙, 第五最后放到哪里, 第六是排了个序, 降序

- `sort(v.begin(), v.end())`
  - 两个参数, 是升序哈, 升序就是从小到大哈2.3.4.5.6这种

- `srand( (unsigned  int)time(NULL) ); random_shuffle(v1.begin(), v1.end());` 这个是打乱顺序哈.


- `reverse(v1.begin(), v1.end());`: 倒过来


# 23. 拷贝和替换算法

- `copy(v.begin(), v.end(), v2.begin())` 一个拷贝到另一个
- `replace(v.begin(), v.end(), 20, 200)` 将第三个元素,替换成第四个. 把20替换成200
- `replace_if(v.begin(), v.end(), myFunc, 300)` 第三个是函数地址,里面是规则, 符合规则的都替换成第四个参数
- `swap(v1, v2)`替换二者容器


# 24. 算术生成算法

- `int ret = accumulate(v.begin(), v.end(), 10)`, 先把容器里面算个总和, 然后再加第四个参数, 返回
- `int ret = accumulate(v.begin(), v.end(), 10, MyPuls() );` 上面是基础数据, 这个是对象, 第三参数是最后加一个 的值,  第四个是一个函数, 里面是规则, 说是对象的是属性做求和的姿势..
- `fill(v.begin(), v.end(), 100);` : 装东西, 将容器的所有元素全部变成100

# 25. 集合算法

- `set_intersection(v1.begin(), v1.end(), v2.begin(), v2.end(), v3.begin());`: 求`v1`和`v2`两个中相等的..
- `v3.resize(v1.size(), v2.size() );` : 这两中哪个`size`大, 3获得哪个的`size`
- `set_union(v1.begin(), v1.end(), v2.begin(), v2.end(), v3.begin())`: 求两个容器中相等的, 相等和不相等最后合并成一份

- `set_difference` : 看第一个容器哪个和第二个容器最不相同, 然后将这个元素组成一个容器
```c

2 3 4 5 6 
========
3 4 5 6 7 
========
2 0 0 0 0 
========



2 3 5 
========
2 4 5 
========
3 0 0 
========


```
