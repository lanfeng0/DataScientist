package org.example.week4.day27.singleton;

/**
 * 懒汉式-方式2（线程安全）
 * 该方式也实现了懒加载效果，同时又解决了线程安全问题。但是在getInstance()方法上添加了 synchronized关键字，
 * 导致该方法的执行效果特别低。从上面代码我们可以看出，其实就是在 初始化instance的时候才会出现线程安全问题，一旦初始化完成就不存在了。
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static synchronized Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
