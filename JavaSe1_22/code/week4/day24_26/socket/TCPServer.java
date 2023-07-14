package org.example.week4.day24_26.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

//使用Socket与ServerSocket进行TCP协议通讯编程---服务端
public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = null;
			try {
//				创建ServerSocket对象，指定端口是4700
				server = new ServerSocket(4700);
				System.out.println("服务器启动成功");
			} catch (Exception e) {
				System.out.println("服务器启动出错");
			}
			Socket socket = null;
			try {
//				调用ServerSocket的accept方法，可以接受客户端的请求，并返回当前的Socket对象
				socket = server.accept();
			} catch (Exception e) {
				e.printStackTrace();
			}
			String line;
//			获得基于Socket的输入流
			DataInputStream is = new DataInputStream(
					socket.getInputStream());
			
//			获得基于Socket的输出流
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			
//			获得控制台输入
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			
//			输出客户端输入
			System.out.println("Client:" + is.readUTF());
			
			line = sin.readLine();
			
//			向客户端写数据
			while (!line.equals("exit")) {
				os.writeUTF(line);
				os.flush();
				System.out.println("Client:" + is.readUTF());
				line = sin.readLine();
			}
			
//			资源关闭操作
			os.close();
			is.close();
			socket.close();
			server.close();
		} catch (Exception e) {
			System.out.println("Error:" + e);
		}

	}
}
