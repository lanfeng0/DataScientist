package org.example.week1.day03;

import java.util.Scanner;

public class WhileTest {
  public static void main(String[] args) {
//	test01();   //输出0-5
//	test02();   //100以内偶数之和
//	test03();  //循环输入商品编号，显示对应的商品价格
}
  
  
 /*
  * 
 循环输入商品编号，显示对应的商品价格
输入“n”结束循环 
  1.输出全部信息
  2.选择编号--循环 
	2.1.初始条件     String result ="y";
	2.2.判断条件语句  while( result.equals("y")){}
	2.3.控制语句   
	      (1)输出是否继续
	      (2)接收参数--result
	2.4.循环体
	   (1)请输入商品编号:
	   (2)接收选择的编号
	   (3)switch
  * 
  */
  private static void test03() {
	  Scanner sc = new Scanner(System.in);
//	  1.输出全部信息
	  System.out.println("myshopping管理系统》购物结算");
	  System.out.println("***********************");
	  System.out.println("请选择购买的商品编号:\n 1.T恤\t 2.网球鞋 \t 3.网球拍");
//	  2.选择编号--循环 
//		2.1.初始条件     String result ="y";
	  String result = "y";//循环变量  y--继续  n 结束购物
//		2.2.判断条件语句  while( result.equals("y")){}
	  while(result.equals("y")) {  //第一次  真 
//		2.4.循环体
//		   (1)请输入商品编号:
		  System.out.println("请输入商品编号");
//		   (2)接收选择的编号
		  int selected = sc.nextInt();
//		   (3)switch	
			switch (selected) {
			case 1:
                 System.out.println("T恤  ￥570");
				break;
			case 2:
				 System.out.println("网球鞋  ￥245");
				break;
			case 3:
				 System.out.println("网球拍  ￥150");
				break;
			}
//		2.3.控制语句   
//	      (1)输出是否继续
//	      (2)接收参数--result
		System.out.println("是否继续（y/n）:");
		result = sc.next();
	  }
	  
	  System.out.println("程序结束，祝您愉快");

}



//100以内的偶数之和(包括100)-- i%2==0
  private static void test02() {
	    //1.初始值  int i = 0;
		//2.判断条件语句    i<=100
		//3.控制语句  i++
		//4.循环体  ：挑选出偶数，相加     if(i%2==0){ sum+=i }
	  int sum = 0; //偶数和的变量
	  int i = 0;  //初始值
	  while(i<=100) {//100以内
		  if(i%2==0) {//i除以2 的余数为0  偶数
			  sum+=i;//sum = sum+i 
		  }
		  i++; //控制语句
	  }
	  System.out.println("100以内偶数之和："+sum);
	  
//	  int sum = 0;  //偶数和的变量
//	  for(int i = 0;i<=100;i++) {
//		  if(i%2==0) {  //i除以2 的余数为0  偶数 
//			  sum+=i;//sum = sum+i
//		  }
//	  }
//	  System.out.println("100以内偶数之和："+sum);
 }



//输出5以内的数字   
  /*
   * while
   
      初始值(1)
   while(判断条件语句(2)){
            循环体语句块；(3)
            控制语句；(4)
   }
   
   注意：1、初始值，一般情况写在while循环外边
       2、判断条件语句 ：结果是boolean类型,只有真和假，如果结果为真，执行循环体的语句块；如果为假，跳出循环，继续执行while后的语句
       3、控制语句：看while循环能不能结束，修改循环变量
       4、执行顺序：1234 234 234.....
   * 
   */
private static void test01() {
	//1.初始条件  int i= 0；
	//2.判断条件语句  i<100
	//3.控制语句  i++
	//4.循环体
	
	/*for(int i = 0 ;i<5;i++) {
		System.out.println(i);
	}*/
	
	
//	int i = 0;  //初始值
//	while(i<5) {  //判断条件语句
//		System.out.println(i);  //循环体
//		i++; //控制语句
//	}
	
	
	int i = 0;  //初始值
	while(true) {  //永真条件
		System.out.println(i);  //循环体
		i++; //控制语句
	}
	

}
  
 
  
  
}
