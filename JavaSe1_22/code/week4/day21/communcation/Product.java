package org.example.week4.day21.communcation;

//产品类
public class Product {
	private String name; // 商品名称
	private double price; // 商品价格
	private boolean flag = false; // 是否有产品的标识 false--没有 true--有

	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", flag=" + flag + "]";
	}

}
