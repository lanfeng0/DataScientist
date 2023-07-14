package org.example.week3.day14;

import java.util.Scanner;

/*
 * 
String类测试
 */
public class StringTest {
	public static void main(String[] args) {
		// test01();
		test02();
	}

	// 输入一个字符串，输入一个字符，判断字符在该字符串中出现的次数
	private static void test02() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个字符串:");
		String str = sc.next();
		System.out.println("请输入一个字符:");
		String find = sc.next();
		char[] finds = find.toCharArray(); // 把字符串转成字符数组
		int count = 0;// 出现次数
		for (int i = 0; i < str.length(); i++) {// 遍历字符串
			// 每一个字符和输入的字符比较
			if (str.charAt(i) == finds[0]) {
				count++;
			}
		}
		System.out.println(str + "中出现" + count + "次" + find);
	}

	// 常用方法测试
	private static void test01() {
		// 创建对象的两种方式
		// String str1 = "aa";
		// String str2 = new String("aa");

		// String类的创建方式:= new 区别
		// String str1 = "etc"; // == 直接引用常量池中的地址
		// String str2 = "etc";
		// String str3 = new String("etc"); // 引用的是堆中的地址 每new一次就分配一次空间
		// String str4 = new String("etc");
		// System.out.println(str1 == str2); // true 常量池 相同的字符串地址相同
		// System.out.println(str2 == str3); // false //一个常量池 一个堆 地址肯定不同
		// System.out.println(str3 == str4); // false //引用的是堆中的地址

		// 不可变性
		// String s1 = "Hello";
		// s1 = "World";
		
		// 不可变性测试
		// String str1 = "hello";
		// str1.toUpperCase(); // 小写转成大写
		// System.out.println(str1); // hello
		// String str2 = str1.toUpperCase(); // 小写转成大写
		// System.out.println(str2); // HELLO

		
		//常用方法测试
		String s="beijingETC";
		//返回字符串s中第一次出现i的位置索引，为2
		System.out.println(s.indexOf('i'));
		//返回字符串s中最后一次出现i的位置索引，为4
		System.out.println(s.lastIndexOf('i'));
		//返回字符串s中第3个字符以后，第一次出现字符i的位置索引，为4
		System.out.println(s.indexOf('i',3));
		//返回字符串中第一次出现jing的索引位置，为3
		System.out.println(s.indexOf("jing"));
		//返回字符串中，第4个字符后，第一次出现jing的位置索引，由于没有，所以返回-1
		System.out.println(s.indexOf("jing",4));
		//返回字符串中的第二个字符，为i，注意索引从0开始
		System.out.println(s.charAt(2));
		
		int i=10;
		//将i转换为String类型
		String si=String.valueOf(i);

		char[] c1={'h','e','l','l','o'};
		//将char数组转换为String类型
		String sc1=String.valueOf(c1);

		// 将char数组中的第1到第4个字符转换为String类型
		String sc2=String.valueOf(c1,1,4);

		//分别输出hello及ello
		System.out.println(sc1);
		System.out.println(sc2);
          
		

	}
}
