package org.example.week1.day03;

import java.util.Scanner;

//分支语句测试
public class BranchStatementTest {
	public static void main(String[] args) {
//		iftest01();   //if语句
//		iftest02();//if语句
//		ifelsetest01();  //if-else 结构
//		ifelsetest02(); //if-else 结构
//		ifelsetest03();//if-else 结构
//		ifelseiftest03();  //if-else if-else 结构
//		calcDiscount(); //嵌套if结构
//		test05();   //嵌套if结构
//		test06();  //三元运算符
//		switchTest01(); //switch结构
//		switchTest02();  //switch结构
	}

	
	private static void switchTest01() {
		int x = 2;
		switch (x) {
		case 0:
			System.out.println("你将退出系统");
			break;
		case 1:
			System.out.println("请输入用户名及密码：");
			break;
		case 2:
			System.out.println("Pls input your name and password");
			break;
		default:
			System.out.println("请按照提示选择1/2/3进行操作");
			break;
		}

	}
   
//   韩嫣参加计算机编程大赛
//   如果获得第一名，将参加麻省理工大学组织的1个月夏令营
//   如果获得第二名，将奖励惠普笔记本电脑一部
//   如果获得第三名，将奖励移动硬盘一个
//   否则，不给任何奖励
   /*
     switch(表达式){
        case 常量表达式1：
                           执行语句块1；
              break;
        case 常量表达式2：
                          执行语句块2;
             break;
            .......
        default:
                         执行语句块n；
             break;
     
     }
     注意：1.如果不加break，当表达式的值等于常量表达式1的值时，从语句1开始运行，依次运行语句2…3…直到结束
        2.常量表达式是具体的值，不能是范围
        3.如果加上break，多选一，只能执行其中一个语句块
        4.表达式只能使用规定的数据类型：byte short int char 枚举（enum） String
        5.case后面的常量必须各不相同
        6.default块放在末尾，也可以省略。相当于if语句中的else


    * 
    */



	private static void switchTest02() {
		int mingc = 13;
		// String mingc= "4";
		switch (mingc) {
		case 1: // if(mingc == 1) {
			System.out.println("将参加麻省理工大学组织的1个月夏令营");
			break;
		case 2: // else if(mingc == 2){
			System.out.println("将奖励惠普笔记本电脑一部");
			break;
		case 3: // else if(mingc == 3){
			System.out.println("将奖励移动硬盘一个");
			break;
		default: // else
			System.out.println("否则，不给任何奖励");
			break;
		}

		System.out.println("继续执行switch以外的代码");

		// if(mingc == 1) {
		// System.out.println("将参加麻省理工大学组织的1个月夏令营");
		// }else if(mingc == 2){
		// System.out.println("将奖励惠普笔记本电脑一部");
		// }else if(mingc == 3) {
		// System.out.println("将奖励移动硬盘一个");
		// }else {
		// System.out.println("否则，不给任何奖励");
		// }

	}



//输出两个数字中最大的值
   public static void test06() {
	   int a = 10;
	   int b = 2;
	   int max;  //存储最大的值
	   if(a>b) { //如果a>b
		   max=a;  //a的值赋值给max
	   }else {
		   max = b; //否则  b的值赋值给max
	   }
	   
	   System.out.println(max);
	   
	   //三目运算
	   int max2 = a>b?a:b;
	   System.out.println(max2);
   }
   
   
   //普通顾客购物满100元打9折；会员购物打8折；会员购物满200元打7.5折
   public static void calcDiscount() {
	   Scanner input = new Scanner(System.in);

		System.out.println("请输入是否是会员：（0-是，1-否）");
		int vip = input.nextInt();
		System.out.println("请输入购物金额：");
		double money = input.nextDouble();
		
		double discount = 1;
		if(vip==0){
			if(money>200){
				discount = 0.75;
			}else if(money>100){
				discount = 0.8;
			}
		}else{
			if(money>100){
				discount = 0.9;
			}
		}
		System.out.println("实际支付:"+(money*discount));
   }
  /* 
   * if的嵌套
   * 
   * 学校举行运动会，百米赛跑跑入15秒内的学生有资格进决赛，
      根据性别分别进入男子组和女子组
   嵌套if语句
   1.创建Scanner的对象
   2.获取控制台输入的时间
   3.判断是否有资格进决赛   time<15   有---继续执行4   没有--输出淘汰了 
   4.获取控制台输入的性别
   5.判断性别，分别进入男子还女子组
   6.套用语法
      *
      *
      */
    public static void test05() {
    	
//    	1.创建Scanner的对象
    	Scanner sc = new Scanner(System.in);
//    	2.获取控制台输入的时间
    	System.out.println("请输入时间");
    	double time =  sc.nextDouble();
//    	   3.判断是否有资格进决赛     有---继续执行4   没有--输出淘汰了 
    	if(time < 15) {
    		//  4.获取控制台输入的性别
    		System.out.println("请输入性别");
    		String sex = sc.next();
//     	   5.判断性别，分别进入男子还女子组
    		if("男".equals(sex)) {
    			System.out.println("进入男子组");
    		}else {
    			System.out.println("进入女子组");
    		}
    	}else {
    		System.out.println("淘汰了");
    	}
    	
    }
   
   
   
   

   
  

   
   /*
    if(判断语句1){
             执行语句块1;
    }else if (判断语句2){
             执行语句块2；
    }........
    else if(判断语句n){
             执行语句块n；
    }else{
             执行语句块;  //以上所有条件都不满足执行
    }
    
    注意： 1、多选一
        2、else语句可以省略，如果写那么所有判断语句都不满足的时候执行
    
    
    
1、岳小鹏参加Java考试，他和父亲岳不群达成承诺：
如果：
成绩为100分时，奖励一台华为Mete40 pro；
成绩为(80，99]时，奖励一台iPad；
当成绩为[60,80]时，奖励一个 switch；
其它时，什么奖励也没有。
请从键盘输入岳小鹏的期末成绩，并加以判断

    */
   public static void ifelseiftest03() {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("请输入岳小鹏的期末成绩:");
	   double score = sc.nextDouble();
	    if(score==100) {
	    	System.out.println("奖励一台华为Mete40 pro");
	    } else if(score>80 && score <= 99) {
	    	System.out.println("奖励一台iPad");
	    }else if(score>60 && score <=80) {
	    	System.out.println("奖励一个 switch");
	    }else {
	    	System.out.println("什么奖励也没有");
	    }
   }
   
// 用户输入两个数a、b。如果a能被b整除或a加b大于1000，则输出a；否则输出b
   /*
    * 1、创建scanner对象
    * 2、获取a和b的值
    * 3、用什么语法？ if-else
    * 4、判断条件    a%b==0 || a+b>1000
    * 5、语句块    if--输出a  else--输出b
    * 6.套语法  
    * 
    */
   public static void ifelsetest03() {
//	   * 1、创建scanner对象
	   Scanner sc = new Scanner(System.in);
//	    * 2、获取a和b的值
	   System.out.println("请输入a的值：");
	   int a = sc.nextInt();
	   System.out.println("请输入b的值：");
	   int b = sc.nextInt();
//	    * 3、用什么语法？ if-else
//	    * 4、判断条件    a%b==0 || a+b>1000
	   if(a%b==0 || a+b>1000) {
//		    * 5、语句块    if--输出a  else--输出b
		   System.out.println(a);
	   }else {
		   System.out.println(b);
	   }
	   
   }
   
