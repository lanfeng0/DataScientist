package org.example.week3.day15;

import java.lang.reflect.Method;

/**
 * 鏃犻檺鍒剁被鍨嬫摝闄わ紝鍙互閫氳繃鍙嶅皠鏉ョ湅鍒版摝闄ゅ悗鐨勭被鍨�
 * 
 * @author Lvling
 * @param <T>
 */

public class EraseTest3 {

	/**
	 * 瀹氫箟浜嗕竴涓硾鍨嬫柟娉�
	 * @param <T>
	 * @param t
	 * @return
	 */
	public <T > T show(T  t){
		
		return t;
	}

	public static void main(String[] args) {
		// 鍒涘缓EraseTest瀵硅薄
		EraseTest3 er= new EraseTest3();
		// 鍒╃敤鍙嶅皠鎷垮埌EraseTest鐨勫瓧鑺傜爜鏂囦欢鐨刢lass绫诲璞�
		Class<? extends EraseTest3> ers = er.getClass();
		// 鑾峰彇鎵�鏈夌殑鏂规硶
		Method[] methods = ers.getDeclaredMethods();
		// 閬嶅巻鎵�鏈夋柟娉�
		for (Method me : methods) {
			
			// 鎵撳嵃鏂规硶鍚嶏紝鍜屾柟娉曠殑杩斿洖鍊肩被鍨� show 鍜孫bject
			
			System.out.println(me.getName()+","+me.getReturnType().getSimpleName());
					
		}

	}

}
