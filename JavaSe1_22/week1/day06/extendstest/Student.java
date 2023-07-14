package org.example.week1.day06.extendstest;
//子类继承父类
public class Student extends Person {

    public Student(){}

    public Student(int age, String name) {
        super(age, name);
    }

    //学习
    public String learn(){
        return super.getName() + " is learning in class ";
    }

    public void printInfo() {
        System.out.println("名字："+getName()+"年龄"+getAge());
    }
}
