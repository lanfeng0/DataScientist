package org.example.week3.day15;

public class Book implements Comparable<Book>{
	private String bname;
	private double price;

	public Book() {
	}

	public Book(String bname, double price) {
		super();
		this.bname = bname;
		this.price = price;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bname=" + bname + ", price=" + price + "]";
	}

	
	//重写
	@Override
	public int compareTo(Book o) {
		if(this.price >o.getPrice()) {
			return 1;
		}else if(this.price == o.getPrice()) {
			return 0;
		}else {
			return -1;
		}
	}

}
