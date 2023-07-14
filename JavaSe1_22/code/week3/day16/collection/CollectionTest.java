package org.example.week3.day16.collection;

import java.util.ArrayList;
import java.util.Collection;

//Collection鎺ュ彛閲嶈鏂规硶娴嬭瘯
public class CollectionTest {
	public static void main(String[] args) {
		// =====娣诲姞==================================
		// 闆嗗悎1
		Collection<String> col1 = new ArrayList<String>();
		col1.add("aa");
		col1.add("bb");

		// 闆嗗悎2
		Collection<String> col2 = new ArrayList<String>();
		col2.add("cc");
		col2.add("dd");
		// 闆嗗悎2褰撻泦鍚�1鐨勫厓绱�
		col1.addAll(col2);

		System.out.println(col1);
		// =====鍒犻櫎============================
		// 浠庨泦鍚�1涓垹闄ら泦鍚�2涓殑鍏冪礌
		boolean b1 = col1.removeAll(col2);
		System.out.println(b1);
		System.out.println(col1);
		// 浠庨泦鍚�1涓垹闄や竴涓厓绱�
		boolean b2 = col1.remove("aa");
		System.out.println(col1);

		// =====鍒ゆ柇============================
		// 闆嗗悎涓虹┖鍚�
		boolean b3 = col1.isEmpty();
		System.out.println(b3);
		// 鏄惁鍖呭惈"bb"
		boolean b4 = col1.contains("bb");
		System.out.println(b4);
		// 鏄惁鍖呭惈鍙︿竴涓泦鍚�
		boolean b5 = col1.containsAll(col2);
		System.out.println(b5);
		// =====鑾峰緱============================
		// 鑾峰緱闆嗗悎闀垮害
		int length = col1.size();
		System.out.println(length);
		// 鎶婇泦鍚堜腑鐨勫厓绱犲彉鎴愭暟缁�
		Object[] obj = col1.toArray();
		System.out.println(obj[0]);

		// ========娣诲姞鑷畾涔夊璞�==============
		 Person person1= new Person();
		 person1.setUname("aa");
		 person1.setPwd("123");
		
		 Person person2= new Person();
		 person2.setUname("bb");
		 person2.setPwd("456");

		// 鍚戦泦鍚堜腑娣诲姞鑷畾涔夊璞�
		 Collection<Person> col6 =new ArrayList<Person>();
		 col6.add(person1);
		 col6.add(person2);
		 //鎵撳嵃鍑烘潵鐪嬪埌闆嗗悎涓湁浜屼釜瀵硅薄
		 System.out.println(col6);

	}

}
