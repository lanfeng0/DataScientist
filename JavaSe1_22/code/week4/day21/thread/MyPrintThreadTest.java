package org.example.week4.day21.thread;

//创建线程 方式一：继承Thread类 重写run方法 测试
public class MyPrintThreadTest {
   public static void main(String[] args) {
	//创建线程对象
	MyPrintThread thread1 = new MyPrintThread("线程1");
	MyPrintThread thread2 = new MyPrintThread("线程2");
	
	/*
	 * 
	 * 1.启动线程(调用start方法)，线程将等待调度（到底什么时候被调度，不一定要看当前的操作系统分配资源的情况）
	 * 2.调度后，自动调用其run方法，run方法是等着被自动调用的。
	 * 3.结果：每一次都是随机的，再运行一次还是不一样，不同的机器结果不同，每次运行的结果也不同
	 * 
	 */
	
	//设置优先级，并不是优先级低的线程就没有机会运行，只是每次优先级高线程的时间片会长一些，得到的控制权的几率也会高一些。
	thread2.setPriority(Thread.MIN_PRIORITY);  //设置优先级
	thread1.setPriority(Thread.MAX_PRIORITY); //优先级高的，获取的可能性则高。
	System.out.println(thread1.getPriority());  //获取当前线程的优先级  ，默认是5
	System.out.println(thread2.getPriority());  
	
	thread1.start();  //启动线程1
	thread2.start();  //启动线程2
	

	
	
	System.out.println("main方法的最后一条语句");
	
	
}
}
