package org.example.week2.day13.exception;
/*
try{
  //可能抛出异常的代码块;
}catch(异常类型 变量名){  //异常类型匹配才会捕获，否则依然报错
   //1.可以写任意需要对异常进行处理的代码；
   //2.可以调用异常对象的方法，例如printStackTrace，查看异常发生的栈轨迹
}
三种情况
1.没发现异常，正常执行 
2.发生异常，并处理
3.发生异常，没处理(异常类型匹配不成功)---程序终止

注意：
1.使用try-catch能保证程序发生异常的时候，能继续执行
2.catch可以写多个，catch语句的异常类型必须从子类到父类的顺序，否则编译错误；

 */
public class TryCatchTest {
 public static void main(String[] args) {
	try {//可能抛出异常的代码块;
//	   System.out.println(10/0);	 //数字异常 
	   String str = null;
	   System.out.println(str.length());   //空指针
//	   int[] a = new int[5];
//	   System.out.println(a[5]);  //数组越界
	}catch(ArithmeticException e) {  //捕获数字异常
		//1.可以写任意需要对异常进行处理的代码；
		System.out.println("除数不能为0");
		//2.可以调用异常对象的方法，例如printStackTrace，查看异常发生的栈轨迹
		e.printStackTrace();  //你报了什么错，不会影响程序继续运行
	}catch (NullPointerException e) {  //捕获空指针异常
		e.printStackTrace();
		System.out.println("字符串不能为null");
	}catch (IndexOutOfBoundsException e) {  //捕获数组越界异常
		e.printStackTrace();
		System.out.println("数据下标不能越界");
	}catch (Exception e) {  //捕获所有异常   Exception是所有异常的父类
		System.out.println("发生异常了");
	}finally {
		System.out.println("无论是否发生异常，无论异常是否被捕获处理，都会执行的语句块");
	}
	
	System.out.println("是否继续执行程序");
}
}
