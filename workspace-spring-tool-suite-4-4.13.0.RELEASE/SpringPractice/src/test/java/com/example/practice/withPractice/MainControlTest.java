package com.example.practice.withPractice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mockit.Delegate;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;

class MainControlTest {

	@Tested(fullyInitialized = true)
	private MainControl sut = new MainControl();
	
	//�������uJudge-1�v�uJudge-4�v
	//�L�聨�u�v
	@Injectable Judge judge;
	
	@BeforeEach
	void setUp() throws Exception {
		
		new Expectations() {{	
			//�uJudge-1�v�uJudge-2�v
			judge.judgeString(withSuffix("e")); //�ue�v�ŏI���
			result = true;
			
			//�uJudge-2�v
//			judge.judgeString("false");
//			result = true;
		}};
		
		new Expectations() {{
			//�uJudge-1�v�uJudge-2�v�uJudge-3�v
//			judge.judgeUser( (User)any );
//			result = true;
			
			//�uJudge-1�v�uJudge-2�v�uJudge-4�v
			judge.judgeUser( (User)any );
			result = new Delegate() {
				public boolean sample(User user) {
					return "UserName".equals(user.getName()) ? true : false;
				}
			};
		}};
		
	}

	@Test
	void testMain() {
		this.sut.main();
	}

}