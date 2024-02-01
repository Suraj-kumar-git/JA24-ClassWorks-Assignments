package com.hexaware.springrestjpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.springrestjpa.entities.Employee;
import com.hexaware.springrestjpa.service.IEmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	@Autowired
	IEmployeeService service;

	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
//		boolean isValid=EmployeeServiceImpl.validateEmployeeData(emp);
//		Employee tempemp=null;
//		if(isValid) {
//			tempemp=service.addEmployee(emp);  // Validation using Core Java
//		}
//		return tempemp;
		return service.addEmployee(emp);
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody @Valid Employee emp) {
		return service.updateEmployee(emp);
	}

	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return service.getAll();
	}

	@DeleteMapping("delete/{eid}")
	public String deleteEmployee(@PathVariable long eid) {
		return service.deleteEmployee(eid);
	}

	@GetMapping("/getById/{eid}")
	public Employee getEmployeeById(@PathVariable long eid) {
		return service.getEmployeeById(eid);
	}

	@GetMapping("/getByName/{name}")
	public List<Employee> getByEname(@PathVariable("name") String ename) {
		return service.getByEname(ename);
	}

	@GetMapping("/getBySalaryGT/{salary}")
	public List<Employee> findBySalaryGreaterThan(@PathVariable double salary) {
		return service.findBySalaryGreaterThan(salary);
	}

	@GetMapping("/getBySalaryLT/{salary}")
	public List<Employee> findBySalaryLT(@PathVariable double salary) {
		return service.findBySalaryLessThan(salary);
	}

	@GetMapping("/getBySalarySorted")
	public List<Employee> getBySalarySorted() {
		return service.getBySalarySorted();
	}

	@GetMapping("getBySalaryRange/{min}/{max}")
	public List<Employee> getBySalaryRange(@PathVariable double min, @PathVariable double max) {
		return service.getBySalaryRange(min, max);
	}

	@DeleteMapping("deleteByName/{name}")
	public String deleteByEname(@PathVariable(name="name") String ename) {
		int count=service.deleteByEname(ename);
		return count+" Record Deleted";
	}
}
