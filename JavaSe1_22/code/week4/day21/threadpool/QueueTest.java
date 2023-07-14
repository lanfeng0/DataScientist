package org.example.week4.day21.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTest {
  public static void main(String[] args) throws InterruptedException {
	//无边界队列，无长度限制   
//	  ConcurrentLinkedQueue<String>  clq =  new ConcurrentLinkedQueue<>(); 
//	  //入队
//	  clq.add("aaa");
//	  clq.add("bbb");
//	  clq.add("ccc");
//	  //出队
//	  System.out.println(clq.poll()); //取出元素并移除元素
//	  System.out.println(clq.size());   //2
//	  System.out.println(clq.peek());  //取出元素但是不移除元素
//	  System.out.println(clq.size());
	  
	  
	  //阻塞队列
	  BlockingQueue<String> bq = new LinkedBlockingQueue<>(3);
	  bq.offer("aaa");
	  bq.offer("ccc");
	  bq.offer("ddd");
//	  bq.offer("eeee");  // 无法插入
	  System.out.println(bq.size());  //获取元素的个数
	  System.out.println(bq.poll());  //取出元素并移除元素
	  bq.offer("eee", 3, TimeUnit.SECONDS);   //经过三秒来添加元素
	  System.out.println(bq.poll());  
	  System.out.println(bq.poll());  
	  System.out.println(bq.poll());  
	  System.out.println(bq.poll());  //什么都没有 取出来的为空
	  
	  /*
	   corePoolSize：核心线程数，默认情况下核心线程会一直存活
	   maximumPoolSize：最大线程数
	   keepAliveTime：非核心线程的闲置超时时间，超过这个时间就会被回收。
	   unit：指定keepAliveTime的单位，如TimeUnit.SECONDS
	   workQueue：线程池中的任务队列(阻塞队列).常用的有三种队列，SynchronousQueue,LinkedBlockingDeque,ArrayBlockingQueue。
	   */
	  ThreadPoolExecutor  t = new ThreadPoolExecutor(1, 3, 0, TimeUnit.MICROSECONDS, new LinkedBlockingQueue<>(3));
	  
}
}
