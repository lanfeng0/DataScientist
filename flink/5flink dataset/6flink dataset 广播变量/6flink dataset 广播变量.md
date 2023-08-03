1.  ### 广播变量

    （1）广播变量允许编程人员在每台机器上保持1个只读的缓存变量，而不是传送变量的副本给tasks

    （2）广播变量创建后，它可以运行在集群中的任何function上，而不需要多次传递给集群节点。另外需要记住，不应该修改广播变量，这样才能确保每个节点获取到的值都是一致的。可以理解为是一个公共的共享变量，我们可以把一个dataset
    数据集广播出去，然后不同的task在节点上都能够获取到，这个数据在每个节点上只会存在一份。如果不使用broadcast，则在每个节点中的每个task中都需要拷贝一份dataset数据集，比较浪费内存(也就是一个节点中可能会存在多份dataset数据)。

<!-- -->

3.  与DataStreaming 中的Broadcast区别开来，DataStreaming
    中的Broadcast是把元素广播给所有的分区，数据会被重复处理，类似于storm中的allGrouping（调用方式
    dataStream.broadcast()）

<!-- -->

1.  ### 语法

    (1)：初始化数据 DataSet&lt;Integer&gt; toBroadcast =
    env.fromElements(1, 2, 3)

    (2)：广播数据 withBroadcastSet(toBroadcast, "broadcastSetName");

    (3)：获取数据 Collection&lt;Integer&gt; broadcastSet =
    getRuntimeContext().getBroadcastVariable("broadcastSetName");

    注意：

    (1)广播出去的变量存在于每个节点的内存中，所以这个数据集不能太大。因为广播出去的数据，会常驻内存，除非程序执行结束

    (2)广播变量在初始化广播出去以后不支持修改，这样才能保证每个节点的数据都是一致的。

2.  ### 开发

**package** com.zrr;\
\
**import** org.apache.flink.api.common.functions.MapFunction;\
**import** org.apache.flink.api.common.functions.RichMapFunction;\
**import** org.apache.flink.api.java.DataSet;\
**import** org.apache.flink.api.java.ExecutionEnvironment;\
**import** org.apache.flink.api.java.operators.MapOperator;\
**import** org.apache.flink.api.java.tuple.Tuple2;\
**import** org.apache.flink.configuration.Configuration;\
\
**import** java.util.ArrayList;\
**import** java.util.HashMap;\
**import** java.util.List;\
\
**public class** ds5 {\
**public static void** main(String\[\] args) **throws** Exception {\
ExecutionEnvironment env =
ExecutionEnvironment.*getExecutionEnvironment*();\
\
\
List&lt;Tuple2&lt;String, String&gt;&gt; b1 = **new**
ArrayList&lt;&gt;();\
b1.add(**new** Tuple2&lt;&gt;(**"101"**, **"zs"**));\
b1.add(**new** Tuple2&lt;&gt;(**"102"**, **"ls"**));\
b1.add(**new** Tuple2&lt;&gt;(**"103"**, **"ww"**));\
\
DataSet&lt;Tuple2&lt;String, String&gt;&gt; tuple2broadCastData =
env.fromCollection(b1);\
\
DataSet&lt;HashMap&lt;String, String&gt;&gt; sd1 =
tuple2broadCastData.map(**new** MapFunction&lt;Tuple2&lt;String,
String&gt;, HashMap&lt;String, String&gt;&gt;() {\
@Override\
**public** HashMap&lt;String, String&gt; map(Tuple2&lt;String,
String&gt; value) **throws** Exception {\
HashMap&lt;String, String&gt; map = **new** HashMap&lt;&gt;();\
map.put(value.**f0**, value.**f1**);\
**return** map;\
}\
});\
List&lt;Tuple2&lt;String, Integer&gt;&gt; l2 = **new**
ArrayList&lt;&gt;();\
l2.add(**new** Tuple2&lt;&gt;(**"101"**, 10000));\
l2.add(**new** Tuple2&lt;&gt;(**"102"**, 20000));\
l2.add(**new** Tuple2&lt;&gt;(**"103"**, 30000));\
DataSet&lt;Tuple2&lt;String, Integer&gt;&gt; sd3 =
env.fromCollection(l2);\
\
DataSet&lt;String&gt; result = sd3.map(**new**
RichMapFunction&lt;Tuple2&lt;String, Integer&gt;, String&gt;() {\
List&lt;HashMap&lt;String, String&gt;&gt; **broadCastMap** = **new**
ArrayList&lt;HashMap&lt;String, String&gt;&gt;();\
HashMap&lt;String, String&gt; **allMap** = **new** HashMap&lt;String,
String&gt;();\
\
@Override\
**public void** open(Configuration parameters) **throws** Exception {\
**this**.**broadCastMap** =
getRuntimeContext().getBroadcastVariable(**"bm"**);\
**for** (HashMap&lt;String, String&gt; map : **broadCastMap**) {\
**allMap**.putAll(map);\
}\
}\
\
@Override\
**public** String map(Tuple2&lt;String, Integer&gt; t2) **throws**
Exception {\
String name = **allMap**.get(t2.**f0**);\
**return** name + **","** + t2.**f1**;\
}\
}).withBroadcastSet(sd1, **"bm"**);\
\
result.print();\
}\
}
