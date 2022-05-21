package com.example.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sample.entity.Department;
import com.example.sample.entity.Employee;
import com.example.sample.entity.Position;

@Mapper
public interface SampleMapper {
	
	public abstract List<Employee> selectAll();

	public abstract String getNextId();
	public abstract boolean insertEmployee(Employee employee);
	
	public abstract List<Department> getDepartmentList();
	public abstract List<Position> getPositionList();
	
	public abstract String getDepartmentName(String code);
	public abstract String getPositionName(String code);
	
}
