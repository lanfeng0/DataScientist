package org.example.week1.day06;
//用户实体类
public class UserPojo {
	// 属性私有化
	private String name;
	private int age;

	// 方法公有化
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
