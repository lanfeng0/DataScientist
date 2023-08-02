### 1.索引的作用

Hive支持索引，但是Hive的索引与关系型数据库中的索引并不相同，比如，Hive不支持主键或者外键。

Hive索引可以建立在表中的某些列上，以提升一些操作的效率，例如减少MapReduce任务中需要读取的数据块的数量。

在可以预见到分区数据非常庞大的情况下，索引常常是优于分区的。

虽然Hive并不像事物数据库那样针对个别的行来执行查询、更新、删除等操作。它更多的用在多任务节点的场景下，快速地全表扫描大规模数据。但是在某些场景下，建立索引还是可以提高Hive表指定列的查询速度。（虽然效果差强人意）

为什么要创建索引？

Hive的索引目的是提高Hive表指定列的查询速度。

没有索引时，类似'WHERE tab1.col1 = 10'
的查询，Hive会加载整张表或分区，然后处理所有的rows，

但是如果在字段col1上面存在索引时，那么只会加载和处理文件的一部分。

与其他传统数据库一样，增加索引在提升查询速度时，会消耗额外资源去创建索引和需要更多的磁盘空间存储索引。

Hive 0.7.0版本中，加入了索引。Hive 0.8.0版本中增加了bitmap索引。

### 2.索引管理

（1）创建索引

create index emp\_index on table emp(empno) as
'org.apache.hadoop.hive.ql.index.compact.CompactIndexHandler' with
deferred rebuild IN TABLE emp\_index\_table;

2.  填充索引数据

建立完索引之后 需要重建索引数据，会触发一个mr job

alter index emp\_index on emp rebuild;

（3）想要索引在查询时，生效，还得设置使用索引：默认是不使用的。

SET hive.input.format=org.apache.hadoop.hive.ql.io.HiveInputFormat;

SET hive.optimize.index.filter=true;

SET hive.optimize.index.filter.compact.minsize=0;

（4）查看索引测试表的创建的索引

show index on emp;

（5）查看索引数据

hive&gt; select \* from emp\_index\_table;

6.  删除索引

    drop index emp\_index on emp;


