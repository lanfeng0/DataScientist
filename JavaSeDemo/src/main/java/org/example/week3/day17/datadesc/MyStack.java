package org.example.week3.day17.datadesc;

//栈   先进后出
public class MyStack {
	private int[] stack; // 存放栈数据的数组
	private final int SIZE; // 数组大小，不能改变
	private final int BOTTOM = 0;// 栈底的标识，栈底始终是数组的第0个元素
	private int top;// 栈顶，它会随着栈得使用情况而变化

	// 初始化栈---一个空栈被创建
	public MyStack(int size) {
		SIZE = size;
		stack = new int[size];
		top = BOTTOM;
	}

	// 判断是否为空栈
	public boolean isEmpty() {
		return top == BOTTOM;
	}

	// 判断是否是满栈
	public boolean isFull() {
		return top == SIZE;
	}

	// synchronized的原因：入栈与出栈的操作过程中是不允许其它操作干扰的。有了同步的保障,栈的工作才不会出现异常
	// 压栈---栈是要用来存储数据的,数据被存储到栈中,这个动作叫入栈或者压栈
	public synchronized void push(int data) {
		// 1.判断是否满栈--是，抛异常 不是--压入数据
		if (!isFull()) {
			stack[top++] = data;// 压入数据 先赋值，再top++ 相当于stack【top】 = data top++;
		} else {
			throw new IllegalStateException("已经栈满");
		}
	}

	// 弹栈 -- 当需要从栈中取出数据时,只能从栈顶取出,这个动作叫出栈或者是弹栈
	public synchronized int pop() {
		// 1.判断是否为空栈 是---抛异常 不是---弹出数据
		if (!isEmpty()) {
			return stack[--top];
		} else {
			throw new IllegalStateException("空栈，无需删除");
		}
	}

	
	public static void main(String[] args) {
		MyStack stack = new MyStack(8);
		stack.push(10);
		stack.push(12);
		stack.push(13);
		stack.push(14);
		stack.push(15);
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}
}
