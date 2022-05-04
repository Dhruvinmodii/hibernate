package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.controller.model.Employee;
import com.demo.dao.EmployeeDao;

@Component
@Service
public class EmployeeService {

	@Autowired
	EmployeeDao employeedao;

	// add emp
	public void addEmp(Employee emp) {
		employeedao.addEmployee(emp);
	}

	// get all
	public List<Employee> getAllEmp() {
		return employeedao.getAllEmp();
	}

	// get emp by id

	public Employee getById(Long id) {
		return employeedao.getEmpById(id);
	}

	// update employee

	public void updateEmp(Employee emp) {
		employeedao.updateEmp(emp);
	}

	// delete employee

	public void deleteEmployee(Long id) {
		employeedao.deleteEmp(id);
	}
}
