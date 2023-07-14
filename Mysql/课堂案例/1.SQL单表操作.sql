1、通过DDL语句创建表 
create table 表名(
  列名 列的数据类型(长度) 列的约束,
列名 列的数据类型(长度) 列的约束,
列名 列的数据类型(长度) 列的约束,
列名 列的数据类型(长度) 列的约束
)

create table studentinfo(
	stu_no int(8) not null primary key,
	stu_name varchar(10) not null,
	gender char(1),
	age    int,
	birthday date,
	class  varchar(10),
	course varchar(10),
	score  float
)

create table studentinfo2(
	stu_no int(8) not null,
	stu_name varchar(5) not null,
	gender char(1) null,
	age    int null,
	birthday date null,
	class  varchar(10) null,
	course varchar(10) null,
	score  float null,
  primary key(stu_no)
)

2、通过DDL语句删除表 
drop table studentinfo2;


3、插入语句
语法：insert into 表名(字段名,字段名, ... ) values(字段值,字段值,...);
①部分字段插入(非空字段必须插入)
insert into studentinfo(stu_no,stu_name) values(1,'大力');
insert into studentinfo(stu_no,stu_name) values(2,"大力");
insert into studentinfo(stu_no,stu_name,gender) values(3,"baby",'男');
insert into studentinfo(stu_no,stu_name,gender) values(4,"baby",'女');
②全字段插入
表名后面没有声明插入的字段列表,则代表为全表列字段的插入,值的顺序比较和表结构的顺序一致
insert into studentinfo(stu_no,stu_name,gender,age,birthday,class,course,score) 
  values(5,"coco",'女',18,'2020-01-01','C营一期','JAVA',85.55);
insert into studentinfo 
	values(5,"coco",'女',18,'2020-01-01','C营一期','JAVA',85.55);
insert into studentinfo 
	values(6,"coco",'女',18,'2020-01-01',null,null,null);
③因为主键列是数值列,可以设置为自增。
该列插入数据的时候可以不插入,或者填null
insert into studentinfo 
	values(null,"郑宇",'男',25,'2010-01-01',null,null,null);

insert into studentinfo(stu_name,gender,age,birthday,class,course,score) 
  values("张大伟",'女',18,'2020-01-01','C营一期','JAVA',85.55);

④批量插入 
语法： insert into 表名(字段1,字段2) values(值1,值2),(值1,值2),(值1,值2),(值1,值2)..
insert into studentinfo values
 (null,"郑宇1",'男',25,'2010-01-01',null,null,null),
 (null,"郑宇2",'男',25,'2010-01-01',null,null,null),
 (null,"郑宇3",'男',25,'2010-01-01',null,null,null);

4、修改语句
语法： update 表名 set 列名=新值,列名=新值 where 子句; 
①更新学生表的年龄为18 此时update不带where匹配表中所有记录
update studentinfo set age=18;  
②更新学生郑宇的年龄为20
update studentinfo set age=20 where stu_name ="郑宇";  
②更新学生郑宇的年龄和出生年月 
update studentinfo set age=21,birthday="1991-02-10" where stu_name ="郑宇";  

5、删除数据语句
语法： delete from 表名 where 子句;
面试题：drop和delete的区别,drop是删除表结构，delete删除表数据
①删除表中所有的数据
delete from studentinfo;
②删除年龄21的学生列表
delete from studentinfo where age=21;  

6、查询语句
语法： select 查询的字段名1,查询的字段名2, ... from 表名 where 子句
①查询表中所有的记录  *符号表示 所有列
select * from studentinfo;
②查询表中的部分列
select stu_no,stu_name,gender from studentinfo;
③查询郑宇的信息,带where子句
select * from studentinfo where stu_name = '郑宇1';

7、as关键字：对列和表取别名
①对列取别名
select 
	stu_no   as studentNo,
	stu_name as studentName,
  gender 
  from studentinfo;
②as关键字可以省略
select stu_no studentNo,stu_name studentName,gender from studentinfo;
③对表取别名
select 
	A.stu_no   as studentNo,
	A.stu_name as studentName,
  A.gender 
  from studentinfo as A;

8、where子句：配合update、delete、select使用,where是对表中的行进行匹配。
①比较条件 =  >  >= < <=  高级等于<=>  不等于!=或<>
查询年龄为18岁
select * from studentinfo where age = 18;
查询年龄大于等于18岁
select * from studentinfo where age >= 18;
查询年龄不等于18岁
select * from studentinfo where age != 18;
select * from studentinfo where age <> 18;
②判断空值  is null/is not null
查询没有分配班级的学生
select * from studentinfo where class is null;
select * from studentinfo where class <=> null;
查询已分配班级的学生
select * from studentinfo where class is not null;
③and和or
查询18岁的郑宇
select * from studentinfo where stu_name="郑宇" and age = 18;
查询郑宇和年龄18的学生列表
select * from studentinfo where stu_name="郑宇" or age = 18;

④确定集合(OR关系)
查询年龄15 17 19的学生
select * from studentinfo where age = 15 or age = 17 or age = 19;
select * from studentinfo where age in(15,17,19);

⑤确定范围(闭区间) between 值1 and 值2;
查询年龄15-19的学生
select * from studentinfo where age >=15  and age <= 19;
select * from studentinfo where age between 15 and 19;
查询出生年月在2010-2020
select * from studentinfo where birthday between "2010-1-1" and "2020-1-1";

⑥字符匹配-模糊查询   where 列名 like  '匹配符+字符串'
%匹配0-N个字符  _匹配单个字符

精确查询
select * from studentinfo where stu_name = "郑宇";
不确定查询的内容
select * from studentinfo where stu_name like "%宇";  张宇 宇 小宇
select * from studentinfo where stu_name like "_宇";  张宇 小宇
select * from studentinfo where stu_name like "%宇%"; 张宇 宇 小宇 小宇宙
select * from studentinfo where stu_name like "宇%";  宇宙 宇
查询陈姓学生列表
select * from studentinfo where stu_name like "张%";  张三 张大伟 张张

9、mysql默认不区分大小写
select * from studentinfo where stu_name like "b%";  baby BOBO Bannar
select * from studentinfo where binary stu_name like "b%"; baby

select * from studentinfo where  stu_name = 'baby';  baby BABY
select * from studentinfo where binary stu_name = 'baby'; baby

10、排序 order BY 
语法  select .. from 表名 where .. order by 列1 asc/desc,列2 asc/desc 
①按照年龄升序
select * from studentinfo order by age;  -- 默认是升序,可以省略asc关键字
select * from studentinfo order by age asc;
②按照年龄降序
select * from studentinfo order by age desc;
③按照年龄降序，学号升序（当第一个排序规则出现相同的时候，则启动第二个排序规则）
select * from studentinfo order by age desc,stu_no asc;

11、统计函数

12、分组 group BY

13、对组筛选 HAVING

14、分页 limit






