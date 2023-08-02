### 1.Udf

UDF：进来一个出去一个，row mapping。是row级别操作开发

### 原始数据

创建销售工资表

hive&gt; create table if not exists sale12(id bigint, sal float, sale
float ,mdate string)

row format delimited fields terminated by ',';

本地数据

\[hadoop@h201 hhh\]\$ cat sale12.txt

10001,5000,100500,20200202

10002,6000,600000,20200202

10003,5000,50000,20200202

10004,5000,280000,20200202

10005,8000,980000,20200202

10001,5000,205800,20200102

10002,6000,250000,20200102

导入数据

hive&gt; load data local inpath '/home/hadoop/hhh/sale12.txt' into table
sale12;

### 3.开发

开发流程

1.  集成UDF类

2.  重写evaluate方法

**package** com.hzr;\
**import** org.apache.hadoop.hive.ql.exec.UDF;\
**public class** myudf **extends** UDF {\
**public float** evaluate(**float** a, **float** b) {\
**if** (b&gt;100000 && b&lt;=200000) {\
**return** (**float**) (a+b\*0.05);\
} **else if**(b&gt;200000 && b&lt;=500000){\
**return** (**float**)(a+b\*0.08);\
} **else if**(b&gt;500000){\
**return** (**float**)(a+b\*0.15);\
}**else** {\
**return** a;\
}\
}\
}

### 4.生成jar包并执行

![a](E:\中软大数据\hive视频\hive课程\课件/2hive UDF/media/image1.png){width="5.5in"
height="5.197916666666667in"}

![a](E:\中软大数据\hive视频\hive课程\课件/2hive UDF/media/image2.png){width="5.541666666666667in"
height="4.052083333333333in"}

4.2拷贝到Linux上

\[hadoop@h201 \~\]\$ cp /ff/hivejar/udf1.jar /home/hadoop/qq/

4.3 执行udf

添加jar包到hive中

hive&gt; add jar /home/hadoop/qq/udf1.jar;

创建UDF函数 udf123

hive&gt; create temporary function udf123 as 'com.hzr.myudf';

显示字段名

hive&gt; set hive.cli.print.header=true;

应用UDF函数

hive&gt; select udf123(sal,sale) as gongzi from sale12;

结果：

gongzi

10025.0

96000.0

5000.0

27400.0

155000.0

21464.0

26000.0
