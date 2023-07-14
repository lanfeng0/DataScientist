package org.example.week3.day18;

import java.io.File;

public class FilterByHiddenTest {

	public static void main(String[] args) {
		File f=new File("e:\\");
		File [] files = f.listFiles(new FilterByHidden());
		for(File  file :files){
			System.out.println(file);
		}
	}

}
