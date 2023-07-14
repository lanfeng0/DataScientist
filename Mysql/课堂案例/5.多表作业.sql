通过可视化工具创建课程表、教师表、班级表,并且在班级表中设置外键
通过DDL语句创建学生表,课程成绩表,设置主外键
create table t_course(
 course_id int not null auto_increment ,
 course_name varchar(10),
 primary key(course_id)
)
create table t_teacher(
 teacher_id int not null auto_increment ,
 teacher_name varchar(10),
 age int,
 primary key(teacher_id)
)
create table t_class(
	class_id int not null auto_increment ,
  class_name varchar(10) not null,
  teacher_id	int not null,
  primary key(class_id),
  constraint fk_teacher_id foreign key (teacher_id) references t_teacher(teacher_id)
)

create table t_student(
	stu_id int not null auto_increment ,
  stu_name varchar(10) not null,
  age int,
  class_id int,
  primary key(stu_id),
  constraint fk_class_id foreign key (class_id) references t_class(class_id)
)

create table t_score(
	stu_id int not null,
	course_id int not null,
  score int not null,
  primary key(stu_id,course_id),
	constraint fk_stu_id foreign key (stu_id) references t_student(stu_id),
	constraint fk_course_id foreign key (course_id) references t_course(course_id)
)

通过批量插入SQL语句完成上面的插入数据任务
1号陈老师年龄20  
2号黄老师年龄28  
3号白老师年龄30  
insert into t_teacher values(null,"陈老师",20),(null,"黄老师",28),(null,"白老师",30);

班级编号1 班级名：软件1班   授课老师编号：1
班级编号2 班级名：软件2班   授课老师编号：2
班级编号3 班级名：计算机1班 授课老师编号：3
班级编号4 班级名：计算机2班 授课老师编号：1
班级编号5 班级名：自动化1班 授课老师编号：2
insert into t_class values(null,"软件1班",1),(null,"软件2班",2),
	(null,"计算机1班",3),(null,"计算机2班",1),(null,"自动化1班",2);

1号学生名： 大力  年龄：20  所属班级编号： 1
2号学生名： 晶晶  年龄：25  所属班级编号： 1 
3号学生名： 景斌  年龄：30  所属班级编号： 2 
4号学生名： 华彬  年龄：22  所属班级编号： 2 
5号学生名： 嘉诚  年龄：18  所属班级编号： 3
6号学生名： 李四  年龄：33  所属班级编号： 4
7号学生名： 张三  年龄：33  所属班级编号： 5
8号学生名： 张三  年龄：33  所属班级编号： 4
insert into t_student values(null,"大力",20,1),(null,"晶晶",25,1),(null,"景斌",30,2),
(null,"华彬",22,2),(null,"嘉诚",18,3),(null,"李四",33,5),
(null,"张三",33,5),(null,"张三",33,4);

课程编号1 课程名：JAVA基础
课程编号2 课程名：JAVA框架应用
课程编号3 课程名：PHP编程
insert into t_course values(null,"JAVA基础"),(null,"JAVA框架应用"),(null,"PHP编程");

对成绩表插入数据:让1,2,3,4,5,6,7同学均参加Java基础、JAVA框架应用、PHP编程课程的考试
insert into t_score values
 (1,1,100),(1,2,88),(1,3,50),(2,1,70),(2,2,58),(2,3,80),(3,1,10),(3,2,68),(3,3,90),
 (4,1,67),(4,2,88),(4,3,50),(5,1,66),(5,2,58),(5,3,60),(6,1,76),(6,2,38),(6,3,71),
 (7,1,45),(7,2,98),(7,3,88);


列出所有班级信息(班级编号,班级名)及授课老师的姓名和年龄
select 
	A.class_id,
  A.class_name,
  B.teacher_name,
  B.age 
	from t_class A 
  inner join t_teacher B 
  on A.teacher_id = B.teacher_id

