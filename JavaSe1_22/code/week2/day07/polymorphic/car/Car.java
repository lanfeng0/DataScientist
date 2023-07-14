package org.example.week2.day07.polymorphic.car;

//父类
public class Car {
	private String name; // 名字
	private String color; // 颜色

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Car() {
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	// 运行方法
	public void run() {
		System.out.println("父类的运行方法");
	}

}
