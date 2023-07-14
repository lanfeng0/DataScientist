package org.example.week1.day06.extendstest;

public class PersonTest {
    public static void main(String []args){
//    	创建对象
        Student stu = new Student(12, "Tom");
//        调用子类特有的方法
        System.out.println(stu.learn());
        stu.printInfo();
        Teacher teacher = new Teacher(20, "Sherry");
//      调用子类特有的方法
        System.out.println(teacher.teach());
        teacher.printInfo();
    }

}
