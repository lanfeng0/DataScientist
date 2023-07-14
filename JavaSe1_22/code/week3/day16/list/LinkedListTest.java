package org.example.week3.day16.list;

import java.util.LinkedList;

//LinkedList测试
public class LinkedListTest {
	public static void main(String[] args) {
		// test01(); //LinkedList语法测试
		test02(); // 在集合任何位置（头部、中间、尾部）添加、获取、删除狗狗对象

	}

	// 在集合任何位置（头部、中间、尾部）添加、获取、删除狗狗对象
	private static void test02() {
		LinkedList<Dog> dogs = new LinkedList<>(); // 创建集合对象
		Dog dog1 = new Dog("小七", "柯基");
		Dog dog2 = new Dog("小八", "拉布拉多");
		Dog dog3 = new Dog("小九", "金毛");
		Dog dog4 = new Dog("小十", "吉娃娃");

		dogs.add(dog1); // 向集合中添加数据
		dogs.add(dog2);
		dogs.add(dog3);
		dogs.add(dog4);
		System.out.println("第一条狗狗的昵称:" + dogs.getFirst().getName()); // 获取第一个对象
		System.out.println("最后一条狗狗的昵称:" + dogs.getLast().getName()); // 获取最后一个对象

		dogs.remove(2); // 删除索引为2 的元素
		System.out.println("删除部分狗狗后，还有" + dogs.size() + "条狗狗"); // 获取长度
		System.out.println("分别是:");
		for (Dog dog : dogs) { // 遍历
			System.out.println(dog);
		}
	}

	// LinkedList语法测试
	private static void test01() {
		// 创建LinkedList的集合对象，空列表
		LinkedList<BookEntity> books = new LinkedList<>();
		// 有序 可重复
		BookEntity book1 = new BookEntity("java", 80);
		BookEntity book2 = new BookEntity("c#", 60);
		BookEntity book3 = new BookEntity("sql", 90);
		BookEntity book4 = new BookEntity("html", 50);
		BookEntity book5 = book4;
		// 添加元素
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		// books.clear(); //删除所有元素
		// System.out.println(books.contains(book2)); //是否包含此元素，返回值是boolean类型
		// books.remove(4); //删除该列表中指定位置的元素

		books.addFirst(book2); // 在列表的首部添加元素
		books.addLast(book2); // 在列表的尾部添加元素
		System.out.println("获取首部元素：" + books.getFirst());
		System.out.println("获取尾部元素：" + books.getLast());
		System.out.println(books.removeFirst()); // 删除头部元素，并返回列表中的第一个元素
		System.out.println(books.removeLast());// 删除尾部元素，并返回列表中的最后一个元素
		for (int i = 0; i < books.size(); i++) { // 获取此列表中的元素
			System.out.println(books.get(i)); // 返回列表中指定位置的元素
		}
	}
}
