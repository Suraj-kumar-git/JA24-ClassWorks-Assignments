package com.hexaware.springrestdemo.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hexaware.springrestdemo.entity.Employee;

@Repository
public class EmployeeRepoImpl implements IEmployeeRepo {

	JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeRepoImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
//		System.out.println(jdbcTemplate);
	}

	@Override
	public Employee addEmployee(Employee emp) {
		String insert = "insert into employee values(?,?,?)";
		int count = jdbcTemplate.update(insert, emp.getEid(), emp.getName(), emp.getSalary());
		if (count == 1) {
			return emp;
		}
		return null;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		String update = "update employee set ename=?,salary=? where eid=?";
		int count = jdbcTemplate.update(update, emp.getName(), emp.getSalary(), emp.getEid());
		int empid=emp.getEid();
		String select ="select eid,ename,salary from employee where eid=?";
		Employee updatedEmp = jdbcTemplate.queryForObject(select,new EmployeeMapper(),empid);
		if (count == 1) {
			return updatedEmp;
		}
		return emp;
	}

	@Override
	public Employee getEmployeeById(int eid) {
		String getOne = "select eid,ename,salary from employee where eid=?";
		Employee emp = jdbcTemplate.queryForObject(getOne, new EmployeeMapper(), eid);
		return emp;
	}

	@Override
	public String deleteEmployeeById(int eid) {
		String delete = "delete from employee where eid=?";
		int count=jdbcTemplate.update(delete,eid);
		return count+" Record deleted";
	}

	@Override
	public List<Employee> getAllEmployees() {
		String selectAll = "select eid,ename,salary from employee";
		List<Employee> list = jdbcTemplate.query(selectAll, new EmployeeMapper());
		return list;
	}

}
