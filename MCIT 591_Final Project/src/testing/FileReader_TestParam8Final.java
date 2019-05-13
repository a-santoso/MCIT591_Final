package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam8Final {

	@Test
	void test() {
        FileReader x = new FileReader("coefficient_final.csv");
		
		
		assertEquals("term_num",x.getParsedParameters().get(8));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
	}

}
