### pom.xml

&lt;**dependencies**&gt;\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hive&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hive-exec&lt;/**artifactId**&gt;\
&lt;**version**&gt;1.2.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;

&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hive&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hive-jdbc&lt;/**artifactId**&gt;\
&lt;**version**&gt;1.2.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;

&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hadoop&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hadoop-common&lt;/**artifactId**&gt;\
&lt;**version**&gt;2.7.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hadoop&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hadoop-hdfs&lt;/**artifactId**&gt;\
&lt;**version**&gt;2.7.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hadoop&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hadoop-mapreduce-client-core&lt;/**artifactId**&gt;\
&lt;**version**&gt;2.7.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;org.apache.hadoop&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;hadoop-client&lt;/**artifactId**&gt;\
&lt;**version**&gt;2.7.2&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
&lt;/**dependencies**&gt;

1.  ### idea 配置

    ![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image1.png){width="4.769444444444445in"
    height="6.219444444444444in"}

    因为IDEA没有内置hive的驱动，所以需要自己新建一个Driver

    ![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image2.png){width="3.9270833333333335in"
    height="5.541666666666667in"}

    **找到 pom依赖中，下载的hive jar路径**

    **找到 linux上hive安装目录下的lib中jar包都拷贝过来**

    ![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image3.png){width="5.761805555555555in"
    height="2.032638888888889in"}

    在次选中

    ![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image4.png){width="5.0in"
    height="3.34375in"}

    启动hiveserver

    \[hadoop@h201 hive1.2\]\$ bin/hiveserver2

    ![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image5.png){width="5.764583333333333in"
    height="2.4194444444444443in"}

2.  ### 使用控制台

右键连接名--》进入控制台

![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image6.png){width="4.447916666666667in"
height="3.9479166666666665in"}

![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image7.png){width="5.763194444444444in"
height="3.1333333333333333in"}

结果：

![a](E:\中软大数据\hive视频\hive课程\课件/4 hive idea开发环境配置/media/image8.png){width="5.7625in"
height="1.3423611111111111in"}

### jdbc 连接hive

**package** com.hzr;\
\
**import** java.sql.Connection;\
**import** java.sql.DriverManager;\
**import** java.sql.ResultSet;\
**import** java.sql.Statement;\
\
**public class** hivejdbc1 {\
**public static void** main(String\[\] args)**throws** Exception{\
String driverName =**"org.apache.hive.jdbc.HiveDriver"**;\
String URL=**"jdbc:hive2://192.168.8.201:10000"**;\
String USER=**"root"**;\
String PASSWORD=**"123456"**;\
\
Class.*forName*(driverName);\
Connection conn = DriverManager.*getConnection*(URL, USER, PASSWORD);\
Statement stmt = conn.createStatement();\
ResultSet rs = stmt.executeQuery(**"select** *\** **from aa"**);\
\
**while**(rs.next()){\
String id = rs.getString(**"id"**);\
String name = rs.getString(**"name"**);\
String num = rs.getString(**"num"**);\
String row1 = id+**" "**+name+**" "**+num;\
System.***out***.println(row1);\
Thread.*sleep*(1000);\
}\
}\
}
