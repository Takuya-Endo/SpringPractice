package com.example.sample.form;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import com.example.sample.entity.Employee;

import lombok.Data;

@Data
public class EmployeeForm {

	@NotBlank private String id;
	@NotBlank private String name;
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
	
	
	public Employee toEntity() {
		Employee employee  = new Employee ();
		BeanUtils.copyProperties(this, employee);
		return employee ;
	}
	
	public EmployeeForm setCodeName(String departmentName, String positionName) {
		this.setDepartment_name(departmentName);
		this.setPosition_name(positionName);
		return this;
	}
	
}
