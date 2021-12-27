package com.example.practice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.example.practice.service.TblUserService;

import mockit.Injectable;
import mockit.Tested;

@ExtendWith(SpringExtension.class)
class PracticeControllerTest3 {

	@Tested
	private PracticeController practiceController = new PracticeController();
	
	@Injectable
	private TblUserService tblUserService;
	
	@Injectable
	private Model model;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testLog() {
//		this.practiceController.log();
//	}
	
	@Test
	void testException1() {
		
		try {
			
			this.practiceController.exception();
			
			fail();
			
		} catch (Exception e) {
			
			String expected = "testException";
			String actual = e.getMessage();
			
			assertThat(actual, is(expected));
			
		}
		
	}
	
	@Test
	void testException2() {
		
	}
	
	
//	@Test
//	void testRead() {
//		
//		
//		
//		this.practiceController.read(1, this.model);
//		
//	}
	
//	@Test
//	void testList() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testCreate() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testInsert() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testDelete() {
//		fail("Not yet implemented");
//	}

}