package org.example.week4.day24_26.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient {
	public static void main(String[] args) {
		try {
//			创建DatagramSocket对象，绑定端口3456
			DatagramSocket sendSocket = new DatagramSocket(3456);
//			准备好要发送的数据，类型为byte[]
			String string = "Hello,I come form ICSS!";
			byte[] databyte = new byte[100];
			databyte = string.getBytes();
//			创建数据报，封装了要发送的数据，数据长度，服务器地址，以及服务器端口为5000
			DatagramPacket sendPacket = new DatagramPacket(databyte,
					string.length(), InetAddress.getByName("127.0.0.1"), 5000);
//			使用DatagramSocket对象将数据报sendPacket发送到服务器
			sendSocket.send(sendPacket);
			System.out.println("发送数据:" + string);
		} catch (SocketException e) {
			System.out.println(e);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}
}
