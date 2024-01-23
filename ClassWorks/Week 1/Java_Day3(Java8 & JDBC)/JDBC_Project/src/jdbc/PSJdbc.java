package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PSJdbc {
	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fsd", "root", "73524Idea#");
			/*
			 * String delete = "Delete from dept where dno=?"; PreparedStatement pstmt =
			 * con.prepareStatement(delete); pstmt.setInt(1, 70); int count =
			 * pstmt.executeUpdate(delete);
			 * System.out.println(count+" Record/s updated...");
			 */

			String selectAll = "Select dno,dname,location from dept where dno=?";
			String selectAll2 = "Select dno,dname,location from dept where dno>?";
			String mulSelect = "select eid,ename from employees where Mid in (?,?)";
			PreparedStatement pstmt = con.prepareStatement(mulSelect);
			pstmt.setInt(1, 101);
			pstmt.setInt(2, 102);
			ResultSet set = pstmt.executeQuery();
			while (set.next()) {
//				System.out.println("Dno: " + set.getInt("dno") + ", DName: " + set.getString("dname") + ", Location: "+ set.getString(3));
				System.out.println("ENo: "+set.getInt("eid")+" Ename: "+set.getString("ename"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
