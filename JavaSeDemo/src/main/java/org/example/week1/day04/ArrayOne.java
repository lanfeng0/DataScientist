package org.example.week1.day04;

import java.util.Scanner;

//一维数组的常见案例
public class ArrayOne {
	public static void main(String[] args) {
//		test01();//一维数组语法测试
//		test02(); //数组常见问题
//		test03();//循环录入10位顾客的年龄 放到数组中，遍历数组  计算18岁以上和以下的比例
//		test04();//猜数游戏
	}

	/*
	 * 有一个数列：8，4，2，1，23，344，12
               循环输出数列的值
               求数列中所有数值的和
               猜数游戏：从键盘中任意输入一个数据，判断数列中是否包含此数 
	 */
	private static void test04() {
		int sum = 0; //求和
//	      1.创建数组 并且赋值
		int[] ary = {8,4,2,1,23,344,12};
//	      2.遍历输出数组中的值
		for(int i = 0;i<ary.length;i++) {
			System.out.println("第"+(i+1)+"个值："+ary[i]);
//		      3.遍历的过程中累计求值
			sum+=ary[i];
		}
     
		System.out.println("数列中所有数值的和:"+sum);
//	      4.创建scanner对象，获取控制台输入的数字
		Scanner sc  = new Scanner(System.in);
		System.out.println("数游戏：从键盘中任意输入一个数据:");
		int input = sc.nextInt();
		
		boolean flag = false; //标识符，标识是否包含  true--包含   false--不包含  默认false
//	      5.遍历数组
		for(int num : ary) {
//		    6.判断是否包含次数    if(input == num)   包含--break   不包含 ---输出没找到此数		
           if(input==num) {
        	   flag = true;  //找到数值，包含
        	   break;
           }
		}
		
		System.out.println(flag==false?"数列中不包含此数":"数列中包含此数");
		
	}

	//循环录入10位顾客的年龄 放到数组中，遍历数组  计算18岁以上和以下的比例
	private static void test03() {
        Scanner sc = new Scanner(System.in);
        int[] ageAry = new int[10];  //声明并初始化数组 ，存放顾客的年龄
        for(int i = 0;i<10;i++) { 
        	System.out.println("请输入第"+(i+1)+"位顾客的年龄：");
        	int age = sc.nextInt();
        	ageAry[i] = age;  //获取到的年龄赋值给数组中的元素
        }
        
        int num1 = 0;  //18以下的数量
        int num2 = 0; //18以上的数量
        //遍历数据
        for(int age:ageAry) {
        	//计算18以上和以下的人数
        	if(age>18) {
        		num2++;
        	}else {
        		num1++;
        	}
        }
        
        //计算比例 输出
        System.out.println("18以下："+ num1/(double)ageAry.length *100.0 +"%");
        System.out.println("18以上："+ num2/(double)ageAry.length *100.0 +"%");
	}
	
	//数组常见问题
	private static void test02() {
		//数组脚标越界异常(ArrayIndexOutOfBoundsException)
		int[] arr1 = new int[2];
		System.out.println(arr1[3]);
		
		//空指针异常(NullPointerException)
		int[] arr2 = null;
		System.out.println(arr2[0]);
	}
	
	//语法测试
	private static void test01() {
		//数组的声明
		int[] a1; 
		int a2 [];
		
		//数组的创建
		//方式一：声明数组的同时，根据指定的长度分配内存，但数组中元素值都为默认的初始化值。
		int[] arr1 = new int[5];
		//方式二：声明数组并分配内存，同时将其初始化。arr2的长度为4，元素的值为3,5,1,7
		int[] arr2 = new int[]{3,5,1,7};
		//方式三：直接赋值，方式二的简化版  arr3的长度为4，元素的值为3,5,1,7
		int[] arr3 = {3,5,1,7}; 
		
		//数组长度测试
		System.out.println("arr1的长度："+arr1.length);
		System.out.println("arr2的长度："+arr2.length);
		System.out.println("arr3的长度："+arr3.length);

		
		//数组的使用
		int[] arr4;
		arr4 = new int[5]; 
		arr4 [0] = 8;
		arr4 [0] = arr4[0] * 10;
		System.out.println(arr4[0]);
		
		/*
		 * 数组的使用： 1.声明 2.赋值 3.可以赋值 4.可以取值 5.获取数组长度 (1)取值：数组名[索引]; 索引从0开始 (2)赋值：数组名[索引] =
		 * 值; (3)length属性:获取数组的长度
		 * 
		 */

		String[] ary = new String[5]; // 声明并初始化数组
		ary[0] = "etc"; // 给数组中的第一个元素赋值
		ary[2] = "icss"; // 给数组中的第三个元素赋值
		ary[3] = "chinasofti";
		ary[4] = "aa";

		String val3 = ary[2]; // 获取数组中第三个元素赋值给val3
		System.out.println(val3);

		int len = ary.length; // 获取数组的长度
		System.out.println("数组的长度是：" + len);

		// 数组的遍历 for 增强for while
		for (int i = 0; i < ary.length; i++) {
			System.out.println(ary[i]);
		}

		/*
		 * 增强for循环 for(元素的数据类型 变量名: 数组名){ 循环体； }
		 * 
		 */
		for (String str : ary) {
			System.out.println(str);
		}

		int i = 0;
		while (i < ary.length) {
			System.out.println(ary[i]);
			i++;
		}
		
		
		
		//倒序遍历
		for (int j = ary.length-1; j >= 0; j--) {
			System.out.println(ary[j]);
		}
	}
}
