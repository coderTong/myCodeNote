# 目录


1. [基本语法](#基本语法)
1. [组成部分](#组成部分)
1. [约束](#约束)
1. [](#)
1. [](#)




# 基本语法

1. xml文档的后缀 .xml
2. xml第一行必须定义为文档声明, 如下
```

<?xml version='1.0' ?>

```

3. xml 文档中有且仅有一个跟标签
4. 属性值必须使用引号(单/双)引起来
```

// id 才是属性 

<user id='1'>
<name>zhangsan</name>
<age>23</age>
<gender>male</gender>					
</user>

```

5.  标签必须正确关闭
6. xml标签名称区分大小写


# 组成部分

1. 文档声明
`<?xml version='1.0' ?>`
2. 指令, 当它不存在
3. 标签: 标签名称自定义的

```

1. 名称可以包含字母、数字以及其他的字符
2. 名称不能以数字或者标点符号开始 
3. 名称不能以字母 xml（或者 XML、Xml 等等）开始
4. 不能包含空格 

```

4. 属性, 属性值唯一哈~
```

// id 才是属性 

<user id='1'>
<name>zhangsan</name>
<age>23</age>
<gender>male</gender>					
</user>

```
5. 文本 , 当它不存在




# 约束

分类:
1. DTD: 简单
2. Schema: 复杂


## Schema

1. 填写xml 文档的 根元素

2. 引入`xsi`前缀, 
```

xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

```
3. 引入`xsd` 文件命名空间.

```

xsi:schemaLocation="http://www.domanshow.com/xml  student.xsd"

```

4. 为每个xsd约束声明一个前缀, 作为标识.

```

xmlns="http://www.domanshow.com/xml" 

```



```

<students   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
					xmlns="http://www.itcast.cn/xml"
					xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd">


```



#  解析

DOM: 一次性加载,占内存, 可以CRUD

SAX: 逐行读取,事件驱动,只读


### 常见解析器

1. JAXP...没人用
2. DOM4J
3. Jsoup: DOM方式
4. PULL：Android操作系统内置的解析器，sax方式的。





