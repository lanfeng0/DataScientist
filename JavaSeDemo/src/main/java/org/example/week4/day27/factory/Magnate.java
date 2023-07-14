package org.example.week4.day27.factory;

//简单工厂模式
//interface Car {
//	public void drive();
//}
//// 具体产品角色
//class Benz implements Car {
//	public void drive() {
//		System.out.println("Driving Benz ");
//	}
//}
//class Bmw implements Car {
//	public void drive() {
//		System.out.println("Driving Bmw ");
//	}
//}
//class Audi implements Car {
//	public void drive() {
//		System.out.println("Driving Audi ");
//	}
//}
//
//// 工厂类角色
//class Driver {
//	// 工厂方法.注意 返回类型为抽象产品角色
//	public static Car driverCar(String s) throws Exception {
//		// 判断逻辑，返回具体的产品角色给Client
//		if (s.equalsIgnoreCase("Benz"))
//			return new Benz();
//		else if (s.equalsIgnoreCase("Bmw"))
//			return new Bmw();
//		else if (s.equalsIgnoreCase("Audi"))
//			return new Audi();
//		else
//			throw new Exception();
//	}
//}
//
//
//public class Magnate {
//	public static void main(String[] args) {
//		try {
//			Car car = Driver.driverCar("benz");		
//			car.drive();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//	}
//}
