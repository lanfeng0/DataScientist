package org.example.week4.day24_26.http;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		URL serverURL = new URL(
				"http://www.baidu.com/");
		HttpURLConnection con = (HttpURLConnection) serverURL.openConnection();

		// con.setDoOutput(true);
		// OutputStream os = con.getOutputStream();
		// //输出数据
		int code = con.getResponseCode();
		if (code == HttpURLConnection.HTTP_OK) {
			InputStream is = con.getInputStream();
			// 处理输入数据
			FileOutputStream fos = new FileOutputStream("D:/baidu.html");
			byte[] buf = new byte[1024];
			int c = 0;
			while ((c = is.read(buf, 0, buf.length)) != -1) {
				fos.write(buf, 0, c);
			}
			fos.close();
			is.close();
		}
	}

}
