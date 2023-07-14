package org.example.week1.day05;

//可变参数    求和，但是参数个数不定   2个数的和   3个数的和。。。。10个数之和
public class VariableParamTest {
	public static void main(String[] args) {
		VariableParamTest test = new VariableParamTest();
		// 调用方法传入2个参数
		System.out.println(test.sum(1, 2));
		// 调用方法传入4个参数
		System.out.println(test.sum(1, 2, 3, 4));
		
		
		//拥有可变参数的方法可以被重载，在被调用时，如果能匹配到参数定长的方法则优先调用参数定长的方法。
		test.comp(1, 2);
		
		//可变参数可以兼容数组参数，但数组参数无法兼容可变参数
//		test.print(1,2,3,4);
	}

	// 求和方法就是一个可变参数
	// 编译器创建一个隐含的数组，访问ary 以数组的形式访问
	public int sum(int... ary) {
		int sum = 0; // 和
		// 遍历可变参数的隐含数组，
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i]; // 求和
		}
		return sum;
	}
	
	
	public void comp(int... items) {
		System.out.println("执行了comp(int... items)方法");
	}

	public void comp(int a,int b) {
		System.out.println("执行了comp(int a,int b)方法");
	}
	//变参数和数组作为参数去实现重载时，会报错，说明可变参数与数组冲突以像操作数组一样操作该参数
//	public void comp(int[] items) {
//		System.out.println("执行了comp(int... items)方法");
//	}
	
	
	public void print(int[] items) {
	System.out.println("执行了comp(int... items)方法");
}
}
