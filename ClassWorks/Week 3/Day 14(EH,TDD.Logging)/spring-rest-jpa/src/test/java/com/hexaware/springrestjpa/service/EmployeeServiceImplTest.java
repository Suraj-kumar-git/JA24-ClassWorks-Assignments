package com.hexaware.springrestjpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.springrestjpa.dto.EmployeeDTO;
import com.hexaware.springrestjpa.entities.Employee;

@SpringBootTest
class EmployeeServiceImplTest {

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);
	@Autowired
	IEmployeeService serviceTest;

	@Test
	void testAddEmployee() {
		EmployeeDTO empDTO = new EmployeeDTO(119,"Suraj-Test",50000);
		Employee added = serviceTest.addEmployee(empDTO);
		logger.info("Holla...! Employee added successfully");
//		assertNotNull(added);
		assertEquals(empDTO.getEid(),added.getEid());
//		assertTrue(emp.getEid()>0);
	}

	@Test
	void testUpdateEmployee() {
		Employee toUpdate = new Employee(106,"Ayushi",5000);
		Employee updated = serviceTest.updateEmployee(toUpdate);
		assertEquals(toUpdate.getEname(),updated.getEname());
	}

	@Test
	void testGetAll() {
		List<Employee> list = serviceTest.getAll();
		boolean isEmpty=list.isEmpty();
		assertFalse(isEmpty);
	}

	@Test
	void testGetEmployeeById() {
		Employee emp = serviceTest.getEmployeeById(101);
		assertEquals("Suraj",emp.getEname());
	}

}
