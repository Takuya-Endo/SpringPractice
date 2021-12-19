package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.practice.entity.User;
import com.example.practice.service.TblUserService;

@Controller
@RequestMapping(value = "practice")
public class PracticeController {
	
	@Autowired
	private TblUserService tblUserService;
	
	@RequestMapping(value = "")
	public String list(Model model) {
		
		List<User> userList = this.tblUserService.selectAll();
		model.addAttribute("userList", userList);
		
		return "html/index";
		
	}
	
	@RequestMapping(value = "create")
	public String create() {
		return "html/insert";
	}

}