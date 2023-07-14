package org.example.week1.day06.extendstest;
public class Person {
    private int age;  //年龄
    private String name; //名字

    //无参构造
    public Person(){}

    //有参构造
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //吃的方法
    public String eat(){
        return name + "is eating";
    }

    //睡觉
    public String sleep(){
        return name + "is sleeping";
    }


    //年龄和名字的get（获取）和set（设置）方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
