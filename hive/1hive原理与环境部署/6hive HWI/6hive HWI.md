### WEBGUI:hive客户端提供了一种通过网页的方式访问hive所提供的服务。这个接口对应hive的hwi组件(hive web interface),使用前要启动hwi服务。 {#webguihive客户端提供了一种通过网页的方式访问hive所提供的服务这个接口对应hive的hwi组件hive-web-interface使用前要启动hwi服务 .ListParagraph}

### 1.下载源码包 {#下载源码包 .ListParagraph}

War文件安装包默认没有，需要下载源码包，解压缩后打包

\[hadoop@h201 \~\]\$ cp /ff/apache-hive-1.2.2-src.tar.gz /home/hadoop/

\[hadoop@h201 \~\]\$ tar -zxvf apache-hive-1.2.2-src.tar.gz

\[hadoop@h201 \~\]\$ cd apache-hive-1.2.2-src/hwi/

\[hadoop@h201 hwi\]\$ jar cfM hive-hwi-1.2.2.war -C web .

\[hadoop@h201 hwi\]\$ cp hive-hwi-1.2.2.war /home/hadoop/hive1.2/lib/

### 2.修改配置文件

Vi hive-site.xml

&lt;property&gt;

&lt;name&gt;hive.hwi.listen.host&lt;/name&gt;

&lt;value&gt;192.168.8.251&lt;/value&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;hive.hwi.listen.port&lt;/name&gt;

&lt;value&gt;19999&lt;/value&gt;

&lt;/property&gt;

&lt;property&gt;

&lt;name&gt;hive.hwi.war.file&lt;/name&gt;

&lt;value&gt;lib/hive-hwi-1.2.2.war&lt;/value&gt;

&lt;/property&gt;

### Pom.xml

&lt;**dependency**&gt;\
&lt;**groupId**&gt;tomcat&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;jasper-compiler&lt;/**artifactId**&gt;\
&lt;**version**&gt;5.5.23&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;tomcat&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;jasper-runtime&lt;/**artifactId**&gt;\
&lt;**version**&gt;5.5.23&lt;/**version**&gt;\
&lt;/**dependency**&gt;\
&lt;**dependency**&gt;\
&lt;**groupId**&gt;commons-el&lt;/**groupId**&gt;\
&lt;**artifactId**&gt;commons-el&lt;/**artifactId**&gt;\
&lt;**version**&gt;1.0&lt;/**version**&gt;\
&lt;/**dependency**&gt;

\[hadoop@h201hive1.2\]\$ cp /ff/jspjar/jasper-runtime-5.5.23.jar
/home/hadoop/hive1.2/lib/

\[hadoop@h201 hive1.2\]\$ cp /ff/jspjar/jasper-compiler-5.5.23.jar
/home/hadoop/hive1.2/lib/

\[hadoop@h201 hive1.2\]\$ cp /ff/jspjar/commons-el-1.0.jar
/home/hadoop/hive1.2/lib/

### 4.启动服务

\[hadoop@h201 hive1.2\]\$ bin/hive --service hwi

\[hadoop@h251 hive1.2\]\$ cp /usr/jdk1.8.0\_131/lib/tools.jar lib/

### 5.浏览器

![a](E:\中软大数据\hive视频\hive课程\课件/6hive HWI/media/image1.png){width="5.7659722222222225in"
height="2.5680555555555555in"}
