查询图书列表
select * from book;
查询类型列表
select * from book_type;



mysql多表的关联查询支持3种：内连接  左连接  右链接 
内连接语法：获取两张表的共同部分
语法： select * from A表 inner join B表 on A表.字段=B表.字段 where.....

查询所有图书的详细信息(包括类型名)
select * from book inner join book_type on book.book_type_id = book_type.type_id

多表关联操作建议对表取别名
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   inner join book_type B
   on A.book_type_id = B.type_id

查询"三国演义"的详细信息(包括类型名)
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A
   inner join book_type B
   on A.book_type_id = B.type_id
   where A.book_name = "三国演义";




左连接语法：保留左表的所有记录，右表没有与之对应则使用null填充。
select * from A表 left join B表 on A表.字段=B表.字段  where.....

查询全部图书的详细信息(包括类型名),包括未分配图书类型
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A left join book_type B
   on A.book_type_id = B.type_id


右连接语法：保留右表的记录
select * from A表 right join B表 on A表.字段=B表.字段 where.....

显示每种图书类型下的所有书籍
select A.book_id,A.book_name,A.price,B.type_id,B.type_name 
   from book A right join book_type B
   on A.book_type_id = B.type_id


显示“文学名著”类型的全部书籍
select A.book_id,A.book_name,A.price,B.type_id,B.type_name   
from book A inner join book_type B
on A.book_type_id = B.type_id
where B.type_name = "文学名著"

显示每一种图书类型的图书数量,总价格,平均价格
select B.type_id,B.type_name,COUNT(A.book_id),SUM(A.price),AVG(A.price)  
	from book A right join book_type B
	on A.book_type_id = B.type_id
	group by B.type_id;


多表的关联 2张以上
假设A B C D,这4张表有关联关系 
select * from A表 
	inner join B表 on A和B关联关系
  inner join C表 on A或B和C的关联关系
  inner join D表 on A或B或C和D的关联关系
  where ... group by 列 having 条件 order by 列 desc/asc limit a,b;






