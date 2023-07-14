package org.example.week2.day07.polymorphic.shape;

//子类 长方形
public class Rect extends MyShape{
    private double width;  
    private double height;
	
    public Rect() {
	}
    
	public Rect(double width, double height) {
		this.setWidth(width);
		this.setHeight(height);
	}

	//重写计算面积
	@Override
	public double getArea() {
		return width*height;
	}
	//重写计算周长
	@Override
	public double getLen() {
		return 2*(width+height);
	}
	

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
}
