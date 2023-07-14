package org.example.week1.day06;

//构造方法测试---理发店会员卡类
public class MemberCard {
	private String name; // 姓名
	private String cardNo; // 卡号
	private String phone; // 手机号
	private double integral; // 积分
	private double balance; // 余额

	// 无参的构造方法，不写也默认存在
	public MemberCard() {
//		this("lily", 999);
	}

	// 构造方法重载
	public MemberCard(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	// 构造方法重载
	public MemberCard(String name, String cardNo, double balance) {
		// this(); 放在第一行，不报错
		this.name = name;
		this.cardNo = cardNo;
		this.balance = balance;
		// this();//放在这报错，必须放在第一行
	}

	// 查看姓名
	public String getName() {
		return name;
	}

	// 设置姓名
	public void setName(String name) {
		this.name = name;
	}

	// 查看卡号
	public String getCardNo() {
		return cardNo;
	}

	// 查看手机号
	public String getPhone() {
		return phone;
	}

	// 查看积分
	public double getIntegral() {
		return integral;
	}

	// 查看余额
	public double getBalance() {
		return balance;
	}

	// 设置卡号
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	// 设置手机号
	public void setPhone(String phone) {
		this.phone = phone;
	}

	// 设置积分
	public void setIntegral(double integral) {
		this.integral = integral;
	}

	// 设置余额
	public void setBalance(double balance) {
		this.balance = balance;
	}

	// 消费
	public void consumption(double conMoney) {
		double allMoney = 0;
		if (conMoney >= 2000) {
			allMoney = conMoney * 0.5;
		} else if (conMoney >= 1000 && conMoney < 2000) {
			allMoney = conMoney * 0.8;
		} else {
			allMoney = conMoney;
		}
		balance = balance - allMoney;
		System.out.println("账户当前余额是：" + balance);
	}

	// 充值
	public void saveMoney(double saveMoney) {
		balance = balance + saveMoney;
		System.out.println("账户当前余额是：" + balance);
	}

	public void hello() {
		System.out.println("hello world!");
	}

	public void sayHello() {
		this.hello();
	}

}
