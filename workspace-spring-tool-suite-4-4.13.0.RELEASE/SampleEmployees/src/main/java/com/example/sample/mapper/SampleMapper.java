package com.example.sample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.sample.entity.Employee;

@Mapper
public interface SampleMapper {
	
	public abstract List<Employee> selectAll();

	public abstract String getNextId();
	public abstract boolean insertEmployee(Employee employee);
	
}
