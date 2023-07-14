package org.example.week2.day09.implementdemo;

//可擦铅笔   实现多个接口
public class PencilWithEraser implements Pencil, Eraser {
//public class PencilWithEraser  implements  InterfaceTest{

    //重写抽象方法
    @Override
    public void remove() {
        System.out.println("可以擦除文字");
    }

    //重写抽象方法
    @Override
    public void write() {
        System.out.println("正在写文字......");
    }

}
