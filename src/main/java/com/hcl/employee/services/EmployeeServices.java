package com.hcl.employee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.DAO.EmployeeDAO;
import com.hcl.employee.DAO.ProjectDAO;
import com.hcl.employee.beans.Employee;
import com.hcl.employee.beans.Project;
import com.hcl.employee.util.UserInputException;
@Service
public class EmployeeServices {
	@Autowired
	private EmployeeDAO ed;
	
	@Autowired
	private ProjectDAO pd;
	
	
	public  List<Employee> displayEmployee(){
//		List<Employee> temp=ed.findAll();
//		List<Employee> list=temp.stream().filter(s->s.getEmpId()>9).collect(Collectors.toList());
//		return list;
		return ed.findAll();
	}

	public  Employee addEmployee(Employee employee) throws UserInputException {
		
		if(!ed.findById(employee.getEmpId()).isPresent()) {
		pd.saveAll(employee.getProject2());	
		return ed.saveAndFlush(employee);
		}
		else
			throw new UserInputException("id already exists");
	}
	public  boolean updateEmployee(int id,Employee employee) throws UserInputException{
		if(ed.findById(id).isPresent()) {
		pd.saveAll(employee.getProject2());	
		   ed.saveAndFlush(employee);
		   return true;
		}
		else
			throw new UserInputException("does not exists");
		
	}
	public Boolean deleteEmployee(int emp_id) throws UserInputException {
		if(ed.findById(emp_id).isPresent()) {
	    ed.deleteById(emp_id);
		return true;
		}
		else
			throw new UserInputException("does not exists");
		
	}
	public  Employee searchEmployee(int emp_id) throws UserInputException{
		if(ed.findById(emp_id).isPresent())
		    return ed.findById(emp_id).get();
		else
			throw new UserInputException("does not exists");
	}

	public List<Project> displayproject() {
		// TODO Auto-generated method stub
		return pd.findAll();
	}

	

	public Project addProject(Project project){
		
		
		return pd.saveAndFlush(project);
	}

}
