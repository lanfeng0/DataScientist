package org.example.week3.day16.map;

//实体类
public class BookEntity implements Comparable<BookEntity>{
	private String name;
	private double price;
	
	@Override
	public int compareTo(BookEntity o) {
		if (price>o.price) {
			return 1;
		}else if(price == o.price) {
			return name.compareTo(o.name);
		}else {
			return -1;
		}
	}
	
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

	//需要重写hashcode和equals方法
	@Override
	public String toString() {
		return "BookEntity [name=" + name + ", price=" + price + "]";
	}



}
