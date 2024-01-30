package com.hexaware.springbootweb.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.springbootweb.entity.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao{
	
	public EmployeeDaoImpl() {
		
	}
	
	
	JdbcTemplate template;
	@Autowired
	public EmployeeDaoImpl(DataSource datasource) {
		template= new JdbcTemplate(datasource);
	}
	@Override
	public String addEmployee(Employee emp) {
		
		String insert = "insert into employee values(?,?,?)";
		int count = template.update(insert,emp.getEid(),emp.getName(),emp.getSalary());
		return count+" record inserted";
	}
	@Override
	public List<Employee> getAll() {

		String select = "select * from employee";
		List<Employee> list = template.query(select,new EmployeeMapper());
		return list;
	}
	@Override
	public String updateEmployee(Employee emp) {

		String update = "update employee set ename= ?,salary=? where eid=?";
		int count = template.update(update,emp.getName(),emp.getSalary(),emp.getEid());
		return count+" record Updated";
	}
	@Override
	public String deleteEmployee(int id) {
		String delete = "delete from employee where eid=?";
		int count=template.update(delete,id);
		return count+" record deleted";
	}
	@Override
	public Employee getEmployeeById(int id) {
		String search = "select * from employee where eid=?";
		Employee emp = template.queryForObject(search,new EmployeeMapper(),id);
		return emp;
	}

}
