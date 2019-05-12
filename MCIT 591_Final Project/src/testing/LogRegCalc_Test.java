package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Loan;
import main.LogRegCalculator;

class LogRegCalc_Test {

	@Test
	void test() {
		LogRegCalculator logRegCalTest = new LogRegCalculator(1000,2,3,4,5,6,7,8,9,10,11);
		Loan loanTest = new Loan(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		double output = logRegCalTest.predictDefault(loanTest);
		
		System.out.println(output);
		
		assertEquals(1.0,output);
		
	}

}
