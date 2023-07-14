package org.example.week3.day15;

//泛型类测试
public class Box<T> {
	private T t;
	public void add(T t) {
		this.t = t;
	}
	public T get() {
		return t;
	}
	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<Integer>();
		Box<String> stringBox = new Box<String>();
		integerBox.add(new Integer(10));
		stringBox.add(new String("Chinasofti"));
		System.out.printf("整型值为 :%d\n\n", integerBox.get());
		System.out.printf("字符串为 :%s\n", stringBox.get());
	}
}
