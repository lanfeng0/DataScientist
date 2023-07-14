package org.example.week3.day16.list;

import java.util.ArrayList;

public class MyArrayListTest {
  public static void main(String[] args) {
	MyArrayList<String>  names = new MyArrayList<String>();  //创建自定义ArrayList的泛型类对象
	
	names.add("alice1"); //模拟ArrayList的实现 ，向对象中添加元素
	names.add("alice2");
	names.add("alice3");
	names.add("alice4");
	names.add("alice5");
	
//	System.out.println(names.get(5));  //抛异常测试 索引越界异常
//	names.set(2, "jack");  //修改某个位置的元素
//	names.removeAll(); //删除所有元素
	names.remove(4);  //删除某个位置的元素
	//遍历
	for (int i = 0; i < names.getSize(); i++) {
		 System.out.println(names.get(i));
	}

	
	ArrayList<String> names1 = new ArrayList<>();
	names1.add("aa");
//	names1.get(1);
//	names1.size();
}
}
