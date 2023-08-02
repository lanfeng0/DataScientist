sqoop
export是指将HDFS上的数据导出到RDBMS上，而在RDBMS上目标表要已经存在了

### 1.hdfs 导出到mysql

1）原始数据

\[hadoop@h201 \~\]\$ vi a.txt

101 zs 100000

102 ls 200000

（tab分割）

\[hadoop@h201 \~\]\$ hadoop fs -put a.txt /hive123

Mysql创建测试表

mysql&gt; create table c1(col1 int primary key,col2 varchar(50),coll3
int);

2）导出到mysql

\[hadoop@h201 \~\]\$ sqoop export --connect jdbc:mysql://h201/spark1
--username spark -password spark123 --export-dir /hive123/a.txt -m 1
--table c1 --fields-terminated-by '\\t'

结果：

![a](E:\中软大数据\hive视频\hive课程\课件/6sqoop 导出/media/image1.png){width="2.15625in"
height="1.125in"}

### export 更新数据

1.  原始数据

    \[hadoop@h201 \~\]\$ cat b.txt

    101 zs 50000

    103 ww 90000

    （101 跟任务1中的id相同，但coll3字段不同）

    \[hadoop@h201 \~\]\$ hadoop fs -put b.txt /hive123

    \[hadoop@h201 \~\]\$ cat c.txt

    103 ww 999999

    109 zl 850000

    \[hadoop@h201 \~\]\$ hadoop fs -put c.txt /hive123/

    2）参数说明

    --update-key 指定要更新的列

    --update-mode 对应的参数有两种updateonly或者allowinsert

    allowinsert：update-key字段存在的更新，不存在的插入

    updateonly：update-key字段存在的更新，不存在的丢弃

    3）allowinsert

    \[hadoop@h201 \~\]\$ sqoop export --connect jdbc:mysql://h201/spark1
    --username spark -password spark123 --export-dir /hive123/b.txt -m 1
    --table c1 --input-fields-terminated-by '\\t' --update-key col1
    --update-mode allowinsert

    结果：

    ![a](E:\中软大数据\hive视频\hive课程\课件/6sqoop 导出/media/image2.png){width="2.125in"
    height="1.25in"}

    101 对应的coll3 已经更新

<!-- -->

4)  Updateonly

    \[hadoop@h201 \~\]\$ sqoop export --connect jdbc:mysql://h201/spark1
    --username spark -password spark123 --export-dir /hive123/c.txt -m 1
    --table c1 --input-fields-terminated-by '\\t' --update-key col1
    --update-mode updateonly

    结果：

    ![a](E:\中软大数据\hive视频\hive课程\课件/6sqoop 导出/media/image3.png){width="2.0625in"
    height="1.28125in"}

    103的值已经更新，但109被丢弃

<!-- -->

2.  ### 批量导出

    虽然Sqoop的导出功能符合需要,
    但速度太慢。每一行都插入到单独的insert语句中,是否有方法将多个insert语句一起批处理

    --batch 指定是否使用批量处理。默认是一条一条记录处理

\[hadoop@h201 \~\]\$ sqoop export --connect jdbc:mysql://h201/spark1
--username spark -password spark123 --export-dir /hive123/a.txt -m 1
--table c1 --fields-terminated-by '\\t' --batch
