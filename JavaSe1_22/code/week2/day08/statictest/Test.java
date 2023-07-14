package org.example.week2.day08.statictest;

public class Test {
	
	//测试方法
	public static void main(String[] args) {
        Employee e1 = new Employee("lily",9000);    //创建lily的对象
        System.out.println(e1.name+"   "+e1.salary+"   "+Employee.count); // lily 9000  1
        Employee e2 = new Employee("alice",3000);   //创建alice的对象
        System.out.println(e2.name+"   "+e2.salary+"   "+e2.count); //alice  3000    2 
       
        
        //不同类之间的调用   
        //调用静态方法---使用类名  
        StaticTest.f();
        StaticTest.g();
        //调用非静态方法---创建对象，通过对象名调用
        StaticTest test = new StaticTest();
        test.a();
        test.b();
	}

}
