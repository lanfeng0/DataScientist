package org.example.week3.day16.set;

import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		test01();  //TreeSet测试
//		test02();//使用TreeSet完成，将字符串中的数值进行排序。
		
	}
	
	//使用TreeSet完成，将字符串中的数值进行排序。
	private static void test02() {
		String str = "8 19 10 7 11";
		//字符串转成字符串数组
		String[] arys =  str.split(" ");  //按照空格拆分字符串
		//创建TreeSet对象----排序
		TreeSet<Integer> ts = new TreeSet<>(); 
		//遍历 添加元素
		for (int i = 0; i < arys.length; i++) {
			//TreeSet存储自定义类型，那么需要实现compareable接口,重写compareTo方法;
			//存储非自定类型(本身已经实现compareable的接口)，默认排序 
			ts.add( Integer.parseInt(arys[i]));   
		}
		System.out.println(ts);
	}
	private static void test01() {
		BookEntity book1 = new BookEntity("java", 88);
		BookEntity book2 = new BookEntity("c#", 86);
		BookEntity book3 = new BookEntity("sql", 89);
		BookEntity book4 = new BookEntity("html", 90);
		//调用重写的compareto方法 返回的是0，认为数据重复，不允许添加   
		//treeset和hashcode和equals方法无关
		BookEntity book5 = new BookEntity("java", 88);   
//		BookEntity book6 = book4;
		
		//创建TreeSet对象
		/*
		   1.无序不重复，但是排序，所以TreeSet中存放的对象必须实现Comparable接口，重写compareTo方法
           2.如果比较元素的时候，compareTo方法返回的是0，那么该元素就被视为重复元素，不允许添加（TreeSet与hashcode和equals方法是没有任何关系的）
           3.基于TreeMap，生成一个总是处于排序状态的set，内部以TreeMap来实现。TreeMap使用红黑树数据结构实现，存储规则：左小右大
		 */
//		Set<BookEntity> books = new TreeSet<>();
		TreeSet<BookEntity> books = new TreeSet<>();
		books.add(book1);  //添加数据
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
//		books.add(book6);
		
		System.out.println("第一个元素是："+books.first());
		System.out.println("最后一个元素是："+books.last());
		for (BookEntity book : books) {
			System.out.println(book);
		}
	}
}
