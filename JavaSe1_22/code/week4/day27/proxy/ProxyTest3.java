package org.example.week4.day27.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest3 {
	public static void main(String[] args) {
		IMan1 civilian = new Man1();
		FBI2 fbi = new FBI2(civilian);
		civilian = (IMan1) Proxy.newProxyInstance(Man.class.getClassLoader(), 
				new Class[] { IMan1.class }, fbi);
		civilian.qq();
		civilian.mm();
		System.out.println(civilian.sayHelp("我被监控了！"));
	}
}
