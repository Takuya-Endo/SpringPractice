package com.example.sample.entity;

import org.springframework.beans.BeanUtils;

import com.example.sample.form.EmployeeForm;

import lombok.Data;

@Data
public class Employee {
	
	private String id;
	private String name;
	private String age;
	private String sex_flg;
	private String birth_date;
	private String address;
	private String biko;
	private String department_code;
	private String department_name;
	private String position_code;
	private String position_name;
	private String update_date;
	private String delete_flg;

	
	public EmployeeForm toForm() {
		EmployeeForm employeeForm  = new EmployeeForm ();
		BeanUtils.copyProperties(this, employeeForm);
		return employeeForm ;
	}
	
	public Employee setCodeName(String departmentName, String positionName) {
		this.setDepartment_name(departmentName);
		this.setPosition_name(positionName);
		return this;
	}
	
}
