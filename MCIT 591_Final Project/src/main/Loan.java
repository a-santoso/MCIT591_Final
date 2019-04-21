package main;
/**
 * Loan class that contains all information about loan and borrower in instance variables:
 * annual_income, term_number, loan_amount, etc
 *
 */
public class Loan {
	
	// Instance variables
	private double annual_income;
	private double dti;
	private double funded_amount;
	private int grade;
	private double rate;

	private int issueDate;
	private double loan_amount;
	private double revol_balance;
	private int term_number;
	private double total_payment;
	
	/**
	 * Constructor for loan - empty
	 */
	public Loan() {
		
	}
	
	/**
	 * Constructor for loan - initialized
	 * @param annual_income
	 * @param dti
	 * @param funded_amount
	 * @param grade
	 * @param rate
	 * @param issueDate
	 * @param loan_amount
	 * @param revol_balance
	 * @param term_number
	 * @param total_payment
	 */
	public Loan(double annual_income, double dti, double funded_amount, int grade, double rate, 
			int issueDate, double loan_amount, double revol_balance, int term_number, double total_payment) {
		this.annual_income = annual_income;
		this.dti = dti;
		this.funded_amount = funded_amount;
		this.grade = grade;
		this.rate = rate;
		this.issueDate = issueDate;
		this.loan_amount = loan_amount;
		this.revol_balance = revol_balance;
		this.term_number = term_number;
		this.total_payment = total_payment;
	}

	public double getAnnual_income() {
		return annual_income;
	}

	public double getDti() {
		return dti;
	}

	public double getFunded_amount() {
		return funded_amount;
	}

	public int getGrade() {
		return grade;
	}

	public double getRate() {
		return rate;
	}


	public int getIssueDate() {
		return issueDate;
	}

	public double getLoan_amount() {
		return loan_amount;
	}

	public double getRevol_balance() {
		return revol_balance;
	}

	public int getTerm_number() {
		return term_number;
	}

	public double getTotal_payment() {
		return total_payment;
	}

	public void setAnnual_income(double annual_income) {
		this.annual_income = annual_income;
	}

	public void setDti(double dti) {
		this.dti = dti;
	}

	public void setFunded_amount(double funded_amount) {
		this.funded_amount = funded_amount;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setIssueDate(int issueDate) {
		this.issueDate = issueDate;
	}

	public void setLoan_amount(double loan_amount) {
		this.loan_amount = loan_amount;
	}

	public void setRevol_balance(double revol_balance) {
		this.revol_balance = revol_balance;
	}

	public void setTerm_number(int term_number) {
		this.term_number = term_number;
	}

	public void setTotal_payment(double total_payment) {
		this.total_payment = total_payment;
	}
	
	
	

}
