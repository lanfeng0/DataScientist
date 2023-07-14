package org.example.week2.day08.statictest;
//员工类   测试静态属性  

public class Employee {
	 String name;  //员姓名
	 double salary; //员工工资
	 static int count; // 静态变量 员工数量

	//无参构造
	public Employee() {
	}

	//有参构造
	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
		count++;  //员工数量自加1
	}
	//测试方法
	public static void main(String[] args) {
        Employee e1 = new Employee("lily",9000);    //创建lily的对象
        System.out.println(e1.name+"   "+e1.salary+"   "+Employee.count); // lily 9000  1
        Employee e2 = new Employee("alice",3000);   //创建alice的对象
        System.out.println(e2.name+"   "+e2.salary+"   "+e2.count); //alice  3000    2 
	}
}
