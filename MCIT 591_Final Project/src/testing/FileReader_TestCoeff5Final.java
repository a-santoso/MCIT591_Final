package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff5Final {

	@Test
	void testCoeff5() {
       FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals(-0.397999,x.getParsedCoefficients().get(5),0.00001);
		
	}
	
	

}
