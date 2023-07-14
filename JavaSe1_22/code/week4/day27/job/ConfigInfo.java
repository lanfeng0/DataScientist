package org.example.week4.day27.job;

//实体类，接收解析出来的数据
public class ConfigInfo {
    private String dbDriver;  //数据库驱动
    private String dbURL;  //数据库url
    private String userName;  //数据库的用户名
    private String password;  //数据库的密码

    public String getDbDriver() {
        return dbDriver;
    }

    public void setDbDriver(String dbDriver) {
        this.dbDriver = dbDriver;
    }

    public String getDbURL() {
        return dbURL;
    }

    public void setDbURL(String dbURL) {
        this.dbURL = dbURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
