package ar.com.tvillanueva.helper;

import java.time.LocalDate;
import java.util.List;

import ar.com.tvillanueva.dto.MonthlyPaymentDTO;

public class AmortizationCalculusHelper {

	public static Double calculateBasicPaymentForLoanTermAndR(Double loan, Integer term, Double r) {
		Double tmpCalc1 = Math.pow(1 + r, term);
		return loan * r * tmpCalc1 / (tmpCalc1 - 1);
	}

	public static Double getRForInterest(Double interest) {
		return interest / 100 / 12;
	}

	public static Double processPeriodAndGetRemainingPrincipal(Double interest, Double loan, Integer term,
			Integer interestTerm, List<MonthlyPaymentDTO> monthlyPayments, LocalDate date) {
		Double remainingPrincipal = loan;
		Double r = AmortizationCalculusHelper.getRForInterest(interest);
		Double basicPaymentFirstPeriod = AmortizationCalculusHelper.calculateBasicPaymentForLoanTermAndR(loan, term, r);
		for (int i = 0; i < interestTerm; i++) {
			Double tmpInterest = remainingPrincipal * r;
			Double principal = basicPaymentFirstPeriod - tmpInterest;
			MonthlyPaymentDTO monthlyPayment = new MonthlyPaymentDTO(date, basicPaymentFirstPeriod,
					principal, tmpInterest, remainingPrincipal);
			remainingPrincipal -= principal;
			date = date.plusMonths(1);
			monthlyPayments.add(monthlyPayment);
		}
		return remainingPrincipal;
	}
}
