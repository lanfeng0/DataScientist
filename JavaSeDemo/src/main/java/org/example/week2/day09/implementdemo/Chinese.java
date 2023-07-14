package org.example.week2.day09.implementdemo;


public class Chinese implements Person {

    //重写接口中的抽象方法
    @Override
    public void say() {
        System.out.println("说中文");
    }

}
