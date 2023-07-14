package org.example.week4.day24_26.socket;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//单一服务器对多客户端提供网络服务  ---用来对客户端提供服务
public class MultiThreadServer implements Runnable {
	private Socket socket;
	DataInputStream is;
	DataOutputStream os;

	public MultiThreadServer(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// 获得基于Socket的输入流

		String line;

		try {
			is = new DataInputStream(socket.getInputStream());
			os = new DataOutputStream(socket.getOutputStream());
			while (true) {
				line = is.readUTF();
				System.out.println("Client "+socket.hashCode()+"说：" + line);
				TCPServer03.sendToAll("Client "+socket.hashCode()+"说:"+line);
				if (line.equals("exit")) {
					break;
				}
			}
		} catch (IOException e) {

		}

	}
}
