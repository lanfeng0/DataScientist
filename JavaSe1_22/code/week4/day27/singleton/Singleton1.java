package org.example.week4.day27.singleton;

//

/**
 * 单例模式(饿汉式-方式1（静态变量方式）):该方式在成员位置声明Singleton类型的静态变量，并创建Singleton类的对象instance。 instance对象是随着类的加载而创建的。如果该对象足够大的话，而一直没有使用就会造成内存 的浪费。
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
