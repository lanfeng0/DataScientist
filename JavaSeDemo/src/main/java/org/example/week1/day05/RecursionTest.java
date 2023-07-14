package org.example.week1.day05;

//递归
public class RecursionTest {
	public static void main(String[] args) {
		int result = f(5);
		System.out.println(result);
	}

	//使用Java代码求5的阶乘
	public static int f(int n) {
		if (1 == n)
			return 1;
		else
			return n * f(n - 1);
	}

}
