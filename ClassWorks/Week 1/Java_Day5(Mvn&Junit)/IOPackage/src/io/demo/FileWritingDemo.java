package io.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingDemo {

	public static void main(String[] args) {
		FileWriter fw =null;
		FileReader fr = null;
		try {
			fw = new FileWriter("resources/output.txt");
			for(int i=65;i<=70;i++) {
				fw.write((char)i);
			}
			
			String str="My name is Suraj Kumar";
			char[] chars = str.toCharArray();
			for(char c:chars) {
				fw.write(c);
			}
			
			// Copying the data from another file
			fr=new FileReader("resources/input.txt");
			int n=0;
			while((n=fr.read())!=-1) {
				fw.write((char)n);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
