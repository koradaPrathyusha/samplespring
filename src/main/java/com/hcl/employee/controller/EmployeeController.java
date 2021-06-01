package com.hcl.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.beans.Project;
import com.hcl.employee.services.EmployeeServices;
import com.hcl.employee.util.UserInputException;

@RestController
@RequestMapping("api/v2")
public class EmployeeController {
	@Autowired
	private EmployeeServices es;
	
	@Autowired
	private EmployeeServices ps;
	@GetMapping("/hello")
	public ResponseEntity<ArrayList<Employee>> sayHello() {
		return new ResponseEntity<ArrayList<Employee>>((ArrayList<Employee>)es.displayEmployee(),HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) throws UserInputException {
           return new ResponseEntity<Employee>( es.addEmployee(employee),HttpStatus.OK);
    }
	
	@DeleteMapping("/delete/{emp_id}")
	public ResponseEntity<Boolean> delEmp(@PathVariable int emp_id) throws UserInputException {
	   return new ResponseEntity<Boolean>(es.deleteEmployee(emp_id),HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public  ResponseEntity<Boolean> updateEmp(@PathVariable int id,@RequestBody Employee employee) throws UserInputException { 
	   return new  ResponseEntity<Boolean>(es.updateEmployee(id, employee),HttpStatus.OK); 
	}
	@GetMapping("/getemp/{id}")
	public ResponseEntity<Employee> getEmpOnId(@PathVariable int id) throws UserInputException {
	   return new ResponseEntity <Employee>(es.searchEmployee(id),HttpStatus.OK);	
	}
	
	@ExceptionHandler(UserInputException.class)
	public ResponseEntity<Object> handleGlobalException(HttpServletRequest request,Exception ex){
		System.out.println("controller based exception handler");
		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/projectdisplay")
	public ResponseEntity<ArrayList<Project>> sayHello1() {
		return new ResponseEntity<ArrayList<Project>>((ArrayList<Project>)ps.displayproject(),HttpStatus.OK);
	}
	
	@PostMapping("/addproject")
	public ResponseEntity<Project> addProject(@RequestBody Project project) throws UserInputException {
           return new ResponseEntity<Project>( ps.addProject(project),HttpStatus.OK);
    }

	 
	
}
