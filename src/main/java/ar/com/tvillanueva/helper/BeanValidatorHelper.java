package ar.com.tvillanueva.helper;

import java.util.ArrayList;
import java.util.List;

import ar.com.tvillanueva.dto.LoanInformationDTO;

public class BeanValidatorHelper {

	private static final String LOAN_REQUIRED = "Loan amount is required.";
	private static final String TERM_REQUIRED = "Term is required.";
	private static final String FIRST_INTEREST_TERM_REQUIRED = "First interest term is required.";
	private static final String FIRST_INTEREST_TERM_LIMIT = "First interest term cannot be greater than term.";
	private static final String SECOND_INTEREST_REQUIRED = "Second interest is required for the entered terms.";
	private static final String FIRST_INTEREST_REQUIRED = "First interest is required.";
	public static final String EMPTY = "";
	
	public static List<String> validateLoanInformationDTO(LoanInformationDTO loanInformation){
		List<String> errors = new ArrayList<>();
		
		if (loanInformation.getLoan() == null) {
			errors.add(LOAN_REQUIRED);
		}
		
		if (loanInformation.getTerm() == null) {
			errors.add(TERM_REQUIRED);
		}
		
		if (loanInformation.getFirstInterestTerm() == null) {
			errors.add(FIRST_INTEREST_TERM_REQUIRED);
		} else if (loanInformation.getTerm() != null) {
			if (loanInformation.getFirstInterestTerm() > loanInformation.getTerm()) {
				errors.add(FIRST_INTEREST_TERM_LIMIT);
			} else if (loanInformation.getFirstInterestTerm() < loanInformation.getTerm() && loanInformation.getSecondInterest() == null) {
				errors.add(SECOND_INTEREST_REQUIRED);
			}
		}
		
		if (loanInformation.getFirstInterest() == null) {
			errors.add(FIRST_INTEREST_REQUIRED);
		}

		return errors;
	}
	
}
