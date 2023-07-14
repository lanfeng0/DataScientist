package org.example.week3.day16.map;

//HashMap原理分析代码
public class MyHashCode {
  //简化存储位置算法
  public void put(String key,String value) {
	  System.out.println("key、key的hash值、位置\t"+
       key+" , "+key.hashCode()+" , "+Math.abs(key.hashCode()%15));
  }	
	
  public static void main(String[] args) {
	MyHashCode map = new MyHashCode();
	map.put("刘一", "张三");
    map.put("陈二", "张三");
    map.put("张三", "张三");
    map.put("李四", "李四");
    map.put("王五", "王五");
    map.put("马六", "马六");
}
}
