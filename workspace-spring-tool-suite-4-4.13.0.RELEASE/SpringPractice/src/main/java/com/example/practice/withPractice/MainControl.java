package com.example.practice.withPractice;

import org.springframework.beans.factory.annotation.Autowired;

public class MainControl {
	
	@Autowired
	private Judge judge;
	
	private User user = null;
	
	public void main() {
		
		if (judge.judgeString("true")) {
			System.out.println("Judge-1");
		}
		
		this.user = new User();
		if (judge.judgeUser(this.user)) {
			System.out.println("Judge-2");
		}
		
		if (judge.judgeString("false")) {
			System.out.println("Judge-3");
		}
		
		this.user = new User("UserName", 1);
		if (judge.judgeUser(this.user)) {
			System.out.println("Judge-4");
		}
		
	}

}
