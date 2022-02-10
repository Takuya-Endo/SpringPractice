package com.example.practice.withPractice;

import org.springframework.beans.factory.annotation.Autowired;

public class MainControl {
	
	@Autowired
	Judge judge;
	
	public void main() {
		
		if (judge.judgeString("true")) {
			System.out.println("Judge-1");
		}
		
		if (judge.judgeUser(new User())) {
			System.out.println("Judge-2");
		}
		
		if (judge.judgeString("false")) {
			System.out.println("Judge-3");
		}
		
		if (judge.judgeUser(new User("UserName", 1))) {
			System.out.println("Judge-4");
		}
		
	}

}
