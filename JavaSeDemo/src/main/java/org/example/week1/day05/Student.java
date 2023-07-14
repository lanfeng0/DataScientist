package org.example.week1.day05;

//学生类
public class Student {
	String name;// 姓名
	int age; // 年龄

	public Student() {// 创建一个对象时需要的方法
	}

	// 有参的构造方法
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	// 吃的方法
	public void eat() {
		System.out.println("吃的真香！！！");
	}

	public void sleep() {
		System.out.println("说的好听！！！");
	}

	{
		System.out.println("我是实例块");
	}
	static {
		System.out.println("我是静态块");
	}

	// 内部类
	class InnerClass {
	}

	public static void main(String[] args) {
		// 类名 对象名 = new 该类的构造方法();
		Student stu1 = new Student();
		Student stu2 = new Student("lily", 18);
		stu2.sleep();
		System.out.println("stu1的学生名字：" + stu1.name);
		System.out.println("stu2的学生名字：" + stu2.name);

		stu2.name = "lucy"; // 给属性赋值
		System.out.println(stu2.name); // 获取属性值
		stu2.eat(); // 调用类的方法，该方法中的操作将被执行

	}
}
