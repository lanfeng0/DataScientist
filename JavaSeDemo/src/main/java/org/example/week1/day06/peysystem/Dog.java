package org.example.week1.day06.peysystem;

//子类继承父类 可以使用父类非私有的成员变量和方法  
public class Dog extends Pet{
  String type = "dog成员";
  private String strain;
 //创建子类对象，在子类构造方法完成初始化之前，先调用父类的构造方法
  public Dog() {
	  super("柯基", 100, 80);  //调用父类的有三个参数的构造方法   ，super(...)必须放在第一条语句上
	  System.out.println("我是dog子类无参的构造方法");
}
  
  //创建子类对象，在子类构造方法完成初始化之前，先调用父类的构造方法
  public Dog(String name,int health,int love ) {
	  super(name, health, love);  //调用父类的有三个参数的构造方法 super(...)必须放在第一条语句上
	  System.out.println("我是dog子类无参的构造方法");
}
 
  public String getStrain() {
	  return strain;
  }
  
  public void printInfo() {
	  String type = "dog局部";
	  print();
	  System.out.print("\t 品种："+getStrain()+"\n");
//	  System.out.println(super.type);  //dog成员 
	  
  }
  
	public void test() {
		super.test();
		System.out.println("我是子类的test方法");
	}
  
}
