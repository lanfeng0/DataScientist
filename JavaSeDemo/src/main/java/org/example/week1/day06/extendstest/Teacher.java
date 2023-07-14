package org.example.week1.day06.extendstest;
/*教师子类*/
public class Teacher extends Person {

    public Teacher() {}

    public Teacher(int age, String name) {
        super(age, name);
    }

    //教学
    public String teach(){
        return " teacher " + super.getName() + " is teaching";
    }
    public void printInfo() {
        System.out.println("名字："+getName()+"年龄"+getAge());
    }
}
