package org.example.week4.day21.thread;

//sleep方法测试
public class TestSleep {
	public static void main(String[] args) {
		System.out.println("Wait");
		// 让主线程等待5秒再执行
		Wait.bySec(5);
		// 提示恢复执行
		System.out.println("start");
	}
}
class Wait {
	public static void bySec(long s) {
		// sleep s个1秒
		for (int i = 0; i < s; i++) {
			System.out.println(i + 1 + "秒");
			try {
				// sleep1秒
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

