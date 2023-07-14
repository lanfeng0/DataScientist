package org.example.week1.day06.peysystem;
//子类继承父类 可以使用父类非私有的成员变量和方法  
public class Penguin extends Pet{
  private String sex;
  
  public String getSex() {
	  return sex;
  }
  
  public void printInfo() {
	  print();
	  System.out.print("\t 性别："+getSex()+"\n");
  }
}
