package com.example.sample.form;

import org.springframework.beans.BeanUtils;

import com.example.sample.entity.Employee;

import lombok.Data;

@Data
public class EmployeeForm {

	private String id;
	private String name;
	private String age;
	private String sex_flg;
	private String birth_date;
	private String address;
	private String biko;
	private String department_code;
	private String position_code;
	private String update_date;
	private String delete_flg;
	
	
	public Employee toEntity() {
		Employee employee  = new Employee ();
		BeanUtils.copyProperties(this, employee);
		return employee ;
	}
	
}
