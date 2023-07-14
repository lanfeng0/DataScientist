package org.example.week4.day24_26.http;


import java.io.IOException;
import java.io.InputStream;

public class BufferedLineInputStream {

	InputStream is;

	public BufferedLineInputStream(InputStream is) {
		// super();
		this.is = is;
	}

	/**
	 * 以行优先方式读取流中数据，直到换行或缓冲区读满
	 * */
	public int readLine(byte[] b, int off, int len) throws IOException {

		if (len <= 0) {
			return 0;
		}
		int count = 0, c;

		while ((c = is.read()) != -1) {

			// System.out.println("READ:"+(char)c+"  ---  "+c);
			b[off++] = (byte) c;
			count++;
			if (c == '\n' || count == len) {
				break;
			}
		}
		return count > 0 ? count : -1;
	}
}
