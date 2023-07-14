package org.example.week3.day16.list;

import java.util.Enumeration;
import java.util.Vector;

//Vector测试
public class VectorTest {

	public static void main(String[] args) {
     Vector<String> v = new Vector<>();   //创建集合对象
     v.addElement("aa");  //添加元素
     v.addElement("1234");
     v.add("ccc");
//     System.out.println(v);  
     String con =  v.elementAt(1); //返回指定索引的元素
//     System.out.println(con);
     
     //遍历  for   增强for  while  do-while   Enumeration<E>遍历
     Enumeration<String> ens =  v.elements();  //返回集合中所有元素，封装Enumeration对象中
	 while( ens.hasMoreElements() == true) {   //当前枚举是否包含更多元素
		  System.out.println(ens.nextElement()); //输出
	 }
	}

}
