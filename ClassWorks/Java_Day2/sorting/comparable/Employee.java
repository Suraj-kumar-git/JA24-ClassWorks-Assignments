package sorting.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Employee implements Comparable<Employee>{
	
	int eid;
	String name;
	int salary;
	static String company="Hexaware technologies";
	
	Employee(){
		
	}
	Employee(int eid,String name,int salary){
		this.eid=eid;
		this.name=name;
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return "Eid: "+this.eid+", Name: "+this.name+", Salary: "+this.salary+", Company: "+this.company;
	}
	public static void main(String[] args) {
		Employee e = new Employee(1,"Suraj Kumar",50000);
		List<Employee> employees = new ArrayList<>();
		employees.add(e);
		employees.add(new Employee(2,"Palash Agarwal",40000));
		employees.add(new Employee(3,"Yash Dubey",45000));
		employees.add(new Employee(4,"Bhupendra Jogi",55000));
		employees.add(new Employee(5,"Sidhi Kasbekar",50000));
		
		System.out.println("Employees before sorting:\n");
		for(Employee emp:employees) {
			System.out.println(emp);
		}
		
		Collections.sort(employees);
		
		System.out.println("Employees after salary sorting:\n");
		Iterator<Employee> itr = employees.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	@Override
	public int compareTo(Employee e) {
		int result =this.salary-e.salary;
		if(result==0) {
			return this.name.compareTo(e.name);
		}
		return result;
	}
/*
The below compareTo overriding is also correct. The below method is overridden when we dont pass argument in the Comparable interface while implementing that.
*/
//	@Override
//	public int compareTo(Object o) {
//		Employee e = (Employee)o;
//		int result =this.salary-e.salary;
//		if(result==0) {
//			return this.name.compareTo(e.name);
//		}
//		return result;
//	}

}
