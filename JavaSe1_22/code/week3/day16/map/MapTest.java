package org.example.week3.day16.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//map娴嬭瘯
public class MapTest {
	
	public static void main(String[] args) {
		
		Map<String,String> map =new HashMap<String,String>();
		// 瀛樺偍鍏冪礌
		map.put("one","b");
		map.put("two","c");
		map.put("three","a");
		map.put("four","d");
		System.out.println(map);
		//鍒ゆ柇
		boolean b = map.containsKey("one");
		System.out.println(b);
		//鑾峰彇
		String value = map.get("two");
		System.out.println(value);
		int length = map.size();
		System.out.println(length);
		
		//閬嶅巻
		//涓嶅彲浠ョ洿鎺ョ敤Iterator锛屽洜涓烘病鏈夎繖涓柟娉�
		//娌℃湁涓嬫爣涓嶈兘鐢ㄦ櫘閫歠or寰幆
		
		//keySet()寰楀埌鎵�鏈夌殑key鏀惧叆Set闆嗗悎涓�
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()){
			String key = it.next();
			String val=map.get(key);
			System.out.println("key="+key+",vlaue="+val);
		}
		
		
		
		//鍒犻櫎
		map.remove("one");
		System.out.println(map);
		map.clear();
		System.out.println(map);
	}

}
