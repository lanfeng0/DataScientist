1.mysql 创建用户和表

> \[root@h201 \~\]\# service mysqld start
>
> mysql&gt; create user 'sq' identified by 'sq123';
>
> mysql&gt; grant all privileges on \*.\* to 'sq'@'%' with grant option;
>
> mysql&gt; grant all privileges on \*.\* to sq@h201 identified by
> 'sq123';
>
> mysql&gt; grant all privileges on \*.\* to sq@192.168.8.66 identified
> by 'sq123';
>
> \[root@h201 \~\]\# mysql -h 192.168.8.201 -u sq -p
>
> mysql&gt; create database flink;
>
> mysql&gt; use flink;
>
> mysql&gt; create table t1(id int,name varchar(20));
>
> \[hadoop@h201 \~\]\$ mysql -h h201 -u hive -p
>
> mysql&gt; create database hivedb;
>
> mysql&gt; insert into t1 values(101,'zs');
>
> mysql&gt; insert into t1 values(102,'ls');
>
> mysql&gt; commit;

2.

**package** com.sq2;\
\
**import** org.apache.flink.streaming.api.datastream.DataStream;\
**import**
org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;\
**import**
org.apache.flink.streaming.api.functions.source.SourceFunction;\
\
**import** java.sql.Connection;\
**import** java.sql.DriverManager;\
**import** java.sql.ResultSet;\
**import** java.sql.Statement;\
\
**public class** source4 {\
**public static void** main(String\[\] args) **throws** Exception {\
StreamExecutionEnvironment env =
StreamExecutionEnvironment.*getExecutionEnvironment*();\
DataStream input3 = env.addSource(**new** ss1());\
input3.print();\
env.execute(**"sss"**);\
}\
**public static class** ss1 **implements** SourceFunction&lt;String&gt;
{\
**private static final** String
***URL***=**"jdbc:mysql://192.168.8.201:3306/flink"**;\
**private static final** String ***USER***=**"sq"**;\
**private static final** String ***PASSWORD***=**"sq123"**;\
**private boolean isRunning** = **true**;\
@Override\
**public void** run(SourceContext&lt;String&gt; sourceContext)
**throws** Exception {\
Class.*forName*(**"com.mysql.jdbc.Driver"**);\
Connection conn = DriverManager.*getConnection*(***URL***, ***USER***,
***PASSWORD***);\
Statement stmt = conn.createStatement();\
ResultSet rs = stmt.executeQuery(**"select** *\** **from t1"**);\
**while**(rs.next()){\
String id = rs.getString(**"id"**);\
String name = rs.getString(**"name"**);\
String row1 = id+**" "**+name;\
sourceContext.collect(row1);\
Thread.*sleep*(1000);\
}\
}\
@Override\
**public void** cancel() {\
**isRunning** = **false**;\
}\
}\
}