   /*
    * 
    *  如果张浩Java考试成绩大于98分，老师就奖励他一个MP4，否则老师就罚他进行编码
    if(判断语句){
            执行语句块1；
    }else{
            执行语句块2；
    } 
    注意: 1.判断语句结果为true，执行if的语句块1，如果判断语句结果为false，执行else的语句块2 
        2.语句块1和语句块2只能执行其中一个      
        
    */
   public static void ifelsetest02() {
	   double score = 99;
	   if(score>98) {  //判断条件  boolean 
		  System.out.println("奖励mp4");  
	   }else {
		  System.out.println("代码敲100遍");  
	   }
	   
	   System.out.println("继续执行语句");
   }
   //输入一个数，判断它是奇数还是偶数。
   public static void ifelsetest01() {
		int x=10;
		if(x%2==0){
			System.out.println("x是偶数");
		}else{
			System.out.println("x是奇数");
		}
   }
   
   //张浩Java成绩大于98分，而且音乐成绩大于80分，老师奖励他；或者Java成绩等于100分，音乐成绩大于70分，老师也可以奖励他
   public static void iftest02() {
	   double score1 = 99;
	   double score2 = 81;
	   if(( score1 >98&& score2 > 80 ) || ( score1 == 100 && score2 > 70 )) {  //判断条件  boolean 
		  System.out.println("奖励");  
	   }
	   
	   System.out.println("继续执行语句");
   }
   
   
   //如果张浩Java考试成绩大于98分，老师就奖励他一个MP4.
   /*
    if(判断语句1){
                 执行语句；
    }
    注意：1.判断语句的返回值必须是boolean类型
       2.如果判断语句1为true，那么就执行语句;为false，就不会进if语句，会继续执行if后的代码
       
     步骤：
     1.判断使用什么语句？ if
     2.判断语句怎么写？ score >98 
     3.执行语句怎么写？奖励mp4
     4.套用语法
    * 
    */
   public static void iftest01() {
	   double score = 99;
	   if(score>98) {  //判断条件  boolean 
		  System.out.println("奖励mp4");  
	   }
	   
	   System.out.println("继续执行语句");
   }
}
