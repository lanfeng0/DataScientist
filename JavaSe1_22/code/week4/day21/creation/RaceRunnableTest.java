package org.example.week4.day21.creation;

////龟兔赛跑 实现runnable接口测试
public class RaceRunnableTest {
   public static void main(String[] args) {
	
	//创建兔子的线程类对象
	MyThread3 r3 = new MyThread3();
	Thread t3 = new Thread(r3);
	t3.start();  //启动兔子的线程
	//创建乌龟的线程类对象
	MyThread4 r4 = new MyThread4();
	Thread t4 = new Thread(r4);
	t4.start();  //启动乌龟的线程
}
}
//兔子的线程
class MyThread3 implements Runnable{
	private int s = 100;   //100米短跑
	//线程执行的代码
	@Override
	public void run() {
		//永真循环
		while(true) {
			//s小于0，跑完全程
			if(s<0) {
				System.out.println("兔子跑完了");
				break; //结束线程
			}
			System.out.println("兔子领先了，加油,还剩下"+s+"米");
			s--;
			
		}
	}
}

//乌龟的线程
class MyThread4 implements Runnable{
	private int s = 100;   //100米短跑
	@Override
	public void run() {
		while(true) {
			if(s<0) {
				System.out.println("乌龟跑完了");
				break; //结束线程
			}
			System.out.println("乌龟领先了，加油,还剩下"+s+"米");
			s--;
		}
	}
}
