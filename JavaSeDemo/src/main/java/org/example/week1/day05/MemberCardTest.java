package org.example.week1.day05;

//理发店会员卡测试类
public class MemberCardTest {
	public static void main(String[] args) {
		MemberCard card1 = new MemberCard(); // 创建对象
		card1.saveMoney(1000); // 调用充值方法
		card1.consumption(200); // 调用消费方法
	}

}
