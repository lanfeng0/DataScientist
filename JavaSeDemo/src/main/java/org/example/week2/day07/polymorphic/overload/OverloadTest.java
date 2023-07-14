package org.example.week2.day07.polymorphic.overload;
//方法重载
/*
 * 方法重载：方法名相同，参数不同 (类型不同，个数不同，顺序不同)
 * 同一作用域  （同一个类中或者子父类关系中）
 * 注意：方法重载和返回值无关，只有返回值类型不同，不是方法重载
 *       请勿将功能完全不一样的方法进行重载！
 *    
 *  调用：1.编译器会根据调用时传递的实际参数自动判断具体调用的是哪个重载方法.
 *        (1)如果能找到完全一致参数的方法 ---调用对应的方法
 *        (2)如果都是同类型（比如：整型和浮点型），此时传递的参数没有对应的方法，那么低精度就会去调用高精度的方法
 *        (3)如果都是同类型（比如：整型和浮点型），此时只写了int double，但是参数传的long类型 ,那么会去调用同精度的double类型
 *        (4)如果是字符串和字符、boolean，类型完全不同的，不符合2.3点
 *       
 */
public class OverloadTest {
   //思考:两个整数相加  三个整数相加  两个小数相加  三个小数相加  小数和整数相加......
    
//	public byte add(byte a,byte b) {
//		return (byte)(a+b);
//	}
	//两个整数相加
	public int add(int a,int b) {
		return a+b;
	}
	//三个整数相加   和add(int a ,int b)属于个数不同
	public int add(int a ,int b ,int c) {
		return a+b+c;
	}
	//两个小数相加    和add(int a ,int b)属于类型不同
	public double add(double a,double b) {
		return a+b;
	}
	//三个小数相加
	public double add(double a ,double b ,double c) {
		return a+b+c;
	}
	//一个小数和整数相加
	public double add(int a,double b ) {
		return a+b;
	}
	//一个小数和整数相加   和add(int a,double b )属于顺序不同
	public double add(double a,int b ) {
		return a+b;
	}
	
	//只有返回值类型不同，不是方法重载   此方法报错，只为测试
//	public double add(int a,int b ) {
//		return a+b+1.1;
//	}
	
	public static void main(String[] args) {
		OverloadTest overload = new OverloadTest();
		long i = 1L;
		long j = 2L;
		double sum1 = overload.add(i, j);
		System.out.println(sum1);
	}
}
