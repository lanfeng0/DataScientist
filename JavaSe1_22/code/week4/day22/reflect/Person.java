package org.example.week4.day22.reflect;

public class Person {
	 String name;
	 Integer age;
	String defaultStr;
	protected String  protectStr;
	public String publicStr;
	int age1;
	

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

//	@Override
//	public String toString() {
//		return "Person [name=" + name + ", age=" + age + "]";
//	}
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]"+age1+" "+defaultStr+" "+protectStr+"  "+publicStr;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
