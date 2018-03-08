package ar.com.tvillanueva.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import ar.com.tvillanueva.dto.LoanInformationDTO;
import ar.com.tvillanueva.dto.MonthlyPaymentDTO;
import ar.com.tvillanueva.helper.AmortizationCalculusHelper;

@Stateless
public class AmortizationCalculatorServiceImpl implements IAmortizationCalculatorService {

	@Override
	public List<MonthlyPaymentDTO> getMonthlyPaymentsForLoan(LoanInformationDTO loanInformation) {
		List<MonthlyPaymentDTO> result = new ArrayList<>();
		Double remainingPrincipal = loanInformation.getLoan();

		// First period
		LocalDate firstPeriodFirstDate = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue() + 1, 1);
		remainingPrincipal = AmortizationCalculusHelper.processPeriodAndGetRemainingPrincipal(
				loanInformation.getFirstInterest(), loanInformation.getLoan(), loanInformation.getTerm(),
				loanInformation.getFirstInterestTerm(), result, firstPeriodFirstDate);
		// Second period (not always)
		if (loanInformation.getSecondInterest() != null) {
			LocalDate secondPeriodFirstDate = firstPeriodFirstDate.plusMonths(loanInformation.getFirstInterestTerm());
			Integer interest2Term = loanInformation.getTerm() - loanInformation.getFirstInterestTerm();
			AmortizationCalculusHelper.processPeriodAndGetRemainingPrincipal(loanInformation.getSecondInterest(),
					remainingPrincipal, interest2Term, interest2Term, result, secondPeriodFirstDate);
		}

		return result;
	}

}
