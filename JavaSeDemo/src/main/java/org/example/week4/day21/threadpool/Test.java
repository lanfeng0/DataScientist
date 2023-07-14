package org.example.week4.day21.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
	public static void main(String[] args) {
		  /*
		   corePoolSize：核心线程数，默认情况下核心线程会一直存活
		   maximumPoolSize：最大线程数
		   keepAliveTime：非核心线程的闲置超时时间，超过这个时间就会被回收。
		   unit：指定keepAliveTime的单位，如TimeUnit.SECONDS
		   workQueue：线程池中的任务队列(阻塞队列).常用的有三种队列，SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。
		     创建线程池对象
		   */
		 
		ThreadPoolExecutor  pool = new ThreadPoolExecutor(1, 3, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(3));
	    
		MyThread thread = new MyThread();  //创建线程对象
		pool.execute(thread);  //执行任务    核心线执行
		pool.execute(thread);   //添加到阻塞队列
		pool.execute(thread);//添加到阻塞队列
		System.out.println("------------- 执行三个任务-----------");
		System.out.println("核心线程数："+pool.getCorePoolSize());
		System.out.println("线程池中线程的数量:"+pool.getPoolSize());
		System.out.println("队列任务数:"+pool.getQueue().size());
		
		
		pool.execute(thread);  //添加到阻塞队列
		pool.execute(thread); //队列满了  创建新的线程(新的线程数+核心线程数<=最大线程数)
		pool.execute(thread);//队列满了  创建新的线程(新的线程数+核心线程数<=最大线程数)
		System.out.println("------------- 再三个任务-----------");
		System.out.println("核心线程数："+pool.getCorePoolSize());
		System.out.println("线程池中线程的数量:"+pool.getPoolSize());
		System.out.println("队列任务数:"+pool.getQueue().size());
		
		pool.execute(thread);  //队列满了  新的线程数+核心线程数>最大线程数    拒绝 报错
		
		pool.shutdown(); //关闭线程池
		
	}
	
}

class MyThread implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
