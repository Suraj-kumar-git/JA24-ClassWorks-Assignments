package io.demo;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFileDemo {

	public static void main(String[] args) {
		FileInputStream reader=null;
		try {
			reader = new FileInputStream("resources/input.txt");
			int n =0;
			while((n=reader.read())!=-1) {
				System.out.print((char)n);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
