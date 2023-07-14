package org.example.week2.day09.implementdemo;

//人类接口
public interface Person {
    public abstract void say();  //说的抽象方法

    //1.8 以后有   默认方法
    default void foo() {
        System.out.println("我是接口的默认方法");
    }
}
