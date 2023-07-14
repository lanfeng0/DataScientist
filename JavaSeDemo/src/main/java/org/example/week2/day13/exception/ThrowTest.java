package org.example.week2.day13.exception;

//异常层层抛出
public class ThrowTest {
  public static void main(String[] args) {
	try {
		//抛出异常：jvm执行throw new ArithmeticException();
		System.out.println(10/0);   
		System.out.println("计算结束");
		
	} catch (Exception e) { //异常处理机制将ArithmeticException与catch语句的异常类型匹配
		System.out.println("除数不能为0");  //匹配成功， 运行catch代码块，异常被处理
	}
	System.out.println("程序继续执行");  //程序继续运行
}
}
