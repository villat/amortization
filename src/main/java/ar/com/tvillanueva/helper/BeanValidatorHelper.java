package ar.com.tvillanueva.helper;

import java.util.ArrayList;
import java.util.List;

import ar.com.tvillanueva.dto.LoanInformationDTO;

public class BeanValidatorHelper {

	private static final String LOAN_REQUIRED = "Loan amount is required.";
	private static final String LOAN_POSITIVE = "Loan amount must be greater than 0.";
	private static final String TERM_REQUIRED = "Term is required.";
	private static final String TERM_POSITIVE = "Term must be greater than 0.";
	private static final String FIRST_INTEREST_TERM_REQUIRED = "First interest term is required.";
	private static final String FIRST_INTEREST_TERM_POSITIVE = "First interest term must be greater than 0.";
	private static final String FIRST_INTEREST_TERM_LIMIT = "First interest term cannot be greater than term.";
	private static final String FIRST_INTEREST_REQUIRED = "First interest is required.";
	private static final String FIRST_INTEREST_POSITIVE = "First interest must be greater than 0.";
	private static final String SECOND_INTEREST_REQUIRED = "Second interest is required for the entered terms.";
	private static final String SECOND_INTEREST_POSITIVE = "Second interest must be greater than 0.";
	public static final String EMPTY = "";
	
	public static List<String> validateLoanInformationDTO(LoanInformationDTO loanInformation){
		List<String> errors = new ArrayList<>();
		
		if (loanInformation.getLoan() == null) {
			errors.add(LOAN_REQUIRED);
		} else if (loanInformation.getLoan() <= 0) {
			errors.add(LOAN_POSITIVE);
		}
		
		if (loanInformation.getTerm() == null) {
			errors.add(TERM_REQUIRED);
		} else if (loanInformation.getTerm() <= 0) {
			errors.add(TERM_POSITIVE);
		}
		
		if (loanInformation.getFirstInterestTerm() == null) {
			errors.add(FIRST_INTEREST_TERM_REQUIRED);
		} else if (loanInformation.getTerm() != null) {
			if (loanInformation.getFirstInterestTerm() > loanInformation.getTerm()) {
				errors.add(FIRST_INTEREST_TERM_LIMIT);
			} else if (loanInformation.getFirstInterestTerm() < loanInformation.getTerm() && loanInformation.getSecondInterest() == null) {
				errors.add(SECOND_INTEREST_REQUIRED);
			}  else if (loanInformation.getSecondInterest() != null && loanInformation.getSecondInterest() <= 0) {
				errors.add(SECOND_INTEREST_POSITIVE);
			}
		} else if (loanInformation.getFirstInterestTerm() <= 0) {
			errors.add(FIRST_INTEREST_TERM_POSITIVE);
		}
		
		if (loanInformation.getFirstInterest() == null) {
			errors.add(FIRST_INTEREST_REQUIRED);
		} else if (loanInformation.getFirstInterest() <= 0) {
			errors.add(FIRST_INTEREST_POSITIVE);
		}

		return errors;
	}
	
}
