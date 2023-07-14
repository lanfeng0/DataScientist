package org.example.week4.day21.creation;

//测试创建线程的第二种方式
public class MyRunnableThreadTest {
	public static void main(String[] args) {
		MyThread r1 = new MyThread();
		// 创建一个线程作为外壳，将r1包起来
		Thread t1 = new Thread(r1);
		// 启动线程
		t1.start();

		MyThread r2 = new MyThread();
		// 创建一个线程作为外壳，将r2包起来
		Thread t2 = new Thread(r2);
		// 启动线程
		t2.start();
	}
}

// 创建线程的第二种方式 实现Runnable接口 重写run方法
// 打印输出0-100的数字，创建两个线程交替执行
class MyThread implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			// Thread.currentThread().getName() ---当前正在执行的线程的名字
			System.out.println(Thread.currentThread().getName() + "  i=" + i);
		}
	}
}
