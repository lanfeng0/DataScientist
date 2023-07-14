package org.example.week2.day07.polymorphic.peysystem;

//宠物类 -- 父类  提取共同的属性和方法
public class Pet {
	private String name;  //名字
	private int health; //健康值
	private int love; //亲密度
   static int i = 3;
	//无参构造
	public Pet() {
	}

	// 有三个参数的构造方法
	public Pet(String name, int health, int love) {
		this.name = name;
		this.health = health;
		this.love = love;
	}

	//以下是get和set方法
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getLove() {
		return love;
	}
	
   
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setLove(int love) {
		this.love = love;
	}

	//打印方法
	public void printInfo() {
		System.out.print("宠物名称:" + getName() + "\t 爱心值：" + getLove() + "\t健康值：" + "" + getHealth());
	}
	
	//去医院
	public void toHospital() {
	   System.out.println("父类方法");
	}
}
