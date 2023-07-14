package org.example.week2.day13.exception;
//异常层层抛出
public class Calculator {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		try {  //调用者 可以处理异常  继续往上抛
			calc.div(10, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("程序是否继续执行");
	}

	
	//throw抛出异常     throws：在方法声明异常(方法有异常，谁来调用谁处理),可以声明多个异常，多个用逗号
	public void div(int x, int y) throws Exception,NullPointerException,ArithmeticException {
		if (y == 0) {
			throw new Exception(); // 抛出异常 编译报错
		}
		System.out.println("x/y=" + x / y);

	}
}
