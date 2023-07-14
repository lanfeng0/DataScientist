package org.example.week4.day24_26.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//单一服务器对多客户端提供网络服务---服务端
public class TCPServer03 {
	static List<MultiThreadServer> clients = Collections.synchronizedList(new ArrayList<MultiThreadServer>());

	static void sendToAll(String msg) {
		for (int i = 0; i < clients.size(); i++) {
			MultiThreadServer server = clients.get(i);
			try {
				server.os.writeUTF(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		ServerSocket server = null;
		try {
			server = new ServerSocket(6700);
			System.out.println("服务器启动成功");
		} catch (Exception e) {
			System.out.println("服务器启动出错");
		}
		Socket socket = null;
		try {
			while (true) {
				socket = server.accept();
				MultiThreadServer st=new MultiThreadServer(socket);
//				创建线程并启动，为客户端提供服务
				Thread thread=new Thread(st);
				clients.add(st);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
