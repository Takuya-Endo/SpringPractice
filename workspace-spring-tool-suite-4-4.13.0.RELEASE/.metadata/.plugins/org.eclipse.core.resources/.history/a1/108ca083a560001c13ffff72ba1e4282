package com.example.practice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practice.entity.User;
import com.example.practice.mapper.TblUserMapper;

@Service
@Transactional
public class TblUserService {
	
	@Autowired
	private TblUserMapper tblUserMapper;
	
	public List<User> selectAll() {
		return this.tblUserMapper.selectAll();
	}
	
}
