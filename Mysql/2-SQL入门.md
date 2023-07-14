# 第1天【SQL入门】

## 主要内容

1.  了解SQL语言的功能
2.  熟悉SQL分类
3.  掌握DDL、DML语句

## 学习目标

| 节数                         | 知识点           | 要求 |
|------------------------------|------------------|------|
| 第一节（了解SQL语言的功能）  | SQL语言的功能    | 了解 |
| 第二节（熟悉SQL分类）        | 熟悉SQL分类      | 掌握 |
| 第三节（掌握DDL、DML语句）   | 掌握DDL、DML语句 | 掌握 |

## 第一节 了解SQL语言的功能

### SQL语言的功能

SQL具有数据定义、数据操纵和数据控制的功能。

1、SQL数据定义功能DDL

用于定义SQL模式、基本表、视图和索引的创建和撤消操作.DDL是SQL语言的四大功能之一。 用于定义数据库的三级结构，包括外模式、概念模式、内模式及其相互之间的映像，定义数据的完整性、安全控制等约束 DDL不需要commit.

2、SQL数据操纵功能DML

包括对基本表和视图的数据插入、删除和修改，特别是具有很强的数据查询功能。

3、SQL的数据控制功能

主要是对用户的访问权限加以控制，以保证系统的安全性。

### 本节作业

1.  描述出SQL语言的功能

## 第二节 熟悉SQL分类

### 2.1 SQL分类

SQL语句的四中分类：DDL,DML,DCL,DQL;

DDL(Data Defination Language)：是一组SQL命令，用于创建和定义数据库对象，并且将对这些对象的定义保存到数据字典中。通过DDL语句可以创建数据库对象，修改数据库对象和删除数据库对象等。

DML(Data Manipulaton Language):主要用来处理数据库中的数据内容。允许用户对数据库中的数据进行查询 ，插入，更新和删除等操作

DQL(Data Query Language ):对数据库的数据的查询操作

DCL(Data Control Language):数据控制语言用于修改数据库结构的操作权限

### 本节作业

1.  描述出SQL分类

## 掌握DDL、DML语句

### DDL语句概念

数据库模式定义语言DDL(Data Definition Language)，是用于描述数据库中要存储的现实世界实体的语言。主要由create（添加）、alter（修改）、drop（删除）和 truncate（删除） 四个关键字完成。

### 3.2 create关键字

1、创建一个数据库

//建立一个数据库

create database 数据库名;

//建立一个数据库并制定编码格式

create database 数据库名 default charset utf8 collate utf8_general_ci;

1.  

2、创建一个表

表是存放在数据库中的只能在数据库下创建表

语法：

create table 表名(

列名 列的数据类型(长度) 列的约束,

列名 列的数据类型(长度) 列的约束,

列名 列的数据类型(长度) 列的约束,

列名 列的数据类型(长度) 列的约束

)

注意：如果是varchar数据类型必须设置长度。

3、使用create复制表

//只复制表结构及约束，但不复制数据

CREATE TABLE 复制出的表 LIKE 原表

//复制表结构及数据，但不复制约束

CREATE TABLE 复制出的表 AS SELECT \* FROM 原表

### 3.3 alter关键字

1、添加字段

ALTER TABLE 表名称 ADD 字段名 字段约束

ALTER TABLE 表名称 ADD COLUMN 字段名 字段约束

2、添加索引

ALTER TABLE 表名称 ADD INDEX 索引名称 (字段名)

3、添加主键

ALTER TABLE 表名称 ADD PRIMARY KEY (字段名)

ALTER TABLE 表名称 ADD UNIQUE KEY (字段名)

4、添加外键约束

ALTER TABLE 需要添加外键表名称 ADD FOREIGN KEY 外键名(设为外键的字段) REFERENCES 被添加外键表名称(设为被添加外键的字段)

5、修改字段类型时要注意字段类型的兼容性及精度，除非该列全部数据为null

