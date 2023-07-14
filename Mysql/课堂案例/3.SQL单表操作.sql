1、统计函数  count(*/列)   sum(数值列)  avg(数值列)  max(数值列)  min(数值列)
①count() 用于统计非null个数
获取学生数量
select * from studentinfo;
select count(*) from studentinfo; -- 查询表中多少条记录数
指定列的个数
select count(gender) from studentinfo; -- 查询表中指定列的记录数
select count(class) from studentinfo;

② sum(数值列)  avg(数值列)  max(数值列)  min(数值列)
计算全部学生的总分，平均分，最高分，最低分
select SUM(score) from  studentinfo;
select avg(score) from  studentinfo;
select max(score) from  studentinfo;
select min(score) from  studentinfo;

计算JAVA学生的人数，总分，平均分，最高分，最低分
select  
  COUNT(*) as studentCount
	,SUM(score) as sumScore 
	,avg(score) as avgScore 
	,max(score) as maxScore
	,min(score) as minScore 
	from  studentinfo 
  where course = 'java';

2、DISTINCT去重复关键字
select DISTINCT stu_name from studentinfo;
查询班级列表
select DISTINCT class from studentinfo;
查询班级个数
select COUNT(DISTINCT class) from studentinfo; -- 2
查询总分,去掉重复的分数
select sum(DISTINCT score) from  studentinfo;

3、分组 group by 列名
查询班级列表
select  class from studentinfo group by class;
查询每个班级的学生个数
select  class,COUNT(*) from studentinfo group by class;
查询男生和女生的个数
select gender,count(*) from studentinfo group  by gender;
查询每个课程的学生个数
select course,count(*) from studentinfo group  by course;

4、对分组进行筛选 having 
查询课程人数大于3个的课程列表
select course,count(*) from studentinfo group  by course having count(*) > 3;

查询课程成绩最低分不低于60分的课程列表和最低分
select course,MIN(score) from studentinfo group by course  having min(score) >= 60;

5、limit 限制
语法： SELECT.... limit a,b; a偏移量,b获取的记录数
select * from studentinfo limit 0,2;
select * from studentinfo limit 1,2;
select * from studentinfo limit 2,2;
select * from studentinfo limit 2,4;

总条数13条，每页显示3条，总页数5页 
显示第一页：
select * from studentinfo limit 0,3;
显示第二页：
select * from studentinfo limit 3,2;
显示第三页：
select * from studentinfo limit 6,2;
显示第四页：
select * from studentinfo limit 9,2;
显示第五页：
select * from studentinfo limit 12,2;


java中自定义方法
public  void page(int pageNum,int pageSize){ //pageNum=1  pageSize=3
	select * from studentinfo limit (pageNum-1)*pageSize,pageSize;
}

显示前10条学生的数据
select * from studentinfo limit 0,10; 
显示Java选修课程的分数前3名
select * from studentinfo where course = "JAVA" order by score desc limit 0,3;


6、子查询
1.查询分数大于平均分的学生信息 
select * from studentinfo where score >= (select avg(score) from studentinfo);

2.查询课程成绩最高分大于90分的课程,将选修这些课程的学生显示出来  
select * 
  from studentinfo 
  where course in(
		select course
			from studentinfo 
			group by course 
			having max(score) > 90)

3.查询选修人数大于等于3个的课程数量  
select COUNT(*) from (select course,COUNT(*) 
	from studentinfo where course is not null 
  group by course 
  having COUNT(*)>=3) as temp;


4.查询java成绩排名第三的所有学生(此时存在相同分数的情况)
select * from studentinfo where score = (
	select DISTINCT score 
	from studentinfo 
  where course = 'java' 
  order by score desc 
  limit 2,1);

select * from studentinfo where score = (
	select score 
	from studentinfo 
  where course = 'java' 
  group by score
  order by score desc 
  limit 2,1);

