package org.example.week1.day02;

public class BitOperator {
  /*
&：按位与  两位同时为1，才返回值1
|：按位或   只要有1位为1就返回值1 
^：按位异或  相同为0，不同时返回1 
~：按位非，将操作数的每一位(包括符号位)全部取反
<<:左移位，8<<2 ====8*2的2次幂=== 左操作数*2的右操作数次幂
>>:右移位，8>>2 ===8除以2的2次幂==== 左操作数除以2的右操作数次幂
>>>: 无符号又右移
 1248
 15:0000 1111
 6: 0000 0110
    
 
 15&6  0000 0110   6
 15|6  0000 1111   15
 15^6  0000 1001   9
 
 补码 = 反码+1  反码= 补码-1   反码--原码  除符号位 每位取反
 ~6  0000 0110  原码=反码=补码
 ~   1111 1001  补码
     1111 1000  反码
     1000 0111  原码   
~6   -7
     
~-6  1000 0110  原码
     1111 1001  反码
     1111 1010  补码= 反码+1
   ~ 0000 0101  补码=反码=原码    
~-6  5

正数：最高位0  原码=反码=补码
负数：最高位1  原码 反码=原码除符号位，每位取反  补码=反码+1


~1   0000 0001  原码 =反码=补码
 ~   1111 1110  补码
     1111 1101  反码
     1000 0010  原码     -2


 
   */
	public static void main(String[] args) {
		System.out.println(15&6);
		System.out.println(15|6);
		System.out.println(15^6);
		System.out.println(~6);
		System.out.println(~-6);
		System.out.println(8<<2);  //左操作数*2的右操作数次幂  32
		System.out.println(8>>2);  //左操作数除以2的右操作数次幂  2
		System.out.println(8>>>2);  //2
//		System.out.println(7>>2);  //7除以4 1  
	}
	
//	 public static void main(String[] args) {
//	     int x=1;
//	     int y=~x+1;
//	     System.out.println(x+" "+y);
//	}

}
