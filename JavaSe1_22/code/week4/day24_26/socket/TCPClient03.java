package org.example.week4.day24_26.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
//单一服务器对多客户端提供网络服务---客户端  模拟两个客户端对服务器端发送请求
public class TCPClient03 {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 6700);
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			DataOutputStream os = new DataOutputStream(socket.getOutputStream());
			final DataInputStream is = new DataInputStream(socket.getInputStream());
			String readline;

			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							String readline = is.readUTF();
							System.out.println(readline);
							if (readline.equals("exit")) {
								break;
							}
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			};
			new Thread(runnable).start();
			while (true) {
				readline = sin.readLine();
				os.writeUTF(readline);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
