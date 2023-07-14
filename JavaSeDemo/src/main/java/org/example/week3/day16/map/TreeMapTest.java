package org.example.week3.day16.map;

import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		BookEntity book1 = new BookEntity("java", 88);
		BookEntity book2 = new BookEntity("c#", 86);
		BookEntity book3 = new BookEntity("sql", 89);
		BookEntity book4 = new BookEntity("html", 90);
		BookEntity book5 = new BookEntity("java", 88);
		//创建对象---通过key（键）排序
//		TreeMap<String, BookEntity> treeMaps = new TreeMap<>();
//		treeMaps.put("zhangsan", book1);  //添加键值对
//		treeMaps.put("lisi", book2);
//		treeMaps.put("wangwu", book3);
//		
//		//获取所有键的集合
//		Set<String> keys =  treeMaps.keySet();
//		//遍历键的集合，通过key来取出value
//		for (String key : keys) {
//			System.out.println(key+"   "+treeMaps.get(key));
//		}
//		
//		System.out.println("集合中的第一个键:"+treeMaps.firstKey());
//		System.out.println("集合中的最后一个键:"+treeMaps.lastKey());
		
		
		TreeMap<BookEntity, String> treeMaps = new TreeMap<>();
		treeMaps.put(book1, "zhangsan");
		treeMaps.put(book2, "lisi");
		treeMaps.put(book3, "wangwu");
		treeMaps.put(book5, "maliu");   //maliu把张三覆盖了
		//获取所有键的集合
		Set<BookEntity> keys =  treeMaps.keySet();
		//遍历键的集合，通过key来取出value
		for (BookEntity key : keys) {
			System.out.println(key+"   "+treeMaps.get(key));
		}
	}
}
