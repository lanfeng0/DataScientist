### hive 表压缩

1、TEXTFILE

　　对应hive
API为org.apache.hadoop.mapred.TextInputFormat和org.apache.hive.ql.io.HiveIgnoreKeyTextOutputFormat

　　hive不会对数据进行切分，从而无法对数据进行并行操作。

2、SequenceFile

　　可分割、可压缩，可进行切片。压缩支持NONE,RECORD,BLOCK（优先），可进行切片

3、rcfile

列式存储

压缩编码可以降低磁盘存储空间。由于同一列的数据类型是一样的，可以使用更高效的压缩编码进一步节约存储空间。

只读取需要的列，支持向量运算，能够获取更好的扫描性能。

4、orcfile

orcfile是对rcfile的优化，可以提高hive的读写、数据处理性能，提供更高的压缩效率。

create table hh(id int,name string)

row format delimited

fields terminated by '\\t'

stored as textfile;

hive&gt; load data local inpath '/home/hadoop/hh2/hh.txt' into table hh;

没开启压缩的大小

\[hadoop@h101 hh2\]\$ hadoop fs -ls /user/hive/warehouse/hh

-rw-r--r-- 2 hadoop supergroup 646464 2015-12-08 09:04
/user/hive/warehouse/hh/hh.txt

启动压缩

hive&gt; set hive.exec.compress.output=true;

hive&gt; set mapred.output.compress=true;

声明压缩格式 （Gzip）

hive&gt; set
mapred.output.compression.codec=org.apache.hadoop.io.compress.GzipCodec;

hive&gt; set
io.compression.codecs=org.apache.hadoop.io.compress.GzipCodec;

create table hh111(id int,name string)

row format delimited

fields terminated by '\\t'

stored as textfile;

hive&gt; insert overwrite table hh111 select \* from hh;

查看大小（大小为1970 明显小了很多）

\[hadoop@h101 hh2\]\$ hadoop fs -ls /user/hive/warehouse/hh111

-rw-r--r-- 2 hadoop supergroup 1970 2015-12-08 09:08
/user/hive/warehouse/hh111/000000\_0.gz
