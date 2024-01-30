package com.hexaware.springbootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexaware.springbootweb.dao.IEmployeeDao;
import com.hexaware.springbootweb.entity.Employee;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	IEmployeeDao dao;
	
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(HttpServletRequest request, HttpServletResponse response) {
		
		int eid =Integer.parseInt( request.getParameter("eid"));
		
		String ename=  request.getParameter("ename");
		
		double salary = Double.parseDouble( request.getParameter("salary"));
		
		Employee emp = new Employee(eid,ename,salary);
		System.out.println(eid+ename+salary);
		return dao.addEmployee(emp);
	}
	@RequestMapping(value="/update", method = RequestMethod.POST)
	@ResponseBody
	public String updateEmployee(HttpServletRequest request) {
		
		int eid =Integer.parseInt( request.getParameter("eid"));
		
		String ename=  request.getParameter("ename");
		
		double salary = Double.parseDouble( request.getParameter("salary"));
		
		Employee emp = new Employee(eid,ename,salary);
		System.out.println(eid+" "+ename+" "+salary);
		return dao.updateEmployee(emp);
	}
	
//	@RequestMapping("/getAll")
//	@ResponseBody
//	public List<Employee> getAllEmployee(){
//		return dao.getAll();
//	}
	
	@RequestMapping("/getAll")
	public String getAllEmployee(HttpSession session){
		List<Employee> list = dao.getAll();
		session.setAttribute("empList", list);
		return "displayAll";
	}
	
	@RequestMapping("/getEmployee")
//	@ResponseBody
	public String getEmployee(){
		return "success";  //   /views/Success.jsp
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(HttpServletRequest request) {
		int eid=Integer.parseInt(request.getParameter("eid"));
		return dao.deleteEmployee(eid);
	}
	
//	@RequestMapping("/getEmployee")
//	@ResponseBody
//	public String getById(HttpServletRequest request) {
//		int eid= Integer.parseInt(request.getParameter("eid"));
//		return dao.getEmployeeById(eid).toString();
//	}
}