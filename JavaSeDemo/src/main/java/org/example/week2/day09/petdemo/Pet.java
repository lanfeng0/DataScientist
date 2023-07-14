package org.example.week2.day09.petdemo;


//宠物类 -- 父类  提取共同的属性和方法
public abstract class Pet {
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

	//打印方法    抽象方法
	public abstract void printInfo();
	
	//去医院  抽象方法  没有方法体的方法  
	public abstract void toHospital();
	
	//喂食
//	public void eat() {
//		
//	}
}
