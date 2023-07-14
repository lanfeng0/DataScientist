package org.example.week3.day16.list;

import java.util.Arrays;

//自定义ArrayList泛型类
public class MyArrayList<T> {
    //数组，默认长度   假设是4
	Object[] objs = new Object[4];
	//元素个数 
	int size;
	
	//获取元素个数
	public int getSize() {
		return size;
	}
	//添加元素  -- 扩容
	public void add(T value) {
		//如果size >= Object数组的长度---扩容操作   
		if(size>=objs.length) {
//			Object[] temp = new  Object[size * 3/2+1];  //扩容后新数组的对象,赋值给一个临时变量
//			for(int i = 0 ;i<objs.length;i++) { //遍历原数组
//				temp[i] = objs[i]; //数组元素赋值   依次把原来数组的第i条数据赋值给新数组同样位置的数据 
//			}
//			objs= temp;  //临时变量赋值给成员变量，此时objs是扩容后的长度
			int oldCapacity = objs.length;   //原数组长度
			int newCapacity = oldCapacity + (oldCapacity >> 1);  //1.5 扩容后的长度
			//拷贝数组，创建新数组并把原来数组的元素复制到新数组中
			objs =  Arrays.copyOf(objs, newCapacity);    
		}
        objs[size] = value; //添加元素
		size++;  //元素加1
	}
	
	//获取元素--根据索引获取元素
	public T get(int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("超出索引的范围");
		}
		return (T)objs[index];  //取值
	}
	
	
	//修改索引index位置的值
	public void set(int index,T value) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("超出索引的范围");
		}
		objs[index] = value;  //给index位置的数据赋值操作
	}
	//删除所有元素
	public void removeAll() {
		size = 0;  //元素的个数为0
		//遍历objs数组，每一个元素都变为null
		for (int i = 0; i < objs.length; i++) {
			objs[i]= null;
		}
	}
	
	//根据索引来删除元素
	public void remove(int index) {
		if(index>=size) {
			throw new IndexOutOfBoundsException("超出索引的范围");
		}
		//把当前索引的下一个元素一直到最后一个元素，依次前移
		for(int i = index+1; i<size ;i++) {
			objs[i-1] = objs[i];
		}
		//元素-1
		size--;
	}
}
