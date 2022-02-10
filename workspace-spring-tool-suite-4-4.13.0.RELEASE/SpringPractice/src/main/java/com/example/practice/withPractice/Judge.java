package com.example.practice.withPractice;

public class Judge {

	public boolean judgeString(String str) {	
		if ("true".equals(str)) {
			return true;
		}
		return false;
	}
	
	public boolean judgeUser(User user) {
		
		if ("UserName".equals(user.getName())) {
			return true;
		}
		return false;
	}
	
}
