package org.example.week4.day21.creation;

// 打印输出0-100的数字，创建两个线程交替执行
//创建线程 方式一：继承Thread类 重写run方法 
public class MyPrintThread extends Thread{
	//有参数的构造方法--参数 线程名字
	public MyPrintThread(String name) {
		super(name);  //调用Thread中的构造方法
	}
	
	//run方法的方法体就是线程的执行体
	@Override
	public void run() {
		for (int i = 0; i <= 100; i++) {
			try {
				//休眠1秒钟，此线程进入阻塞状态，苏醒之后，进入可运行状态，不是立刻执行
				Thread.sleep(1000);  
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(this.getName()+ "i="+i);
		}
	}

}
