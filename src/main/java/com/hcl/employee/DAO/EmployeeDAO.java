package com.hcl.employee.DAO;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.util.ConnectionUtil;
import com.hcl.employee.util.UserInputException;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	public Employee findByEmpName(String empName);
	public Employee findByEmpAddress(String empAddress);
//	@Query(value="select * from employee where emp_id>9",nativeQuery=true)
//	List<Employee> findAllWithGreaterEmpId();
	
	}
