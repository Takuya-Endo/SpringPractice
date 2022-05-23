package com.example.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		
		List<Employee> employeeList = this.sampleService.selectAllEmployees();
		model.addAttribute("employeeList", employeeList);
		
		return "employees/list";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String showInsert(Model model) {
		
		model.addAttribute(new EmployeeForm());
		model.addAttribute(this.sampleService.getDepartmentList());
		model.addAttribute(this.sampleService.getPositionList());
		
		return "employees/insert";
	}
	
	@RequestMapping(value="/confirmInsert", method=RequestMethod.POST)
	public String confirmInsert(Model model, @Validated EmployeeForm employeeForm, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
//			model.addAttribute(new EmployeeForm());
			model.addAttribute(this.sampleService.getDepartmentList());
			model.addAttribute(this.sampleService.getPositionList());
			return "employees/insert";
		}
		
		model.addAttribute(this.putCodeName(employeeForm));
		return "employees/insertConfirm";
	}
	
	@RequestMapping(value="/runInsert", method=RequestMethod.POST)
	public String insert(EmployeeForm employeeForm) {
		
		this.sampleService.insertEmployee(employeeForm.toEntity());
		
		return "redirect:list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdate(Model model, @RequestParam String id) {
		
		model.addAttribute(this.sampleService.selectEmployeeById(id).toForm());
		model.addAttribute(this.sampleService.getDepartmentList());
		model.addAttribute(this.sampleService.getPositionList());
		
		return "employees/update";
	}
	
	@RequestMapping(value="/confirmUpdate", method=RequestMethod.POST)
	public String confirmUpdate(Model model, EmployeeForm employeeForm) {
		
		model.addAttribute(this.putCodeName(employeeForm));
		return "employees/updateConfirm";
	}
	
	@RequestMapping(value="/runUpdate", method=RequestMethod.POST)
	public String update(EmployeeForm employeeForm) {
		
		boolean result = this.sampleService.updateEmployee(employeeForm.toEntity());
		return "redirect:list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String showDelete(Model model, @RequestParam String id) {
		
		EmployeeForm employeeForm = this.sampleService.selectEmployeeById(id).toForm();
		model.addAttribute(this.putCodeName(employeeForm));
		
		return "employees/delete";
	}
	
	@RequestMapping(value="/runDelete", method=RequestMethod.POST)
	public String runDelete(EmployeeForm employeeForm) {
		
		this.sampleService.deleteEmployee(employeeForm.toEntity());
		
		return "redirect:list";
	}
	
	
	/**
	 * 受け取ったemployeeFormのcodeからcode_nameを検索し、セットする。
	 * @param employeeForm
	 * @return code_nameをセットし終えたemployeeForm
	 */
	private EmployeeForm putCodeName(EmployeeForm employeeForm) {
		String departmentName = this.sampleService.getDepartmentName(employeeForm.getDepartment_code());
		String positionName = this.sampleService.getPositionName(employeeForm.getPosition_code());
		return employeeForm.setCodeName(departmentName, positionName);
	}
	
}
