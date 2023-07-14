package org.example.week1.day02;

import java.util.Scanner;


//算术运算符
public class ArithmeticOperator {
  //程序的入口
  public static void main(String[] args) {
//	 test01();  //调用test01方法
//	  test02();
	  test03();
  }
  
/*  从控制台输入学员王浩3门课程成绩，编写程序实现
  （1）Java课和SQL课的分数之差
  （2）3门课的平均分*/
  public static void test03() {
	  //1.获取Scanner对象
	  Scanner sc = new Scanner(System.in);
	  //2.获取控制台输入的三门成绩
	  System.out.println("java的成绩是:");
	  double javaScore = sc.nextDouble();
	  System.out.println("sql的成绩是:");
	  double sqlScore = sc.nextDouble();
	  System.out.println("html的成绩是:");
	  double htmlScore = sc.nextDouble();
	  //3.输出获取到的内容
	  System.out.println("\n\njava\t sql\t html");
	  System.out.println(javaScore+"\t"+sqlScore+"\t"+htmlScore+"\n\n");
	  //4.计算成绩差
	  double diff = javaScore-sqlScore;
	  //5.计算平均分
	  double avg = (javaScore+sqlScore+htmlScore)/3;
	  
	  //6.输出
	  System.out.println("java和sql的成绩差:"+diff);
	  System.out.println("三门成绩的平均分:"+avg);
  }
  
  public static void test02() {
	  //1.创建Scanner类的对象,用于获取控制台输入的内容
	  Scanner sc  = new Scanner(System.in); 
	  System.out.println("请输入年龄：");
	  //2.调用Scanner中的nextXXX方法，获得需要的数据类型
      int age =  sc.nextInt();  // 获取控制台输入的年龄(整数)
      System.out.println("请输入姓名：");
      String name = sc.next();  // 获取控制台输入的字符串(名字)
      System.out.println(age+"  "+name);
  }
  
  
  //测试算术运算符的语法
  public static void test01() {
	  int a = 2;
	  int b = 3;
	  System.out.println("正号:"+(+a));  //2
	  System.out.println("加运算a+b="+(a+b));  //5
	  System.out.println("减运算a-b="+(a-b)); //-1
	  System.out.println("乘运算a*b="+a*b);  //6
	  System.out.println("除运算b/a="+b/a);  //1   取整数部分
	  System.out.println("取余运算b%a="+b%a);  //1  取余数部分
	  int c = a++;   // ++ 自增1  先赋值再自增1
	  System.out.println(c+"   "+a);  // c=2 a=3
	  int d = ++a;  // 先自增1，再赋值
	  System.out.println(d+"   "+a);  // d = 4,a=4
	
  } 
}
