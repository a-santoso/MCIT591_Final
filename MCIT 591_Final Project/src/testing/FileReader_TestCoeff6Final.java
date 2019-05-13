package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff6Final {

	@Test
	void testCoeff6() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(-0.000182,x.getParsedCoefficients().get(6),0.00001);
		
	}
	
	

}
