package org.example.week4.day27.singleton;

/**
 * 饿汉式-方式2（静态代码块方式）
 * 该方式在成员位置声明Singleton类型的静态变量，而对象的创建是在静态代码块中，也是对着 类的加载而创建。所以和饿汉式的方式1基本上一样，当然该方式也存在内存浪费问题。
 */
public class Singleton2 {
    private static Singleton2 instance = null;

    static {
        instance = new Singleton2();
    }

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
