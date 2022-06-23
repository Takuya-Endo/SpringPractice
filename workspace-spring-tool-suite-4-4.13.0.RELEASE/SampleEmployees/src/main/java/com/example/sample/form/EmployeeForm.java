package com.example.sample.form;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.BeanUtils;

import com.example.sample.entity.Employee;

import lombok.Data;

@Data
public class EmployeeForm {

	private String id;
	@NotBlank private String name;
	@NotBlank @Pattern(regexp="^[0-9]*$") private String age;
	@NotBlank @Pattern(regexp="^[0|1]$") private String sex_flg;
	@NotBlank @Pattern(regexp="^[0-9]{4}[/][0-9]{1,2}[/][0-9]{1,2}$") private String birth_date;
	@NotBlank private String address;
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
		
		//空文字だと外部キー制約に引っかかるため、departmentとpositionのコードはnullに変換してから返却
		return employee.changeEmptyCodeToNull();
	}
	
	public EmployeeForm setCodeName(String departmentName, String positionName) {
		this.setDepartment_name(departmentName);
		this.setPosition_name(positionName);
		return this;
	}
	
}
