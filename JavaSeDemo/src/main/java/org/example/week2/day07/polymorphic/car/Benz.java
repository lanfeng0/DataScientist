package org.example.week2.day07.polymorphic.car;

public class Benz extends Car {

	public Benz() {
	}

	public Benz(String name, String color) {
		super(name, color);
	}

	@Override
	public void run() {
		System.out.println("Benz正在运行....");
	}

}
