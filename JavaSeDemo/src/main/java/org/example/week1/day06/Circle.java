package org.example.week1.day06;

//测试构造方法重载---引出this关键字
public class Circle {
	private double x, y, r;

	public Circle(double x1, double y1, double r1) {
		x = x1;
		y = y1;
		r = r1;
	}
	public Circle() {
		x = 0;
		y = 0;
		r = 15;
	}
	public Circle(double r1) {
		x = 0;
		y = 0;
		r = r1;
	}
	
	public static void main(String[] args) {
		Circle a = new Circle(20.1, 30.5, 10);
		Circle b = new Circle(32);
		Circle c = new Circle();
	}

}
