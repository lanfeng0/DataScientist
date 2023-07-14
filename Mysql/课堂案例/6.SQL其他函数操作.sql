
1.左连接  右连接
select * from book LEFT JOIN book_type on book.book_type_id = book_type.type_id;
select * from book RIGHT JOIN book_type on book.book_type_id = book_type.type_id;

2.使用union和union all 合并两个结果集
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   left join book_type B
   on A.book_type_id = B.type_id
union
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   right join book_type B
   on A.book_type_id = B.type_id

select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   left join book_type B
   on A.book_type_id = B.type_id
union all
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   right join book_type B
   on A.book_type_id = B.type_id


用户搜索关键字"老"：可能是学生名字,可能老师名字,课程名
select stu_name as content from t_student where stu_name like '老%'
union all
select teacher_name from t_teacher where teacher_name like '老%'
union all
select course_name from t_course where course_name like '老%';


3、日期时间函数

select timestampdiff(MONTH,'2020-01-01','2020-08-07'); # 7
SELECT DATEDIFF('2013-01-13','2012-10-01'); # 104

select now();

create table datetime(
 id int not null primary key, 
 oper_datetime datetime,
 oper_date date,
 oper_time time
)

对datetime表进入插入
insert into datetime values(1,"2020-04-10 15:38:12","2020-04-10","15:38:12")

now()函数返回的是当前时间的年月日时分秒
curdate()函数返回的是年月日信息
curtime()函数返回的是当前时间的时分秒信息

insert into datetime values(4,NOW(),CURDATE(),CURTIME())

SELECT * FROM DATETIME;

select now(); # 2020-04-10 14:22:33
select SYSDATE();#2020-04-10 14:22:39
SELECT DATE(NOW()); # 2020-4-10
注意：now()与sysdate()类似，只不过now()在执行开始时就获取，而sysdate()可以在函数执行时动态获取。





