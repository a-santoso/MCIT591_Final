package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam6Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		
		assertEquals("loan_amnt",x.getParsedParameters().get(6));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
