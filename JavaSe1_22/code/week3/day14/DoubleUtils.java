package org.example.week3.day14;

import java.math.BigDecimal;

//小数运算的工具类
public class DoubleUtils {
   /**
    * 提供精确的加法运算
    * @param v1
    * @param v2
    * @return 两个参数的和
    */
	public static double add(double v1,double v2) {
		
		BigDecimal b1 = new BigDecimal(Double.toString(v1));  //创建对象
		BigDecimal b2 = new BigDecimal(Double.toString(v2));  //创建对象
		return b1.add(b2).doubleValue();  //加运算---把BigDecimal通过doubleValue转换成double类型
	} 
	
	
    /**
     * 提供精确的减法运算
     * @param v1
     * @param v2
     * @return 两个参数的差
     */
	public static double sub(double v1,double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));  //创建对象
		BigDecimal b2 = new BigDecimal(Double.toString(v2));  //创建对象
		return b1.subtract(b2).doubleValue(); //减运算
	}
	
	/**
	 * 提供精确的乘法运算
	 * @param v1
	 * @param v2
	 * @return 两个参数的积
	 */
	public static double mul(double v1,double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));  //创建对象
		BigDecimal b2 = new BigDecimal(Double.toString(v2));  //创建对象
		return b1.multiply(b2).doubleValue(); //减运算
	}
	
	/**
	 * 提供精确的除法运算
	 * @param v1
	 * @param v2
	 * @return 两个参数的积
	 */
	public static double div(double v1,double v2) {
		BigDecimal b1 = new BigDecimal(Double.toString(v1));  //创建对象
		BigDecimal b2 = new BigDecimal(Double.toString(v2));  //创建对象
		return b1.divide(b2).doubleValue(); //减运算
	}
	
}
