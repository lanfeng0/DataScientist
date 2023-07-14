package org.example.week2.day07.polymorphic.peysystem;

//子类继承父类 可以使用父类非私有的成员变量和方法  
public class Dog extends Pet {
	private String strain;  //品种
	int i = 4;

	// 创建子类对象，在子类构造方法完成初始化之前，先调用父类的构造方法
	public Dog() {
	}

	// 创建子类对象，在子类构造方法完成初始化之前，先调用父类的构造方法
	public Dog(String name, int health, int love,String strain) {
		super(name, health, love); // 调用父类的有三个参数的构造方法 super(...)必须放在第一条语句上
	    this.strain = strain;
	}

	
	
	//品种的get和set方法
	public String getStrain() {
		return strain;
	}
	

	public void setStrain(String strain) {
		this.strain = strain;
	}

	//打印
	public void printInfo() {
		super.printInfo();
		System.out.print("\t 品种：" + getStrain() + "\n");

	}
	
//	//给狗狗看病
	public void toHospital() {
		System.out.println("打针，吃药");
		super.setHealth(60);
	}

	//玩接飞盘游戏的方法
	public void catchingFlyDics() {
		setHealth(getHealth()-10);
		setLove(getLove()+5);
		System.out.println("玩接飞盘游戏，狗狗很开心");
	}
}
