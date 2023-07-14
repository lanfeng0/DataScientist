package org.example.week1.day05;

import java.util.Scanner;

public class MethodTest {

	/*
	 * 三个整数之和 
	 * （1）是否有返回值? 有 什么类型？int
	 *  (2)是否需要参数? 需要参数? 几个什么类型? 三个int类型的参数 
	 *  （3） 相加
	 * 
	 */

	public int addInt(int a, int b, int c) {
		int sum = a + b + c; // 求和
		return sum;
	}

	// 定义一个方法，求三个数的平均数，并获取平均数。
	public int avgInt(int a, int b, int c) {
		int avg = (a + b + c) / 3; // 求和
		return avg;
	}

	/*
	 * 键盘录入两个数，返回两个数中的较大值
	 * 
	 * (1)方法是否有返回值，有 int 
	 * (2)方法是否需要参数，需要，需要几个什么类型的参数--两个 int
	 * (3)方法如何才能正确得到想要的结果。if(a>b){ a }
	 * 
	 */
	public int max(int a, int b) {
		int num;
		// 比较两个数返回最大的
		if (a > b) {
			num = a;
		} else {
			num = b;
		}
		return num;
	}

	/*
	 * 键盘录入两个数，比较两个数是否相等
	 * 
	 * (1)方法是否有返回值，有 boolean 
	 * (2)方法是否需要参数，需要，需要几个什么类型的参数？ 两个int
	 * (3)方法如何才能正确得到想要的结果。if(a==b){ true }{false}
	 * 
	 */

	public boolean compare(int a, int b) {
		boolean result;
		// 比较两个数是否相等 相等--true 不相等--false
		if (a == b) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	/*
	 * 没有返回值 没有参数的 键盘录入行数和列数，输出对应的星号 2 3 *** 
	 * (1)方法是否有返回值，没有 void
	 * (2)方法是否需要参数，需要，需要几个什么类型的参数？ 两个int 也可以不需要 
	 * (3)方法如何才能正确得到想要的结果。先循环行数 再循环列数
	 */
	public void printStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入行数:");
		int rows = sc.nextInt();
		System.out.println("请输入列数:");
		int cols = sc.nextInt();
		// 先循环行数 再循环列数
		for (int i = 1; i <= rows; i++) {
			// 再循环列数
			for (int j = 1; j <= cols; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MethodTest m1 = new MethodTest(); // 创建当前类的对象
		

		// 接收控制台输入的a b两个数
		 Scanner sc = new Scanner(System.in);
		 System.out.println("请输入第一个数:");
		 int a = sc.nextInt();
		 System.out.println("请输入第二个数:");
		 int b= sc.nextInt();
		 System.out.println("请输入第三个数:");
		 int c= sc.nextInt();
		 
		// 调用三个数相加的方法
	     int sum = m1.addInt(a,b,c); //通过对象名来调用方法，得到方法的返回值
	     System.out.println("三个整数之和:"+sum);
		 
	     //调用求三个数的平均数，并获取平均数。
	     int avg = m1.avgInt(a, b, c);
	     System.out.println("三个平均值:"+avg);
		 
	     // 调用比较两个数是否相等
		 boolean result = m1.compare(a, b);
		 System.out.println("是否相等："+result);

		 // 调用返回较大数的方法
		 int num = m1.max(a, b);
		 System.out.println("两个数中较大的值是:"+num);
		 
		 
		 //调用键盘录入行数和列数，输出对应的星形
		 m1.printStart();
         
	}
	

}
