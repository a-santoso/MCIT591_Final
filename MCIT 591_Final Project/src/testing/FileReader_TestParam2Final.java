package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam2Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		
		assertEquals("dti",x.getParsedParameters().get(2));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
