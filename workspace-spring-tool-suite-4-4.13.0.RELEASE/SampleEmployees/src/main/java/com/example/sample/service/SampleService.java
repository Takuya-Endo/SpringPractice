package com.example.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sample.entity.Department;
import com.example.sample.entity.Employee;
import com.example.sample.entity.Position;
import com.example.sample.mapper.SampleMapper;

@Service
@Transactional
public class SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;
	
	public List<Employee> selectAllEmployees() {
		
		return this.sampleMapper.selectAllEmployees();
		
		//↑下だとJavaの処理に頼っているので、上に変えて、SQLの段階で結合する。
		
//		return this.sampleMapper.selectAllEmployees().stream()
//			.collect(ArrayList::new, (list, employee) -> {
//				String departmentName = this.sampleMapper.getDepartmentName(employee.getDepartment_code());
//				String positionName = this.sampleMapper.getPositionName(employee.getPosition_code());
//				list.add(employee.setCodeName(departmentName, positionName));
//			}, (a,b)->{;});
		
		
	}

	public Employee selectEmployeeById(String id) {
		return this.sampleMapper.selectEmployeeById(id);
	}
	
	public boolean insertEmployee(Employee employee) {
		
		String id = this.sampleMapper.getNextId();
		employee.setId(id);
		return this.sampleMapper.insertEmployee(employee);
	}
	
	public boolean updateEmployee(Employee employee) {
		
		return this.sampleMapper.updateEmployee(employee);
	}
	
	public boolean deleteEmployee(Employee employee) {
		return this.sampleMapper.deleteEmployee(employee);
	}
	
	
	public List<Department> getDepartmentList() {
		
		List<Department> departmentList = this.sampleMapper.getDepartmentList();
		
		Department department = new Department();
		department.setCode("");
		department.setName("---");
		
		departmentList.add(0, department);
		
		return departmentList;
	}
	
	public List<Position> getPositionList() {
		
		List<Position> positionList = this.sampleMapper.getPositionList();
		
		Position position = new Position();
		position.setCode("");
		position.setName("---");
		
		positionList.add(0, position);
		
		return positionList;
	}
	
	public String getDepartmentName(String code) {
		return this.sampleMapper.getDepartmentName(code);
	}
	public String getPositionName(String code) {
		return this.sampleMapper.getPositionName(code);
	}
	
}
