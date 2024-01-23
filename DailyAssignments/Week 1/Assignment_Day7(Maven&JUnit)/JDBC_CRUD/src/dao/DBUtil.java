package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
public static Connection   getDBConnection(){ // Factory method 
		Connection conn = null;
		Properties properties=null;
		try {
		FileReader reader = new FileReader("resources/db.properties");
		properties = new Properties();
			properties.load(reader);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String driverclass=properties.getProperty("driverclass");
		String url=properties.getProperty("url");
		String username=properties.getProperty("username");
		String password=properties.getProperty("password");
		try {
			Class.forName(driverclass);
			conn = DriverManager.getConnection(url,username,password);
		}catch (Exception e) {
				e.printStackTrace();
			}
		return conn;
	}
}
