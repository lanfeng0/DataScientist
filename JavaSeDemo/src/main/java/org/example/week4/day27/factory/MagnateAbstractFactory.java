package org.example.week4.day27.factory;
//抽象工厂模式
interface Car{
	public void drive();
}

interface SportsCar extends Car{
	public boolean isConvertible();
}

interface BussinessCar extends Car{
	public boolean isAutoDoor();
}

// 具体产品角色
class BenzSprotsCar implements SportsCar {
	public void drive() {
		System.out.println("Driving Benz S");
	}

	@Override
	public boolean isConvertible() {
		// TODO Auto-generated method stub
		return true;
	}
}
class BenzBussinessCar implements BussinessCar {
	public void drive() {
		System.out.println("Driving Benz B");
	}

	@Override
	public boolean isAutoDoor() {
		// TODO Auto-generated method stub
		return false;
	}	
}

class BmwSprotsCar implements SportsCar {
	public void drive() {
		System.out.println("Driving Bmw S ");
	}

	@Override
	public boolean isConvertible() {
		return true;
	}
}
class BmwBussinessCar implements BussinessCar {
	public void drive() {
		System.out.println("Driving Bmw B ");
	}

	@Override
	public boolean isAutoDoor() {
		// TODO Auto-generated method stub
		return false;
	}	
}


interface CarFactory{
	public SportsCar getSportsCar();
	public BussinessCar getBussinessCar();
}

class BenzCarFactory implements CarFactory{

	@Override
	public SportsCar getSportsCar() {
		// TODO Auto-generated method stub
		return new BenzSprotsCar();
	}

	@Override
	public BussinessCar getBussinessCar() {
		// TODO Auto-generated method stub
		return new BenzBussinessCar();
	}
	
}

class BmwCarFactroy implements CarFactory{

	@Override
	public SportsCar getSportsCar() {
		// TODO Auto-generated method stub
		return new BmwSprotsCar();
	}

	@Override
	public BussinessCar getBussinessCar() {
		// TODO Auto-generated method stub
		return new BmwBussinessCar();
	}
	
}

// 抽象产品角色，具体产品角色与简单工厂模式类似，只是变得复杂了些，这里略。
// 抽象工厂角色
class AbstractCarFactory{
	
	public static CarFactory getCarFactory(String name){
		if("Benz".equals(name)){
			return new BenzCarFactory();
		}else if("Bmw".equals(name)){
			return new BmwCarFactroy();
		}else{
			throw new RuntimeException();
		}
	}
	
}



public class MagnateAbstractFactory {
	public static void main(String[] args) {
		try {
			CarFactory factory = AbstractCarFactory.getCarFactory("Bmw");
			BussinessCar car = factory.getBussinessCar();
			car.drive();
			System.out.println(car.isAutoDoor());
		} catch (Exception e) {
		}
	}
}
