package com.example.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.sample.entity.Employee;
import com.example.sample.mapper.SampleMapper;

@Service
@Transactional
public class SampleService {
	
	@Autowired
	private SampleMapper sampleMapper;
	
	public List<Employee> selectAll() {
		return this.sampleMapper.selectAll();
	}

	public boolean insertEmployee(Employee employee) {
		
		String id = this.sampleMapper.getNextId();
		employee.setId(id);
		return this.sampleMapper.insertEmployee(employee);
	}
	
}
