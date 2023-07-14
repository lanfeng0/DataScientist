package org.example.week3.day16.map;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
/**
 * LinkedHashMap 瀛樺叆鍏冪礌鍞� 涓�锛屼笖鏈夊簭
 *
 */
public class LinkedHashMapTest {
	
	public static void main(String[] args) {
		
		LinkedHashMap<String,Integer>  lhm =new LinkedHashMap<String,Integer>();
		lhm.put("one",1);
		lhm.put("two",2);
		lhm.put("three",3);
		lhm.put("four",4);
		
		Set<String> set = lhm.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			Integer val=lhm.get(key);
			System.out.println("key="+key+",vlaue="+val);
		}
		
	}

}
