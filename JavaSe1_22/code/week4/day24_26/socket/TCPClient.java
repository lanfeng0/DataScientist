package org.example.week4.day24_26.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

//使用Socket与ServerSocket进行TCP协议通讯编程---客户端
public class TCPClient {
	public static void main(String[] args) {
		try {
//			创建Socket，指定ip，port
			Socket socket = new Socket("127.0.0.1", 4700);
			
//			获得键盘输入
			BufferedReader sin = new BufferedReader(new InputStreamReader(
					System.in));
			
//			获得基于Socket的输入流和输出流
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(
					socket.getInputStream());
			
			String readline;
			readline = sin.readLine();
			
//			向服务器写数据
			while (!readline.equals("exit")) {
				os.writeUTF(readline);
				os.flush();
				System.out.println("Server:" + is.readUTF());
				readline = sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
