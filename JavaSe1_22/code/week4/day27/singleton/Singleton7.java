package org.example.week4.day27.singleton;

/**
 * 这是一个使用枚举实现的单例模式示例，该示例是使用枚举类中的一个常量来表示单例对象。
 * 在这个示例中，Singleton6 是一个枚举类，拥有一个名为 INSTANCE 的枚举常量。这个枚举常量表示这个单例对象的实例。
 * 通过使用枚举的方式，可以简洁地创建线程安全的单例对象，并且天然地提供了序列化和反射安全的保证。
 * 你可以通过 Singleton6.INSTANCE 来获取 Singleton6 类的实例，并可以调用 whateverMethod() 方法来执行其他操作。
 * 以下是一个示例用法：
 * Singleton6 singleton = Singleton6.INSTANCE;
 * singleton.whateverMethod();
 * 通过枚举的方式实现单例模式，可以确保在多线程环境下也能保持单例的唯一性，并且还能防止通过反射和序列化创建新的实例。
 *
 *
 * 枚举方式
 * 枚举类实现单例模式是极力推荐的单例实现模式，因为枚举类型是线程安全的，并且只会装载一 次，设计者充分的利用了枚举的这个特性来实现单例模式，枚举的写法非常简单，
 * 而且枚举类型是 所用单例实现中唯一一种不会被破坏的单例实现模式。
 *  枚举方式属于恶汉式方式。
 */
public enum Singleton7 {
    INSTANCE;

    public void whateverMethod() {
        System.out.println("运行了whateverMethod方法");
    }
}  
