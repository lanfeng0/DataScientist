package org.example.week3.day16.list;

import java.util.ArrayList;
import java.util.List;

//ArrayList测试
public class ArrayListTest {

	public static void main(String[] args) {
//		test01();  //方法测试
		// test02(); //图书对象测试
		test03();  //存储多条狗狗信息，获取狗狗总数，逐条打印出各条狗狗信息
		
		
	}
	
	//存储多条狗狗信息，获取狗狗总数，逐条打印出各条狗狗信息
    private static void test03() {
       	//1.创建集合对象
    	List<Dog> dogs = new ArrayList<Dog>();
    	//2.创建多个狗狗的对象
    	Dog dog1 = new Dog("小七","柯基");
    	Dog dog2 = new Dog("小八","拉布拉多");
    	Dog dog3 = new Dog("小九","金毛");
    	Dog dog4 = new Dog("小十","吉娃娃");
    	//3.把对象添加到集合中   add()
    	dogs.add(dog1);
    	dogs.add(dog2);
    	dogs.add(dog3);
    	dogs.add(dog4);
    	//4.获取狗狗的总数  size()  
    	int size = dogs.size();
    	System.out.println("共计有"+size+"条狗狗");
    	//5.遍历  size（）get（）
    	System.out.println("分别是:");
    	for (int i = 0; i < dogs.size(); i++) {
          System.out.println(dogs.get(i));			
		}
    	System.out.println("第一条狗狗的昵称："+dogs.get(0).getName());
    	System.out.println("最后一条狗狗的昵称："+dogs.get(dogs.size()-1).getName());
    	//6.删除第一个位置的狗狗    remove(int index)
    	dogs.remove(0);
    	
    	//7.删除指定的狗狗  美美  remove（Object o）
    	dogs.remove(dog4);
    	
    	
    	//8.判断集合中是否包含指定的狗 contains
    	boolean flag =  dogs.contains(dog2);
    	System.out.println("集合中是否包含"+dog2.getName()+":"+flag);
    	System.out.println("删除部分狗狗后还有"+dogs.size()+"条狗狗");
    	System.out.println("分别是:");
    	for (int i = 0; i < dogs.size(); i++) {
          System.out.println(dogs.get(i));			
		}
	}
	//添加4本图书信息(书名和价格)信息，并遍历   测试特点  有序插入，可重复
	private static void test02() {
		//ArrayList特点：有序插入，可重复
		//1.先创建集合对象，泛型是BookEntity
		List<BookEntity> books = new ArrayList<BookEntity>(); //多态
		//2.创建四本图书对象
		BookEntity book1 = new BookEntity("java", 90);
		BookEntity book2 = new BookEntity("java", 90);
		BookEntity book3 = new BookEntity("c#", 80);
		BookEntity book4 = new BookEntity("html", 70);
		BookEntity book5 = book3;
		//3.把图书对象添加到集合中
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		//4.遍历
//		for (BookEntity book : books) {
//			System.out.println(book);
//		}
		
		for (int i = 0; i < books.size(); i++) {  //获取集合长度
			System.out.println(books.get(i));  //根据索引获取元素
		}
	}
	
	// 使用String类型来测试常用方法和遍历方式
	private static void test01() {
		// 创建一个集合对象 长度为10
		ArrayList<String> strs = new ArrayList<>();

		strs.add("alice"); // 向集合中添加元素
		strs.add("lily");
		strs.add("lucy");

		System.out.println(strs.get(1)); // 返回此列表中指定位置的元素

		System.out.println(strs.contains("alice")); // 如果此列表包含指定的元素，则返回 true

		strs.remove(0);// 删除该列表中指定位置的元素

		int size = strs.size(); // 返回此列表中的元素数。
		System.out.println(size);

		// strs.clear(); //从列表中删除所有元素

		System.out.println(strs.indexOf("lily")); // 返回此列表中指定元素的第一次出现的索引，如果此列表不包含元素，则返回-1。

		// 遍历
		// 方式一: for循环
		for (int i = 0; i < strs.size(); i++) {
			System.out.print(strs.get(i) + "  ");
		}
		System.out.println("\n-------------------for循环-------------------------");

		// 方式二：增强for循环
		for (String s : strs) {
			System.out.print(s + "   ");
		}
		System.out.println("\n-------------------增强for循环-------------------------");

		// 方式三：while
		int i = 0;
		while (i < strs.size()) {
			System.out.print(strs.get(i) + "  ");
			i++;
		}
		System.out.println("\n-------------------while循环-------------------------");

		// 方式四：do-while循环
		int j = 0;
		// 如果使用do-while循环，至少集合中要有一个元素，否则报错。因为do-while至少要执行一次
		if (strs.size() > 0) {
			do {
				System.out.print(strs.get(j) + "  ");
				j++;
			} while (j < strs.size());
		}
		System.out.println("\n-------------------do-while循环-------------------------");

		// 方式五和六--后面讲
	}
}
