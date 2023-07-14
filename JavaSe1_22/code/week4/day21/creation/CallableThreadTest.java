package org.example.week4.day21.creation;

import java.util.List;
import java.util.concurrent.FutureTask;

public class CallableThreadTest {
	public static void main(String[] args) {
		// 创建线程对象
		UserThread userThread = new UserThread(new UserService());
		FutureTask futureTask = new FutureTask(userThread);
		// 开启线程
		new Thread(futureTask).start();
		try {
			List<User> list = (List<User>) futureTask.get();
			System.out.println("线程结果:"+list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
