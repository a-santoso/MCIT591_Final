package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff2Final {

	@Test
	void testCoeff2() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(-0.002946,x.getParsedCoefficients().get(2),0.00001);
		
	}
	
	

}
