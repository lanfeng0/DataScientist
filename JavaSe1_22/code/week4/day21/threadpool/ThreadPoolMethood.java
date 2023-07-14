package org.example.week4.day21.threadpool;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolMethood {
public static void main(String[] args) throws InterruptedException, ExecutionException {
//	test01();
//	test02();
	test03();
}

private static void test03() throws InterruptedException, ExecutionException {
	//创建线程池对象
   ExecutorService es = Executors.newFixedThreadPool(3);	
   Set<Callable<String>> callables = new HashSet<>();  //创建set集合
    //向集合中添加数据 ，数据是实现Callable<String>的实现类对象(匿名内部类)
   callables.add(new Callable<String>() {

	@Override
	public String call() throws Exception {
		return "task1";
	}
   });
   
   callables.add(new Callable<String>() {

		@Override
		public String call() throws Exception {
			return "task2";
		}
	});
   callables.add(new Callable<String>() {

		@Override
		public String call() throws Exception {
			return "task3";
		}
	});
   
//   String result = es.invokeAny(callables);   //返回集合中任意一个对象 
//   System.out.println("result="+result);
   
     List<Future<String>> arys =  es.invokeAll(callables);  //返回集合中所有对象
     for (Future<String> future : arys) {
		System.out.println("future="+future.get());
	}
     es.shutdown();
}

private static void test02() throws InterruptedException, ExecutionException {
    ExecutorService es = Executors.newFixedThreadPool(3);	
//    Future future =  es.submit(new Runnable() {
//		@Override
//		public void run() {
//			System.out.println("执行异步任务");
//		}
//	});
//    
     Future<String> future =  es.submit(new Callable<String>() {
    	 @Override
    	public String call() throws Exception {
    		return "callable的执行结果";
    	}
	});
    System.out.println("future.get()=" +future.get());
}

private static void test01() {
	//newFixedThreadPool创建一个可重用固定个数的线程池  
    ExecutorService es = Executors.newFixedThreadPool(3);	
    
    //结果解析：由于设置最大线程数为3，所以在输出三个数后等待1s才继续输出
    for (int i = 1; i <=20; i++) {
		int index = i;
		es.execute(new Runnable() {   //执行任务
			@Override
			public void run() {
				System.out.println("第"+index+"个线程"+Thread.currentThread().getName()); 
				  try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			}
		});
		System.out.println("执行......");
		es.shutdown(); //关闭
		
	}
    
    //异步执行 
    //同步执行
}
}
