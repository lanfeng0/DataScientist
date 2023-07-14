package org.example.week3.day18;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 利用FileWriter向文件中写入字符
 *
 * @author Lvling
 *
 */
public class FileWrterTest {

	public static void main(String[] args) {

		FileWriter fw = null;
		try {
			fw = new FileWriter("e:\\Test.txt", true);
			// 这里写入97,在文件中显示的是a
			fw.write(97);
			fw.write("abc");
			char[] b = { 'a', 'b', 'c' };
			fw.write(b);
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {

				try {
					fw.close();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

		}

	}

}
