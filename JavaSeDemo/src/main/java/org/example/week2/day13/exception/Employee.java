package org.example.week2.day13.exception;

public class Employee {
	private String name;  //姓名
	private double salary; //工资
	private String sex;  //性别

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}
	
	public String getSex() {
		return sex;
	}

	//设置性别
	public void setSex(String sex) throws SexException {  //声明异常
		if("男".equals(sex) || "女".equals(sex)) {
			this.sex = sex;
		}else {
			throw new SexException("性别只能是男或者女");  //抛异常
		}
		
	}

	//设置工资
	public void setSalary(double salary) throws DataValueException {  //声明异常
		if(salary<10000) {
			throw new DataValueException("工资不能低于10000");  //抛出异常
		}else {
			this.salary = salary;
		}
		
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setName("alice");
		try {  
			e.setSalary(10001);  //调用者处理异常
			e.setSex("111");//调用者处理异常
		} catch (DataValueException e1) { //处理异常
			e1.printStackTrace();
			System.out.println("工资不能低于一万，请重新输入");
		} catch (SexException e1) {
			e1.printStackTrace();
			System.out.println("性别不能为空");
		}
		
		System.out.println("程序继续执行");
	}


}
