package org.example.week1.day03;

import java.util.Scanner;

//for循环测试
public class ForTest {
	public static void main(String[] args) {
		// test01(); //输出5以内的整数
		// test02(); //测试死循环
		// test03(); //循环输入某同学S1结业考试的5门课成绩，并计算平均分
		// test04(); //加法表--嵌套循环
		// test05();  //嵌套循环
		 test06();
		 test07();
	}
     
	//加法表
	private static void test04() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个值:");
		int val = sc.nextInt();
		// 1.初始值 i = 0 ,j=输入的值
		// 2.判断条件：i<=输入的值
		// 3.控制条件: i++ j--
		// i :0--输入的值
		// j:输入的值--0
		for(int i = 0,j=val;i<=val && j>=0;i++,j--) {
			// 4.循环体：输出i+j=
			System.out.println(i+" + "+j+" = "+(i+j));
		}
	}

	//循环输入某同学S1结业考试的5门课成绩，并计算平均分
	private static void test03() {
		//1.创建sacnner对象
		Scanner sc = new Scanner(System.in);
		//2.获取学生姓名
		System.out.println("请输入学生姓名:");
		String userName = sc.next();
		//3.获取5门成绩并求和
		double sum = 0;//成绩和的变量声明
		//3.1 初始化条件   int i = 1  3.2判断条件 i<=5  3.3 控制语句 i++
		for(int i = 1;i<=5;i++) {
			//3.4 循环体  
			//3.4.1 提示语句
			System.out.println("请输入第"+i+"门成绩：");
			//3.4.2 获取输入的第i们成绩
			double score = sc.nextDouble();
			//3.4.3 累计求和
			sum += score ;  // sum = sum+score
		}
		
	   //4、计算平均分并输出
		double avg = sum/5;
		System.out.println(userName+"的平均分是:"+avg);
	}

    
	//测试死循环
	private static void test02() {
//		for(;;){}   
//		for(;true;){}
//		for(;false;){} 
	}
    
	//输出5以内的整数
	private static void test01() {
		// 输出100以内的数字
		// 1.判断初始值多少？ a = 0
		// 2.判断条件语句？ a < 5
		// 3.控制语句？a++
		// 4.循环体？打印a的值
		// 5.套用语法
		int a;
		for (a = 0; a < 5; a++) {
			System.out.println("a=" + a);
		}
	}
	
	
	  private static void test05() {
			 //外层循环  循环i=0 1 2 
			loop1: for(int i = 0;i<3;i++) {
				//循环体是另一个循环
			loop2:for(int j = 5;j>0;j--) {
					if(i==j) {  
						break loop1; 
					}
					System.out.println("i="+i+"   j="+j);
				}
				System.out.println("第"+i+"层循环结束");
			}
			System.out.println("循环全部结束");		
	}

	private static void test06() {
		 //外层循环  循环i=0 1 2 3 4
		for(int i = 0;i<5;i++) {
			//循环体是另一个循环
			for(int j = 5;j>0;j--) {
				if(i==j) {
//					continue; //结束是j层的本次循环
					break; //结束整个j层的循环（当前循环）
				}
				System.out.println("i="+i+"   j="+j);
			}
			System.out.println("第"+i+"层循环结束");
		}
		System.out.println("循环全部结束");		
	}

	//循环嵌套
	private static void test07() {
		  
		  //外层循环  循环i=0 1 2 
		for(int i = 0;i<3;i++) {
			//循环体是另一个循环
			for(int j = 5;j>0;j--) {
				System.out.println("i="+i+"   j="+j);
			}
			System.out.println("第"+i+"层循环结束");
		}
		System.out.println("循环全部结束");	
	}
}