ALTER TABLE 表名称 CHANGE COLUMN NAME 修改字段 修改为字段类型

ALTER TABLE 表名称 MODIFY COLUMN 修改字段 修改为字段类型

6、修改与删除表中default

//设置default

ALTER TABLE 表名称 ALTER COLUMN 字段名 SET DEFAULT '修改的值'

//删除default

ALTER TABLE 表名称 ALTER COLUMN 字段名 DROP DEFAULT

7、禁用和启用约束

//禁用约束

ALTER TABLE 表名称 DISABLE KEYS

//启用约束

ALTER TABLE 表名称 ENABLE KEYS

8、删除表字段、主键、索引、外键约束

//删除表字段

ALTER TABLE 表名称 DROP COLUMN 字段名

//删除主键

ALTER TABLE 表名称 DROP PRIMARY KEY

//删除索引

ALTER TABLE 表名称 DROP INDEX 索引的字段名

//删除外键约束

ALTER TABLE 表名称 DROP FOREIGN KEY 外键的字段名

9、修改表名

ALTER TABLE 修改前表名称 RENAME 修改后表名称

### 3.4 drop关键字

1、删除数据库

DROP DATABASE 数据库名

2、删除表

DROP TABLE 表名称

### 3.5 truncate关键字

与drop的区别：truncate只删除数据不删除表的结构(定义)，释放空间

删除表内全部数据

truncate table 表名称;

### 3.6 DML语句概念

DML 操作是指对数据库中表记录的操作，主要包括表记录的插入（insert）、更新（update）、删除（delete）和查询（select），是开发人员日常使用最频繁的操作。

### 3.7 插入语句

INSERT 是将数据插入到数据库对象中的指令。

基本语法

INSERT INTO tbl_name(col1,col2,col3) values(var1,var2,var3)

说明：如果表名后面没写字段名，则默认是向所有的字段添加值，字符串值应该用引号括起来，注意值要和列的约束一致。

### 3.8 更新语句

UPDATE 指令是依给定条件，将匹配条件的数据表中的数据更新为新的数值

基本语法

UPDATE table_reference SET 列名=新值1,列名=新值2,...[WHERE where_condition]

说明：where 子句是判断语句，用来设定条件，限制只更新匹配的行，where可以省略

### 3.9 删除语句

DELETE 指令为自数据库对象中删除数据的指令

基本语法

DELETE FROM tbl_name;

DELETE FROM tbl_name WHERE where_condition;

说明：此语句删除表中的行，如果不带where子句，则删除整个表中的记录,但是表不被删除，删除有关联的记录时，先删除从表，再删除主表。where可以省略

### 3.10 查询语句

SELECT是SQL数据操纵语言(DML)中用于查询表格内字段数据的指令，可搭配条件限制的子句(如where)或排列顺序的子句(如order)等来获取查询结果

基本语法：

select 查询的字段名1,查询的字段名2, ...

from 表名

where 子句

group by子句

having 子句

order by 列 asc/desc

limit a,b

SELECT语句用于从一个或多个表中查询出需要的信息。

一个最基本的SELECT语句如下：

SELECT \* FROM 表名

其中“\*”是一个特殊的列名，它表示一个表格中所有的列。

查询部分字段

select 字段1, 字段2,.... from 表名

### 3.11 as关键字

表中的列名由于经常采用简写或英文字符，有时不便于查看，这时可以使用为列重命名的方法将列名显示为易于理解的别名。

为列重命名可以采用如下方法：

SELECT 列名 AS 新列名,列名 AS 新列名,.. FROM 表名

也可以对表取别名方法：

SELECT 新表名.列名, 新表名.列名,... FROM 表名 as 新表名

**注意**：as关键字可以省略

### 3.12 代码演示

### 本节作业

1.使用SQL的DDL语句创建表

2.使用SQL的DML语句完成指定表的CRUD操作
