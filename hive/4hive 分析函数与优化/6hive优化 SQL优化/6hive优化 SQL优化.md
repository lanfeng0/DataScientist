Hive是将符合SQL语法的字符串解析生成可以在Hadoop上执行的MapReduce的工具。使用Hive尽量按照分布式计算的一些特点来设计sql，和传统关系型数据库有区别，

### 1.减少查询范围

所以需要去掉原有关系型数据库下开发的一些固有思维。

基本原则：

尽量尽早地过滤数据，减少每个阶段的数据量,对于分区表要加分区，同时只选择需要使用到的字段

select ... from A

join B

on A.key = B.key

where A.userid&gt;10

and B.userid&lt;10

and A.dt='20120417'

and B.dt='20120417';

应该改写为：

select .... from (select .... from Awhere dt='201200417' and
userid&gt;10) a

join ( select .... from B where dt='201200417' and userid &lt; 10 ) b

on a.key = b.key;

### 2.解决user\_id为空不参与关联：

select \* from log a join users b on a.user\_id is not null and
a.user\_id = b.user\_id unoin all select \* from loga where a.user\_id
is null;

或者

select \* from log a left outer join users b on case when a.user\_id is
null then concat('hive',rand()) else a.user\_id end =b.user\_id;

### 3.使用分区

对历史库的计算经验 (这项是说根据不同的使用目的优化使用方法)

历史库计算和使用，分区

### 4.尽量原子化操作，尽量避免一个SQL包含复杂逻辑

可以使用中间表来完成复杂的逻辑

**5 jion操作**

小表要注意放在join的左边（目前TCL里面很多都小表放在join的右边）。

否则会引起磁盘和内存的大量消耗

### 6.union all操作

如果union
all的部分个数大于2，或者每个union部分数据量大，应该拆成多个insert into
语句，实际测试过程中，执行时间能提升50%

insert overwite table tablename partition (dt= ....)

select ..... from ( select ... from A

union all

select ... from B

union all

select ... from C ) R where ...;

可以改写为：

insert into table tablename partition (dt= ....)

select .... from A

WHERE ...;

insert into table tablename partition (dt= ....)

select .... from B

WHERE ...;

insert into table tablename partition (dt= ....)

select .... from C

WHERE ...;
