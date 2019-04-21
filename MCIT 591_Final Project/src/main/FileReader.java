package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;


public class FileReader {
	
	// Class to read file that is passed from Python Program
	// File contains parameters and coefficients of Logistic Regression

	// Parameters
	ArrayList<String> parsedParameters = new ArrayList<String>();
	// Coefficients of the parameters
	ArrayList<Double> parsedCoefficients = new ArrayList<Double>();
	
	public FileReader(String fileName) {
		File f = new File(fileName);
		Scanner scanner;
		try {
			scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] paramsAndCoef = line.split(",");
				
				parsedParameters.add(paramsAndCoef[0]);
				parsedCoefficients.add(Double.parseDouble(paramsAndCoef[1]));
						
				}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public ArrayList<String> getParsedParameters() {
		return parsedParameters;
	}

	public ArrayList<Double> getParsedCoefficients() {
		return parsedCoefficients;
	}
	
	
}
