package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff1Final {

	@Test
	void testCoeff0() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(3.679185,x.getParsedCoefficients().get(0),0.00001);
		
	}
	
	void testCoeff1() {
		FileReader x = new FileReader("coefficient_final.csv");
		assertEquals(4.00E-06,x.getParsedCoefficients().get(1),0.00001);
	}

}
