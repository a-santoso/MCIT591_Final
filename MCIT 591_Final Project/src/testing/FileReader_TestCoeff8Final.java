package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff8Final {

	@Test
	void testCoeff6() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(0.01829,x.getParsedCoefficients().get(8),0.00001);
		
	}
	
	

}
