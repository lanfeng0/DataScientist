package org.example.week2.day08.statictest;

import static java.lang.Math.*;  //静态导入  Math类下面的所有方法
public class StaticTest {
	
	
	//测试本来之间静态方法和非静态方法之间的调用
	//静态方法
	public static void f() {
		StaticTest test = new StaticTest();
		test.a();  //静态----非静态    创建对象，通过对象名调用
		
		StaticTest.g();  // 静态---静态   直接通过类名调用
		
//		System.out.println(Math.abs(-1));
		System.out.println(abs(-1)+E+PI+cos(1));
	}
	//静态方法
	public static void g() {

	}
	//非静态方法
	public void a() {
		StaticTest.g();   //非静态---静态   直接类名调用
		b();    //非静态--非静态    直接调用
	}
	//非静态方法
	public void b() {
	}
	
	
	//不同类之间的调用   调用静态方法---使用类名  调用非静态方法---创建对象，通过对象名调用

}
