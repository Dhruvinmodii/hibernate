package com.demo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.demo.controller.model.Employee;
import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

@Component
public class EmployeeDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	//add employee
		@Transactional
		public void addEmployee(Employee emp)
		{
			hibernateTemplate.save(emp);
		}
		
		
		//get all employee
		public List<Employee> getAllEmp()
		{
			return hibernateTemplate.loadAll(Employee.class);
		}
		
		//get employee by id
		@Transactional
		public Employee getEmpById(Long id)
		{
			
			
			Employee emp= hibernateTemplate.get(Employee.class, id);
			return emp;
		}
		
		
		//update employee
		
		@Transactional
		public void updateEmp(Employee emp)
		{
			hibernateTemplate.update(emp);
		}
		
		
		//delete employee
		@Transactional
		public void deleteEmp(Long id)
		{
			hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
		}
}
