package org.example.week2.day12.outerclass;

//局部内部类
//外部类
public class OuterClass1 {
	private String name;  //成员变量
	private int age;//成员变量
	//外部类的成员方法   
	public void display(int age1) {
		//局部内部类写在局部--方法里
		 class InnerClass{
		    //内部类的构造方法
			public InnerClass() {
				name = "jack";
				age = age1;  //可以调用外部类的成员变量，也可以调用成员方法的局部变量(方法的参数，常量等)
			}
			 //内部类的显示方法
			public void display() {
				System.out.println("name="+name+"  age="+age);
			}
		}
		InnerClass inner = new InnerClass();//创建内部类对象
		inner.display();  //调用内部类中的display方法
	}
	
	public static void main(String[] args) {
		OuterClass1 outer = new OuterClass1();   //创建外部类对象
		outer.display(13); //调用外部类的成员方法
	}
}
