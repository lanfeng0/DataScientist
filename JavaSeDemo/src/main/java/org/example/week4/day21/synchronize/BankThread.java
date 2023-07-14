package org.example.week4.day21.synchronize;

public class BankThread extends Thread {
	static double count = 500000; // 存款
	static Double d  = new Double(0);   //唯一
    static Object obj = new Object();
	public BankThread(String name) {
		super(name);
	}

	@Override
//	public synchronized void run() {   //同步方法，锁对象this对象  多个线程有多个对象  不生效
	public void run() {
	  test(this.getName());
	}
   
	
	//同步方法  ---  如果是静态的同步方法的锁，对象是当前函数所属的类的字节码文件（Class对象）---反射。
	public static synchronized void  test(String name) {
		while(true) {
//			synchronized ("锁") {  //1.唯一，否则不生效     2.不能写在循环外，否则第一个进来的人就会执行完再走
//			synchronized (obj) { 	
//			synchronized (d) { 
			if(count>0) {
					System.out.println(name+"取走了1000元，还剩"+(count-1000)+"元");
					count = count-1000;
				}else {
					System.out.println("取光了...");
					break;
				}
				
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
//		}
	}
	
	
	
	public static void main(String[] args) {
		BankThread  b1 = new BankThread("丈夫");
		BankThread  b2 = new BankThread("妻子");
		b1.start();
		b2.start();
	}
}
