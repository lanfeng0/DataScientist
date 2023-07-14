package org.example.week1.day06;

//构造方法--理发店会员卡测试类
public class MemberCardTest {
	public static void main(String[] args) {
		MemberCard card1 = new MemberCard(); // 创建对象
		card1.saveMoney(1000);
		System.out.println("姓名："+card1.getName()+"\t会员卡号:"+card1.getCardNo()+"\t余额:"+card1.getBalance());
		MemberCard card2 = new MemberCard("lily", 2000); // 创建对象
		card2.consumption(1000);
		System.out.println("姓名："+card2.getName()+"\t会员卡号:"+card2.getCardNo()+"\t余额:"+card2.getBalance());
		MemberCard card3 = new MemberCard("lucy","13231231",3000); // 创建对象
		System.out.println("姓名："+card3.getName()+"\t会员卡号:"+card3.getCardNo()+"\t余额:"+card3.getBalance());
	}

}
