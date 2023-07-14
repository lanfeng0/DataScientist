package org.example.week2.day09.petdemo;


//子类继承父类 可以使用父类非私有的成员变量和方法  
public class Penguin extends Pet {
	private String sex;  //性别


	//无参构造  调用父类的无参构造
	public Penguin() {
	}

	//有参数的构造方法，调用父类有参的构造
	public Penguin(String name, int health, int love, String sex) {
		super(name, health, love);
		this.sex = sex;
	}

    
	//性别get和set方法
	public String getSex() {
		return sex;
	}
    
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void printInfo() {
		System.out.print("宠物名称:" + getName() + "\t 爱心值：" + getLove() + "\t健康值：" + "" + getHealth());
		System.out.print("\t 性别：" + getSex() + "\n");
	}
	
	//给企鹅看病
	public void toHospital() {
		System.out.println("吃药,疗养");
		super.setHealth(60);
	}
	
	//企鹅游泳
	public void swimming() {
		setHealth(getHealth()-10);
		setLove(getLove()+5);
		System.out.println("游泳，企鹅很开心");
	}
	
	public void eat() {
		System.out.println("企鹅吃辣椒酱");
	}
	
	
}
