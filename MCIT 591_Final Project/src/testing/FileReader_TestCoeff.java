package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestCoeff {

	//Test file reader for coefficients
	//Return parsed coefficients based on input file
	void testCoeff() {
		FileReader x = new FileReader("coefficient.csv");
		
		// assertEquals(1.405,x.getParsedCoefficients().get(0),0.00001);
		// assertEquals(2.3,x.getParsedCoefficients().get(1),0.00001);
		
		System.out.println(x.getParsedParameters());
		System.out.println(x.getParsedCoefficients());
		
	}

}
