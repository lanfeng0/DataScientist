package org.example.week2.day07.polymorphic.car;

public class Bmw extends Car{
	
	public Bmw() {
	}

	public Bmw(String name, String color) {
		super(name, color);
	}
	
	@Override
	public void run() {
		System.out.println("Bmw正在运行");
	}

}
