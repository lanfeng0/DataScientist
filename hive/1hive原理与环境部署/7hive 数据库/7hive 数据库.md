1.  ### hive创建数据库

    hive&gt; create database test1;

    当名为test1的数据库当前不存在时才创建

    hive&gt; create database if not exists test1;

    创建数据库时指定位置，这个位置一般是在hdfs上的位置

    hive&gt; create database test2 location '/db/test2';

    查看已经创建的数据库

    hive&gt; show databases;

    在创建数据库时可以指定描述性信息

    hive&gt; create database test3 comment 'test3 database';

    通过describe database可以查看到数据库的详细信息

    hive&gt; describe database test1;

    数据库可以有一些描述性的键值对信息，在创建时添加

    hive&gt; create database test11 with dbproperties ('own'='hadoop',
    'day'='20200101');

2.  ### 删除库

    hive&gt; drop database if exists test11;

    删除非空库

    hive&gt; use test2;

    hive&gt; create table t2(id int);

    hive&gt; drop database if exists test2;

    删除时会报错，因为库中有对象

    方法1：

    先清空库中所有对象

    方法2：

    删库时在后面加上cascade，表示级联删除此数据库下的所有表

    hive&gt; drop database if exists test2 cascade;

    显示当前数据库名称

    hive&gt; set hive.cli.print.current.db=true;


