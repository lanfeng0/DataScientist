package org.example.week1.day05;

/*
匿名类型，基本数据类型，引用数据类型当参数
 */
public class PassValueTest {
	int age = 10;

	// 匿名类型为参数
	public void print(PassValueTest t) {
		System.out.println("age=" + t.age);
	}

	// 基本数据类型传递的是值，独立的空间，相互不影响的。
	public void add(int x) {
		x++;
		System.out.println("add()方法：x=" + x);
	}

	// 引用数据类型传递的是地址
	public static void getValue(int[] arr) {
		arr[0] = 300;
	}

	public static void main(String[] args) {
		// 匿名类型为参数测试
		// PassValueTest test = new PassValueTest();
		// test.age = 20;
		// test.print(new PassValueTest());

		// 基本数据类型传递的是值，独立的空间，相互不影响的。
		// PassValueTest test=new PassValueTest();
		// int x=100;
		// test.add(x);
		// System.out.println("main()方法：x="+x);

		// 引用数据类型传递的是地址
		int[] arr = { 1, 3, 4, 100, 6, 80 };
		getValue(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

}
