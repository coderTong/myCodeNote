# FMDB基本使用
- 1. 什么是FMDB?
  - FMDB是iOS平台的SQLite数据库框架
  - FMDB以OC的方式封装了SQLite的C语言API
- 2. FMDB有什么优势?
  - 使用起来更加面向对象，省去了很多麻烦、冗余的C语言代码
  - 提供了多线程安全的数据库操作方法，有效地防止数据混乱
- 3. 安装方式
  - Cocoapods
  	- use_frameworks!
	  	- 使用dynamic frameworks的方式集成
  	- pod 'FMDB'
  - 手动集成(swift)
  	- 1. 导入FMDB文件
  	- 2. 导入系统依赖库sqlite3.0.tbd
  	- 3. 建立桥接文件, 并导入需要的头文件
- 核心类
  - FMDatabase
  	- 一个FMDatabase对象就代表一个单独的SQLite数据库
  	- 用来执行SQL语句
  - FMResultSet
  	- 使用FMDatabase执行查询后的结果集
  - FMDatabaseQueue
  	- 用于在多线程中执行多个查询或更新，它是线程安全的
- 使用步骤
  - 1. 打开数据库
  	- 通过指定SQLite数据库文件路径来创建FMDatabase对象
  		- 文件路径有三种情况
			- 具体文件路径
				- 如果不存在会自动创建
			- 空字符串@""
				- 会在临时目录创建一个空的数据库
				- 当FMDatabase连接关闭时，数据库文件也被删除
			- nil
				- 会创建一个内存中临时数据库，当FMDatabase连接关闭时，数据库会被销毁
  	- FMDatabase *db = [FMDatabase databaseWithPath:path];
  	- if ([db open])  { NSLog(@"打开成功!"); }


  - 2. 执行更新
  	- 在FMDB中，除查询以外的所有操作，都称为“更新”
				create、drop、insert、update、delete等
  	- 使用executeUpdate:方法执行更新

```

				- (BOOL)executeUpdate:(NSString*)sql, ...
				- (BOOL)executeUpdateWithFormat:(NSString*)format, ...
				- (BOOL)executeUpdate:(NSString*)sql withArgumentsInArray:(NSArray*)arguments

```



  	- 示例

	  	- [db executeUpdate:@"UPDATE t_student SET age = ? WHERE name = ?;", @20, @"Jack"]
  - 3. 执行查询
			查询方法

```

				- (FMResultSet *)executeQuery:(NSString*)sql, ...
				- (FMResultSet *)executeQueryWithFormat:(NSString*)format, ...
				- (FMResultSet *)executeQuery:(NSString *)sql withArgumentsInArray:(NSArray *)arguments

```
			demo
  - 4. 关闭数据库
			database.close()

# self

1.  `FMDatabase` - Represents a single SQLite database. Used for executing SQL statements.
2.  `FMResultSet` - Represents the results of executing a query on an `FMDatabase`.
3.  `FMDatabaseQueue` - If you're wanting to perform queries and updates on multiple threads, you'll want to use this class. It's described in the "Thread Safety" section below.



# FMDatabase

FMDatabase 一个已经打开的数据库

```
/**
如果传@"", 就创建一个临时的数据库, 连接断了就删除
如果是一个有值的路径就创建永久的数据库
如果是nil, 那就创建一个内存数据库,连接管
*/
NSString *path = [NSTemporaryDirectory() stringByAppendingPathComponent:@"tmp.db"];
FMDatabase *db = [FMDatabase databaseWithPath:path];


// 打开数据库
if (![db open]) {
    db = nil;
    return;
}
```


FMResultSet  结果集, 查询的结果集

FMDatabaseQueue 队列,多线程操作避免错乱


