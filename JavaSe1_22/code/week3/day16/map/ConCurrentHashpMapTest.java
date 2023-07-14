package org.example.week3.day16.map;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/*
 * ConcurrentHashMap是线程安全并且高效的HashMap
 */
public class ConCurrentHashpMapTest {
public static void main(String[] args) {
	BookEntity book1 = new BookEntity("java", 88);
	BookEntity book2 = new BookEntity("c#", 86);
	BookEntity book3 = new BookEntity("sql", 89);
	BookEntity book4 = new BookEntity("html", 90);
	BookEntity book5 = new BookEntity("java", 88);
	//创建对象---线程安全并且高效
	ConcurrentHashMap<String, BookEntity> treeMaps = new ConcurrentHashMap<>();
	treeMaps.put(null, book1);  //添加键值对
	treeMaps.put("lisi", book2);
	treeMaps.put("wangwu", book3);
	
	//获取所有键的集合
	Set<String> keys =  treeMaps.keySet();
	//遍历键的集合，通过key来取出value
	for (String key : keys) {
		System.out.println(key+"   "+treeMaps.get(key));
	}
}
}
