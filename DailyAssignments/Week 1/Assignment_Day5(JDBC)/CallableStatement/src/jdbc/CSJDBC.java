package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CSJDBC {

	public static void main(String[] args) {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd","root","73524Idea#");
			/*
			 * Using Statement interface to call stored procedure
			 * String query="{call getAllEmp()}";
			 * Statement stmt = con.createStatement(); ResultSet rs =
			 * stmt.executeQuery(query); while(rs.next()) {
			 * System.out.println("Eid: "+rs.getInt(1)+"EName: "+rs.getString(2)+"ESalary: "
			 * +rs.getDouble(3)); }
			 */
			
			// ProcedureName 'inandout' = select ename from employees where eid=id;
			String query = "{call inandout(?,?)}";
			CallableStatement cstmt = con.prepareCall(query);
			cstmt.setInt(1, 102);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			cstmt.execute();
			String eName = cstmt.getString(2);
			System.out.println("Fetched Record: "+eName);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
