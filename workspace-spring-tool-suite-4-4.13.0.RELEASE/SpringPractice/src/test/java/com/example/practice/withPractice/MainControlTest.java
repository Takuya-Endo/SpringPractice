package com.example.practice.withPractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mockit.Injectable;
import mockit.Tested;

class MainControlTest {

	@Tested(fullyInitialized = true)
	private MainControl sut = new MainControl();
	
//	@Injectable Judge judge;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testMain() {
		this.sut.main();
	}

}
