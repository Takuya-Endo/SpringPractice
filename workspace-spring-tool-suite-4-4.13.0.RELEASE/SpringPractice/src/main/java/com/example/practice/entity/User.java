package com.example.practice.entity;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class User {
	
	@NotEmpty private int id;
	@NotEmpty private String name;
	@NotEmpty private int age;
	
}
