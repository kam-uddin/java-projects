package com.kuddin.tools;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GraderTest {

	@Test
	void fiftyNineShouldReturnF() {
		var grader = new Grader();
		assertEquals('F', grader.determineLetterGrade(59));
	}
	
	@Test
	void sixtyNineShouldReturnD() {
		var grader = new Grader();
		assertEquals('D', grader.determineLetterGrade(69));
	}
	
	@Test
	void seventyNineShouldReturnC() {
		var grader = new Grader();
		assertEquals('C', grader.determineLetterGrade(79));
	}

	@Test
	void eightyNineShouldReturnB() {
		var grader = new Grader();
		assertEquals('B', grader.determineLetterGrade(89));
	}
	
	@Test
	void nintyNineShouldReturnA() {
		var grader = new Grader();
		assertEquals('A', grader.determineLetterGrade(99));
	}
	
	@Test
	void negativeOneShouldReturnIllegalArgumentException() {
		var grader = new Grader();
		assertThrows(IllegalArgumentException.class,
			() -> {
				 grader.determineLetterGrade(-1);
			});
				
			
	}

}
