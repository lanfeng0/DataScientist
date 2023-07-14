package org.example.week4.day27.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest2 {
	public static void main(String[] args) {
		IMan civilian = new Man();
		FBI1 fbi = new FBI1(civilian);
		civilian = (IMan) Proxy.newProxyInstance(Man.class.getClassLoader(), 
				new Class[] { IMan.class }, fbi);
		civilian.qq();
		civilian.mm();
	}
}
