package org.example.week2.day07.classrelation.ticket;

public class Test {
	public static void main(String[] args) {
		// 两张车票
		Ticket t1 = new Ticket("2549", 160);   //车票默认关闭  无法购买
		Ticket t2 = new Ticket("d52", 195);   //车票默认关闭  无法购买
		
		// 创建两个用户
		User user1 = new User("alice", "女");
		User user2 = new User("jack", "男");
		
		Admin.close(t1);   //管理员设置2549 为开放
		Admin.open(t2);  //管理员设置d52为关闭状态
		
		//以下测试一对一情况  一个用户一次只能购买一张车票
//		user1.buyTicket(t1);   //alice购买2549   --  购买成功
//		user2.buyTicket(t2);  //jack购买  d52   -- 购买失败
//		user1.viewInfo();  
//		user2.viewInfo();
		
		
		//以下测试一对多情况  一个用户一次可以购买一张车票，最多两张、
		Ticket[] tickets = new Ticket[2];   
		tickets[0] = t1;
		tickets[1] = t2;
		user1.buyTicket(tickets);  //alice 购买了2549和d52两张车票
		user1.viewInfo();
	
	}
}
