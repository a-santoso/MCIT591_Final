package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam1Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		assertEquals("annual_inc",x.getParsedParameters().get(1));
		
		//assertEquals("dti",x.getParsedParameters().get(2));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
