package org.example.week4.day27.factory;

//工厂方法模式
//interface Car {
//	public void drive();
//}
//
//// 具体产品角色
//class Benz implements Car {
//	public void drive() {
//		System.out.println("Driving Benz ");
//	}
//}
//
//class Bmw implements Car {
//	public void drive() {
//		System.out.println("Driving Bmw ");
//	}
//}
//
//class Audi implements Car {
//	public void drive() {
//		System.out.println("Driving Audi ");
//	}
//}
//
//// 抽象产品角色，具体产品角色与简单工厂模式类似，只是变得复杂了些，这里略。
//// 抽象工厂角色
//interface Driver {
//	public Car driverCar();
//}
//
//class BenzDriver implements Driver {
//	public Car driverCar() {
//		return new Benz();
//	}
//}
//
//class BmwDriver implements Driver {
//	public Car driverCar() {
//		return new Bmw();
//	}
//}
//
//public class MagnateFactoryMethod {
//	public static void main(String[] args) {
//		try {
//			Driver driver = new BenzDriver();
//			Car car = driver.driverCar();
//			car.drive();
//		} catch (Exception e) {
//		}
//	}
//}
