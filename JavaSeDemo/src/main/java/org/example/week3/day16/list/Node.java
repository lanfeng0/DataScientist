package org.example.week3.day16.list;

//结点类，存储数据和下一个结点的地址
public class Node {
	Object value;   //数据
	Node next;   //下一个结点的地址

	public Node(Object value) {
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
