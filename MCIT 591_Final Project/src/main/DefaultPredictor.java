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
		// Hard code the coefficients obtained from Python ML
		LogRegCalculator logRegCal = new LogRegCalculator(2.3119, 0.000004615, 0.00001077, -0.0015, 0.4291, 
				-0.2689, 0.0029, -0.0002, -0.00001734, 0.0212, 0.0016);
		
		// Create loan instance to test logistic regression calculator
		// Dummy loan - to be deleted
		Loan loan = new Loan(10000, 20, 5000, 1, 11, 21, 10000, 11000, 36, 6000);
		
		// Loan instance variable that feeds to logistic regression calculator
		// Parameters of this loan variable will be obtained from user prompts
		Loan loanInput = new Loan();
		
		System.out.println("-------------------------------");
		System.out.println("Loan Default Predictor Program");
		System.out.println("-------------------------------");
		
		System.out.println();
		
		System.out.println("This program will predict loan default rate based on logistic "
				+ "regression performed on LendingClub data");
		
	
		
		System.out.println("Please enter the following 10 user prompts so as to predict the default rate");
		
		System.out.println();
		System.out.println("GETTING USER INPUT ...");
		System.out.println();
		
		Scanner userInputScanner = new Scanner(System.in);
		boolean inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("1. Please fill annual income: ");
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
		while(!inputValidation) {
			try {
				System.out.println("2. Please fill dti: ");
				double input = userInputScanner.nextDouble();
				if(input >= 0) {
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
				System.out.println("3. Please fill funded amount: ");
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
				System.out.println("4. Please fill grade: ");
				int input = userInputScanner.nextInt();
				if(input >= 0) {
					loanInput.setGrade(input);
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
				System.out.println("5. Please fill interest rate: ");
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
		
		inputValidation = false;
		while(!inputValidation) {
			try {
				System.out.println("7. Please fill loan amount: ");
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
				System.out.println("8. Please fill revolve balance: ");
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
				System.out.println("9. Please fill term number: ");
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
				System.out.println("10. Please fill total payment: ");
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
		System.out.println("Default rate prediction: " + logRegCal.predictDefault(loanInput));
		
	
	}

}
