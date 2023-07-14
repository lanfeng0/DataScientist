package org.example.week2.day12.outerclass;
//静态内部类
//外部类
public class OuterClass2 {
	private static String name = "jack";  //静态成员变量
	private int age;//成员变量
	//静态内部类
	static class InnerClass{
		static String staticName = "lucy";  //内部类 静态成员变量
		//内部类静态方法
		static void display() {
			System.out.println(name); //调用外部类的静态成员变量，无法调用外部类的非静态变量和方法
		}
		 void display1() {
			System.out.println("成员方法"+name); //调用外部类的静态成员变量，无法调用外部类的非静态变量和方法
		}
	}
	//外部类的成员方法
	void display() {
	   System.out.println(InnerClass.staticName);   //可以通过内部类的名字直接调用静态成员变量
	   InnerClass.display();   //可以通过内部类的名字直接调用静态成员方法
	 //static内部类构建对象不要依赖外部类对象---- 创建内部类对象，通过对象调用方法
	   new InnerClass().display1();
	}
	public static void main(String[] args) {
		OuterClass2 outer  = new OuterClass2();  //创建外部类对象
		outer.display(); //调用外部类的成员方法
	}
}
