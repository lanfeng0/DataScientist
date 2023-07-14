package org.example.week3.day17.datadesc;

//循环队列   先进先出
public class MyQueue {
	private final int SIZE;
	private int[] queue; // 存放队列数据的数组
	private int head; // 对头
	private int end;// 对尾

	// 队列初始化 一个空的队列
	public MyQueue(int size) {
		SIZE = size;
		queue = new int[size];
		head = 0;
		end = 0;
	}
	//获取移动后的位置
	public int next(int i) {
		return (i+1)%SIZE;
	}
	
	//判断队空
	public boolean isEmpty() {
		return head == end;
	}
	
	//判断队满
	public boolean isFull() {
		return next(end) == head;
 	}
	
	//入队
	public void offer(int data) throws Exception {
		if(isFull()) {
			throw new Exception("队列已经满了，无法继续添加数据");
		}else {
			queue[end] = data;  //队尾插入数据
			end = next(end);  //end正向移动
		}
	}
	//出队
	public int poll() throws Exception {
		if(isEmpty()) {
			throw new Exception("队列为空，无法取出数据");
		}else {
			int result = queue[head]; //队头移除数据
			head = next(head);//head正向移动
			return result;
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		MyQueue queue = new MyQueue(8);
		queue.offer(10);
		queue.offer(12);
		queue.offer(14);
		queue.offer(16);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
	}
}
