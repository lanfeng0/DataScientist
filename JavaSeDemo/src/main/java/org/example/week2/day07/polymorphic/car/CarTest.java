package org.example.week2.day07.polymorphic.car;

public class CarTest {
	public static void main(String[] args) {
		CarTest test = new CarTest();
        //制造10辆车
	     for(int i = 0 ;i<10;i++) {
	    	 Car car = test.carFactory();  //Car car = new Bsj("","");
	    	 car.run();    //父类引用指向子类对象   调用方法  编译看左  运行看右
	     }
	}

	// 生成不同汽车的方法 Benz Bwm Bsj    返回值---多态
	public Car carFactory() {
		Car car = null;  //声明父类对象
		int x = (int) Math.round(Math.random() * 2); // 0-2的随机数
		//如果随机数等于0 生产宝马
		if (x == 0) {
			car = new Bmw("宝马", "白色");   //父类引用指向子类对象
		} else if (x == 1) {  ////如果随机数等于1生产奔驰
			car = new Benz("奔驰", "白色");
		} else { //如果随机数等于2 生产保时捷
			car = new Bsj("保时捷", "黑色");
		}
       return car;   //返回值 是父类类型，实际是各种子类对象
	}

}
