package com.hcl.employee.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hcl.employee.beans.Employee;

public class EmployeeMapper implements RowMapper<Employee>{

	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee e=new Employee();
		e.setEmpId(rs.getInt(1));
		e.setEmpName(rs.getString(2));
		e.setEmpAddress(rs.getString(3));
		return e;
	}

}
