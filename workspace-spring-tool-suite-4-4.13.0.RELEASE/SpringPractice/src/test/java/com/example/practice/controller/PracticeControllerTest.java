package com.example.practice.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.practice.entity.User;
import com.example.practice.service.TblUserService;

class PracticeControllerTest {
	
	@Mock
	@Autowired
	private TblUserService tblUserService;
	
	@InjectMocks
	@Autowired
	private PracticeController practiceController;
	
	private User user = new User();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		this.user.setId(025);
		this.user.setName("TestUser25");
		this.user.setAge(35);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testList() {
		fail("Not yet implemented");
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testInsert() {
			
		Mockito.doReturn(true).when(this.tblUserService).insert(this.user);
		
		String actual = this.practiceController.insert(this.user);
		String expected = "redirect:/practice";
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testRead() {
		fail("Not yet implemented");
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

}
