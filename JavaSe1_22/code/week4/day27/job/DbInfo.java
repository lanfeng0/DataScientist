package org.example.week4.day27.job;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
1.创建一个实体类，接收解析出来的数据 ---ConfigInfo
2.创建DbInfo类--编写读取properties文件的方法，把值取出，给实体对象赋值
3.DbInfo类单例模式--提供共有方法，返回DbInfo的对象
4.在构造方法，创建ConfigInfo对象，并调用读取文件的方法。
5.提供几个get方法，返回数据的属性值
 */
public class DbInfo {
    volatile private static DbInfo dbInfo = null;  //私用静态的成员变量  volatile--保证可见性
    private ConfigInfo configInfo = null;  //读取文件的属性值保存到此对象中

    //私有的构造方法--不让其它类来创建对象
    private DbInfo() {
        //1.创建ConfigInfo对象
        configInfo = new ConfigInfo();
        //2.调用读取文件的方法
        getProperties();
    }

    //提供公有方法，返回DbInfo的对象
    public static DbInfo getInstance() {
        if (dbInfo == null) {
            synchronized (DbInfo.class) {  //懒汉式单例，使用双检查锁机制，保证线程安全
                if (dbInfo == null) {
                    dbInfo = new DbInfo();
                }
            }
        }
        return dbInfo;
    }


    //获取dbDriver的值
    public String getDbDriver() {
        return configInfo.getDbDriver();
    }

    //获取dbDriver的值
    public String getDbURL() {
        return configInfo.getDbURL();
    }

    //获取dbDriver的值
    public String getUserName() {
        return configInfo.getUserName();
    }

    //获取dbDriver的值
    public String getPassword() {
        return configInfo.getPassword();
    }


    // 编写读取properties文件的方法，把值取出，给实体对象赋值
    private void getProperties() {
        FileInputStream fis = null;
        try {
            // 1.获取文件路径
            // getResource("/")此路径不包含包的路径，代码编译之后是在bin文件夹下运行的
            // getResource(".")此路径包含包的路径
            String url = DbInfo.class.getResource("/").getPath() + "db.properties";
            System.out.println(url);
            // 2.创建Properties对象
            Properties properties = new Properties();
            // 3.加载
            fis = new FileInputStream(new File(url));
            properties.load(fis);
            // 4.取值并存放到实体类中
            configInfo.setDbDriver(properties.getProperty("dbDriver"));
            configInfo.setDbURL(properties.getProperty("dbURL"));
            configInfo.setUserName(properties.getProperty("userName"));
            configInfo.setPassword(properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5.关闭资源
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
