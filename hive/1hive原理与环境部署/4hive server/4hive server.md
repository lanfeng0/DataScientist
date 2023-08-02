### 1.HiveServer 2

HiveServer 2(HS2)是一种服务，使客户端能够对Hive执行查询。HiveServer
2是HiveServer 1的继承者，HiveServer
1已被废弃。HS2支持多客户端并发和身份验证。它的设计是为了更好地支持开放API客户机，如JDBC和ODBC。HS2是一个作为复合服务运行的单个进程，它包括基于Thwift的Hive服务(TCP或HTTP)和用于WebUI的JettyWeb服务器。

Thrift是一种接口描述语言和二进制通讯协议，它被用来定义和创建跨语言的服务。它被当作一个远程过程调用（RPC）框架来使用，是由Facebook为“大规模跨语言服务开发”而开发的。

2.  ### 修改配置文件

    vi hive-site.xml

    &lt;property&gt;

    &lt;name&gt;hive.server2.thrift.port&lt;/name&gt;

    &lt;value&gt;10000&lt;/value&gt;

    &lt;/property&gt;

    &lt;property&gt;

    &lt;name&gt;hive.server2.thrift.bind.host&lt;/name&gt;

    &lt;value&gt;192.168.8.201&lt;/value&gt;

    &lt;/property&gt;

3.  ### 启动服务

    启动hadoop

    启动 mysql 服务

    启动 hiveserver2

    \[hadoop@h201 hive1.2\]\$ bin/hiveserver2

4.  ### 客户端测试

\[hadoop@h201 hive1.2\]\$ bin/beeline

beeline&gt; !connect jdbc:hive2://192.168.8.201:10000

Enter username for jdbc:hive2://192.168.8.201:10000: root

Enter password for jdbc:hive2://192.168.8.201:10000: \*\*\*\*\*\*

0: jdbc:hive2://192.168.8.201:10000&gt; show databases;

0: jdbc:hive2://192.168.8.201:10000&gt; show tables;
