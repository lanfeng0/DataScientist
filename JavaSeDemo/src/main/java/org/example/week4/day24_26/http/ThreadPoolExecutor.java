package org.example.week4.day24_26.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadPoolExecutor {
	private List<ExecutorThread> threads;
	public ThreadPoolExecutor(int threadCount) {
		threads = Collections.synchronizedList(new ArrayList<>());
		for(int i = 1; i <= threadCount; i++) {
			ExecutorThread et = new ExecutorThread("绾跨▼" + i);
			threads.add(et);
			et.start();
		}
	}
	public void execute(Runnable callBack) {
		int i ;
		for(i = 0 ; i < threads.size(); i++) {
			ExecutorThread currentThread = threads.get(i);
			if(!currentThread.runningFlag) {
				currentThread.setCallBack(callBack);
				currentThread.setRunning(true);
				return ;
			}
		}
		if(i == threads.size()) {
			System.out.println("绾跨▼璧勬簮宸茬粡鐢ㄥ畬锛岃绋嶅悗鍐嶈瘯");
		}
	}
	public static void main(String[] args) {
		MyThread mt1 = new MyThread(100);
		MyThread mt2 = new MyThread(200);
		MyThread mt3 = new MyThread(300);
		MyThread mt4 = new MyThread(400);
		MyThread mt5 = new MyThread(500);
		MyThread mt6 = new MyThread(600);
		
		ThreadPoolExecutor pool = new ThreadPoolExecutor(5);
		pool.execute(mt1);
		pool.execute(mt2);
		pool.execute(mt3);
		pool.execute(mt4);
		pool.execute(mt5);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		pool.execute(mt6);
		
	}
}

class MyThread implements Runnable {
	private int i;
	public MyThread(int i) {
		this.i = i; 
	}
	public void run() {
		System.out.println(Thread.currentThread().getName() + " 鏁板瓧i = " + i);
	}
}
