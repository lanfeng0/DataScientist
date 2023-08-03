Pom.xml

中添加依赖

&lt;dependency&gt;

&lt;groupId&gt;org.apache.flink&lt;/groupId&gt;

&lt;artifactId&gt;flink-connector-kafka\_2.11&lt;/artifactId&gt;

&lt;version&gt;1.7.2&lt;/version&gt;

&lt;/dependency&gt;

1.  开发

**package** com.sq1;\
\
**import** org.apache.flink.streaming.api.datastream.DataStreamSource;\
**import**
org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;\
**import**
org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;\
**import**
org.apache.flink.streaming.util.serialization.SimpleStringSchema;\
\
**import** java.util.Properties;\
\
**public class** sk1 {\
**public static void** main(String\[\] args) **throws** Exception {\
StreamExecutionEnvironment env =
StreamExecutionEnvironment.*getExecutionEnvironment*();\
\
String topic = **"t1"**;\
Properties prop = **new** Properties();\
prop.setProperty(**"bootstrap.servers"**,**"192.168.8.201:9092"**);\
prop.setProperty(**"group.id"**,**"flinkConsumer"**);\
prop.setProperty(**"auto.offset.reset"**,**"earliest"**);\
\
FlinkKafkaConsumer&lt;String&gt; consumer = **new**
FlinkKafkaConsumer&lt;String&gt;(topic, **new** SimpleStringSchema(),
prop);\
*//设置消费策略\
*consumer.setStartFromGroupOffsets();\
DataStreamSource&lt;String&gt; text = env.addSource(consumer);\
*//将并行度设置为1\
*text.print().setParallelism(1);\
env.execute(**"KafkaSourceExample"**);\
}\
}

1.  

<!-- -->

2.  Kafka创建 topic

\[hadoop@h201 kafka\_2.11-0.11.0.0\]\$ bin/kafka-topics.sh --create
--zookeeper h201:2181,h202:2181,h203:2181 --replication-factor 2
--partitions 3 --topic t1

启动生产者

bin/kafka-console-producer.sh --broker-list h201:9092 --topic t1

Flink上

\[hadoop@h201 flink-1.7.2\]\$ bin/start-scala-shell.sh local

\[hadoop@h201 flink-1.7.2\]\$ bin/start-cluster.sh

\[hadoop@h201 flink-1.7.2\]\$ bin/flink run flink12.jar --class
com.sq1.sk1

Kafka上输入内容

结果：

![](media/image1.png){width="2.5729166666666665in"
height="0.75in"}

1.

2.1 会话1:kafka上

删除之前的topic

\[hadoop@h201 kafka\_2.11-1.1.0\]\$ bin/kafka-topics.sh --delete
--zookeeper h201:2181,h202:2181,h203:2181 --topic t1

重新创建topic

bin/kafka-topics.sh --create --zookeeper h201:2181,h202:2181,h203:2181
--replication-factor 2 --partitions 3 --topic t1

2.2 会话2：h201启动nc

Nc -l 9999

2.3 会话3：

\[hadoop@h201 flink-1.7.2\]\$ bin/flink run /home/hadoop/flink12s.jar
--class com.sq1.sk2
