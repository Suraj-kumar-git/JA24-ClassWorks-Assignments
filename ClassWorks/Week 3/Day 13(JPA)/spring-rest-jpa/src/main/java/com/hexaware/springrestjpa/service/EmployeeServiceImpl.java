package com.hexaware.springrestjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.repository.EmployeeRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmployee(Employee emp) {
		return repo.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {

		return repo.save(emp);
	}

	@Override
	public List<Employee> getAll() {
		return repo.findAll();
	}

	@Override
	public String deleteEmployee(long id) {
		repo.deleteById(id);
		return "Record deleted";
	}

	@Override
	public Employee getEmployeeById(long id) {
//		Optional<Employee> optional = repo.findById(id);
//		Employee emp = null;
//		if(optional.isPresent()) {
//			emp=optional.get();
//		}
//		return emp;
		return repo.findById(id).orElse(null);
	}

	@Override
	public List<Employee> getByEname(String name) {
		List<Employee> list = repo.findByEname(name);
		return list;
	}

	@Override
	public List<Employee> findBySalaryGreaterThan(double salary) {
		List<Employee> list = repo.findBySalaryGreaterThan(salary);
		return list;
	}

	@Override
	public List<Employee> findBySalaryLessThan(double salary) {
		List<Employee> list = repo.findBySalaryLessThan(salary);
		return list;
	}

	@Override
	public List<Employee> getBySalarySorted() {
		return repo.findAll(Sort.by(Order.desc("salary")));
//		return repo.findAll(Sort.by("salary"));
//		return repo.findAll(Sort.by(Direction.DESC,"salary"));
	}

	@Override
	public List<Employee> getBySalaryRange(double min, double max) {
		List<Employee> list = repo.findEmployeesBySalaryRange(min, max);
		return list;
	}

	@Override
	public int deleteByEname(String ename) {
		return repo.deleteByEname(ename);
	}
	
	public static boolean validateEmployeeData(Employee emp) {
		boolean flag=false;;
		if(emp.getEid()>99 && emp.getSalary()>1000 && emp.getEname().equals(emp.getEname().toUpperCase())) {
			flag=true;
		}
		return flag;
	}

}
