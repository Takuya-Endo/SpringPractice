package com.example.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.practice.entity.User;
import com.example.practice.service.TblUserService;

@Controller
@RequestMapping(value = "practice")
public class PracticeController {
	
	@Autowired
	private TblUserService tblUserService;
	
//	//テスト用メソッド
//	public void log() {
//		System.out.println("test");
//	}
//	
//	//例外送出用練習メソッド
//	public void exception() throws Exception {
//		throw new Exception("testException");
//	}
	
	@RequestMapping(value = "")
	public String list(Model model) {
		
		List<User> userList = this.tblUserService.selectAll();
		model.addAttribute("userList", userList);
		
		return "html/index";
		
	}
	
	@RequestMapping(value = "create")
	public String create(Model model) {
		
		model.addAttribute("userForm", new User());
		return "html/insert";
		
	}
	
	@RequestMapping(value = "insert")
	public String insert(@ModelAttribute User user) {
		
		boolean result = this.tblUserService.insert(user);
		if (!result) {
			System.err.println("insert失敗");
		}
		
		return "redirect:/practice";
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="detail/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		
		User user = this.tblUserService.selectOne(id);
		model.addAttribute("user", user);
		
		return "html/detail";
		
	}
	
	@RequestMapping(value = "delete")
	public String delete(@ModelAttribute User user) {
		
		boolean result = this.tblUserService.delete(user);
		if (!result) {
			System.err.println("delete失敗");
		}
		
		return "redirect:/practice";
		
	}
	
}
