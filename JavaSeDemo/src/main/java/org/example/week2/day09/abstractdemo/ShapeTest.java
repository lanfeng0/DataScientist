package org.example.week2.day09.abstractdemo;

//图形案例的测试
public class ShapeTest {
    public static void main(String[] args) {
        Rect rect = new Rect(2, 3);
        Circle circle = new Circle(3);

        ShapeTest test = new ShapeTest();
        test.cul(rect);
        test.cul(circle);
    }

    //计算方法
    public void cul(MyShape ms) { //多态参数
        System.out.println(ms.getArea());
        System.out.println(ms.getLen());
    }
}
