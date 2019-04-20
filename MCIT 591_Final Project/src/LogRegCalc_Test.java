
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LogRegCalc_Test {

	@Test
	void test() {
		LogRegCalculator logRegCalTest = new LogRegCalculator(100,2,3,4,5,6,7,8,9,10,11);
		Loan loanTest = new Loan(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		double output = logRegCalTest.predictDefault(loanTest);
		
		System.out.println(output);
		
		assertEquals(3.3038492872965484E234,output);
		
	}

}
