package org.example.week4.day24_26.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//TCP通讯线程特性---TCPClient02类向服务器端发送消息
public class TCPClient02 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 5700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			DataInputStream is = new DataInputStream(socket.getInputStream());
			String readline;
			// 向服务器写数据
			while (true) {
				readline = sin.readLine();
				System.out.println(readline);
				os.writeUTF(readline);
				if (readline.equals("exit")) {
					break;
				}
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
