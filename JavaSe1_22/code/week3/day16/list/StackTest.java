package org.example.week3.day16.list;

import java.util.Stack;

//Stack测试
public class StackTest {
  public static void main(String[] args) {
	Stack<String> stack = new Stack<>();   // 创建集合对象   先进后出
	stack.push("aaa");   //入栈
	stack.push("bbb");
	stack.push("ccc");   
	
	while(stack.size()>0) {
		System.out.println(stack.pop());  //出栈
	}
}
}
