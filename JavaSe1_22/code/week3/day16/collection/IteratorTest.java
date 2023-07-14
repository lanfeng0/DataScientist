package org.example.week3.day16.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {

	public static void main(String[] args) {
		// 闆嗗悎1
		Collection<String> col1 = new ArrayList<String>();
		col1.add("aa");
		col1.add("bb");

		// =====浣跨敤澧炲己鍨媐or閬嶅巻===========
		for (String str : col1) {
			System.out.println(str);
		}

		// =====浣跨敤杩唬鍣ㄩ亶鍘�==============
		Iterator<String> it = col1.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

		// ======浣跨敤澧炲己鍨媐or涓庤凯浠ｅ櫒閬嶅巻闆嗗悎閲岀殑鑷畾涔夊璞�==========================
		Person person1 = new Person();
		person1.setUname("aa");
		person1.setPwd("123");

		Person person2 = new Person();
		person2.setUname("bb");
		person2.setPwd("456");

		// 鍚戦泦鍚堜腑娣诲姞鑷畾涔夊璞�
		Collection<Person> col6 = new ArrayList<Person>();
		col6.add(person1);
		col6.add(person2);

		// 1)浣跨敤澧炲己鍨媐or閬嶅巻
		for (Person p : col6) {
			System.out.println(p.getUname() + "," + p.getPwd());
		}
		// 2)浣跨敤杩唬鍣ㄩ亶鍘�
		Iterator<Person> it2 = col6.iterator();
		while (it2.hasNext()) {
			Person p = it2.next();
			System.out.println(p.getUname() + "," + p.getPwd());
		}
	}
}
