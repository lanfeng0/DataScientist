package org.example.week4.day21.thread;
//线程停止测试---使用共享变量停止线程的示例
public class ThreadStopExample extends Thread{
	private boolean flag = true;
	public void stopThread() {
		this.flag = false;
	}
	public void run() {
		int i = 0;
		while(flag) {
			System.out.println("thread execute loop..." + i++);
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadStopExample st = new ThreadStopExample();
		st.start();
		Thread.sleep(5000);
		st.stopThread();
	}
}
