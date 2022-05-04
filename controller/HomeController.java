package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.controller.model.Employee;
import com.demo.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
		
	}
	
	//load form
	@GetMapping("addEmployee")
	public String addEmp()
	{
		return "AddEmployee";
	}
	
	//add emp data
	@PostMapping("/insertEmployee")
	public String insertEmp(@ModelAttribute("insertEmployee") Employee emp)
	{
		employeeservice.addEmp(emp);
		return "redirect:/employeeReport";
	}
	
	//get all data
	@GetMapping("employeeReport")
	public String loadEmployee(Model m)
	{
		m.addAttribute("employee",employeeservice.getAllEmp());
		return "EmployeeReport";
	}
	
	//load edit form
	@GetMapping("/editEmployee/{id}")
	public String lodeEditForm(@PathVariable(value="id") Long id, Model m)
	{
		Employee emp=employeeservice.getById(id);
		
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");
		
		return "EditEmployee";
		
	}
	
	//update emp
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp)
	{
		employeeservice.updateEmp(emp);
		
		return "redirect:/employeeReport";
		
	}
	
	//delete emp
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeservice.deleteEmployee(id);
		
		
		return "redirect:/employeeReport";
	}

}
