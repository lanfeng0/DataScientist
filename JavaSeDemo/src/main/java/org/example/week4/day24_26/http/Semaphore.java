package org.example.week4.day24_26.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Semaphore {
	private List<Object> locks = Collections.synchronizedList(new ArrayList<Object>());
	private int permitNum = 1;
	private int nowPermitNum = 1;
	private boolean permitNumGrow = false;
	private boolean fair = false;
	private Random random = new Random();
	static WareHouse buffer = new WareHouse();
	public Semaphore(int permitNum, boolean permitNumGrow, boolean fair) {
		this.permitNum = permitNum;
		this.nowPermitNum = permitNum;
		this.permitNumGrow = permitNumGrow;
		this.fair = fair;
	}
	public Semaphore(int permitNum) {
		this(permitNum,true,false);
	}
	public Semaphore() {
		this(1);
	}
	public void acquire() {
		Object lock = new Object();
		synchronized (lock) {
			if(nowPermitNum > 0) {
				nowPermitNum--;
			}else {
				locks.add(lock);
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void release() {
		if(locks.size() > 0) {
			int index = 0;
			if(!fair) {
				index = Math.abs(random.nextInt()) % locks.size();
			}
			Object lock = locks.get(index);
			locks.remove(lock);
			synchronized (lock) {
				lock.notify();
			}
		}else if(nowPermitNum < permitNum || permitNumGrow) {
			nowPermitNum++;
		}
	}
	public int getAvailablePermitNum() {
		return nowPermitNum;
	}
	
	static class WareHouse{
		final Semaphore notFull = new Semaphore(10);
		final Semaphore notEmpty = new Semaphore(0);
		final Semaphore mutex = new Semaphore(1);
		final String[] items = new String[10];
		int putptr;
		int takeptr;
		int count;
		public void put(String x) {//鏀剧疆鍟嗗搧
			notFull.acquire();//淇濊瘉闈炴弧
			mutex.acquire();//淇濊瘉涓嶅啿绐?
			try {
				items[putptr] = x;
				if(++putptr == items.length) {
					putptr = 0;
				}
			} finally {
				mutex.release();
				notEmpty.release();
			}
		}
		public String take() {
			notEmpty.acquire();
			mutex.acquire();
			try {
				String x = items[takeptr];
				if(++takeptr == items.length) {
					takeptr = 0;
				}
			--count;
			return x;
			} finally {
				mutex.release();//閫?鍑烘牳蹇冨尯
				notFull.release();//澧炲姞闈炴弧鐨勪俊鍙烽噺锛屽厑璁稿姞鍏ュ晢鍝?
			}
		}
	}
	
	static class Producer implements Runnable{
		static int num = 1;
		Random random = new Random();
		public String getRandomCharList(char[] randomElement, int stringLength) {
			String resultString = "";
			StringBuffer tempString = new StringBuffer();
			int i = -1;
			int randomIndex = -1;
			for(i = 0 ; i < stringLength; i++) {
				randomIndex = Math.abs(random.nextInt() % randomElement.length);
				tempString.append(randomElement[randomIndex]);
			}
			resultString = tempString.toString();
			return resultString;
		}
		@Override
		public void run() {
			int n = num++;
			while(true) {
				try {
					int length = Math.abs(random.nextInt()) % 32;
					long time = Math.abs(random.nextLong()) % 1000 + 500;
					String str = getRandomCharList("abcdefghijklmnopqrstuvwxyz".toCharArray(), length);
					buffer.put(str);
					System.out.println("鐢熶骇鑰呯敓浜т簡瀛楃涓诧細" + str);
					Thread.sleep(time);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	static class Customer implements Runnable{
		ExecutorService tpm = Executors.newCachedThreadPool();
		Random random = new Random();
		@Override
		public void run() {
			while(true) {
				try {
					long time = Math.abs(random.nextLong()) % 300;
					Thread.sleep(time);
					String res = buffer.take();
					Runnable task = ()->System.out.println("娑堣垂鑰呭鐞嗗瓧绗︿覆锛?" + res);
					tpm.execute(task);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	public static void main(String[] args) {
		for(int i = 0; i <= 3; i++) {
			new Thread(new Producer()).start();
		}
		new Thread(new Customer()).start();
	}
}
