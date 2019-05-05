package main;
/**
 * Main class that functions as loan default predictor runner
 * This class serves as interface with users also
 *
 */

import java.util.*;
import java.util.Scanner;

public class DefaultPredictor {
	
	public DefaultPredictor() {
		
	}
	
	public static void main(String[] args) {

		// Create logistic regression calculator
	
		FileReader coeffInput = new FileReader("coefficient_final.csv");
		
		LogRegCalculator logRegCalDynamic = new LogRegCalculator(coeffInput);
		
				
		// LogRegCalculator logRegCal = new LogRegCalculator(2.3119, 0.000004615, 0.00001077, -0.0015, 0.4291, 
		//		-0.2689, 0.0029, -0.0002, -0.00001734, 0.0212, 0.0016);
		
		// Create loan instance to test logistic regression calculator
		// Dummy loan - to be deleted
		// Loan loan = new Loan(10000, 20, 5000, 1, 11, 21, 10000, 11000, 36, 6000);
		
		// Loan instance variable that feeds to logistic regression calculator
		// Parameters of this loan variable will be obtained from user prompts
		Loan loanInput = new Loan();
		
		System.out.println("-------------------------------");
		System.out.println("Loan Default Predictor Program");
		System.out.println("-------------------------------");
		
		System.out.println();
		
		System.out.println("This program will predict loan default rate based on logistic "
				+ "regression performed on LendingClub data");
		
	
		
		
		
		System.out.println("Please enter the following 9 user prompts in order to predict the default rate");
		
		System.out.println();
		System.out.println("GETTING USER INPUT ...");
		System.out.println();
		
		Scanner userInputScanner = new Scanner(System.in);
		boolean inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("1. Please fill annual income in USD. Typical ranges: 20000 to 250000");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setAnnual_income(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while (!inputValidation) {
			try {
				System.out.println("2. Please fill debt to income (DTI) ratio.");
				System.out.println("DTI ratio is calculated by dividing total debt (excluding mortgage) with monthly income");
				System.out.println("In other words, how many monthly incomes are required to pay for your total debt. Typical ranges: 2-25");
				double input = userInputScanner.nextDouble();
				if (input >= 0) {
					loanInput.setDti(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("3. Please fill funded amount in USD");
				System.out.println("Funded amount is the total amount committed to the loan. Typical ranges: 1000-35000 ");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setFunded_amount(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("4. Please fill loan grade. Loan grade is assigned by Lending Club");
				System.out.println("Typical ranges: A to G. Please put C if it is unknown");
				String input = userInputScanner.next();
				if(input.equals("A")){
					loanInput.setGrade(0);
					inputValidation = true;
				} else if (input.equals("B")){
					loanInput.setGrade(1);
					inputValidation = true;
				} else if (input.equals("C")){
					loanInput.setGrade(2);
					inputValidation = true;
				} else if (input.equals("D")){
					loanInput.setGrade(3);
					inputValidation = true;
				} else if (input.equals("E")){
					loanInput.setGrade(4);
					inputValidation = true;
				} else if (input.equals("F")){
					loanInput.setGrade(5);
					inputValidation = true;
				} else if (input.equals("G")){
					loanInput.setGrade(6);
					inputValidation = true;
				} else 				
				{
					System.out.println("Invalid input, please enter A/B/C/D/E/F/G");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please enter A/B/C/D/E/F/G");
				userInputScanner.next();
			}
		}
		
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("5. Please fill interest rate (don't put %). Typical ranges: 6.0-22.0 ");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setRate(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		/*
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("6. Please fill issue date: ");
				int input = userInputScanner.nextInt();
				if(input >= 0) {
					loanInput.setIssueDate(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		*/
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("6. Please fill loan amount in USD. Loan amount is the listed amount requested by borrower");
				System.out.println("Typical ranges: 1000-35000");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setLoan_amount(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("7. Please fill revolve balance in USD. Revolve balance is total credit revolving balance");
				System.out.println("Typical ranges: 0-100000");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setRevol_balance(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("8. Please fill term number in months. Typical ranges: 36-60: ");
				int input = userInputScanner.nextInt();
				if(input >= 0) {
					loanInput.setTerm_number(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("9. Please fill total payments received to date for total amount funded. Typical ranges: 0-35000");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
					loanInput.setTotal_payment(input);
					inputValidation = true;
				} else {
					System.out.println("Invalid input, negative number is not allowed");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, number required");
				userInputScanner.next();
			}
		}
		
	
		System.out.println();
		System.out.println("CALCULATING ...");

		System.out.println();
		System.out.println("DISPLAYING RESULT ... ");
		
		
		
		System.out.println();
		System.out.println("Default rate prediction: " + logRegCalDynamic.predictDefault(loanInput));
		
		System.out.println();
		System.out.println("--------------");
		
		System.out.println("END OF PROGRAM");
		
		System.out.println("--------------");
		
		System.out.println();
		System.out.println("Example of 2 different profiles:");
		System.out.println("-------------------------------------------------------------");
		System.out.println("                      Customer 1        |    Customer 2     ");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Annual Income:            100000        |         18000          ");
		System.out.println("DTI:        	              20        |            20          ");
		System.out.println("Funded Amount:      	   10000        |          1000");
		System.out.println("Grade of loan:      	       B        |             G  ");
		System.out.println("Loan amount:   	      	   10000        |          1000");
		System.out.println("Revolve balance:      	   10000        |         10000");
		System.out.println("Term number (months):         30        |            60");
		System.out.println("Total payment:      	    5000        |           100");
		System.out.println("-------------------------------------------------------------");
		System.out.println("Default probability:   6.06528E-06      |    0.913190782");
	}

}
