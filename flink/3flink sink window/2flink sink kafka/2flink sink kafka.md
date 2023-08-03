1.

**package** com.sq1;\
\
**import**
org.apache.flink.api.common.serialization.SimpleStringSchema;\
**import** org.apache.flink.streaming.api.datastream.DataStream;\
**import**
org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;\
**import**
org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer;\
\
\
**public class** sk12 {\
**public static void** main(String\[\] args) **throws** Exception {\
StreamExecutionEnvironment env =
StreamExecutionEnvironment.*getExecutionEnvironment*();\
\
String topic = **"t55"**;\
DataStream&lt;String&gt; d1 =
env.socketTextStream(**"192.168.8.201"**,9999);\
FlinkKafkaProducer&lt;String&gt; kk = **new**
FlinkKafkaProducer&lt;String&gt;(**"192.168.8.201:9092"**,topic,**new**
SimpleStringSchema());\
kk.setWriteTimestampToKafka(**true**);\
d1.addSink(kk);\
env.execute(**"aaa"**);\
}\
}

Kafka上：

\[hadoop@h201 kafka\_2.11-1.1.0\]\$ bin/kafka-topics.sh --create
--zookeeper h201:2181,h202:2181,h203:2181 --replication-factor 2
--partitions 2 --topic t55

\[hadoop@h201 kafka\_2.11-1.1.0\]\$ bin/kafka-console-consumer.sh
--zookeeper h201:2181,h202:2181,h203:2181 --topic t55 --from-beginning
