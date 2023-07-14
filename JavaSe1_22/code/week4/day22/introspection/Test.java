package org.example.week4.day22.introspection;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;

//内省测试
public class Test {
 public static void main(String[] args) throws Exception {
	//返回Employee类的BeanInfo对象
	 BeanInfo employeeInfo=Introspector.getBeanInfo(Employee.class);

	//使用BeanInfo返回PropertyDescriptor对象数组
	 PropertyDescriptor[] propsDes=employeeInfo.getPropertyDescriptors();
    

	//迭代所有的PropertyDescriptor，返回属性名字。
	 //由于从Object类继承getClass方法，所以属性名有class
//	for(PropertyDescriptor prop:propsDes){
//	  System.out.println(prop.getName());
//	}ss
	
	 Class c = Employee.class;
	 Constructor constructor =  c.getConstructor(null);
	 Employee emp = (Employee) constructor.newInstance(null);
	 
	//迭代所有的PropertyDescriptor，使用set方法对name和salary赋值,使用getter返回对应值
	for(PropertyDescriptor prop:propsDes){
	if(prop.getName().equals("name")){
	  prop.getWriteMethod().invoke(emp, "Alice");  //通过反射调用set方法赋值
	  System.out.println(prop.getReadMethod().invoke(emp));  //通过反射调用get方法取值
	}
	if(prop.getName().equals("score")){
	  prop.getWriteMethod().invoke(emp, new Double(10000));
	  System.out.println(prop.getReadMethod().invoke(emp));
	}
	}


}
}
