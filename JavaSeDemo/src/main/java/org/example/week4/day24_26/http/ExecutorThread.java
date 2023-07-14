package org.example.week4.day24_26.http;

public class ExecutorThread extends Thread{
	boolean runningFlag;
	private Runnable callBack;
	public void setCallBack(Runnable callBack) {
		this.callBack = callBack;
	}
	public synchronized void setRunning(boolean flag) {
		runningFlag = flag;
		if(flag) {
			this.notifyAll();
		}
	}
	public ExecutorThread(String name) {
		setName(name);
	}
	public synchronized void run() {
		try {
			while(true) {
				if(!runningFlag) {
					this.wait();
				}else {
					System.out.println(Thread.currentThread().getName() + "鎵ц");
					callBack.run();
					setRunning(false);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
