package org.example.week4.day24_26.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class HttpSimple3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String CRLF = "\r\n";
		try {

			ServerSocket server = new ServerSocket(8080);
			ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
					30);
			while (true) {

				final Socket con = server.accept();

				Runnable serverThread = new Runnable() {
					public void run() {
						try {

							BufferedLineInputStream blis = new BufferedLineInputStream(
									con.getInputStream());
							byte[] buf = new byte[1024];

							int c = blis.readLine(buf, 0, buf.length);
							String res = new String(buf, 0, c);
							String[] elements = res.split(" ");
							res = elements[1].substring(1);
							File f = new File(res);
							FileInputStream fis = new FileInputStream(f);
							long length = f.length();

							OutputStream os = con.getOutputStream();

							String responseHeader = "HTTP/1.1 200 OK" + CRLF;
							if (res.endsWith(".htm") || res.endsWith(".html")) {
								responseHeader += "Content-Type: text/html"
										+ CRLF;
							} else {
								responseHeader += "Content-Type: application/stream"
										+ CRLF;
							}
							responseHeader += "Content-Length:  " + length
									+ CRLF;
							responseHeader += CRLF;
							os.write(responseHeader.getBytes());

							while ((c = fis.read(buf, 0, buf.length)) != -1) {
								os.write(buf, 0, c);
							}
							fis.close();
							os.close();
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				};
				executor.execute(serverThread);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
