1.  ### sqoop简介

    ![a](E:\中软大数据\hive视频\hive课程\课件/4sqoop/media/image1.png){width="5.756944444444445in"
    height="1.476388888888889in"}

    在实际的业务当中，我们首先对原始数据集通过MapReduce进行数据清洗，然后将清洗后的数据存入到Hbase数据库中，而后通过数据仓库Hive对Hbase中的数据进行统计与分析，分析之后将分析结果存入到Hive表中，然后通过Sqoop这个工具将我们的数据挖掘结果导入到MySql数据库中，最后通过Web将结果展示给客户。

    （1）Sqoop的概念

    Sqoop：SQL–to–Hadoop

    正如Sqoop的名字所示：Sqoop是一个用来将关系型数据库和Hadoop中的数据进行相互转移的工具，可以将一个关系型数据库(例如Mysql、Oracle)中的数据导入到Hadoop(例如HDFS、Hive、Hbase)中，也可以将Hadoop(例如HDFS、Hive、Hbase)中的数据导入到关系型数据库(例如Mysql、Oracle)中。

    ![a](E:\中软大数据\hive视频\hive课程\课件/4sqoop/media/image2.png){width="5.759722222222222in"
    height="2.4854166666666666in"}

<!-- -->

2.  Sqoop架构

    ![a](E:\中软大数据\hive视频\hive课程\课件/4sqoop/media/image3.png){width="5.759722222222222in"
    height="3.55625in"}

    Sqoop工具接收到客户端的shell命令或者Java
    api命令后，通过Sqoop中的任务翻译器(Task
    Translator)将命令转换为对应的MapReduce任务，而后将关系型数据库和Hadoop中的数据进行相互转移，进而完成数据的拷贝。

### sqoop安装

1.  解压缩软件包

    \[root@h201 \~\]\# mount //192.168.8.66/ISO /ff -o
    username=administrator,password=abc

    \[root@h201 \~\]\# su - hadoop

    \[hadoop@h201 \~\]\$ cp /ff/sqoop-1.4.5-cdh5.3.6.tar.gz .

    \[hadoop@h201 \~\]\$ tar -zxvf sqoop-1.4.5-cdh5.3.6.tar.gz

    \[hadoop@h201 \~\]\$ mv sqoop-1.4.5-cdh5.3.6 sqoop

2.  修改环境变量

    \[hadoop@h201 \~\]\$ vi .bash\_profile

    export SQOOP\_HOME=/home/hadoop/sqoop

    export PATH=\$SQOOP\_HOME/bin:\$PATH

    \[hadoop@h201 \~\]\$ source .bash\_profile

3.  sqoop配置文件

    \[hadoop@h201 sqoop\]\$ cp conf/sqoop-env-template.sh
    conf/sqoop-env.sh

    \[hadoop@h201 sqoop\]\$ vi conf/sqoop-env.sh

    添加：

    export HADOOP\_COMMON\_HOME=/home/hadoop/hadoop-2.7.2

    export HADOOP\_MAPRED\_HOME=/home/hadoop/hadoop-2.7.2

    export HIVE\_HOME=/home/hadoop/hive1.2

    拷贝mysql驱动包

    \[hadoop@h201 \~\]\$ cp /ff/mysql-connector-java-5.1.27.jar
    sqoop/lib/


