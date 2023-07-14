package org.example.week2.day10;

public class Course implements Cloneable{  //clone 必须实现此接口，否则抛异常
	private String name; // 课程名
	private double score; // 分数

	// 无参构造
	public Course() {
	}

	// 有参构造
	public Course(String name, double score) {
		super();
		this.name = name;
		this.score = score;
	}

	
	//重写hashcode方法
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	//重写equals方法
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		return true;
	}

	
	//重写Object类的toString方法， 来限定对象的输出格式，通常测试使用
	@Override
	public String toString() {
		return "name=" + name + "\tscore=" + score ;
	}
   
	
	//
	public static void main(String[] args) throws CloneNotSupportedException  {
		Course c1 = new Course("java",90);
		//1.Clone方法能够“复制”一个对象，生成一个新的引用，分配新的内存空间；
		//2.一个类必须实现Cloneable接口，才能被克隆，否则抛出异常；
		Course c2 = (Course) c1.clone();
		System.out.println(c2);
		System.out.println(c1==c2);  //false
		System.out.println(c1.equals(c2));  //true
	}
	
}
