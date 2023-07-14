package org.example.week4.day21.semap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//信号量
public class SemapDemo implements Runnable {
	// 创建信号量对象，只能5个线程同时访问
	Semaphore semp = new Semaphore(5);

	@Override
	public void run() {
		try {
			semp.acquire();// 获取许可
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "，完成");
			// 访问完 释放   如果把下面语句注释掉 ，控制台只能打印5条数据，就一直阻塞
			semp.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		SemapDemo semapDemo = new SemapDemo();
		//创建固定数目线程的线程池
		ExecutorService es =  Executors.newFixedThreadPool(20);
		//模拟20个客户端访问
		for (int i = 0; i < 20; i++) {
			es.execute(semapDemo);  //执行任务
		}
		//退出线程池
		es.shutdown();
	}
}
