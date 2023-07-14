package org.example.week2.day12.enumclass;

public class TrafficLight {
	Signal color = Signal.RED;//声明枚举类型，类名名.值
	public void change()
	{
		switch (color) {
		case GREEN:
			color = Signal.GREEN;
			System.out.println("GREEN");
			break;
		case YELLOW:
			color = Signal.YELLOW;
			System.out.println("YELLOW");
			break;
		case RED:
			color = Signal.RED;
			System.out.println("RED");
			break;
		}
	}
	
	public static void main(String[] args) {
		TrafficLight ff = new TrafficLight();
		ff.change();
	}
}
