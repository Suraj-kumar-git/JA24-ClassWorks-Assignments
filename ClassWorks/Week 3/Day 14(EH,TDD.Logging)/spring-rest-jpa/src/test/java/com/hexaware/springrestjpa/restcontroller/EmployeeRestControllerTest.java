package com.hexaware.springrestjpa.restcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hexaware.springrestjpa.entities.Employee;

@SpringBootTest
class EmployeeRestControllerTest {

	@Autowired
	RestTemplate restTemplate;

	@Test
	void testAddEmployee() {
		Employee emp = new Employee(107,"SURAJ",45000);
		ResponseEntity<Employee> response = restTemplate.postForEntity("http://localhost:8080/api/employees/add",emp, Employee.class);
		Employee e= response.getBody();
		assertEquals(107,e.getEid());
	}

	@Test
	void testUpdateEmployee() {
		Employee emp = new Employee(106,"Update-Ctrlr-Testing",50000);
		restTemplate.put("http://localhost:8080/api/employees/update", emp );
		String eid="106";
		ResponseEntity<Employee> response =restTemplate.getForEntity("http://localhost:8080/api/employees/getById/"+eid,Employee.class);
		Employee updatedEmp = response.getBody();
		assertEquals(emp.getEname(),updatedEmp.getEname());
	}

	@Test
	void testGetAll() {
		ResponseEntity<List> response = restTemplate.getForEntity("http://localhost:8080/api/employees/getAll",
				List.class);
		List<Employee> list = response.getBody();
		assertTrue(list.size() > 0);
		//OR
//		List<Employee> list2 = restTemplate.getForObject("http://localhost:8080/api/employees/getAll",List.class);
//		assertNotNull(list2);
	}

	@Test
	void testDeleteEmployee() {
		int eid=107;
		restTemplate.delete("http://localhost:8080/api/employees/delete/"+eid);
		ResponseEntity<Employee> response = restTemplate.getForEntity("http://localhost:8080/api/employees/getById/"+eid,Employee.class);
		Employee fetchedEmp = response.getBody();
		assertNull(fetchedEmp);
	}

	@Test
	void testGetEmployeeById() {
		int eid = 101;
		ResponseEntity<Employee> response = restTemplate
				.getForEntity("http://localhost:8080/api/employees/getById/" + eid, Employee.class);
		Employee emp = response.getBody();
//		assertNotNull(emp);
		assertEquals(101, emp.getEid());
	}

}
