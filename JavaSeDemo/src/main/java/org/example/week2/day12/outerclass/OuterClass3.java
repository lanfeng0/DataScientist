package org.example.week2.day12.outerclass;

//外部类   this和外部类this的区别
public class OuterClass3 {
	private int i = 10;  //外部类 成员变量
	
	//成员内部类
	public class InnerClass{  
		private int i = 100; //内部类的成员变量
		//内部类的方法
		void display() {
			System.out.println(this.i);  //当前内部类的成员变量
			System.out.println(OuterClass3.this.i); //外部类名.this.成员变量名   外部类的成员变量
		}
	}
	
	public static void main(String[] args) {
		OuterClass3 outer = new OuterClass3();  //创建外部类对象
		InnerClass inner = outer.new InnerClass();//通过外部类对象来创建成员内部类对象
		inner.display();   //调用成员内部类的方法
	}

}
