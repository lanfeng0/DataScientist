package org.example.week2.day08.statictest;

//测试静态方法   卖票
//(1)静态成员方法只能对方法的局部变量或类的静态成员变量进行操作
//(2)静态成员方法没有this引用
public class TicketSeller {
    private static int count = 11;  //静态属性
    private int a;
    //卖票的静态方法
    public static void sellTicket() {
    	int a = 10;
    	count = count-1;
    	System.out.println("卖票的静态方法"+count);
    }
	
    public static void main(String[] args) {
		TicketSeller.sellTicket();  //直接通过类名调用方法，也可以对象名调用
		TicketSeller.sellTicket(); 
		System.out.println(Math.abs(-1));
	}
}
