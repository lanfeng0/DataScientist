package org.example.week4.day24_26.http;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;


public class HttpSimple2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String CRLF = "\r\n";
		try {

			ServerSocket server = new ServerSocket(8080);
			ThreadPoolExecutor executor = new ThreadPoolExecutor(30);
			while (true) {

				final Socket con = server.accept();

				Runnable serverThread = new Runnable() {
					public void run() {
						try {

							BufferedImage bimage = new BufferedImage(300, 300,
									BufferedImage.TYPE_INT_RGB);
							Random random = new Random();
							int r = random.nextInt(255);
							int g = random.nextInt(255);
							int b = random.nextInt(255);
							Color color = new Color(r, g, b);
							Graphics bg = bimage.getGraphics();
							bg.setColor(color);
							bg.fillRect(0, 0, 300, 300);
							ByteArrayOutputStream baos = new ByteArrayOutputStream();
							ImageIO.write(bimage, "jpeg", baos);

							byte[] data = baos.toByteArray();
							baos.close();
							OutputStream os = con.getOutputStream();

							String responseHeader = "HTTP/1.1 200 OK" + CRLF;
							responseHeader += "Content-Type: image/jpeg" + CRLF;
							responseHeader += "Content-Length:  " + data.length
									+ CRLF;
							responseHeader += CRLF;
							os.write(responseHeader.getBytes());
							os.write(data, 0, data.length);
							os.flush();
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
