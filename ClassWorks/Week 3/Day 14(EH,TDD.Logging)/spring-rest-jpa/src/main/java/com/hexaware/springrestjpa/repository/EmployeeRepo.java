package com.hexaware.springrestjpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.springrestjpa.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	List<Employee> findByEname(String ename);
	
	List<Employee> findBySalaryGreaterThan(double salary);
	
	List<Employee> findBySalaryLessThan(double salary);
	
//	@Query(value="select * from jpaemp where salary between ? and ?",nativeQuery=true)
	@Query("select e from Employee e where e.salary between ?1 and ?2")
	List<Employee> findEmployeesBySalaryRange(double min,double max);
	
	@Query("delete from Employee e where e.ename=?1")
	@Modifying
	int deleteByEname(String ename);
	
//	@Query("update Employee e set e.salary = ?1 where e.eid=?2")
	
	
}
