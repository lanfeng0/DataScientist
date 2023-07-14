package org.example.week3.day16.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
  public static void main(String[] args) {
	test01();   //建立国家英文简称和中文全名间的键值映射，并通过key对value进行操作，应该如何实现数据的存储和操作呢？
	test02();   //作者对应一本图书
	test03();  //作者对应多本图书
    
}
//作者对应多本图书
private static void test03() {
	//创建多个图书对象
	BookEntity book1 = new BookEntity("java", 80);
	BookEntity book2 = new BookEntity("c#", 70);
	BookEntity book3 = new BookEntity(".net", 90);
	//集合中添加多本图书对象
	ArrayList<BookEntity> books = new ArrayList<>();
	books.add(book1);
	books.add(book2);
	books.add(book3);
	
	//创建hashmap的对象   key:String  value:ArrayList<BookEntity>
	HashMap<String, ArrayList<BookEntity>> maps = new HashMap<>();
	//添加键值对    张三：String   books:ArrayList<BookEntity>集合
    maps.put("张三",books);
    maps.put("李四",books);
    Set<String> keys = maps.keySet();  //返回值集合中所有的key值
    //遍历key值
    for (String key : keys) {
		System.out.println(key+" ：");
		ArrayList<BookEntity> value = maps.get(key);  //根据key获取对应value(集合对象)
		//遍历每一个ArrayList集合
		for (BookEntity book : value) {
			System.out.println(book.getName()+"   "+book.getPrice());
		}
	}
    
}
  
  
//作者对应一本图书
	private static void test02() {
	BookEntity book1 = new BookEntity("java", 80);
	BookEntity book2 = new BookEntity("c#", 70);
	BookEntity book3 = new BookEntity(".net", 90);
	//创建hashmap的对象
	HashMap<String, BookEntity> maps = new HashMap<>();
	//添加键值对
    maps.put("张三",book1);
    maps.put("李四",book2);
    maps.put("王五",book3);
    
    Set<String> keys = maps.keySet();  //返回值集合中所有的key值
    for (String key : keys) {
		System.out.println(key+" ："+maps.get(key));
	}
    
}

//建立国家英文简称和中文全名间的键值映射，并通过key对value进行操作，应该如何实现数据的存储和操作呢？
private static void test01() {
	//1.创建HashMap对象  HashMap <k,v>  k:键   V：值
	  HashMap<String, String>  map = new HashMap<>();
	  
	 //2.向map中添加数据  键值对
	 map.put("CN", "中华人民共和国");
	 map.put("RU", "俄罗斯");
	 map.put("US", "美利坚合众国");
	 map.put("US", "美利坚合众国1");  //如果key的值相同，后添加的数据会覆盖之间的数据
	 
	 //3.根据key来获取对应的value值
	 System.out.println("CN对应的国家是:"+map.get("CN"));
	 
	 //4.获取map的元素个数
	 System.out.println("map中共有:"+map.size()+"组数据");
	 
	 //5.map中是否包含某个key
	 System.out.println("map中包含FR的key吗？"+map.containsKey("FR"));
	 System.out.println("map中包含CN的key吗？"+map.containsKey("CN"));
	 
	 //6.返回值所有的key
	 Set<String>  keys =  map.keySet();
	 System.out.println(keys);
	 
	 //7.返回值所有的value
	 Collection<String> values =  map.values();
	 System.out.println(values);
	 
	 //8.HashMap遍历
	 //(1)获取所有的key，返回一个set集合  
	 Set<String>  keyss =  map.keySet();
	 //(2)遍历set集合  通过key获取对应的value  map.get()
	 for (String key : keyss) {
		System.out.println(key+"="+map.get(key));
	}
}
}
