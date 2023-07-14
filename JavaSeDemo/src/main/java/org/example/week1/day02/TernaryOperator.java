package org.example.week1.day02;

//三元运算符
public class TernaryOperator {
	public static void main(String[] args) {
//        test01();
        test02();
        
    }
   
	//获取两个数中的较大数   获取三个数中的较大数
	private static void test02() {
         int a = 10;
         int b = 12;
         int c = 13;
         int max1 = a>b?a:b;
         System.out.println("两个数中最大的值是:"+max1);
         int max2 = (a>b?a:b)>c?(a>b?a:b):c;
         System.out.println("三个数中最大的值是:"+max2);
	}

	private static void test01() {
		int score=68;
        String mark = (score>=60) ? "及格" : "不及格";
        System.out.println("考试成绩如何："+mark);
	} 
}
