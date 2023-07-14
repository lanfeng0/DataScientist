package org.example.week4.day24_26.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpSimple1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String CRLF = "\r\n";
		try {
			final File f = new File("psb.png");
			final long length = f.length();
			ServerSocket server = new ServerSocket(8080);

			while (true) {
				final Socket con = server.accept();
				Thread serverThread = new Thread() {
					public void run() {
						try {
							OutputStream os = con.getOutputStream();
							FileInputStream fis = new FileInputStream(f);
							String responseHeader = "HTTP/1.1 200 OK" + CRLF;
							responseHeader += "Content-Type: image/png" + CRLF;
							responseHeader += "Content-Length:  " + length
									+ CRLF;
							responseHeader += CRLF;

							os.write(responseHeader.getBytes());
							byte[] buf = new byte[1024];
							int c = 0;
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
				serverThread.start();

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
