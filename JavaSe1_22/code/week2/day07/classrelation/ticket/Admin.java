package org.example.week2.day07.classrelation.ticket;

//管理员
public class Admin {
   //设置票为开放   方法如果加上static修饰符  可以直接用类名调用，无需创建对象
	public static void  open(Ticket ticket) {
		ticket.setState(true);
	}
	
  //设置票为关闭    参数:自定义类  引用类型
	public static void  close(Ticket ticket) {
		ticket.setState(false);
	} 
}
