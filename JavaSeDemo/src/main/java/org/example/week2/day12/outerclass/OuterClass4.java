package org.example.week2.day12.outerclass;

//匿名内部类
public class OuterClass4 {
  private int age = 12;
  private String name = "jack";
  
  //匿名内部类
  IFoo foo = new IFoo() {
	  public void display() {
		  System.out.println(age+" "+name);
	  } 
  };
  
  public static void main(String[] args) {
	 OuterClass4 outer = new OuterClass4();
	 outer.foo.display();
}
}
