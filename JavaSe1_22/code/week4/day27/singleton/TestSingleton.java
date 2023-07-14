package org.example.week4.day27.singleton;

public class TestSingleton {

    private static Runtime runtime;
    private static Runtime runtime1;

    public static void main(String[] args) {

        System.out.println(Singleton1.getInstance()==Singleton1.getInstance());

        //测试枚举类型单例模式
        Singleton7 singleton7 = Singleton7.INSTANCE;
        singleton7.whateverMethod();
        //Enum types cannot be instantiated
        //new Singleton6();


        //测试Java自带Runtime类单例模式，创建的两个Runtime类对象一样
        runtime = Runtime.getRuntime();

        runtime1 = Runtime.getRuntime();

        System.out.println(runtime==runtime1);

    }
}
