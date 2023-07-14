package org.example.week1.day02;

/*
 注意：
 1.计算机存储设备的最小信息单元叫“位（bit）”，又称之为“比特位”；连续的8个位成为1个“字节（byte）”；
 2.默认值：整数--0  小数--0.0   char--\u0000(相当于空字符)  boolean -- false
 3.如果没有声明，一个小数默认是double类型，一个整数默认为int类型
 4.如果声明整数，通常使用int类型。eg：年龄  int age；
      如果声明小数，通常使用double类型。 eg:价格  double price
      如果声明一个字符标识，通常使用char类型。eg:性别、状态
      如果声明字符串，使用String类型 。eg：姓名、密码、手机号等
      如果声明一种状态，只有是或者不是的时候，使用boolean类型。eg:注册是否成功
 5.为什么存在i+1<i这样的数。
 6.float赋值需要加f eg:float f = 12.3f
 7.long赋值需要加L  eg:long l = 12321123231L
 8.小数转换成二进制来计算，所以会有精度缺失的问题
    System.out.println(0.3==0.3f);  // false  小数转二进制*2  0.3 0.6 1.2....
    System.out.println(0.5==0.5f);  // true  0.5*2 = 1  0.5f==0.5d
    System.out.println(1.1-0.9);  //0.20000000000000007  精度
    
 9.char ,单个字符，采用unicode编码，无符号位整数 , 取值范围0-2^16-1（2的16次幂-1） ,
       一个英文字母占一个字节，汉字占两个字节。使用''单引号赋值，也可以使用非负整数赋值
  
 * 
 */
public class DataType {
public static void main(String[] args) {
//	dataType1();  //数据类型
//	dataType2(); //数据类型
//    dataTypeChange(); //数据类型转换
    dataType(); //数据类型测试
}

	private static void dataType() {
//		int x = 3;
//		x = 3 + 5;
//		int x=3;
//	    byte b=5;
//	    x=x+b;
//
//		System.out.println(x);
		
//		byte b=3;
//	    //b=b+4;   //编译错误，因为4默认的是int类型  b+4类型提升为int类型   高精度与低精度不能直接转换
//		b=(byte)(b+4);
//		System.out.println(b);
	
		byte b=4;
        b=3+7;  //相当于直接给b赋值

        System.out.println('a');
        System.out.println('a'+1);

		

	}

private static void dataTypeChange() {
	System.out.println("----------------------类型转换-------------");
    /*
     基本数据类型转换
     自动转换(隐式转换)：低精度-->高精度  eg:byte b1 = 1 ;int b2; b2 = b1 
     强制转换(显示转换): 高精度--->低精度  eg:b1 = (byte)b2
     
     * 
     */
    
//	byte b=1;
//	int i=-2;
	//  表示范围小的可以直接转换为表示范围大的类型
//	 i=b;
	//b=i;  //报错
    
	 
//	 byte b=1;
//	 int i=-2;
	 // 表示范围大的不可以直接转换为转换范围小的类型,需要强制转换，称为显式转换
//	 b=(byte)i;
//	 int c=(char)i;
	 
	  byte b=1;
	  boolean b2=false;
	// "风马牛不相及"的boolean和数值类型，强制也不能转换；
	// b2=b; （编译错误）
	//b2=(boolean)b; （编译错误）


}

private static void dataType2() {
	byte b = -128;  //8   -128   127
	short s = 123; // 16  
	int i = 123; //32 
	long l = 12321123231L;//64  
	
    
    float f = 12.3f;  //结尾+f   32
    double d = 12.3;  //双精度   64
    
    // == 比较基本数据类型比较的是二进制  0.3 0.6 1.2 。2.4   64   32   
    // double 0.000000...00001   f 0.00....001
    // 0.01 ==  0.01  true
    System.out.println(0.3==0.3f);  // false  
    System.out.println(0.5==0.5f);  // true 
    System.out.println(1.1-0.9);
    
    
    System.out.println("--------------------------------------------------");
    
    char c1 = 'a';    //a
    char c2 = 98;    //b
    char c3 = '中';  //中
    char c4 = 'a'+'b';   // ?  char类型相加，提升为int类型 ,97+98
    char c5 = '9'; //9
    System.out.println(c5);
    
    boolean flag = false;   //布尔类型
    boolean flag1 = true;
}

private static void dataType1() {
	/* 变量 ：内存中的一小块区域，用来存储值的，通过变量名，来使用具体的变量值   
	   * 声明形式  : 数据类型  变量名  【=值】
	   * 
	   * */
	   
	   //用户名的变量   声明变量并赋值
	   String  userName = "zhangsan";
	   
	   /*
	    * 数据类型分为基本数据类型和引用数据类型
	    * 基本数据类型：分为四类八种
	    * 整型：byte short  int  long
	    * 浮点型：float double 
	    * 字符型：char
	    * 布尔型：boolean
	    * 
	    * 注意:1.如果用来存储整数，通常使用int类型
	    *      2.long赋值需要加l  eg:long l = 21474836479l
	    *      
	    * 存在i+1<i数?---存在  边界值的时候就存在这样的数
	    *      
	    */
	    
	    byte b = -127;   //byte 整数  8位  1  -128-127
	    short sh = 32767;  //short 整数 16  2   -32768-32767
	    int i = 2147483647;  //int 整数   32  4  
	    long l = 21474836479l; //长整型long  64 8 
	    
	    
	    int j = 2147483647; //声明变量并且赋值，int的边界值
	    if(j+1<j) {  //j+1 <j  
	    	System.out.println("存在"+(j+1));
	    }else {
	    	System.out.println("不存在");
	    }
}
}
