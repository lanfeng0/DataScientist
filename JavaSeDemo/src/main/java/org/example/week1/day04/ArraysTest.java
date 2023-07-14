package org.example.week1.day04;

import java.util.Arrays;

//数组工具
public class ArraysTest {
	public static void main(String[] args) {
		// test01();// 排序方法
		// test02(); // 查找
		test03(); // 数组拷贝
	}

	// 数组拷贝
	private static void test03() {
		int[] a = { 10, 100, 1000 };
		int[] b = { 20, 200, 2000, 20000 };
		System.arraycopy(a, 1, b, 2, 2);
		for (int x : b) {
			System.out.println(x);
		}

	}

	// 查找
	private static void test02() {
		int[] ary = { 1, 2, 3, 4 };
		int key = 3;
		// 查找arr数组中的元素索引
		System.out.println(Arrays.binarySearch(ary, key));
	}

	// 排序方法
	private static void test01() {
		int[] ary = { -3, 2, -100, -1, -20 }; // 数组
		Arrays.sort(ary); // 排序的方法

		// 增强for循环
		for (int i : ary) {
			System.out.println(i);
		}
	}
}
