package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam4Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		
		assertEquals("grade_enc",x.getParsedParameters().get(4));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
