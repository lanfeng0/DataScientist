package org.example.week4.day24_26.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
	public static void main(String[] args) {
		try {
//			创建DatagramSocket对象，用来接收数据，端口为5000
			DatagramSocket receiveSocket = new DatagramSocket(5000);
			byte buf[] = new byte[1000];
			DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
			System.out.println("startinig to receive packet");
			while (true) {
//				使用DatagramSocket接收数据报
				receiveSocket.receive(receivePacket);
//				解析数据报中的信息，获得主机名及端口、数据等
				String name = receivePacket.getAddress().toString();
				System.out.println("来自主机：" + name + "端口："
						+ receivePacket.getPort());
				String s = new String(receivePacket.getData(), 0,
						receivePacket.getLength());
				System.out.println("接收数据: " + s);
			}
		} catch (SocketException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
