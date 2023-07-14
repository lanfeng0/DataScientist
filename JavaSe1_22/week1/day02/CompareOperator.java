package org.example.week1.day02;

//比较运算符
public class CompareOperator{
    public static void main(String[] args) {
    	// == 和！=  基本数据类型：比较值（二进制）  引用数据类型：比较地址
    	
		int a = 10;
		int b = 10;
		System.out.println(a==b);  //== 比较二进制 true
		String str1 = "20";   //等号直接赋值的时候  常量池中的地址相同
		String str2 = "20";
		System.out.println(str1 == str2);  //引用类型比较的是地址   true
		String str3 = new String("30");  //给str3赋值为30
		String str4 = new String("30");  //给str4赋值为30
		System.out.println(str3 == str4);  //false
		System.out.println(str3.equals(str4));  //比较两个字符串是否相等  true
		
		int c = 13;
		int d = 14;
		System.out.println("c>d:"+(c>d));  //false 
		System.out.println("c<d:"+(c<d));  //true
		System.out.println("c>=d:"+(c>=d)); //false
		System.out.println("c<=d:"+(c<=d)); //true
		System.out.println("c==d:"+(c==d)); //false
		System.out.println("c!=d:"+(c!=d)); //true
		
	    // == 比较基本数据类型比较的是二进制  0.3 0.6 1.2 。2.4   64   32   
	    // double 0.000000...00001   f 0.00....001
	    // 0.01 ==  0.01  true
	    System.out.println(0.3==0.3f);  // false  
	    System.out.println(0.5==0.5f);  // true 
	    System.out.println(1.1-0.9);
            
// == 比较基本数据类型比较的是二进制  0.3 0.6 1.2 。2.4   64   32   
	    // double 0.000000...00001   f 0.00....001
	    // 0.01 ==  0.01  true
        double d1 = 0.3;  //64
        float  d2 = 0.3f;   //32
        System.out.println(d1 == d2);  //false
        double d3 = 0.5;  
        float d4 = 0.5f;
        System.out.println(d3 == d4);  //true
		
	}
}
