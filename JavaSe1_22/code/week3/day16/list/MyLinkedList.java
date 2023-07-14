package org.example.week3.day16.list;

//自定义LinkedList集合
public class MyLinkedList {
   int size;  //元素
   Node head = null;  //头指针
   
   //获取元素个数
   public int getSize() {
	   return size;
   }
   //添加元素---放到最后一个结点
   public void add(Object value) {
	   Node newNode = new Node(value); //创建一个新的结点
	   if(head == null) {  //判断列表是否为空
		   head = newNode;  //头指针指向新创建的结点
	   }else {
		   Node temp  = head;  //temp代表当前结点
		   while(temp.getNext()!=null) {  //找到最后一个元素，下一个地址为null元素(最后一个元素)
			   temp =  temp.getNext();  //让当前结点向后移动  
		   }
		   
		   temp.setNext(newNode);//循环结束，temp表示最后一个结点，赋值
	   }
	   
	   size++;
   }
   
   //根据索引查找元素
   public Object get(int index) {
	   Node temp = head;//从第一个结点开始找
	   //遍历 0--index
	   for (int i = 0; i < index; i++) {
		 temp = temp.getNext();  //最后一个，就是找到索引对应的结点
	   }
	   return temp.getValue();  //获取当前结点值  
   }
   
   //根据元素来设置索引对应的内容
   public void set(int index,Object value) {
	   Node temp = head;//从第一个结点开始找
	   //遍历 0--index
	   for (int i = 0; i < index; i++) {
		 temp = temp.getNext();  //最后一个，就是找到索引对应的结点
	   }
	    temp.setValue(value);  //设置索引对应的元素
   }
   
   //删除所有数据
   public void clear() {
	   size = 0;
	   head = null;
   }
   //根据索引来删除元素
   public void remove(int index) {
	   if(index == 0) {  //第一个元素
		    head = head.getNext(); //删除头元素，让头指针指向头元素的下一个
	   }else {
		   Node temp = head;  //找到删除元素的前置结点（前一个元素）
		   for(int i = 1; i<index ;i++) {
			   temp = temp.getNext();  //要删除元素的前一个元素
		   }
		   temp.setNext(temp.getNext().getNext()); //设置前一个元素的下一个地址是元素的下一个元素的下一个元素 
		   
	   }
	   size--;
   }
   
}
