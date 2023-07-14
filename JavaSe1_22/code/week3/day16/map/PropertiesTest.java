package org.example.week3.day16.map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/*
鐗圭偣锛�
 1.Properites绫绘槸Hashtable绫荤殑瀛愮被锛屾墍浠ヤ篃闂存帴鍦板疄鐜颁簡Map鎺ュ彛
 2.鍦ㄥ疄闄呭簲鐢ㄤ腑锛屽父浣跨敤Properties绫诲灞炴�ф枃浠惰繘琛屽鐞� 
 3.閿�煎閮芥槸瀛楃涓�
甯哥敤鏂规硶锛�
1. void  load(InputStream inStream))锛氬姞杞芥枃浠讹紱
2.String  getProperty(key)锛氶�氳繃key鍊艰幏寰楀搴旂殑value鍊�
3. Object setProperty(String聽key,String聽value):  缁檖roperties鏂囦欢涓啓鍊�
 */
public class PropertiesTest {
	public static void main(String[] args) {
		// 鍒涘缓瀵硅薄
		Properties p = new Properties();
		// 鍔犺浇鏂囦欢
		try {
			p.load(new FileInputStream(new File("C:\\F\\workspace-new1\\JavaSE_day17\\src\\test.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		p.setProperty("userName", "alice"); //淇敼key瀵瑰簲鐨剉alue鍊�
		// 鎿嶄綔鏂囦欢涓殑灞炴��
		System.out.println(p.getProperty("userName"));   //閫氳繃key鑾峰彇value鐨勫��
		System.out.println(p.getProperty("pwd"));
		
	}
}
