Hive安装

1.1安装环境

> （1）Hadoop部署完成
>
> （2）jdk1.8
>
> （3）mysql部署
>
> 配置yum
>
> \[server\]
>
> name=server
>
> baseurl=file:///mnt/Server
>
> gpgcheck=0
>
> enabled=1
>
> \[root@h201 \~\]\# mount /dev/cdrom /mnt
>
> \[root@h201 \~\]\# yum -y install mysql\*
>
> \[root@h201 \~\]\# service mysqld start
>
> mysql&gt; create user 'hive' identified by 'hive123';
>
> mysql&gt; grant all privileges on \*.\* to 'hive'@'%' with grant
> option;
>
> mysql&gt; grant all privileges on \*.\* to hive@h201 identified by
> 'hive123';
>
> \[hadoop@h201 \~\]\$ mysql -h h201 -u hive -p
>
> mysql&gt; create database hivedb;

1.2 hive配置

\[hadoop@h201 \~\]\$ tar -zxvf apache-hive-1.2.2-bin.tar.gz

\[hadoop@h201 \~\]\$ mv apache-hive-1.2.2-bin hive1.2

配置环境变量

\[hadoop@h201 \~\]\$ vi .bash\_profile

export HIVE\_HOME=/home/hadoop/hive1.2

\[hadoop@h201 \~\]\$ source .bash\_profile

\[hadoop@h201 \~\]\$ cd \$HIVE\_HOME

\[hadoop@h201 conf\]\$ cp hive-default.xml.template hive-site.xml

\[hadoop@h201 conf\]\$ cp hive-default.xml.template hive-default.xml

\[hadoop@h201 conf\]\$ cp hive-env.sh.template hive-env.sh

\[hadoop@h201 conf\]\$ cp hive-exec-log4j.properties.template
hive-exec-log4j.properties

\[hadoop@h201 conf\]\$ cp hive-log4j.properties.template
hive-log4j.properties

\[hadoop@h201 \~\]\$ mkdir hive1.2/logs

\[hadoop@h201 \~\]\$ hadoop-2.7.2/bin/hadoop fs -mkdir -p
/hive/warehouse

1.3 mysql存储元数据

（1）

\[hadoop@h201 conf\]\$ vi hive-site.xml

&lt;property&gt;

&lt;name&gt;javax.jdo.option.ConnectionDriverName&lt;/name&gt;

&lt;value&gt;com.mysql.jdbc.Driver&lt;/value&gt;

&lt;description&gt;Driver class name for a JDBC
metastore&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;javax.jdo.option.ConnectionUserName&lt;/name&gt;

&lt;value&gt;hive&lt;/value&gt;

&lt;description&gt;Username to use against metastore
database&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;javax.jdo.option.ConnectionPassword&lt;/name&gt;

&lt;value&gt;hive123&lt;/value&gt;

&lt;description&gt;password to use against metastore
database&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;javax.jdo.option.ConnectionURL&lt;/name&gt;

&lt;value&gt;jdbc:mysql://h201:3306/hivedb?createDatabaseIfNotExist=true&amp;useSSL=false&lt;/value&gt;

&lt;description&gt;JDBC connect string for a JDBC
metastore&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;hive.metastore.warehouse.dir&lt;/name&gt;

&lt;value&gt;/hive/warehouse&lt;/value&gt;

&lt;description&gt;location of default database for the
warehouse，Hive在HDFS上的根目录&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;hive.exec.local.scratchdir&lt;/name&gt;

&lt;value&gt;/home/hadoop/hive1.2/exec&lt;/value&gt;

&lt;description&gt;Local scratch space for Hive jobs&lt;/description&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;hive.downloaded.resources.dir&lt;/name&gt;

&lt;value&gt;/home/hadoop/hive1.2/downloadedsource&lt;/value&gt;

&lt;description&gt;Temporary local directory for added resources in the
remote file system.&lt;/description&gt;

&lt;/property&gt;

（2）配置日志位置

\[hadoop@h201 conf\]\$ vi hive-log4j.properties

hive.log.dir=/home/hadoop/hive1.2/logs

（3）拷贝mysql驱动包

\[hadoop@h201 \~\]\$ cp mysql-connector-java-5.1.6.jar hive1.2/lib/

客户端启动hive

\[hadoop@h201 hive1.2\]\$ bin/hive
