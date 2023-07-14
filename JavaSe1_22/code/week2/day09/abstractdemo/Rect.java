package org.example.week2.day09.abstractdemo;

//继承抽象类，那么就必须写抽象方法的具体实现，否则报错
public class Rect extends MyShape {
    private double width;
    private double height;

    public Rect() {
    }

    public Rect(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    //重写抽象方法
    @Override
    public double getLen() {
        return 2 * (width + height);
    }

    //重写抽象方法
    @Override
    public double getArea() {
        return width * height;
    }

}
