package org.example.week3.day16.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
  public static void main(String[] args) {
	  //先进先出
     Queue<String> queue = new LinkedList<String>();
     queue.add("aaa");
     queue.add("bbb");
     queue.add("ccc");
     
//     for (String string : queue) {
//		System.out.println(string);
//	 }
     
     while(queue.size()>0) {
    	 System.err.println(queue.remove());
     }
     
 }
}
