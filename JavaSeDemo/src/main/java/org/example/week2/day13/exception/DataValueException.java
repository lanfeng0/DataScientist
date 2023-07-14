package org.example.week2.day13.exception;

//自定义异常步骤：1.继承父类异常 2.重载构造方法，调用父类的构造方法    工资不能低于1万的异常
public class DataValueException extends Exception{
   public DataValueException(String msg) {
	   super(msg);
 }
}
