package org.example.week2.day07.polymorphic.shape;

public class ShapeTest {
	public static void main(String[] args) {
      ShapeTest test = new ShapeTest();
      Rect rect = new Rect(10, 4); 
      test.print(rect);
      
      MyShape m = new Cricle(3);  //父类引用指向子类对象
      test.print(m);
		
	}
	//调用计算面积方法，和计算周长方法。并打印。
	//使用多态特性，多态参数---参数是父类类型，实际传递的是子类对象 
	 //MyShape m = new Rect(10, 4);    //MyShape m = new Cricle(3);   
	public void print(MyShape m) {  
		System.out.println(m.getArea());
		System.out.println(m.getLen());
	}
	
}
