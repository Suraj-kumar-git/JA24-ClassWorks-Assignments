package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import dao.DeptDAOImpl;
import dao.IDepartmentDAO;
import entity.Department;

class DeptDAOImplTest {

	static IDepartmentDAO dao;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		dao=new DeptDAOImpl();
	}

	@Test
	@Disabled
	void testInsertDept() {
		Department dept = new Department();
		dept.setDno(110);
		dept.setDname("Suraj2");
		dept.setLocation("Muzaffarpur");
		int actual =dao.insertDept(dept);
		
		assertEquals(1,actual);
	}

	@Test
	void testSelectAll() {
		List<Department> list = dao.selectAll();
		Department dept = list.get(0);
//		assertTrue(dept.getDno()>0);
		assertNotNull(list);
	}
	


}
