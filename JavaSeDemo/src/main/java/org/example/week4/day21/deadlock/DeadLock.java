package org.example.week4.day21.deadlock;

//电池和遥控器（张三拿遥控器，李四拿电池，谁也不肯放手）
public class DeadLock extends Thread {
	public DeadLock(String name) {
		super(name);
	}
	
	//电池和遥控器都是共享资源，为了线程安全加锁
	@Override
	public void run() {
		//张三拿遥控器---等电池   
		if("张三".equals(this.getName())) {
			synchronized ("遥控器") {
				System.out.println("张三拿到了遥控器，准备拿电池....");
				synchronized ("电池") {
					System.out.println("张三拿到了遥控器也拿到了电池，吹着空调，吃着西瓜......");
				}
			}
		//李四拿着电池---等遥控器
		}else if("李四".equals(this.getName())) {
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			synchronized ("电池") {
				System.out.println("李四拿到了电池，准备拿遥控...");
				synchronized ("遥控器") {
					System.out.println("李四拿到了遥控器也拿到了电池，吹着空调，吃着西瓜......");
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		DeadLock d1 = new DeadLock("张三");
		DeadLock d2 = new DeadLock("李四");
		d1.start();
//		try {
//			d1.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();BLOCKED
//		}
		d2.start();
	}
}
