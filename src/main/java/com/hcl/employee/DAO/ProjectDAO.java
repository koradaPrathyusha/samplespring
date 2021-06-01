package com.hcl.employee.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.employee.beans.Employee;
import com.hcl.employee.beans.Project;

@Repository
public interface ProjectDAO extends JpaRepository<Project, Integer>{



}
