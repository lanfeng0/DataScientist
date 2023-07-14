package org.example.week2.day13.homework;

public class Market {
	private int id;  //id
	private String goods; //商品名
	private double price;  //价格
	private int num; //数量
	public Market() {
		super();
	}
	public Market(int id, String goods, double price) {
		super();
		this.id = id;
		this.goods = goods;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	//计算方法
	public double calc(double price,int num) {
		return num*price;
	}
	@Override
	public String toString() {
		return id + "\t " + goods + "\t" + price+ "￥";
	}
	
}

