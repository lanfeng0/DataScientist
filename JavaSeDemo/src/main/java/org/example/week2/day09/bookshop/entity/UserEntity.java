package org.example.week2.day09.bookshop.entity;

//实体类
//1. 属性---成员变量
//2.getter/setter方法(对属性的取值和赋值)
//3.构造方法有参(根据初始化需求)和无参
//4.重写toString方法（规范格式）
public class UserEntity {
    private int userId;  //用户id  唯一
    private String userName;  //
    private String pwd;

    //用户无参的构造方法
    public UserEntity() {
    }

    //用户有参的构造方法
    public UserEntity(int userId, String userName, String pwd) {
        this.userId = userId;
        this.userName = userName;
        this.pwd = pwd;
    }


    //成员变量的getter和setter方法
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //重写toString方法  ---  为了测试方便
    @Override
    public String toString() {
        return "UserEntity [userId=" + userId + ", userName=" + userName + ", pwd=" + pwd + "]";
    }

}
