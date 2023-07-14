package org.example.week3.day14;

import java.math.BigDecimal;

//浮点型  BigDecimal用来对double、float类型进行精确计算；
public class BigDecimalTest {
     public static void main(String[] args) {
//		test();
    	 double result1 =  DoubleUtils.add(1, 0.7);  //调用工具类的加运算
    	 double result2 =  DoubleUtils.sub(1, 0.7); 
    	 double result3 =  DoubleUtils.mul(3, 9); 
    	 double result4 =  DoubleUtils.div(9,3); 
    	 System.out.println(result4);
    	  

	}

	private static void test() {
		BigDecimal bd1 = new BigDecimal("1");
		BigDecimal bd2 = new BigDecimal("0.7");
		System.out.println("加运算:"+bd1.add(bd2));//1.7
		System.out.println("减运算:"+bd1.subtract(bd2));//0.3
		System.out.println("乘运算:"+bd1.multiply(bd2));//0.7
//		System.out.println("除运算:"+bd1.divide(bd2));  如果不能表示确切的商，则抛出一个ArithmeticException 。 
		
		System.out.println(1-0.7);  //精度缺失  0.30000000000000004
	}
}
