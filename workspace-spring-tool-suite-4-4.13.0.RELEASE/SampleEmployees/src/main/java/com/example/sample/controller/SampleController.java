package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.sample.entity.Employee;
import com.example.sample.form.EmployeeForm;
import com.example.sample.service.SampleService;

@Controller
@RequestMapping(value="/employees")
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model) {
		
		
		List<Employee> employeeList = this.sampleService.selectAll();
		model.addAttribute("employeeList", employeeList);
		
		return "employees/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String showInsert(Model model) {
		
		model.addAttribute(new EmployeeForm());
		
		return "employees/insert";
	}
	
	@RequestMapping(value="/confirmInsert", method=RequestMethod.POST)
	public String confirmInsert(Model model, EmployeeForm employeeForm) {
		
		model.addAttribute(employeeForm);
		
		return "employees/insertConfirm";
	}
	
	@RequestMapping(value="/runInsert", method=RequestMethod.POST)
	public String insert(EmployeeForm employeeForm) {
		
		this.sampleService.insertEmployee(employeeForm.toEntity());
		
		return "redirect:list";
	}
	
	

}
