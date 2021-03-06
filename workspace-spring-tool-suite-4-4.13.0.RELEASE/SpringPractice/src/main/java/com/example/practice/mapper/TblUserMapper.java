package com.example.practice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.practice.entity.User;

@Mapper
public interface TblUserMapper {
	
	public abstract List<User> selectAll();
	public abstract User selectOne(int id);
	public abstract int getNextId();
	public abstract boolean insert(User user);
	public abstract boolean delete(User user);
	
}
