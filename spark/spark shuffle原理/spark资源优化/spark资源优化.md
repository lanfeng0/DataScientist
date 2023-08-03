1.cpu core数量
--------------

一个cpu core 执行一个task线程

task数： 若有 cpu core 2个、num-executor 2个 那么task有4个

公式：task = num-executor \* cpu core .

cpu core 共有50个。一个程序一般设置为总数量的1/3或1/2

driver ： 分配task 到每个work

从yarn申请资源（内存、申请cpu）

2.提交spark作业时，用的spark-submut shell脚本里调整对应的参数
-------------------------------------------------------------

spark-submit --class cn.spark.sparktest.core.WordCount

--num-executors 3 配置executor的数量

--driver-memory 100m 配置driver的内存（影响不大）

--executor-memory 100m 配置每个executor的内存大小 （很重要）

--executor-cores 3 配置每个executor的cpu core数量 SparkTest.jar

### 2.1num-executors（数量）　 

参数说明：

该参数用于设置Spark作业总共要用多少个Executor进程来执行。Driver在向YARN集群管理器申请资源时，YARN集群管理器会尽可能按照你的设置来在集群的各个工作节点上，启动相应数量的Executor进程。这个参数非常之重要，如果不设置的话，默认只会给你启动少量的Executor进程，此时你的Spark作业的运行速度是非常慢的。　
　

参数调优建议：

每个Spark作业的运行一般设置50\~100个左右的Executor进程比较合适，设置太少或太多的Executor进程都不好。设置的太少，无法充分利用集群资源；设置的太多的话，大部分队列可能无法给予充分的资源。（设置太大
会造成内存溢出。）

### 2.2executor-memory（内存）

参数说明：

该参数用于设置每个Executor进程的内存。Executor内存的大小，很多时候直接决定了Spark作业的性能，而且跟常见的JVM
OOM异常，也有直接的关联。　 　

参数调优建议：

每个Executor进程的内存设置4G\~8G较为合适。但是这只是一个参考值，具体的设置还是得根据不同部门的资源队列来定。可以看看自己团队的资源队列的最大内存限制是多少，num-executors乘以executor-memory，就代表了你的Spark作业申请到的总内存量（也就是所有Executor进程的内存总和），这个量是不能超过队列的最大内存量的。此外，如果你是跟团队里其他人共享这个资源队列，那么申请的总内存量最好不要超过资源队列最大总内存的1/3\~1/2，避免你自己的Spark作业占用了队列所有的资源，导致别的作业无法运行。

### 2.3executor-cores（CPU cores）

参数说明：

该参数用于设置每个Executor进程的CPU
core数量。这个参数决定了每个Executor进程并行执行task线程的能力。因为每个CPU
core同一时间只能执行一个task线程，因此每个Executor进程的CPU
core数量越多，越能够快速地执行完分配给自己的所有task线程。　　

参数调优建议：

Executor的CPU
core数量设置为2\~4个较为合适。同样得根据不同部门的资源队列来定，可以看看自己的资源队列的最大CPU
core限制是多少，再依据设置的Executor数量，来决定每个Executor进程可以分配到几个CPU
core。同样建议，如果是跟他人共享这个队列，那么num-executors \*
executor-cores(一共用cpu cores 的数量)不要超过队列总CPU
core的1/3\~1/2左右比较合适，也是避免影响其他同学的作业运行。
