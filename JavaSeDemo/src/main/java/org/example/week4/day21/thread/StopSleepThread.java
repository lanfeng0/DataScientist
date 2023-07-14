package org.example.week4.day21.thread;
////线程停止测试---中断阻塞线程
public class StopSleepThread {
	public static void main(String[] args) {
		SleepThread st = new SleepThread();
		System.out.println("thread start...");
		st.start();
		st.interrupt();
	}
}

class SleepThread extends Thread{
	boolean flag = true;
	public void run() {
		while(flag) {
			try {
				Thread.sleep(1000 * 60 * 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("thread execution interupted!");
				flag = false;
			}
		}
	}
}
