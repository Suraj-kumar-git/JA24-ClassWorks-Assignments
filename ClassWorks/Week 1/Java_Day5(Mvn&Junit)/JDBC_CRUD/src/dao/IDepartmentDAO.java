package dao;

import java.util.ArrayList;
import java.util.List;

import entity.Department;

public interface IDepartmentDAO {
	public int insertDept(Department dept);
	public int updateDept(Department dept);
	
	public int deleteOneDept(int id);
	
	public Department selectOne(int id);
	public List<Department> selectAll();
}
