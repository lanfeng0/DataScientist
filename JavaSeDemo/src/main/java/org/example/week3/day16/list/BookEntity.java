package org.example.week3.day16.list;

//图书类型
public class BookEntity {
	private String name;
	private double price;

	public BookEntity() {
	}

	public BookEntity(String name, double price) {
		super();
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

	@Override
	public String toString() {
		return "BookEntity [name=" + name + ", price=" + price + "]";
	}

}
