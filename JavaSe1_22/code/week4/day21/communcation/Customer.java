package org.example.week4.day21.communcation;

//消费者线程
public class Customer extends Thread{
	Product p;// 产品

	public Customer(Product p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized (p) {  //同步代码块
				if(p.isFlag()==true) {   //有产品：去消费   通知生产者去生产
					System.out.println("消费者消费了："+p.getName()+"价格:"+p.getPrice());
					p.setFlag(false);  //修改产品标识
					p.notifyAll();  //唤醒所有等待的线程。 通知生产者去生产
				}else {//没产品：等待  等生产者生产
					try {
						p.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
}
