/*简单约束*/
CREATE TABLE IF NOT EXISTS t_student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER);
CREATE TABLE IF NOT EXISTS t_student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, age INTEGER NOT NULL);
CREATE TABLE IF NOT EXISTS t_student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT UNIQUE, age INTEGER);
CREATE TABLE IF NOT EXISTS t_student(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER DEFAULT 1);

/*分页*/
SELECT * FROM t_student ORDER BY id ASC LIMIT 30, 10;

/*排序*/
SELECT * FROM t_student WHERE score > 50 ORDER BY age DESC;
SELECT * FROM t_student WHERE score < 50 ORDER BY age ASC , score DESC;

/*计量*/
SELECT COUNT(*) FROM t_student WHERE age > 50;

/*别名*/
SELECT name as myName, age as myAge, score as myScore FROM t_student;
SELECT name myName, age myAge, score myScore FROM t_student;
SELECT s.name myName, s.age myAge, s.score myScore FROM t_student s WHERE s.age > 50;

/*查询*/
SELECT name, age, score FROM t_student;
SELECT * FROM t_student;

/*修改指定数据*/
UPDATE t_student SET name = 'MM' WHERE age = 10;
UPDATE t_student SET name = 'WW' WHERE age is 7;
UPDATE t_student SET name = 'XXOO' WHERE age < 20;
UPDATE t_student SET name = 'NNMM' WHERE age < 50 and score > 10;

/*删除数据*/
DELETE FROM t_student;

/*更新数据*/
UPDATE t_student SET name = 'LNJ';

/*插入数据*/

 INSERT INTO t_student(age, score, name) VALUES ('28', 100, 'jonathan');
 INSERT INTO t_student(name, age) VALUES ('lee', '28');
 INSERT INTO t_student(score) VALUES (100);

/*插入数据*/
INSERT INTO t_student(name, age, score) VALUES ('lee', '28', 100);

/*添加主键*/
CREATE TABLE IF NOT EXISTS t_student (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, age INTEGER, score REAL);
/*添加主键*/
CREATE TABLE IF NOT EXISTS t_student (id INTEGER, name TEXT, age INTEGER, score REAL, PRIMARY KEY(id));

/*删除表*/
DROP TABLE IF EXISTS t_student;

/*创建表*/
CREATE TABLE IF NOT EXISTS t_student(id INTEGER , name TEXT, age , score REAL);