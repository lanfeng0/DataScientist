package org.example.week3.day18;

import java.io.File;

public class FilterByFileNameTest {

	public static void main(String[] args) {
		File f=new File("e:\\");
		File [] files = f.listFiles(new FilterByFileName(".txt"));
		for(File  file :files){
			System.out.println(file);
		}
	}

}
