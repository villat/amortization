package ar.com.tvillanueva.api;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.tvillanueva.dto.LoanInformationDTO;
import ar.com.tvillanueva.dto.MonthlyPaymentDTO;
import ar.com.tvillanueva.helper.BeanValidatorHelper;
import ar.com.tvillanueva.service.IAmortizationCalculatorService;

@Path("/calculator")
public class AmortizationScheduleRS {

	@Inject
	private IAmortizationCalculatorService amortizationCalcService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<MonthlyPaymentDTO> calculateAmortization(LoanInformationDTO loanInformation) {

		List<String> errors = BeanValidatorHelper.validateLoanInformationDTO(loanInformation);
		if (errors.isEmpty()) {
			return amortizationCalcService.getMonthlyPaymentsForLoan(loanInformation);
		} 	
		//Incorrect parameters
		return null;
	}
	
	//JSON to test the POST method
	@GET
	@Path("/mock")
	@Produces(MediaType.APPLICATION_JSON)
	public LoanInformationDTO getLoan() {

		LoanInformationDTO loan = new LoanInformationDTO();
		loan.setLoan(new Double(100000));
		loan.setTerm(24);
		loan.setFirstInterestTerm(12);
		loan.setFirstInterest(new Double(12));
		loan.setSecondInterest(new Double(10));
		
		return loan;
	}
	
}
