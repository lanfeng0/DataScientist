package org.example.week3.day14;

import java.math.BigInteger;

//大整数类型
public class BigIntegerTest {
  public static void main(String[] args) {
	test();

}

private static void test() {
	long l1 = 5632434242342222324L;
	long l2 = 5632434242342222324L;
	long l3 = l1+l2;   //-7181875589025106968   超出取值范围
	System.out.println(l3);
	
//	使用字符串表示超出范围的大整数
	String s1="29219291291919391912919283232323";
	String s2="2007594379874134134134127943";

//	将字符串作为参数，创建大整数BigInteger对象	
	BigInteger bi1=new BigInteger(s1);
	BigInteger bi2=new BigInteger(s2);

//	调用BigInteger类中的方法进行运算,下面是加法和出发	
	System.out.println(bi1.add(bi2));
	System.out.println(bi1.divide(bi2));
	

//(1)java中整数最大范围是long型，64位，如果需要使用超过long范围的大整数，可以使用BigInteger类；
//	(2)BigInteger位于java.math包中，定义了一系列的数学运算方法，调用这些方法可以进行计算，不能使用运算符计算
	BigInteger b1 = new BigInteger(l1+"");  //创建大整数对象
	BigInteger b2 = new BigInteger(l2+""); //创建大整数对象
	BigInteger add = b1.add(b2);
	System.out.println("大整数加运算:"+add);//11264868484684444648
	System.out.println("大整数减运算:"+b1.subtract(b2));//0
	System.out.println("大整数乘运算:"+b1.multiply(b2));//31724315494309204036265952935043960976
	System.out.println("大整数除运算:"+b1.divide(b2));//1

}
}
