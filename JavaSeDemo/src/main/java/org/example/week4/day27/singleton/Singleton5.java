package org.example.week4.day27.singleton;

/**
 * 懒汉式-方式3（双重检查锁）
 * 再来讨论一下懒汉模式中加锁的问题，对于 getInstance() 方法来说，
 * 绝大部分的操作都是读 操作，读操作是线程安全的，所以我们没必让每个线程必须持有锁才能调用该方法，我们需要调整 加锁的时机。由此也产生了一种新的实现模式：双重检查锁模式
 * 双重检查方式
 * 双重检查锁模式是一种非常好的单例实现模式，解决了单例、性能、线程安全问题，上面的双重检 测锁模式看上去完美无缺，其实是存在问题，
 * 在多线程的情况下，可能会出现空指针问题，出现问 题的原因是JVM在实例化对象的时候会进行优化和指令重排序操作。 要解决双重检查锁模式带来空指针异常的问题，
 * 只需要使用 volatile 关键字, volatile 关 键字可以保证可见性和有序性。
 * 小结： 添加 volatile 关键字之后的双重检查锁模式是一种比较好的单例实现模式，能够保证在多线程 的情况下线程安全也不会有性能问题。
 */
public class Singleton5 {
    // 私有构造方法
    private Singleton5() {
    }

    private static volatile Singleton5 instance;

    // 对外提供静态方法获取该对象
    public static Singleton5 getInstance() {
        // 第一次判断，如果instance不为null，不进入抢锁阶段，直接返回实例
        if (instance == null) {
            synchronized (Singleton5.class) {
                // 抢到锁之后再次判断是否为null
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}