package testing;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.FileReader;

class FileReader_TestParam {

	//Test file reader for parameters
	//Return parsed parameters based on input file
	void testParam() {
		FileReader x = new FileReader("ParametersInput.txt");
		
		assertEquals("annual_inc",x.getParsedParameters().get(0));
		assertEquals("term_num",x.getParsedParameters().get(1));
		
		// System.out.println(x.getParsedParameters());
		// System.out.println(x.getParsedCoefficients());
		
	}
	
	
	
	

}
