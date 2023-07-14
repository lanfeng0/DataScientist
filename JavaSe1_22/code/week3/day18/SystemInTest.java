package org.example.week3.day18;

import java.io.IOException;
import java.io.InputStream;
/**
 * System.in   从键盘中输入并打印System.out
 * @author Lvling
 *
 */
public class SystemInTest {

	public static void main(String[] args) throws IOException {

		//从键盘中输入 我a  那么就要打印出来对应的字节
		InputStream ins = System.in;

		int c= ins.read();
		System.out.println(c);  //230
		int c1= ins.read();
		System.out.println(c1);  //136

		int c2= ins.read();
		System.out.println(c2);  //145
		int c3= ins.read();
		System.out.println(c3);   //97

		int c4= ins.read();
		System.out.println(c4); //13
		int c5= ins.read();
		System.out.println(c5);   //10
		//回车是由\r\n 组成  \r =13 \n= 10

	}

}
