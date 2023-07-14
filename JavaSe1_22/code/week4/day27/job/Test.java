package org.example.week4.day27.job;

public class Test {
    public static void main(String[] args) {
        //连接数据库
        DbInfo dbInfo = DbInfo.getInstance();
        System.out.println(dbInfo.getDbDriver());
        System.out.println(dbInfo.getDbURL());
        System.out.println(dbInfo.getUserName());
        System.out.println(dbInfo.getPassword());
    }
}
