package org.example.week2.day12.outerclass;

//成员内部类
//外部类
public class OuterClass {
	private String name;
	private int age;

	// 成员内部类可以直接使用外部类的成员变量
	public class InnerClass {
		// 内部类的构造方法
		public InnerClass() {
			name = "jack"; // 外部类的成员变量赋值
			age = 12;// 外部类的成员变量赋值
		}

		// 内部类的方法
		public void display() {
			System.out.println("name=" + name + "  age=" + age);
		}
	}

	public static void main(String[] args) {
		OuterClass outer = new OuterClass(); // 1.外部类的对象
		OuterClass.InnerClass inner = null;// 2.以外部类.内部类的形式进行声明
		inner = outer.new InnerClass(); // 3.以外部类对象.new 内部类构造方法()的方式构建对象
		inner.display(); // 调用内部类的方法
	}

}
