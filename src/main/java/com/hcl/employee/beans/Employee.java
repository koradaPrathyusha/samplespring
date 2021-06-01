package com.hcl.employee.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//import org.springframework.context.annotation.Scope;
//import org.springframework.data.relational.core.mapping.Table;
//import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Component
@Entity
@Table(name="employee2")
//@Service
//@Scope("prototype")
public class Employee {
	
//	private int emp_id;
//    private String emp_name;
//    private String emp_address;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name",nullable=false)
	private String empName;
	
	@Column(name="emp_address")
	private String empAddress;
	
//	@ManyToOne
//	private Project project;
   
	@OneToMany
	private List<Project> project2;
}