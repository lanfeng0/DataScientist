package org.example.week4.day21.creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallDemo {
	public static void main(String[] args) {
		// (1)创建Callable实现类的实例化对象
		CallableThreadDemo ctd = new CallableThreadDemo();
		// (2)创建FutureTask对象，并将Callable对象传入FutureTask的构造方法中
		// 注意：Callable需要依赖FutureTask，用于接收运算结果。
		//一个产生结果，一个拿到结果。FutureTask是Future接口的实现类。
		FutureTask<Integer> result = new FutureTask<>(ctd);
		// (3)实例化Thread对象，并在构造方法中传入FurureTask对象
		Thread t = new Thread(result);
		// (4)启动线程
		t.start();
		try {
			Integer sum = result.get(); // 检索结果
			System.out.println(sum);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

// 创建线程的第三种方式--实现Callable泛型接口 重写call方法 可以返回结果可以抛异常
class CallableThreadDemo implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			sum += i;
		}
		return sum;
	}
}
