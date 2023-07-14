package org.example.week2.day07;

//访问权限控制
public class AccessControlTest1{
//   private  String name="alice";	  //private 只能本类中调用
//   private void test() {
//	   System.out.println(name);
//   }
   
	//默认不写，就是default权限，同一个包中的类都可以访问
//	String name = "alice";
//	void test() {
//	   System.out.println(name);
//	}
	
	//protected:受保护的，同一个类和同一个包、不同包中的子类，都可以访问
	protected String name = "alice";
	protected void test() {
	   System.out.println(name);
	}
	
	//public:同一个项目内，不同包 不同类 本类都可以访问
//	public String name = "alice";
//	public void test() {
//	   System.out.println(name);
//	}
}
