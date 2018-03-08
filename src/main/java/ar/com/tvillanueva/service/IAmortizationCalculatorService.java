package ar.com.tvillanueva.service;

import java.util.List;

import ar.com.tvillanueva.dto.LoanInformationDTO;
import ar.com.tvillanueva.dto.MonthlyPaymentDTO;

public interface IAmortizationCalculatorService {
	
	public List<MonthlyPaymentDTO> getMonthlyPaymentsForLoan(LoanInformationDTO loanInformation);

}
