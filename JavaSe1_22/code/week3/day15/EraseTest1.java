package org.example.week3.day15;

import java.lang.reflect.Field;

/**
 * 无限制类型擦除，可以通过反射来看到擦除后的类型
 * 
 * @param <T>
 */
public class EraseTest1<T> {

	private T key;

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public static void main(String[] args) {
		// 创建EraseTest对象
		EraseTest1<Integer> er = new EraseTest1<Integer>();
		// 利用反射拿到EraseTest的字节码文件的class类对象
		Class<? extends EraseTest1> ers = er.getClass();
		// 获取所有的成员变量
		Field[] files = ers.getDeclaredFields();
		// 遍历所所员变量
		for (Field field : files) {
			// 打印成员变量的名称和类型 变量名是key,类型是Object
			System.out.println(field.getName() + ","
					+ field.getType().getSimpleName());
		}

	}

}
