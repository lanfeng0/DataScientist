package org.example.week1.day06.overwrite;

public class Tiger extends Animal {

	String color;

	public Tiger(String name, Integer age, String color) {
		super(name, age);

		this.color = color;
	}

	void hunt() {
		System.out.println("一只" + this.color + "的" + this.name + "在捕猎!~~");
	}

	void sound() {
		System.out.print("我是一只老虎~");
		super.sound();
	}
}
