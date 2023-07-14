package org.example.week2.day10;

public class ObjecTest {
    public static void main(String[] args) {
        //Object类是Java语言中所有类的根，所有的类都直接或间接的继承了Object类；数组也继承了Object类；
//	   ObjecTest test = new ObjecTest();
//	   int[] a = new int[10];

        //toString方法测试  默认字符串的返回格式： getClass().getName() + '@' + Integer.toHexString(hashCode())。类名@哈希码值的十六进制形式
//	   Course c1 = new Course("java",90);
//	   Course c2 = new Course("java",90);
        //2、打印输出对象时，默认调用toString方法，如果想要自己限定格式，那么就重写toString方法
//	   System.out.println(c1.toString());
//	   System.out.println(c2.toString());

        //equals用来比较两个对象的虚地址，如果虚地址相同则返回true，否则返回false；
        //如果想要比较两个对象的内容，我们就要重写hascode方法和equals方法
//	   Course c1 = new Course("java",90);
//	   Course c2 = new Course("java",90);
//	   Course c3 = c2;  //把c2的对象的引用赋值给了c3  此时 c2和c3的虚地址是相同的
//	   System.out.println(c1==c2);   //比较虚地址    false
//	   System.out.println(c1.equals(c2));//比较虚地址    false  重写hashcode和equals方法后结果为true
//	   System.out.println(c2==c3);   //true
//	   System.out.println(c2.equals(c3)); //true

        //hashCode()方法
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = c2;
        System.out.println(c1);
        System.out.println(c1.hashCode());
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(Integer.toHexString(c1.hashCode()));
    }
}
