package org.example.week4.day21.synchronize;

//模拟三个窗口同时在售50张票
public class SaleTicket extends Thread {
	static int num = 50; // 一共50张票 静态变量被所有对象所共享

	static Object obj = new Object(); // 不是唯一的 ,加个static就是唯一的

	public SaleTicket(String name) {
		super(name);
	}

	@Override
	public void run() {
		// 永真循环
		while (true) {
			// synchronized ("锁") {
			// 同步代码块 共享对象可以是任意对象，可以是字符串也可以是自定义对象，但是必须是唯一的，否则无效
			// 多线程操作的锁对象必须是唯一共享的，否则无效。
			synchronized (obj) {
				// 余票大于0的时候，卖票
				if (num > 0) {
					System.out.println(this.getName() + "卖了一张票，还剩" + (num - 1) + "张票");
					num--;
				} else { // 等于或者小于0的时候，显示卖完了
					System.out.println("票卖完了");
					break;
				}

				try {
					Thread.sleep(5000); // 休眠5秒钟 ,在同步代码块中调用sleep方法并不会释放锁对象的
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		SaleTicket t1 = new SaleTicket("窗口一");
		SaleTicket t2 = new SaleTicket("窗口二");
		SaleTicket t3 = new SaleTicket("窗口三");

		t1.start();
		t2.start();
		t3.start();
	}
}
