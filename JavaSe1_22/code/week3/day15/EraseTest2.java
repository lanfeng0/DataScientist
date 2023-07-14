package org.example.week3.day15;


import java.lang.reflect.Field;

/**
 * 鏈夐檺鍒剁被鍨嬫摝闄わ紝鍙互閫氳繃鍙嶅皠鏉ョ湅鍒版摝闄ゅ悗鐨勭被鍨媆
 * 鍐欐硶EraseTest<T extends Number>    Number鐨勫効瀛愭槸Integer
 * 濡傛灉鏄埛鐖� 鐖哥埜 瀛欏瓙  閭ｄ細杞垚鐖风埛
 * @param <T>
 */
//    娉ㄦ剰杩欓噷鐨勫啓娉曞拰鏃犻檺姣斿姞浜�          extends   Number
public class EraseTest2<T extends Number> {

	private T key;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public static void main(String[] args) {
		// 鍒涘缓EraseTest瀵硅薄
		EraseTest2<Number> er = new EraseTest2<Number>();
		// 鍒╃敤鍙嶅皠鎷垮埌EraseTest鐨勫瓧鑺傜爜鏂囦欢鐨刢lass绫诲璞�
		Class<? extends EraseTest2> ers = er.getClass();
		// 鑾峰彇鎵�鏈夌殑鎴愬憳鍙橀噺
		Field[] files = ers.getDeclaredFields();
		// 閬嶅巻鎵�鎵�鍛樺彉閲�
		for (Field field : files) {
			// 鎵撳嵃鎴愬憳鍙橀噺鐨勫悕绉板拰绫诲瀷 鍙橀噺鍚嶆槸key,绫诲瀷鏄疦umber锛屽畠浼氭寜鐓т笂闄愮被鍨嬭浆
			 //濡傛灉鏄埛鐖� 鐖哥埜 瀛欏瓙  閭ｄ細杞垚鐖风埛
			System.out.println(field.getName() + ","
					+ field.getType().getSimpleName());
		}

	}

}
