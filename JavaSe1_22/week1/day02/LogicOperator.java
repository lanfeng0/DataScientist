package org.example.week1.day02;

import java.util.Scanner;

public class LogicOperator {
  public static void main(String[] args) {
//	int a = 4;
//	int b = 1;
//	
   //全真为真（左右两个表达式都为真）  有假为假（左右有一个为假，结果为假）
	//&  无论左边表达式是否为假   ，右边都执行     执行到了第二个条件  b++
//	if(a>5 & b++<3) {
//		System.out.println("if"+a+"  "+b);
//	}else {
//		System.out.println("else"+a+"  "+b);   // b++执行了 a=4  b=2
//	}
	
	//&& 左边的表达式为false，就已经知道了逻辑表达式的结果了 ，右边的表达式就不会再执行
//	if(a>5 && b++<3) {
//		System.out.println("if"+a+"  "+b);
//	}else {
//		System.out.println("else"+a+"  "+b);   //b++没执行   a=4  b=2
//	}
	
	
	//案例:模拟登入操作(控制台输入用户名和密码，非空判断)
	/*
	 * 1.创建Scanner对象
	 * 2.获取控制台输入的账户名和密码
	 * 3.非空判断  null  是不是空字符串 --- equals   && 和 || ！
	 *   1.&& ！ 用户名不等于null 并且 不等于空字符串 --- 成功  else  失败
	 *   2.||  用户名等于null 或者 等于空字符串  --- 失败  else 成功 
	 * 4.提示结果  
	 */
	
//	  1.创建Scanner对象
	  Scanner sc = new Scanner(System.in);
//	  2.获取控制台输入的账户名和密码
	  System.out.println("请输入用户名：");
	  String userName = sc.nextLine();
	  System.out.println("请输入密码：");
	  String pwd = sc.nextLine();
	  
//	  3.非空判断  null  是不是空字符串 --- equals 判断连个字符串是否相等 true/false   && 和 || ！
//		1.&& ！ 用户名不等于null 并且 不等于空字符串 --- 成功  else  失败
//		2.||  用户名等于null 或者 等于空字符串  --- 失败  else 成功 
	  
//	  &&  全真为真   ||全假为假
	  
	  if(userName!=null && "".equals(userName)==false && pwd!=null && "".equals(pwd)==false) {
		  System.out.println("非空验证成功");
		  //假设，用户名--zhangsan   密码 123456
		  //1.&& username 等于zhangsan 并且 pwd等于123456 ---登录成功  else--失败
		  //2.|| username 不等于zhangsan 或者 pwd不等于123456  -- 失败  else 成功
//		  if("zhangsan".equals(userName)==true && "123456".equals(pwd)==true ) {
//			  System.out.println("登录成功");
//		  }else {
//			  System.out.println("账户名或者密码输入错误");
//		  }
		  
		  if("zhangsan".equals(userName)==false || "123456".equals(pwd)==false ) {
			  System.out.println("账户名或者密码输入错误");
		  }else {
			  System.out.println("登录成功");
		  }
		  
	  }else {
		  System.out.println("用户名或者密码不能为空");
	  }
	  
//	  if(userName==null || "".equals(userName)==true || pwd == null || "".equals(pwd)==true) {
//		 System.out.println("失败"); 
//	  }else {
//		 System.out.println("成功"); 
//	  }
//	
}
}
