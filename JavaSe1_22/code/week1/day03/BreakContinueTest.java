package org.example.week1.day03;

public class BreakContinueTest {
	public static void main(String[] args) {
		// test01(); //打印输出0-4中的所有奇数；continue的使用
		// test02(); // 多重循环时，continue默认是继续当前的循环；
		// test03(); //用continue 标号;语句继续指定的循环；
		// test04(); //打印输出0-4中的第一个偶数
		// test05();// 在多重循环时，break默认是终止当前的循环；
		// test06(); // 用break标号;语句终止指定的循环

	}

	// 用break标号;语句终止指定的循环
	private static void test06() {
		loop1: for (int i = 0; i < 5; i++) {

			loop2: for (int j = 0; j < 6; j++) {
				// 当i==j时，终止i循环
				if (i == j) {
					break loop1;
				}
				System.out.println("i=" + i + " j=" + j);
			}
			System.out.println("结束i循环的第" + i + "次循环");
		}
		System.out.println("结束i循环");

	}

	// 在多重循环时，break默认是终止当前的循环；
	private static void test05() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				// 当i==j时，终止j循环
				if (i == j) {
					break;
				}
				System.out.println("i=" + i + " j=" + j);
			}
			System.out.println("结束i循环的第" + i + "次循环");
		}
		System.out.println("结束i循环");

	}

	// 打印输出0-4中的第一个偶数
	private static void test04() {
		for (int i = 0; i < 5; i++) {
			// 判断i是偶数
			if (i % 2 != 0) {
				// 如果i不是偶数，则终止循环
				break;
			}
			// 输出i的值
			System.out.println("i=" + i);
		}

	}

	// 用continue 标号;语句继续指定的循环；
	private static void test03() {
		loop1: for (int i = 0; i < 5; i++) {

			loop2: for (int j = 0; j < 6; j++) {
				// 当i==j时，继续i循环
				if (i == j) {
					continue loop1;
				}
				System.out.println("i=" + i + " j=" + j);
			}
			System.out.println("外层循环");
		}
		System.out.println("结束循环");

	}

	// 多重循环时，continue默认是继续当前的循环；
	private static void test02() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				// 当i==j时，继续j循环
				if (i == j) {
					continue;
				}
				System.out.println("i=" + i + " j=" + j);
			}
			System.out.println("结束i循环的第" + i + "次循环");
		}
		System.out.println("循环结束");

	}

	// 打印输出0-4中的所有奇数；
	private static void test01() {
		// 1.初始值 int i= 0；
		// 2.判断条件 i<=4
		// 3.控制语句 i++
		for (int i = 0; i <= 4; i++) {
			// 4.循环体： 挑选出奇数，并输出
			if (i % 2 == 0) { // 偶数
				// continue; //结束本次循环，还会进入下一次循环
				break; // 结束整个循环(当前所在的循环)
			}
			System.out.println(i);
		}
	}
}
