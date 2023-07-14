package org.example.week2.day07.polymorphic.shape;

//子类
public class Cricle extends MyShape {
	private double r;
	private double pai = 3.14;

	public Cricle() {
	}

	public Cricle(double r) {
		this.r = r;
	}
	// 计算面积
	@Override
	public double getArea() {
		return pai * r * r;
	}

	// 计算周长
	@Override
	public double getLen() {
		return 2 * pai * r;
	}
	public double getR() {
		return r;
	}

	public void setR(double r) {
		this.r = r;
	}

	public double getPai() {
		return pai;
	}

	public void setPai(double pai) {
		this.pai = pai;
	}



}