列出陈老师和黄老师所带的班级信息 
select 
  A.class_id,
  A.class_name,
  B.teacher_name,
  B.age 
	from t_class A 
  inner join t_teacher B 
  on A.teacher_id = B.teacher_id
	where B.teacher_name = "陈老师" or B.teacher_name = "黄老师";

列出”软件1班”的学生数量
select 
 A.class_name,
 COUNT(*)
 from t_class A 
 inner join t_student B 
 on A.class_id = B.class_id 
 where  A.class_name = "软件1班";


列出每个班级的班级名和学生数量,并按照学生数量升序显示
select 
 A.class_name,
 COUNT(*)
 from t_class A 
 inner join t_student B 
 on A.class_id = B.class_id 
 group by A.class_id
 order by COUNT(*) asc;

列出每门课程的课程号，课程名，选课人数，平均分
select 
  A.course_id,
  A.course_name,
  COUNT(B.stu_id),
  AVG(B.score)
  from t_course A 
  inner join t_score B 
  on A.course_id = B.course_id
  group by A.course_id


列出选修”JAVA基础”课程的学生学号,学生姓名,课程名,分数，并按照成绩降序方式排序
select C.stu_id,C.stu_name,B.course_name,A.score
 from t_score A 
 inner join t_course B 
 on A.course_id = B.course_id
 inner join t_student C
 on A.stu_id = C.stu_id
 where  B.course_name = "JAVA基础"


列出参加考试的学生编号，学生姓名，班级编号，班级名，选修课程，课程成绩

select 
 A.stu_id,
 A.stu_name,
 B.class_id,
 B.class_name,
 D.course_name,
 C.score
 from t_student A 
 inner join t_class B  on A.class_id =  B.class_id
 inner join t_score C  on A.stu_id = C.stu_id
 inner join t_course D on C.course_id = D.course_id


列出”软件1”班和”软件2班”的参加考试学生编号，学生姓名，班级编号，班级名，选修课程，课程成绩
select 
 A.stu_id,
 A.stu_name,
 B.class_id,
 B.class_name,
 D.course_name,
 C.score
 from t_student A 
 inner join t_class B  on A.class_id =  B.class_id
 inner join t_score C  on A.stu_id = C.stu_id
 inner join t_course D on C.course_id = D.course_id
 where B.class_name = "软件1班" or B.class_name = "软件2班";


列出全校学生的学生编号，学生姓名，班级编号，班级名，选修课程，课程成绩(包括未选修未考试的学生)
select 
 A.stu_id,
 A.stu_name,
 B.class_id,
 B.class_name,
 D.course_name,
 C.score
 from t_student A 
 left join t_class  B  on A.class_id  = B.class_id
 left join t_score  C  on A.stu_id    = C.stu_id
 left join t_course D  on C.course_id = D.course_id
 order by  A.stu_id asc;

列出每一名学生的学号,姓名,班级名,选修数量
select 
 A.stu_id,
 A.stu_name,
 B.class_name,
 COUNT(C.course_id)
 from t_student A 
 left join t_class  B  on A.class_id  = B.class_id
 left join t_score  C  on A.stu_id    = C.stu_id
 group by A.stu_id

列出课程平均分大于80分的课程名和平均分，并按平均分降序方式排序
select 
 B.course_id,
 B.course_name, 
 AVG(A.score) 
 from t_score A 
 inner join t_course B 
 on A.course_id = B.course_id
 group by A.course_id
 having AVG(A.score)> 80
 order by AVG(A.score) desc;


列出选修人数大于2人的课程名和人数,并按照选修人数升序方式排序
select 
 B.course_id,
 B.course_name, 
 COUNT(A.stu_id) 
 from t_score A 
 inner join t_course B 
 on A.course_id = B.course_id
 group by A.course_id
 having COUNT(A.stu_id) >= 2 
 order by COUNT(A.stu_id)  asc;

列出每门课考试都及格的学生学号和学生姓名(60分为及格)
select 
 A.stu_id,
 B.stu_name
 from t_score A 
 inner join t_student B
 on A.stu_id = B.stu_id
 group by A.stu_id
 having MIN(score) >= 60


