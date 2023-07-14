package org.example.week4.day24_26.http;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketHttpClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket(
				InetAddress.getByName("www.baidu.com"), 80);
		OutputStream os = socket.getOutputStream();
		os.write("GET / HTTP/1.1\r\n"
				.getBytes());
		os.write("Host: baidu.com\r\n".getBytes());
		os.write("\r\n".getBytes());

		InputStream is = socket.getInputStream();
		BufferedLineInputStream blis = new BufferedLineInputStream(is);

		int c = 0;
		byte[] buf = new byte[1024];
		int length = 0;
		while ((c = blis.readLine(buf, 0, buf.length)) != -1) {

			if ("\r\n".equals(new String(buf, 0, c))) {
				break;
			} else if (new String(buf, 0, c).startsWith("Content-Length:")) {
				length = Integer.parseInt(new String(buf, 0, c).substring(15)
						.trim());
			}
		}
		int counter = 0;
		FileOutputStream fos = new FileOutputStream("d:/baidu1.html");
		while ((c = blis.readLine(buf, 0, buf.length)) != -1) {

			counter += c;
			fos.write(buf, 0, c);
			if (counter == length) {
				break;
			}

		}

	}

}
