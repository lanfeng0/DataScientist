package org.example.week3.day15;

//泛型方法
public class Box1 {
  public static void main(String[] args) {
	Integer[] integerAry =  new Integer[] {1,2,3,4};  //创建Integer类型的数组
	printArrary(integerAry);  //调用打印方法
	
	String[] strAry = new String[] {"a","c","b"}; //创建String类型的数组
	printArrary(strAry); //调用打印方法
	
	//创建Book类型的数组
	Book[] bookAry = new Book[] {new Book("java", 80),new Book("java1", 60),
			new Book("java2", 70)};
	printArrary(bookAry); //调用打印方法
}    
	
	
	//打印数组的泛型方法  <E> 声明泛型   参数：泛型数组E[]
	public static <E> void printArrary(E[] inputAry) {
		for (E e : inputAry) {
			System.out.print(e+"  ");
		}
		System.out.println();
	}
}
