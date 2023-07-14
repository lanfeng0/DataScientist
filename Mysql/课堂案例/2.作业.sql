create table hw_studentinfo(
	stu_no int(8) not null primary key auto_increment,
	stu_name varchar(10) not null,
	gender char(1),
	age    int,
	birthday date,
	class  varchar(10),
	course varchar(10),
	score  float
)
-- 通过DDL语句创建表
-- 插入一条学生记录：学号1,姓名王五,性别男,年龄10,出生日期2010-05-05,班级名”JJA2001”,选修java,分数70
insert into hw_studentinfo 
	values(1,"王五","男",10,"2010-05-05","JJA2001","Java",70);
-- 插入一条学生记录：学号2,姓名李四,性别女,年龄25,出生日期1997-01-05,班级名”JPH2001”,选修php
insert into hw_studentinfo
	values(2,"李四","女",25,"1997-01-05","JPH2001","php",null);
-- 插入一条学生记录：学号3,姓名张三,性别男,年龄30,选修php
insert into hw_studentinfo
	values(3,"张三","男",30,null,null,"php",null);
insert into hw_studentinfo(stu_no,stu_name,gender,age,course)
	values(4,"张三","男",30,"php");
-- 通过可视化工具再添加一条测试
-- 删除表中王五学生信息
delete from hw_studentinfo where stu_name = '王五';
-- 修改表中所有学生的班级为设置为”JJA2002”
update hw_studentinfo set class = "JJA2002";
-- 修改表中王五的班级为”JPH2001”
update hw_studentinfo set class = "JPH2001" where stu_name = '张三';
-- 列出学生表所有信息
select * from hw_studentinfo;
-- 列出所有学生的姓名和年龄
select stu_name,age from hw_studentinfo;
-- 列出所有学生的学号和姓名,并且显示为studentNo和studentName
select stu_no as studentNo,stu_name as studentName from hw_studentinfo;
-- 列出王五学生的姓名和年龄
select stu_name,age from hw_studentinfo where stu_name = '张三';
-- 列出”JJA2002”或者”JPH2001”的班级学生信息
select * from hw_studentinfo where class = 'JJA2002' or  class = 'JPH2001';
select * from hw_studentinfo where class in('JJA2002','JPH2001');
-- 列出不属于”JJA2001”班的学生信息
select * from hw_studentinfo where class != 'JJA2001';
-- 列出年龄在20-23岁之间的学生信息
select * from hw_studentinfo where age between 20 and 23;
-- 列出没有分配班级的学生数据
select * from hw_studentinfo where class is null;
-- 列出”JPH2001”班级的女生姓名
select stu_name from hw_studentinfo where class = 'JPH2001' and gender = '女';
-- 查询姓“王”的学生
select * from hw_studentinfo where stu_name like '王%';
-- 查询名字中带“强”的学生
select * from hw_studentinfo where stu_name like '%强%';
-- 按学生年龄升序
select * from hw_studentinfo order by age asc;
-- 查询选修java的学生，按考试分数升序
select * from hw_studentinfo where course = 'Java' order by score asc;


-- 查询”JJA2001”班的选修JAVA课程的学生成绩，按照降序显示。成绩相同，则按照学生编号升序。
select * from hw_studentinfo where class = 'JJA2001' and course ='java'
 order by score desc,stu_no asc;
-- 查询学生总年龄
select SUM(age) from hw_studentinfo;
-- 查询学生平均年龄
select AVG(age) from hw_studentinfo;
-- 查询学生最高年龄
select MAX(age) from hw_studentinfo;
-- 查询学生最低年龄
select MIN(age) from hw_studentinfo;
-- 查询”JJA2001”班的学生总数
select class,count(*) from hw_studentinfo where class = 'JJA2001';
-- 查询班级列表
select DISTINCT class from hw_studentinfo;
select class from hw_studentinfo group by class;
-- 查询”JJA2001”班学生的总分
select class,sum(score) from hw_studentinfo where class = 'JJA2001';
-- 查询”JJA2001”班学生的平均分
select class,avg(score) from hw_studentinfo where class = 'JJA2001';
-- 列出男女生的人数
select gender,count(*) from hw_studentinfo group by gender;
-- 列出每个课程选修的人数
select course,count(*) from hw_studentinfo group by course;
-- 列出每个班级的人数
select class,count(*) from hw_studentinfo group by class;

-- 列出班级人数超过3个的班级名和人数
select class,count(*) from hw_studentinfo group by class having count(*)>3;

-- 查询每门选修课程的平均成绩,并按照分数降序。
select course,avg(score) from hw_studentinfo group by course order by avg(score) desc;

-- 查询选课人数超过3个的选课列表,并按照人数降序。
select course,count(*) from hw_studentinfo 
	group by course 
  having count(*) > 3 
  order by count(*) desc;

查询学生表中年龄前5个学生
select * from hw_studentinfo order by age desc limit 5;

按照Java分数从高到低显示前5个学生
select * from hw_studentinfo where course = 'java'  
  order by score desc limit 5;

按照分数从高到低显示前2个课程最高分大于90分的课程列表和对应分数
每一个课程的最高分
select course,max(score) from hw_studentinfo 
  group by course 
  having max(score)>=90
  order by max(score) desc 
  limit 2;

查询选修php课程成绩第三名的学生信息(无相同分数的情况)
select * from hw_studentinfo where course = 'php'  order by score desc limit 2,1;

查询选修Java课程最后一名的学生信息(无相同分数的情况)
select * from hw_studentinfo where course = 'JAVA'  order by score asc limit 1;

查询年龄最高的学生信息
select * from hw_studentinfo where age = (select max(age) from hw_studentinfo);

查询Java课程成绩大于该课程平均分的学生列表
select * from hw_studentinfo 
  where course = 'java' 
  and score > (select avg(score) from hw_studentinfo where course = 'java')

查询班级平均分大于总平均分的班级列表
select class,avg(score) 
 from hw_studentinfo  
 group by class 
 having avg(score) > (select avg(score) from hw_studentinfo)

查询班级平均分大于总平均分的班级数量
select COUNT(*) from (
	select class,avg(score) 
		from hw_studentinfo  
		group by class 
		having avg(score) > (select avg(score) from hw_studentinfo)
) as temp;


