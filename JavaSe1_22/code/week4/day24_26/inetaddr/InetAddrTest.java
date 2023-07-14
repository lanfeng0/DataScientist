package org.example.week4.day24_26.inetaddr;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddrTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address1 = InetAddress.getLocalHost();
		System.out.println("IP地址：" + address1.getHostAddress());
		System.out.println("主机名：" + address1.getHostName());

		// 可以根据一个IP地址的字符串形式或者是一个主机名生成一个IP地址对象。
		InetAddress address2 = InetAddress.getByName("BlueZ");
		System.out.println("IP地址：" + address2.getHostAddress());
		System.out.println("主机名：" + address2.getHostName());

	}
}
