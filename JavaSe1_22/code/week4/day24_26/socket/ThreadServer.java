package org.example.week4.day24_26.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;


//TCP通讯线程特性--ThreadServer类负责处理客户端的请求
public class ThreadServer implements Runnable {

	@Override
	public void run() {
		ArrayList<Socket> socketspool = TCPServer02.getSocketspool();
		String line;
		while (true) {
			for (int i=0;i<socketspool.size();i++) {
				Socket socket=socketspool.get(i);
				DataInputStream is;
				try {
					is = new DataInputStream(socket.getInputStream());	
					DataOutputStream os = new DataOutputStream(socket.getOutputStream());
					line = is.readUTF();
					System.out.println("Client:" + line);
					if(line.equals("exit")) {
						socket.close();
						socketspool.remove(socket);					
					}
				} catch (IOException e) {
					e.printStackTrace();
					socketspool.remove(socket);
				}
			}
		}
	}
}
