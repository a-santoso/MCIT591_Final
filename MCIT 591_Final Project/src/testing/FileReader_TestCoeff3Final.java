package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff3Final {

	@Test
	void testCoeff3() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(-0.001628,x.getParsedCoefficients().get(3),0.00001);
		
	}
	
	

}
