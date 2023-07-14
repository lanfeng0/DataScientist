package org.example.week2.day08.finaltest;

/*
语法：[访问权限修饰符 final 数据类型 常量名 = 值; 
注意：
1.如果将某个变量修饰为final，那么该变量就成为常量。
2.被final修饰的常量必须在初始化的时候赋值，并且不能被修改
3.赋值方式：
  (1)可以直接赋值 
  (2)也可以通过构造方法赋值，如果有多个构造方法，每个构造方法都要对常量赋值
4.常量命名：全部大写，多个单词之间是有_分割
5.final通常和public、static一起声明

常量可读不可写  
使用场景:某一个变量，值是不改变，无论哪个对象调用值都是一样的，就可以用final修饰为常量
 */
public class FinalTest {
    //	public final class FinalTest {
    public static final int ROLE_USER = 1;  //常量
    public static final int ROLE_ADMIN = 2;
    private int role = 1;  //普通的成员变量
    public static final double PI = 3.14;  //常量
    public final int LEVEL;  //声明常量  如果加static，就不执行构造方法
    String name;

    public FinalTest() {  //赋值   使用构造方法赋值     或者  直接声明并赋值
        LEVEL = 1;
    }

    public FinalTest(final int a) {
//	  a=3;   //如果参数是被final修饰，也无法修改
        LEVEL = 2;
    }

    //1.如果将某个成员方法修饰为final，则意味着该方法不能被子类覆盖
    // 2.final和abstract不能同时修饰一个方法
    public final void test() {
        System.out.println("测试方法");
    }


    public static void main(String[] args) {
        System.out.println(FinalTest.PI);
        System.out.println(FinalTest.ROLE_ADMIN);
    }
}
