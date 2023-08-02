1.  删除数据

    1.1truncate

    仅删除表中数据，保留表结构

    hive&gt; truncate table t1;

    1.2 事务级操作 delete、update、insert

    （1）配置文件修改

    \[hadoop@h201 hive1.2\]\$ vi conf/hive-site.xml

    &lt;property&gt;

    &lt;name&gt;hive.support.concurrency&lt;/name&gt;

    &lt;value&gt;true&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.enforce.bucketing&lt;/name&gt;

    &lt;value&gt;true&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.exec.dynamic.partition.mode&lt;/name&gt;

    &lt;value&gt;nonstrict&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.txn.manager&lt;/name&gt;

    &lt;value&gt;org.apache.hadoop.hive.ql.lockmgr.DbTxnManager&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.compactor.initiator.on&lt;/name&gt;

    &lt;value&gt;true&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.compactor.worker.threads&lt;/name&gt;

    &lt;value&gt;1&lt;/value&gt;

    &lt;/property&gt;

    (2)

    **Delete 或update 操作时表得存储格式必须为ORC**

    **创建表时必须指定分桶和transactional**

    hive&gt; create table if not exists t3(id bigint, name string, age
    int)

    clustered by(id) into 2 buckets

    row format delimited fields terminated by ','

    stored as orc

    tblproperties('transactional'='true');

    hive&gt; insert into t3 select \* from t1;

    hive&gt; select \* from t3;

    OK

    60006 qq 70

    40004 zl 50

    20002 ls 30

    50005 tq 60

    30003 ww 40

    10001 zs 20

    hive&gt; update t3 set age=81 where id=10001;

    hive&gt; select \* from t3;

    OK

    60006 qq 70

    40004 zl 50

    20002 ls 30

    50005 tq 60

    30003 ww 40

    10001 zs 81

    hive&gt; delete from t3 where id=10001;

    hive&gt; insert into t3 values(10002,"ha",66);


