package org.example.week4.day21.communcation;

//生产者线程
public class Producer extends Thread {
	Product p;// 产品

	public Producer(Product p) {
		this.p = p;
	}
	@Override
	public void run() {
		int i = 0;
		//永真循环
		while(true) {
			synchronized (p) {  //同步代码块
				//没有产品:生产完    通知消费者去消费
				if(p.isFlag() == false) {
					if(i%2 == 0) {
						p.setName("上衣");
						p.setPrice(60);
					}else {
						p.setName("裤子");
						p.setPrice(70);
					}
					System.out.println("生产者生产了:"+p.getName()+"    价格："+p.getPrice());
					p.setFlag(true); //生产完成修改标识
					i++;
					p.notifyAll(); // 唤醒所有等待的线程。  去通知消费者去消费
					
				}else { //有产品：等待  等待消费者去消费
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
