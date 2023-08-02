### sqoop命令

#### 1.1 命令帮助

\[hadoop@h201 \~\]\$ sqoop help

![a](E:\中软大数据\hive视频\hive课程\课件/5sqoop 导入/media/image1.png){width="5.145833333333333in"
height="2.7291666666666665in"}

\[hadoop@h201 \~\]\$ sqoop help import

（截取部分）

![a](E:\中软大数据\hive视频\hive课程\课件/5sqoop 导入/media/image2.png){width="5.677083333333333in"
height="4.645833333333333in"}

#### 1.2 基本命令

1.  列出mysql上的库

    \[hadoop@h201 \~\]\$ sqoop list-databases --connect
    jdbc:mysql://h201:3306/ --username spark --password spark123

2.  列出mysql上spark1库中的所有表

    \[hadoop@h201 \~\]\$ sqoop list-tables --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123

3.  根据关系型数据库中的表创建hive中的表

    \[hadoop@h201 \~\]\$ sqoop create-hive-table --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table f1 --hive-table hf1

    ![a](E:\中软大数据\hive视频\hive课程\课件/5sqoop 导入/media/image3.png){width="2.9166666666666665in"
    height="0.8229166666666666in"}

4.  Eval

    sqoop下 使用sql语句对 关系型数据库进行操作

    \[hadoop@h201 \~\]\$ sqoop eval --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --query "select \* from f2"

    \[hadoop@h201 \~\]\$ sqoop eval --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --query "insert into f2 values('hangzhou',100)"

### 数据导入

1.  #### 从RDBMS导入到HDFS中

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table f1 --target-dir /hive123 --fields-terminated-by '\\t' -m 1

    解释：

    fields-terminated-by '\\t 分隔符

    -m map task数量

    \[hadoop@h201 hadoop-2.7.2\]\$ hadoop fs -cat /hive123/part-m-00000

    202001 shanghai 28

    202001 hubei 4950

    202001 hebei 700

    202001 beijing 342

    202001 hunan 301

2.  #### 从RDBMS导入到HDFS中（where条件）

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --where "province='hubei'" --table f1 --target-dir /hive123/f1hb
    --fields-terminated-by '\\t' -m 1

    \[hadoop@h201 hadoop-2.7.2\]\$ hadoop fs -cat
    /hive123/f1hb/part-m-00000

    202001 hubei 4950

3.  #### 从RDBMS导入到HDFS中（指定列）

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --columns "province,msum" --where "province='hubei'" --table f1
    --target-dir /hive123/f1hb1 --fields-terminated-by '\\t' -m 1

    \[hadoop@h201 hadoop-2.7.2\]\$ hadoop fs -cat
    /hive123/f1hb1/part-m-00000

    hubei 4950

4.  #### 自定义sql查询

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --target-dir /hive123/f1hb2 --query 'select mdate,msum from f1 where
    province="hubei" and \$CONDITIONS' --fields-terminated-by '\\t' -m 1

    **注意：**

    **query的where条件当中必须有\$CONDITIONS'这个条件，这个条件就相当于一个占位符，动态接收传过来的参数，从而查询出符合条件的结果**

    \[hadoop@h201 hadoop-2.7.2\]\$ hadoop fs -cat
    /hive123/f1hb2/part-m-00000

    202001 4950

5.  #### 并发导入

    如果导入的数据较大的化，我们需要多个map task执行，如：-m
    10，设置多个map task必须指定分割条件split-by

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table f1 --target-dir /hive123/f1hb3 --fields-terminated-by '\\t'
    --split-by msum -m 2

    输出目录中有两个数据文件（map task为2）

    \[hadoop@h201 hadoop-2.7.2\]\$ hadoop fs -lsr /hive123/f1hb3

-rw-r--r-- 2 hadoop supergroup 0 2020-05-05 18:32
/hive123/f1hb3/\_SUCCESS

-rw-r--r-- 2 hadoop supergroup 72 2020-05-05 18:32
/hive123/f1hb3/part-m-00000

-rw-r--r-- 2 hadoop supergroup 18 2020-05-05 18:32
/hive123/f1hb3/part-m-00001

Split-by原理：

![a](E:\中软大数据\hive视频\hive课程\课件/5sqoop 导入/media/image4.png){width="5.764583333333333in"
height="0.2326388888888889in"}

split-by
根据不同的参数类型有不同的切分方法，如int型，Sqoop会取最大和最小split-by字段值，然后根据传入的num-mappers来
确定划分几个区域。比如select max(split\_by),min(split-by)
from得到的max(split-by)和min(split-by)分别为1000和1，而num-mappers（-m）为2的话，则会分成两个区域
(1,500)和(501-1000),同时也会分成2个sql给2个map去进行导入操作，分别为select
XXX from table where split-by&gt;=1 and split-by&lt;500和select XXX from
table where split-by&gt;=501 and
split-by&lt;=1000.最后每个map各自获取各自SQL中的数据进行导入工作

