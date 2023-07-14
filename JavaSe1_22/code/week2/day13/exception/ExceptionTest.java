package org.example.week2.day13.exception;

//异常的概念、异常结构及常见运行时异常
public class ExceptionTest {
	public static void main(String[] args) {
		// System.out.println("演示异常发生情况：");
		// 除数为0，运行的时候程序会抛出一个异常
		// System.out.println(100 / 0);
		// System.out.println("如果我被打印出来，就是异常被处理了。");

		// int[] a=new int[1024*1024*1024]; //错误

		// System.out.println(100 / 0); //运行期异常
		// FileReader fr = new FileReader(new File("a.tx"));//非运行期异常

		// String str1 = "";// 赋值的是空字符串，分配内存的
		// System.out.println(str1.length()); // 0 有地址没内容
		//
		// String str2 = null; // 赋值的是null，没有分配内存
		// System.out.println(str2.length()); // 没有创建对象，就调用方法，报空指针异常

		// int[] a = new int[3];
		// System.out.println(a[3]); //数组越界异常

		// String s = "abc";
		// System.out.println(Integer.parseInt(s)); //数字格式异常

		Object o = new Object();
		String ss = (String) o; //ClassCastException-类型转换异常


	}
}
