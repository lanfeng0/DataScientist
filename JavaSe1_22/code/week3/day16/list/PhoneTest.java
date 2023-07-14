package org.example.week3.day16.list;

import java.util.ArrayList;

//租房电话号码测试
public class PhoneTest {
  public static void main(String[] args) {
//	  Integer[] arr = new Integer[] {8,2,1,0,3}; 
//	  Integer[] index = new Integer[] {2,0,3,2,4,0,1,3,2,3,3}; 
//		String tel = "";
//		for (Integer i : index) {
//			tel+=arr[i];
//		}
//		System.out.println("联系方式:"+tel);
	  
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(8);
		arr.add(2);
		arr.add(1);
		arr.add(0);
		arr.add(3);
		ArrayList<Integer> index = new ArrayList<>();
		index.add(2);
		index.add(0);
		index.add(3);
		index.add(2);
		index.add(4);
		index.add(0);
		index.add(1);
		index.add(3);
		index.add(2);
		index.add(3);
		index.add(3);
		String tel = "";
		for (Integer i : index) {
			tel += arr.get(i);
		}
		System.out.println("联系方式:" + tel);
}
}
