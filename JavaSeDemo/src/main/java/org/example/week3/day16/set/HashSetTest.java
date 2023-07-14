package org.example.week3.day16.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class HashSetTest {
   public static void main(String[] args) {
	//可以声明接口，创建实现类对象   
	List<BookEntity> lis1 = new ArrayList<>();
	//也可以直接创建实现类对象
	ArrayList<BookEntity>  list3 = new ArrayList<>();
	List<BookEntity> list2 = new LinkedList<>();
	LinkedList<BookEntity> list4 = new LinkedList<>();
	//泛型也可以不写，但是通常都会写泛型
	List lis5 = new ArrayList();
	ArrayList list6 = new ArrayList();
	
	/*
	1.特点：无序不重复 无索引
    2.默认不重复的是虚地址，要想内容不重复，就重写hashcode和equals方法。
    3.底层是HashMap实现
    4.HashSet堪称查询速度最快的集合，因为其内部是以HashCode来实现的。
           它内部元素的顺序是由哈希码来决定的，所以它不保证set的迭代顺序；特别是它不保证该顺序恒久不变
    5.无索引，无法使用for循环来遍历 可以使用增强for循环和迭代器来循环
	 */
	
	
	//创建HashSet对象
//	Set<BookEntity> books = new HashSet<>();
	HashSet<BookEntity>  books  = new HashSet<>();
	BookEntity book1 = new BookEntity("java",88);
	BookEntity book2 = new BookEntity("c#",86);
	BookEntity book3 = new BookEntity("sql",89);
	BookEntity book4 = new BookEntity("html",90);
	BookEntity book5 = new BookEntity("java",88);
	BookEntity book6 = book4;
	books.add(book1);  //添加数据
	books.add(book2);
	books.add(book3);
	books.add(book4);
	books.add(book5);
	books.add(book6);
	
	System.out.println("add调用的hashcode");
	System.out.println("集合中有"+books.size()+"个元素");   //返回集合汇总的元素个数
//	books.clear();//删除集合中所有元素
//	System.out.println("集合中是否包含book1："+books.contains(book1));
//	books.remove(book1);  //删除指定元素
//	System.out.println("集合中有"+books.size()+"个元素");   //返回集合汇总的元素个数

	//内存泄漏
	//属性值变化，hashcode的值就会发生变化，导致无法定位到删除的元素，删除失败  内存泄漏
	book1.setPrice(10);
	books.remove(book1);   //无法删除，内存泄漏
	books.add(book1);   //会重新添加一遍---内存泄漏
	System.out.println("修改价格并删除操作后集合中有"+books.size()+"个元素");   //返回集合汇总的元素个数
    
	
	//因为set中没有索引，所以无法使用for循环
	for (BookEntity book : books) {
		System.out.println(book);
	}

}
}
