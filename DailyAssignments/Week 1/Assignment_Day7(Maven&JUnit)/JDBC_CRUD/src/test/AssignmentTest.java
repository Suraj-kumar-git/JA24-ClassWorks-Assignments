package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dao.DeptDAOImpl;
import entity.Department;

class AssignmentTest {
	
	static DeptDAOImpl dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao=new DeptDAOImpl();
	}

	@Test
	void updateDeptTest() {
		Department d = new Department();
		// Updated Department record
		d.setDno(110);
		d.setDname("Fresher");
		d.setLocation("Chennai");
		int count=dao.updateDept(d);
		assertEquals(1,count);
	}
	
	@Test
	void deleteOneDeptTest() {
		int count=dao.deleteOneDept(110);
		assertEquals(1,count);
	}
	
	@Test
	void selectOneTest() {
		Department d = dao.selectOne(90);
		assertNotNull(d);
	}

}
