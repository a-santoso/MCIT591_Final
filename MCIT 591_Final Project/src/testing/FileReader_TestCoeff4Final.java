package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff4Final {

	@Test
	void testCoeff4() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(0.888092,x.getParsedCoefficients().get(4),0.00001);
		
	}
	
	

}
