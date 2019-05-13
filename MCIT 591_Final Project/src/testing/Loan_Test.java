package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Loan;

class Loan_Test {

	@Test
	void test() {
		  Loan loan = new Loan(18000, 20, 1000, 6, 10, -999, 1000, 10000, 60, 100);
		  
		  loan.displayLoanInfo();
		  
		  assertEquals(18000, loan.getAnnual_income(), 0.00001);
	}

}
