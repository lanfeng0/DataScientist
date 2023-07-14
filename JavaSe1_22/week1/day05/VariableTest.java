package org.example.week1.day05;

//局部变量与成员变量的区别
public class VariableTest {
   int i ; //成员变量 
   
   public void test() {
	   i++;
	   if(i>0) {
		   i=i+3;
	   }
	   System.out.println(i);
	   
	   int j =1;
	   System.out.println(j);
   }
   
   public void test01() {
	  int j = 2;  //局部变量 在方法内生效
	  if(j>0) {
		  int z =j;  //z局部变量  在if内生效
		  System.out.println(z);
	  }
	  //System.out.println(z);  //此条语句报编译错误  因为z变量声明在if内，出了if就不能识别了
	  int i = 20;

	  System.out.println(i);  //20  就近原则  
   }
   
   public static void main(String[] args) {
	VariableTest v = new VariableTest();
	v.test();
	v.test01();
}
   
}
