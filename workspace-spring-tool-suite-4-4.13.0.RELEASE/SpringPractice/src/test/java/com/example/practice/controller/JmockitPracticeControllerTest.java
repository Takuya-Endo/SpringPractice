package com.example.practice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.example.practice.mapper.TblUserMapper;
import com.example.practice.service.TblUserService;

import mockit.Injectable;
import mockit.Mocked;
import mockit.Tested;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/test/applicationcontext.xml"})
class JmockitPracticeControllerTest {

	
	@Tested private TblUserService tblUserService;
	
	@Tested
	private PracticeController practiceController = new PracticeController();
	
	@Injectable private TblUserMapper tblUserMapper;
	
	@Mocked private Model model;

	
	@BeforeEach
	void setUp() throws Exception {
	}


	
	@Test
	void testRead() {
		
		this.practiceController.read(1, this.model);
		
	}
	
	
//	@Test
//	void testException1() {
//		
//		try {
//			
//			this.practiceController.exception();
//			
//			fail();
//			
//		} catch (Exception e) {
//			
//			String expected = "testException";
//			String actual = e.getMessage();
//			
//			assertThat(actual, is(expected));
//			
//		}
//		
//	}
	
//	@Test
//	void testException2() {
//		
//		Assertions.assertThrows(
//			
//			Exception.class, () -> {
//				
//				this.practiceController.exception();
//				
//			}
//			
//		);
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
