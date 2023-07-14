package org.example.week3.day16.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CollectionsTest {
	public static void main(String[] args) {
//		testArray();
//		testCollections();
        test();
	}

	private static void test() {
		BookEntity book1 = new BookEntity("java", 88);
		BookEntity book2 = new BookEntity("c#", 86);
		BookEntity book3 = new BookEntity("sql", 89);
		BookEntity book4 = new BookEntity("c#1", 86);
		BookEntity book5 = new BookEntity("sql1", 89);
		BookEntity book6 = new BookEntity("c#1", 86);
		//集合相关
		ArrayList<BookEntity> list2 = new ArrayList<>();
		list2.add(book1);
		list2.add(book2);
		list2.add(book3);
		ArrayList<BookEntity> list1 = new ArrayList<>();
		list1.add(book4);
		list1.add(book5);
		list1.add(book6);
//		Collections.sort(list2);  //排序
//		Collections.reverse(list2);  //反转指定列表中元素的顺序
		Collections.copy(list1, list2);   //讲列表2复制到列表1
		for (BookEntity bookEntity : list1) {
			System.out.println(bookEntity);
		}
		
	}

	//测试集合的比较器---内部比较器  外部比较器
	private static void testCollections() {
		BookEntity book1 = new BookEntity("java", 88);
		BookEntity book2 = new BookEntity("c#", 86);
		BookEntity book3 = new BookEntity("sql", 89);
		//集合相关
		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(3);
		list1.add(1);
		list1.add(5);
		Collections.sort(list1);  //排序   内部比较器   API中的类   Integer类api中就实现了comparable接口
		for (Integer integer : list1) {
			System.out.println(integer);
		}
		
		ArrayList<BookEntity> list2 = new ArrayList<>();
		list2.add(book1);
		list2.add(book2);
		list2.add(book3);
//		Collections.sort(list2);  //排序  内部比较器  自定义类型 要实现接口和重写方法  否则编译报错
		Collections.sort(list2, new BookComparator());   //外部比较器
		for (BookEntity bookEntity : list2) {
			System.out.println(bookEntity);
		}
	}
	
    //测试数组的比较器
	public static void testArray() {
		BookEntity book1 = new BookEntity("java", 88);
		BookEntity book2 = new BookEntity("c#", 86);
		BookEntity book3 = new BookEntity("sql", 89);
		BookEntity book4 = new BookEntity("html", 90);
		BookEntity book5 = new BookEntity("java", 88);

		//数组相关
		int[] ary1 = { 3, 2, 1, 5, 6 };
		Arrays.sort(ary1); // 排序
		for (int i : ary1) {
			System.out.println(i);
		}

		BookEntity[] ary2 = { book1, book2, book3 };
		Arrays.sort(ary2); // 使用内部比较器 可以是内部比较也可以是外部比较器
		for (BookEntity bookEntity : ary2) {
			System.out.println(bookEntity);
		}
	}
}
