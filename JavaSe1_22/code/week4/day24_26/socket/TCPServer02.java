package org.example.week4.day24_26.socket;


import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

//TCP通讯线程特性--线程存在问题的例子
public class TCPServer02 {
	private static ArrayList<Socket> socketspool=new ArrayList<Socket>();
		
	public static ArrayList<Socket> getSocketspool() {
		return socketspool;
	}

	public static void main(String[] args) {
		
			ServerSocket server = null;
			try {
//				创建ServerSocket对象，指定端口是5700
				server = new ServerSocket(5700);
				System.out.println("服务器启动成功");
			} catch (Exception e) {
				System.out.println("服务器启动出错");
			}
			Socket socket = null;
			try {
				new Thread(new ThreadServer()).start();
//				调用ServerSocket的accept方法，可以接受客户端的请求，并返回当前的Socket对象
				while(true){
					socket = server.accept();
					socketspool.add(socket);					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

