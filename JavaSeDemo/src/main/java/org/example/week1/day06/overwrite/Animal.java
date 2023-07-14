package org.example.week1.day06.overwrite;
public class Animal {
	String name;
	Integer age;

	public Animal() {
	}

	public Animal(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	void run() {
		System.out.println("一只" + this.age + "岁的" + this.name + "在奔跑!~~");
	}

	void sound() {
		System.out.println("一只" + this.age + "岁的" + this.name + "在吼叫!~~");
	}
}
