package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam9Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		
		assertEquals("total_pymnt",x.getParsedParameters().get(9));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
