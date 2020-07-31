# 数据结构

# 目录

1. [数据结构理论](#cdatastructure01)
    1. [数据结构概念](#cdatastructure01a)
    2. [算法的概念](#cdatastructure01b)
2. [线性表](#cdatastructure02)
    1. [线性表基本概念](#cdatastructure02a)
    2. [线性表的顺序存储](#cdatastructure02b)
    3. [线性表的链式存储(单向链表)](#cdatastructure02c)
3. [受限线性表](#cdatastructure03)
    1. [栈(Stack)](#cdatastructure03a)
        1. [栈的基本概念](#cdatastructure03a1)
        2. [栈的顺序存储](#cdatastructure03a2)
        3. [栈的链式存储](#cdatastructure03a3)
        4. [栈的应用(案例)](#cdatastructure03a4)
    2. [队列(Queue)](#cdatastructure03b)
        1. [队列基本概念](#cdatastructure03b1)
        2. [队列的顺序存储](#cdatastructure03b2)
        3. [队列的链式存储](#cdatastructure03b3)
4. [树和二叉树](#cdatastructure04)
    1. [树的基本概念](#cdatastructure04a)
    2. [树的表示法](#cdatastructure04b)
    3. [二叉树概念](#cdatastructure04c)
        1. [二叉树基本概念](#cdatastructure04c1)
        2. [二叉树的表示](#cdatastructure04c2)
        3. [二叉树的遍历](#cdatastructure04c3)
        4. [二叉树编程实践](#cdatastructure04c4)
        5. [二叉树的创建](#cdatastructure04c5)
        6. [#号法创建树](#cdatastructure04c6)
    
5. [排序](#cdatastructure05)
    1. [排序基本概念](#cdatastructure05a)
    2. [冒泡排序](#cdatastructure05b)
    3. [选择排序](#cdatastructure05c)
    4. [插入排序](#cdatastructure05d)




### cdatastructure01
# 1.数据结构理论

### cdatastructure01a
## 1.1 数据结构概念

数据结构是计算机存储、组织数据的方式。数据结构是指相互之间存在一种或多种特定关系的数据元素的集合。通常情况下，精心选择的数据结构可以带来更高的运行或者存储效率。数据结构往往同高效的检索算法和索引技术有关。

**数据结构是**[**计算机**](http://baike.baidu.com/view/3314.htm)**存储、组织**[**数据**](http://baike.baidu.com/view/38752.htm)**的方式。**

### cdatastructure01b
## 1.2 算法的概念

算法是特定问题求解步骤的描述，在计算机中表现为**指令的有限序列**，算法是独立存在的一种解决问题的方法和思想。

对于算法而言，语言并不重要，重要的是思想。

### cdatastructure01b1
### 1.2.1 算法和数据结构区别

数据结构只是静态的描述了数据元素之间的关系，高效的程序需要在数据结构的基础上设计和选择算法。

- **算法是为了解决实际问题而设计的。**

- **数据结构是算法需要处理的问题载体。**

- 数据结构与算法相辅相成

### cdatastructure02
# 2.线性表


### cdatastructure02a
## 2.1 线性表基本概念

线性结构是一种最简单且常用的数据结构。线性结构的基本特点是节点之间满足线性关系。本章讨论的动态数组、链表、栈、队列都属于线性结构。他们的共同之处，是节点中有且只有一个开始节点和终端节点。按这种关系，可以把它们的所有节点排列成一个线性序列。但是，他们分别属于几种不同的抽象数据类型实现，它们之间的区别，主要就是操作的不同。
线性表是零个或者多个数据元素的有限序列，数据元素之间是有顺序的，数据元素个数是有限的，数据元素的类型必须相同
例：先来看一个大家感兴趣的话题，一年里的星座列表，是不是线性表呢？如图所示：


![cdatastructure001](images/cdatastructure001.png)

线性表的性质：

1）a0 为线性表的第一个元素，只有一个后继。  
2）an 为线性表的最后一个元素，只有一个前驱。  
3）除 a0 和 an 外的其它元素 ai，既有前驱，又有后继。 
4）线性表能够逐项访问和顺序存取。

线性表的抽象数据类型定义：

```c

ADT线性表（List）
Data
线性表的数据对象集合为{ a1, a2, ……, an }，每个元素的类型均为DataType。其中，除第一个元素a1外，每个元素有且只有一个直接前驱元素，除了最后一个元素an外，每个元素有且只有一个直接后继元素。数据元素之间的关系是一一对应的。

Operation（操作）
// 初始化，建立一个空的线性表L。
InitList(*L);
// 若线性表为空，返回true，否则返回false
ListEmpty(L);
// 将线性表清空
ClearList(*L);
// 将线性表L中的第i个位置的元素返回给e
GetElem(L, i, *e);
// 在线性表L中的第i个位置插入新元素e
ListInsert(*L, i, e);
// 删除线性表L中的第i个位置元素，并用e返回其值
ListDelete(*L, i, *e);
// 返回线性表L的元素个数
ListLength(L);
// 销毁线性表
DestroyList(*L);


```



### cdatastructure02b
## 2.2 线性表的顺序存储

通常线性表可以采用顺序存储和链式存储。这节课我们主要探讨顺序存储结构以及对应的运算算法的实现。

采用顺序存储是表示线性表最简单的方法，具体做法是：将线性表中的元素一个接一个的存储在一块连续的存储区域中，这种顺序表示的线性表也成为顺序表。

### cdatastructure02b1
### 2.2.1线性表顺序存储(动态数组)的设计与实现

**操作要点:**

1. 插入元素算法

    - 判断线性表是否合法

    - 判断插入位置是否合法

    - 判断空间是否满足

    - 把最后一个元素到插入位置的元素后移一个位置

    - 将新元素插入

    - 线性表长度加1

2. 获取元素操作

    - 判断线性表是否合法

    - 判断位置是否合法

    - 直接通过数组下标的方式获取元素

3. 删除元素算法

    1. 判断线性表是否合法

    2. 判断删除位置是否合法

    3. 将元素取出

    4. 将删除位置后的元素分别向前移动一个位置

    5. 线性表长度减1

**元素的插入**
![cdatastructure002](images/cdatastructure002.png)

**元素的删除**

![cdatastructure003](images/cdatastructure003.png)

**注意:** **链表的容量和链表的长度是两个不同的概念**

### cdatastructure02b2
### 2.2.2 优点和缺点

![cdatastructure004](images/cdatastructure004.png)





### cdatastructure02c
## 2.3 线性表的链式存储(单向链表)


前面我们写的线性表的顺序存储(动态数组)的案例，最大的缺点是插入和删除时需要移动大量元素，这显然需要耗费时间，能不能想办法解决呢？链表。

链表为了表示每个数据元素与其直接后继元素之间的逻辑关系，每个元素除了存储本身的信息外，还需要存储指示其直接后继的信息。


![cdatastructure005](images/cdatastructure005.png)


 **单链表**

- 线性表的链式存储结构中，每个节点中只包含一个指针域，这样的链表叫单链表。

- 通过每个节点的指针域将线性表的数据元素按其逻辑次序链接在一起（如图）。

![cdatastructure006](images/cdatastructure006.png)


 **概念解释：**

- 表头结点

    - 链表中的第一个结点，包含指向第一个数据元素的指针以及链表自身的一些信息

- 数据结点

    - 链表中代表数据元素的结点，包含指向下一个数据元素的指针和数据元素的信息

- 尾结点

    - 链表中的最后一个数据结点，其下一元素指针为空，表示无后继

![cdatastructure007](images/cdatastructure007.png)


### cdatastructure02c1
### 2.3.1 线性表的链式存储(单项链表)的设计与实现


 **插入操作**

![cdatastructure008](images/cdatastructure008.png)


```c

node->next = current->next;
current->next = node;

```

 **删除操作**
![cdatastructure009](images/cdatastructure009.png)

```c

current->next = ret->next;

```


### cdatastructure02c2
### 2.3.2 优点和缺点

![cdatastructure010](images/cdatastructure010.png)


### cdatastructure03
# 3.受限线性表

### cdatastructure03a
## 3.1 栈(Stack)




### cdatastructure03a1
### 3.1.1 栈的基本概念

**概念**

- 首先它是一个线性表，也就是说，栈元素具有线性关系，即前驱后继关系。只不过**它是一种特殊的线性表**而已。定义中说是在线性表的表尾进行插入和删除操作，这里表尾是指栈顶，而不是栈底。

**特性**

- **它的特殊之处在于限制了这个线性表的插入和删除的位置，它始终只在栈顶进行。这也就使得：栈底是固定的，最先进栈的只能在栈底。**

**操作**

  - 栈的插入操作，叫做进栈，也成压栈。类似子弹入弹夹（如下图所示）

  - 栈的删除操作，叫做出栈，也有的叫做弾栈，退栈。如同弹夹中的子弹出夹（如下图所示）

![cdatastructure011](images/cdatastructure011.png)


### cdatastructure03a2
### 3.1.2 栈的顺序存储

**基本概念**

  - 栈的顺序存储结构简称顺序栈，它是运算受限制的顺序表。顺序栈的存储结构是：**利用一组地址连续的的存储单元依次存放自栈底到栈顶的数据元素**，同时附设指针top只是栈顶元素在顺序表中的位置。

**设计与实现**

- **因为栈是一种特殊的线性表，所以栈的顺序存储可以通过顺序线性表来实现。**


### cdatastructure03a3
### 3.1.3 栈的链式存储


**基本概念**

  - 栈的链式存储结构简称链栈。

**思考如下问题**：

    - 栈只是栈顶来做插入和删除操作，栈顶放在链表的头部还是尾部呢？

    - 由于单链表有头指针，而栈顶指针也是必须的，那干嘛不让他俩合二为一呢，所以比较好的办法就是把栈顶放在单链表的头部。另外都已经有了栈顶在头部了，单链表中比较常用的头结点也就失去了意义，通常对于链栈来说，是不需要头结点的。

**设计与实现**

  - 链栈是一种特殊的线性表，链栈可以通过链式线性表来实现。


### cdatastructure03a4
### 3.1.4 栈的应用(案例)


### cdatastructure03a4a
### 3.1.4.1 就近匹配

  - 几乎所有的编译器都具有检测括号是否匹配的能力，那么如何实现编译器中的符号成对检测？如下字符串:

`5+5*(6)+9/3*1)-(1+3(`

1. 算法思路

- 从第一个字符开始扫描

- 当遇见普通字符时忽略，

- 当遇见左符号时压入栈中

- 当遇见右符号时从栈中弹出栈顶符号，并进行匹配

- 匹配成功：继续读入下一个字符

- 匹配失败：立即停止，并报错

- 结束：

- 成功: 所有字符扫描完毕，且栈为空

- 失败：匹配失败或所有字符扫描完毕但栈非空

2. 总结

- **当需要检测成对出现但又互不相邻的事物时可以使用栈“后进先出”的特性**

- **栈非常适合于需要“就近匹配”的场合**

### cdatastructure03a4b
### 3.1.4.2 中缀表达式和后缀表达式

**后缀表达式（由波兰科学家在20世纪50年代提出）**

- **将运算符放在数字后面 ===》 符合计算机运算**

- 我们习惯的数学表达式叫做中缀表达式===》符合人类思考习惯

**实例**

- `5 + 4 => 5 4 +` 

- `1 + 2 * 3 => 1 2 3 * +`  

- `8 + ( 3 – 1 ) * 5 => 8 3 1 – 5 * +`

**中缀转后缀算法：**

遍历中缀表达式中的数字和符号：

- 对于数字：直接输出

- 对于符号：

    - 左括号：进栈  

    - 运算符号：与栈顶符号进行优先级比较

    - 若栈顶符号优先级低：此符号进栈  

      -  （默认栈顶若是左括号，左括号优先级最低）

    - 若栈顶符号优先级不低：将栈顶符号弹出并输出，之后进栈

    - 右括号：将栈顶符号弹出并输出，直到匹配左括号

遍历结束：将栈中的所有符号弹出并输出

- 动手练习

```

将我们喜欢的读的中缀表达式转换成计算机喜欢的后缀表达式

中缀表达式: 8 + ( 3 – 1 ) * 5

后缀表达式:  8 3 1 – 5 * +

```


### cdatastructure03a4c
### 3.1.4.3 基于后缀表达式计算

![cdatastructure012](images/cdatastructure012.png)





### cdatastructure03b
## 3.2 队列(Queue)


### cdatastructure03b1
### 3.2.1 队列基本概念

队列是一种特殊的受限制的线性表。  

**队列（queue）是只允许在一端进行插入操作，而在另一端进行删除操作的线性表。**

队列是一种先进先出的（First In First Out）的线性表，简称FIFO。允许插入的一端为队尾，允许删除的一端为队头。队列不允许在中间部位进行操作！假设队列是q=（a1，a2，……，an），那么a1就是队头元素，而an是队尾元素。这样我们就可以删除时，总是从a1开始，而插入时，总是在队列最后。这也比较符合我们通常生活中的习惯，排在第一个的优先出列，最后来的当然排在队伍最后。如下图：

![cdatastructure013](images/cdatastructure013.png)



### cdatastructure03b2
### 3.2.2 队列的顺序存储

![cdatastructure014](images/cdatastructure014.png)

### cdatastructure03b3
### 3.2.3 队列的链式存储

![cdatastructure015](images/cdatastructure015.png)

### cdatastructure04
# 4.树和二叉树

### cdatastructure04a
## 4.1 树的基本概念

![cdatastructure016](images/cdatastructure016.png)

![cdatastructure017](images/cdatastructure017.png)

![cdatastructure018](images/cdatastructure018.png)


![cdatastructure019](images/cdatastructure019.png)

### cdatastructure04b
## 4.2 树的表示法


### cdatastructure04b1
### 4.2.1 图形表示法

**事物之间的逻辑关系**可以通过数的形式很直观的表示出来，如下图：

![cdatastructure020](images/cdatastructure020.png)



### cdatastructure04b2
### 4.2.2 广义表表示法

![cdatastructure021](images/cdatastructure021.png)

用广义表表示法表示上图：

中国（河北（保定，石家庄），广东（广州，东莞），山东（青岛，济南））

**根作为由子树森林组成的表的名字写在表的左边。**


### cdatastructure04b3
### 4.2.3 左孩子右兄弟表示法

左孩子右兄弟表示法可以将一颗多叉树转化为一颗二叉树：
![cdatastructure022](images/cdatastructure022.png)

节点的结构：

![cdatastructure023](images/cdatastructure023.png)

节点有两个指针域，其中一个指针指向子节点，另一个指针指向其兄弟节点。

### cdatastructure04c
## 4.3 二叉树概念


### cdatastructure04c1
### 4.3.1 二叉树基本概念

![cdatastructure024](images/cdatastructure024.png)
![cdatastructure025](images/cdatastructure025.png)
![cdatastructure026](images/cdatastructure026.png)
![cdatastructure027](images/cdatastructure027.png)




### cdatastructure04c2
### 4.3.2 二叉树的表示

![cdatastructure028](images/cdatastructure028.png)

```c

typedef struct BiTNode
{
	int		data;
	struct BiTNode *lchild, *rchild;
}BiTNode, *BiTree;

```
![cdatastructure029](images/cdatastructure029.png)


```c

//三叉链表

typedef struct TriTNode

{

int data;

//左右孩子指针

struct TriTNode *lchild, *rchild;

struct TriTNode *parent;

}TriTNode, *TriTree;


```


### cdatastructure04c3
### 4.3.3 二叉树的遍历

![cdatastructure030](images/cdatastructure030.png)

![cdatastructure031](images/cdatastructure031.png)

![cdatastructure032](images/cdatastructure032.png)


### cdatastructure04c4
### 4.3.4 二叉树编程实践

![cdatastructure033](images/cdatastructure033.png)





### cdatastructure04c5
### 4.3.5 二叉树的创建


![cdatastructure034](images/cdatastructure034.png)

![cdatastructure035](images/cdatastructure035.png)


### cdatastructure04c6
### 4.3.6 `#号法创建树`

![cdatastructure036](images/cdatastructure036.png)
![cdatastructure037](images/cdatastructure037.png)
![cdatastructure038](images/cdatastructure038.png)

```c

Bintree createBTpre( )

{      Bintree T; char ch;

        scanf(“%c”,&ch);

        if(ch==’#’) T=NULL;

        else

        {   T=( Bintree )malloc(sizeof(BinTNode));

            T->data=ch;

            T->lchild=createBTpre();

            T->rchild=createBTpre();

        }        

        return T;

}

```

**使用后序遍历的方式销毁一棵树， 先释放叶子节点，在释放根节点**

**//销毁树**


```c

void  BiTree_Free(BiTNode* T)
{	
	BiTNode *tmp = NULL;
	if (T!= NULL)
	{
		if (T->rchild != NULL) BiTree_Free(T->rchild);
		if (T->lchild != NULL) BiTree_Free(T->lchild);
		if (T != NULL)
		{
			free(T); 
			T = NULL;
		}
	}
}

```



### cdatastructure05
# 5.排序

### cdatastructure05a
## 5.1 排序基本概念

![cdatastructure039](images/cdatastructure039.png)

![cdatastructure040](images/cdatastructure040.png)

1. 多关键字排序

- 排序时需要比较的关键字多余一个，排序结果首先按关键字1进行排序，当关键字1相同时按关键字2进行排序，当关键字n-1相同时按关键字n进行排序，对于多关键字排序，只需要在比较操作时同时考虑多个关键字即可！

2. 排序中的关键操作

- 比较：任意两个数据元素通过比较操作确定先后次序。

- 交换：数据元素之间需要交换才能得到预期结果。

3. 内排序和外排序

- 内排序：在排序过程中，待排序的所有记录全部都放置在内存中，排序分为：内排序和外排序。

- 外排序：由于排序的记录个数太多，不能同时放置在内存，整个排序过程需要在内外存之间多次交换数据才能进行。

4. 排序的审判

- 时间性能：关键性能差异体现在比较和交换的数量

- 辅助存储空间：为完成排序操作需要的额外的存储空间，必要时可以“空间换时间”

- 算法的实现复杂性：过于复杂的排序法会影响代码的可读性和可维护性，也可能影响排序的性能

5. 总结

- 排序是数据元素从无序到有序的过程

- 排序具有稳定性，是选择排序算法的因素之一

- 比较和交换是排序的基本操作

- 多关键字排序与单关键字排序无本质区别

- 排序的时间性能是区分排序算法好坏的主要因素


### cdatastructure05b
## 5.2 冒泡排序

![cdatastructure041](images/cdatastructure041.png)

![cdatastructure042](images/cdatastructure042.png)


### cdatastructure05c
## 5.3 选择排序

![cdatastructure043](images/cdatastructure043.png)

### cdatastructure05d
## 5.4 插入排序

插入排序算法是一种简单的排序算法，也成为直接插入排序算法。它是一种稳定的排序算法，对局部有序的数据具有较高的效率。

插入排序算法是一个队少量元素进行排序的有效算法。比如，打牌是我们使用插入排序方法最多的日常生活例子。我们在摸牌时，一般会重复一下步骤。期初，我们手里没有牌，摸出第一张，随意放在左手上，以后每一次摸排，都会按照花色从小到大排列，直到所有的牌摸完。插入排序算法采用的类似思路，每一次从无序序列中拿出一个数据，将它放到已排序的序序列的正确位置，如此重复，直到所有的无序序列中的数据都找到了正确位置。

![cdatastructure044](images/cdatastructure044.png)

