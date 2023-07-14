package org.example.week4.day27.singleton;

/**
 * 懒汉式-方式1（线程不安全）
 *  从上面代码我们可以看出该方式在成员位置声明Singleton类型的静态变量，并没有进行对象的 赋值操作，那么什么时候赋值的呢？
 *  当调用getInstance()方法获取Singleton类的对象的时 候才创建Singleton类的对象，这样就实现了懒加载的效果。但是，如果是多线程环境，会出现 线程安全问题。
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
