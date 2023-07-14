package org.example.week2.day07.polymorphic.car;

public class Bsj extends Car{
	public Bsj() {
	}

	public Bsj(String name, String color) {
		super(name, color);
	}
	
	@Override
	public void run() {
	   System.out.println("bsj很拉风......");
	}
	

}