1.  #### 空值处理

    mysql&gt; create table s2 (id int,name varchar(50),sal double);

    mysql&gt; insert into s2 values(101,'zs',20000);

    mysql&gt; insert into s2 (id,name)values(102,'ls');

    mysql&gt; insert into s2 (id)values(103);

    mysql&gt; commit;

    mysql&gt; select \* from s2;

    +------+------+-------+

    | id | name | sal |

    +------+------+-------+

    | 101 | zs | 20000 |

    | 102 | ls | NULL |

    | 103 | NULL | NULL |

    +------+------+-------+

    \[hadoop@h201 \~\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table s2 --target-dir /hive123/ff2 --null-string ''
    --null-non-string 0 -m 1

    结果：

    \[hadoop@h201 \~\]\$ hadoop fs -cat /hive123/ff2/part-m-00000

    101,zs,20000.0

    102,ls,0

    103,,0

<!-- -->

1.  ### 增量导入

    事实上，在生产环境中，系统可能会定期从与业务相关的关系型数据库向Hadoop导入数据，导入数仓后进行后续离线分析。故我们此时不可能再将所有数据重新导一遍，此时我们就需要增量数据导入这一模式了。

    增量数据导入分两种，一是基于递增列的增量数据导入（Append方式）。二是基于时间列的增量数据导入（LastModified方式）。

    创建原始数据

    \[hadoop@h201 \~\]\$ mysql -h h201 -u spark -p

    mysql&gt; use spark1

    mysql&gt; create table s1 (id int,name varchar(50),mdate timestamp
    not null default current\_timestamp);

    mysql&gt; insert into s1 (id,name)values(1,'zs');

    mysql&gt; insert into s1 (id,name)values(2,'ls');

    mysql&gt; commit;

<!-- -->

1.  Append方式

    1）全量导入

    \[hadoop@h201 hadoop-2.7.2\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table s1 --target-dir /hive123/hs1 --fields-terminated-by '\\t' -m
    1

    结果：

    \[hadoop@h201 \~\]\$ hadoop fs -cat /hive123/hs1/part-m-00000

    1 zs 2020-05-05 19:51:26.0

    2 ls 2020-05-05 19:51:33.0

    2）增量导入

    插入新的数据

    mysql&gt; insert into s1 (id,name)values(3,'ww');

    mysql&gt; commit;

    \[hadoop@h201 \~\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table s1 -m 1 --target-dir /hive123/hs1-l2 --check-column id
    --incremental append --last-value 2

    解释

    --last-value 2 id字段大于2

    结果：

    \[hadoop@h201 \~\]\$ hadoop fs -cat /hive123/hs1-l2/part-m-00000

    3,ww,2020-05-05 19:59:31.0

    只有新插入的数据

2.  LastModified方式

    产生新的数据

    mysql&gt; insert into s1 (id,name)values(4,'zl');

    mysql&gt; commit;

    ![a](E:\中软大数据\hive视频\hive课程\课件/5sqoop 导入/media/image5.png){width="2.8645833333333335in"
    height="1.4166666666666667in"}

    \[hadoop@h201 \~\]\$ sqoop import --connect
    jdbc:mysql://h201:3306/spark1 --username spark --password spark123
    --table s1 -m 1 --target-dir /hive123/hs1-sj1 --check-column mdate
    --incremental lastmodified --last-value '2020-05-05 19:59:32'

    解释：

    --last-value '2020-05-05 19:59:32' 大于2020-05-05 19:59:32时间的数据

    结果：

    \[hadoop@h201 \~\]\$ hadoop fs -cat /hive123/hs1-sj1/part-m-00000

    4,zl,2020-05-05 20:04:11.0

    只有最新的数据

### 导入到hive

（1）创建hive中表

\[hadoop@h201 \~\]\$ sqoop create-hive-table --connect
jdbc:mysql://h201:3306/spark1 --username spark --password spark123
--table f1 --hive-table hivef1

2.  mysql spark1库中f1 导入到hive hivef1表中

    sqoop import --connect jdbc:mysql://h201:3306/spark1 \\

    --username spark \\

    --password spark123 \\

    -m 1 \\

    --table f1 \\

    --hive-database 'default' \\

    --hive-import \\

    --hive-overwrite \\

    --hive-table 'hivef1' \\

    --fields-terminated-by ' '

    结果：

hive&gt; select \* from hivef1;

OK

202001 shanghai 28

202001 hubei 4950

202001 hebei 700

202001 beijing 342

202001 hunan 301
