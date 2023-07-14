package org.example.week2.day09.abstractdemo;

public class Circle extends MyShape {
    private double r;
    private double pai = 3.14;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    //周长
    @Override
    public double getLen() {
        return 2 * r * pai;
    }

    //面积
    @Override
    public double getArea() {
        return pai * r * r;
    }

}
