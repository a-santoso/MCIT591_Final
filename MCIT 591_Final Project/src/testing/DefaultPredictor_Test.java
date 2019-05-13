package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;
import main.Loan;
import main.LogRegCalculator;

class DefaultPredictor_Test {

	@Test
	void test() {
			// Create logistic regression calculator
		
			FileReader coeffInput = new FileReader("coefficient_final.csv");
			
			LogRegCalculator logRegCalDynamic = new LogRegCalculator(coeffInput);
			
			// Create loan instance to test logistic regression calculator
		    Loan loan = new Loan(18000, 20, 1000, 6, 10, -999, 1000, 10000, 60, 100);
		    
		    System.out.println(logRegCalDynamic.predictDefault(loan));
		    
		    assertEquals(0.9871721645240364,logRegCalDynamic.predictDefault(loan),0.00001);
		    
		    Loan loan2 = new Loan(100000, 20, 10000, 2, 10, -999, 10000, 10000, 30, 5000);
		    
		    loan2.displayLoanInfo();
		    
		    System.out.println(logRegCalDynamic.predictDefault(loan2));
		    
		    assertEquals(7.883017478816509E-4,logRegCalDynamic.predictDefault(loan2),0.00001);
		    
		    
	}

}
