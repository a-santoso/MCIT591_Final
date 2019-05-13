package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff7Final {

	@Test
	void testCoeff6() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(-1.60E-05,x.getParsedCoefficients().get(7),0.00001);
		
	}
	
	

}
