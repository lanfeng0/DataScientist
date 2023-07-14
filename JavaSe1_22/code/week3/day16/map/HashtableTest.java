package org.example.week3.day16.map;

import java.util.HashMap;
import java.util.Hashtable;

public class HashtableTest {
	
	public static void main(String[] args) {
		
		Hashtable<String,Integer>  lhm =new Hashtable<String,Integer>();
		/*
		 * 杩欎笁绉嶅啓娉曢兘涓嶅彲浠�
		lhm.put(null,1);
		lhm.put("two",null);
		lhm.put(null,null);
		*/
		
		
		HashMap<String,Integer>  hm =new HashMap<String,Integer>();
		/*
		 * 杩欎笁绉嶅啓娉曢兘涓嶅彲浠�*/
		hm.put(null,1);
		hm.put("two",null);
		hm.put(null,null);
		
		
	}

}
