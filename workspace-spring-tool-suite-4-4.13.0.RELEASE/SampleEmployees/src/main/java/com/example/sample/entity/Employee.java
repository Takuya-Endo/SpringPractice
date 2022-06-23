package com.example.sample.entity;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.example.sample.form.EmployeeForm;

import lombok.Data;

@Data
public class Employee {
	
//	|物理名			|データ型			|必須	|デフォルト	|
//	|id				|char(4)		|Yes	|		|
//	|name			|varchar(20)	|Yes	|		|
//	|age			|int			|Yes	|		|
//	|sex_flg		|int			|Yes	|		|
//	|birth_date		|date			|Yes	|		|
//	|address		|varchar(50)	|Yes	|		|
//	|biko			|varchar(100)	|		|		|
//	|department_code|char(2)		|		|		|
//	|position_code	|char(2)		|		|		|
//	|update_date	|date			|		|'now()'|
//	|delete_flg		|char(1)		|Yes	|		|

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

//	private String id;
//	private String name;
//	private int age;
//	private int sex_flg;
//	private Date birth_date;
//	private String address;
//	private String biko;
//	private String department_code;
//	private String department_name;
//	private String position_code;
//	private String position_name;
//	private Date update_date;
//	private String delete_flg;
	
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
	
	public Employee changeEmptyCodeToNull() {
		
		if ("".equals(this.getDepartment_code())) {
			this.setDepartment_code(null);
		}
		if ("".equals(this.getPosition_code())) {
			this.setPosition_code(null);
		}
		return this;
	}
	
}
