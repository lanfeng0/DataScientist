package org.example.week2.day13.exception;

//了解return和System类的exit方法
public class ExceptionReturnTest {
	public static void main(String[] args) {
		int x = 10;
		int y = 0;
		calc(x, y);  //调用计算方法
	}

	//执行顺序： try--catch--finally--return  ,无论return写在哪里，都是最后一个执行 
	public static void calc(int x, int y) {
		try {
            System.out.println(x/y);  //除
		} catch (Exception e) {  //发生异常进行匹配
			System.out.println("数字不能为空");  
			return; //返回
		} finally {
           System.out.println("我一定会被执行"); 
		}
	}
	
}
