package org.example.week3.day16.list;

public class MyLinkedListTest {
  public static void main(String[] args) {
	MyLinkedList lists = new MyLinkedList();
	lists.add("aa");
	lists.add("bb");
	lists.add("cc");
	lists.add("dd");
	
//	lists.clear();
	lists.remove(1);
	lists.set(1, "eeeee");
	for (int i = 0; i < lists.getSize(); i++) {
		System.out.println(lists.get(i));
	}
}
}
