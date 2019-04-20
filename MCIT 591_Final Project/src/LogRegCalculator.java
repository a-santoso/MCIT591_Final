/**
 * Logistic Regression Calculator class that contains logistic regression coefficients and calculation
 * to predict output based on loan input
 *
 */

import java.lang.*;

public class LogRegCalculator {

	// Instance variables
	private double coef_constant;
	private double coef_annual_income;
	private double coef_dti;
	private double coef_funded_amount;
	private double coef_grade_enc;
	private double coef_int_rate;
	private double coef_issue_d;
	private double coef_loan_amount;
	private double coef_revol_balance;
	private double coef_term_num;
	private double coef_total_payment;

	/**
	 * Constructor for Logistic Regression Calculator
	 * @param coef_constant
	 * @param coef_annual_income
	 * @param coef_dti
	 * @param coef_funded_amount
	 * @param coef_grade_enc
	 * @param coef_int_rate
	 * @param coef_issue_d
	 * @param coef_loan_amount
	 * @param coef_revol_balance
	 * @param coef_term_num
	 * @param coef_total_payment
	 */
	public LogRegCalculator(double coef_constant, double coef_annual_income, double coef_dti, double coef_funded_amount,
			double coef_grade_enc, double coef_int_rate, double coef_issue_d, double coef_loan_amount,
			double coef_revol_balance, double coef_term_num, double coef_total_payment) {
		this.coef_constant = coef_constant;
		this.coef_annual_income = coef_annual_income;
		this.coef_dti = coef_dti;
		this.coef_funded_amount = coef_funded_amount;
		this.coef_grade_enc = coef_grade_enc;
		this.coef_int_rate = coef_int_rate;
		this.coef_issue_d = coef_issue_d;
		this.coef_loan_amount = coef_loan_amount;
		this.coef_revol_balance = coef_revol_balance;
		this.coef_term_num = coef_term_num;
		this.coef_total_payment = coef_total_payment;
	}
	
	/**
	 * Return odds of default based on loan input
	 * Calculate the odds of default based on loan input parameters
	 * @param loanInput
	 * @return
	 */
	public double predictDefault(Loan loanInput) {
		double prob = coef_constant +
				loanInput.getAnnual_income() * coef_annual_income +
				loanInput.getDti() * coef_dti +
				loanInput.getFunded_amount() * coef_funded_amount +
				loanInput.getGrade() * coef_grade_enc + 
				loanInput.getRate() * coef_int_rate +
				loanInput.getIssueDate() * coef_issue_d +
				loanInput.getLoan_amount() * coef_loan_amount +
				loanInput.getRevol_balance() * coef_revol_balance +
				loanInput.getTerm_number() * coef_term_num +
				loanInput.getTotal_payment() * coef_total_payment;
		
		// Calculate probability based on exponential sum of all coefficients and parameters
		return Math.exp(prob);
	
				
	}

	public void setCoef_constant(double coef_constant) {
		this.coef_constant = coef_constant;
	}

	public void setCoef_annual_income(double coef_annual_income) {
		this.coef_annual_income = coef_annual_income;
	}

	public void setCoef_dti(double coef_dti) {
		this.coef_dti = coef_dti;
	}

	public void setCoef_funded_amount(double coef_funded_amount) {
		this.coef_funded_amount = coef_funded_amount;
	}

	public void setCoef_grade_enc(double coef_grade_enc) {
		this.coef_grade_enc = coef_grade_enc;
	}

	public void setCoef_int_rate(double coef_int_rate) {
		this.coef_int_rate = coef_int_rate;
	}

	public void setCoef_issue_d(double coef_issue_d) {
		this.coef_issue_d = coef_issue_d;
	}

	public void setCoef_loan_amount(double coef_loan_amount) {
		this.coef_loan_amount = coef_loan_amount;
	}

	public void setCoef_revol_balance(double coef_revol_balance) {
		this.coef_revol_balance = coef_revol_balance;
	}

	public void setCoef_term_num(double coef_term_num) {
		this.coef_term_num = coef_term_num;
	}

	public void setCoef_total_payment(double coef_total_payment) {
		this.coef_total_payment = coef_total_payment;
	}
	
	

}
