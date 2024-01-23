package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Department;

public class DeptDAOImpl implements IDepartmentDAO{
	
	Connection con=null;
	public DeptDAOImpl(){
		con=DBUtil.getDBConnection();
	}

	@Override
	public int insertDept(Department dept) {
		String insert ="insert into dept values(?,?,?)";
		int count=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setInt(1, dept.getDno());
			pstmt.setString(2, dept.getDname());
			pstmt.setString(3, dept.getLocation());
			count = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateDept(Department dept) {
		String insert ="update dept set dname=?,location=? where dno=?";
		int count=0;
		try {
			PreparedStatement pstmt = con.prepareStatement(insert);
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLocation());
			pstmt.setInt(3, dept.getDno());
			count = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteOneDept(int id) {
		String delete = "delete from dept where dno=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(delete);
			pstmt.setInt(1, id);
			int count = pstmt.executeUpdate();
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Department selectOne(int id) {
		String selectOne = "select dno,dname,location from dept where dno=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(selectOne);
			pstmt.setInt(1, id);
			ResultSet set = pstmt.executeQuery();
			set.next();
			Department dept = new Department(set.getInt("dno"),set.getString("dname"),set.getString("location"));
			return dept;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Department> selectAll() {
		String selectAll = "select * from dept";
		List<Department> departmentList = new ArrayList<>();
		try {
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(selectAll);
			while(set.next()) {
				Department dept = new Department(set.getInt(1),set.getString(2),set.getString(3));
				departmentList.add(dept);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return departmentList;
	}

}
