package org.example.week2.day11;

//包装类
public class Wapper {
	public static void main(String[] args) {
		// Integer中的属性
		System.out.println(Integer.MAX_VALUE);
		// 构造方法 两种赋值方式
		Integer ii2 = 10;
		Integer ii3 = new Integer(10);

		// 传统的装箱、拆箱
		int a = 128;
		Integer ao1 = new Integer(a);
		int b1 = ao1.intValue();
		// 自动装箱
		Integer ao2 = a;
		Integer ao3 = 128;
		// 自动拆箱
		int b2 = ao2;
		int b3 = ao2 + ao3;

		Integer i1 = 10; // 引用的常量池中的地址
		Integer i2 = 10;
		Integer io1 = new Integer(10); // 引用的是堆内存的地址
		Integer io2 = new Integer(10);

		System.out.println(i1 == i2); // true
		System.out.println(io1 == io2); // false
		System.out.println(i1 == io1); // false

		Integer i3 = 128; // 引用的常量池中的地址 byte -128 - 127
		Integer i4 = 128;
		Integer io3 = new Integer(128); // 引用的是堆内存的地址
		Integer io4 = new Integer(128);

		System.out.println(i3 == i4); // false
		System.out.println(io3 == io4); // false
		System.out.println(i3 == io3); // false
	}
}
