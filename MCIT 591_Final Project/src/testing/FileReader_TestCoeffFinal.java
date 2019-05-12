package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeffFinal {

	@Test
	void test() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(3.679185,x.getParsedCoefficients().get(0),0.00001);
		assertEquals(4.00E-06,x.getParsedCoefficients().get(1),0.00001);
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
