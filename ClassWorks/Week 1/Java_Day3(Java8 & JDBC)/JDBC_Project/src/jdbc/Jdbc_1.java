package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_1 {
	public static void main(String[] args) {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd","root","73524Idea#");
//			String insert = "insert into employees(eid,ename,salary,job) values(111,'Martin',20000,'HR')";
//			String update = "update employees set salary = 40000 where eid=111";
			String delete = "Delete from employees where eid=111";
//			String selectAll = "select * from employees";
			Statement stmt = connection.createStatement();
//			ResultSet data = stmt.executeQuery(selectAll);
			int count = stmt.executeUpdate(delete);
			System.out.println(count+" record/s updated.");
//			while(data.next()) {
//				System.out.println(data.getInt(1)+"    "+data.getString(2)+"     "+data.getDouble(3)+"     "+data.getInt(7));
//			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
