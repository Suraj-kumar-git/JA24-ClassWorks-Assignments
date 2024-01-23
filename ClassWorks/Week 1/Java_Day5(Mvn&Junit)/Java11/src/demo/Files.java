package demo;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Files {

	public static void main(String[] args) {
		try {
			Path path = Paths.get("resources/input.txt");
			String allData=Files.readString(path);
			System.out.println(allData); //All data at the same time
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
