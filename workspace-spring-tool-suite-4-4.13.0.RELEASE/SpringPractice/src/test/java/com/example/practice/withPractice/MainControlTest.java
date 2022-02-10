package com.example.practice.withPractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

class MainControlTest {

	@Tested(fullyInitialized = true)
	private MainControl sut = new MainControl();
	
	//無し→「Judge-1」「Judge-4」
	//有り→「」
	@Injectable Judge judge;
	
	@BeforeEach
	void setUp() throws Exception {
		
		new Expectations() {{	
			//「Judge-1」「Judge-3」
			judge.judgeString(withSuffix("e")); //「e」で終わる
			result = true;
			
			//「Judge-3」
//			judge.judgeString("false");
//			result = true;
		}};
		
		new Expectations() {{
			
			judge.judgeString(withSuffix("e")); //「e」で終わる
			result = true;
			
		}};
		
	}

	@Test
	void testMain() {
		this.sut.main();
	}

}
