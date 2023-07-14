package org.example.week1.day06.peysystem;

//宠物类 -- 父类  提取共同的属性和方法
public class Pet extends ExtendsTest{
	String name;
	private int health = 100;
	private int love = 100;
	String type = "pet成员";
    
	public Pet() {
		System.out.println("我是父类的无参的构造方法");
	}
	
	
	
	//有三个参数的构造方法
	public Pet(String name, int health, int love) {
		this.name = name;
		this.health = health;
		this.love = love;
		System.out.println("我是父类有三个参数的构造方法");
	}



	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getLove() {
		return love;
	}
	
	public void print() {
		  System.out.print("宠物名称:"+getName()+"\t 爱心值："+getLove()+"\t健康值："
		  		+ ""+getHealth());
	}
	
	public void test() {
		System.out.println("我是父类的test方法");
	}
	
}
