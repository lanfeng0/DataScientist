package org.example.week4.day21.thread;

//线程启动测试
public class CreateThreadByExtends extends Thread{
	public void run() {
		System.out.println("First thread with extend Thread @chinasofti");
	}
	public static void main(String[] args) {
		new CreateThreadByExtends().start();
	}
}
