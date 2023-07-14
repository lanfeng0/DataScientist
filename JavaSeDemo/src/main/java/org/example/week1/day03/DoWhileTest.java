package org.example.week1.day03;

public class DoWhileTest {
	public static void main(String[] args) {
//		test01();// do-while 打印5以内数字
//		test02(); //100以内偶数之和
//		test03();  //while和do-while循环对比案例
		
	}

	// while和do-while循环对比
	// 1.while--先判断再执行 do-while --- 先执行再判断
	// 2.当不满足条件是：while--一次都不会执行 do-while---会执行一次
	private static void test03() {
		// int i = 2;
		// do {
		// System.out.println(i);
		// }while(i>2);
		// 条件不满足，但是执行一次

		int i = 2;
		while (i > 2) {
			System.out.println(i);
		}
		// 条件不满足，一次都执行
	}

	// 1.初始值 int i = 0;
	// 2.判断条件语句 i<=100
	// 3.控制语句 i++
	// 4.循环体 ：挑选出偶数，相加 if(i%2==0){ sum+=i }
	private static void test02() {
		int i = 0; // 初始值
		int sum = 0;
		do {
			if (i % 2 == 0) { // 挑选出偶数，相加
				sum += i; // 求和
			}
			i++; // 控制语句
		} while (i <= 100); // 判断条件语句

		System.out.println("100以内偶数之和：" + sum);
	}
	
	
	//do-while 打印5以内数字
	public static void test01() {
		int c=0;
		do{
		     System.out.println("c="+c);
		     c++;
		}while(c<5);

	}
}
