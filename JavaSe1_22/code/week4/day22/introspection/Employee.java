package org.example.week4.day22.introspection;

/**
 * 
 * @author GuXue
 *
 */

//Employee类中根本没有声明name,age,score属性，
 //仅仅是声明了这样的getter和setter，内省机制就认为name,age和score是属性。
public class Employee {

	public Employee() {
	}

	
	//被内省为name属性
	public String getName() {
		return "zhangsan";
	}

	public void setName(String name) {
	}

	public int getAge() {
		return 18;
	}

	public void setAge(int age) {
	}

	public double getScore() {
		return 100;
	}

	public void setScore(double score) {
	}


	@Override    //注解
	public String toString() {
		return "Employee [getName()=" + getName() + ", getAge()=" + getAge() + ", getScore()=" + getScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
	
}
