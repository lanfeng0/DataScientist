package org.example.week2.day07.classrelation.ticket;

//票的类
public class Ticket {
	private String id; // 车次id
	private double price; // 价格
	// 状态 true--开放状态 可以购买 false --关闭状态 不可以购买
	private boolean state = false;

	public Ticket() {
	}

	// 有两个参数的构造
	public Ticket(String id, double price) {
		super();
		this.id = id;
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
