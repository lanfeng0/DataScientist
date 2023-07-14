package org.example.week3.day16.set;

//实体类
public class BookEntity implements Comparable<BookEntity>{
	private String name;
	private double price;

	//重写比较的方法   如果返回的是0，重复元素
		@Override
		public int compareTo(BookEntity o) {
			System.out.println(name+"  compareto  "+o.name);
			//比较价格，如果价格相等，就继续比较name
			if(price > o.price) {
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
	
	
	//重写hashcode   是根据name和price的属性计算出的hash值
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(price);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		System.out.println(result);
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		BookEntity other = (BookEntity) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
//			return false;
//		return true;
//	}



	
}
