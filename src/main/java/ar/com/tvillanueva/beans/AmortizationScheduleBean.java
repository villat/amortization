package ar.com.tvillanueva.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ar.com.tvillanueva.dto.LoanInformationDTO;
import ar.com.tvillanueva.dto.MonthlyPaymentDTO;
import ar.com.tvillanueva.helper.BeanValidatorHelper;
import ar.com.tvillanueva.service.IAmortizationCalculatorService;

@Named(value = "amortizationScheduleBean")
@ViewScoped
public class AmortizationScheduleBean implements Serializable {

	private static final long serialVersionUID = -1174613579018748220L;
	
	@Inject
	private IAmortizationCalculatorService amortizationCalcService;
	
	private LoanInformationDTO loanInformation;
	private List<MonthlyPaymentDTO> monthlyPayments;
	
	@PostConstruct
	public void init() {
		loanInformation = new LoanInformationDTO();
	}
	
	public void calculateAmortization() {
		List<String> errors = BeanValidatorHelper.validateLoanInformationDTO(loanInformation);
		if (errors.isEmpty()) {
			monthlyPayments = amortizationCalcService.getMonthlyPaymentsForLoan(loanInformation);
		} else {
			showErrors(errors);
		}		
	}
	
	private void showErrors(List<String> errors) {
		for (String error : errors) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, error, BeanValidatorHelper.EMPTY));
		}
	}

	public LoanInformationDTO getLoanInformation() {
		return loanInformation;
	}

	public void setLoanInformation(LoanInformationDTO loanInformation) {
		this.loanInformation = loanInformation;
	}

	public List<MonthlyPaymentDTO> getMonthlyPayments() {
		return monthlyPayments;
	}

	public void setMonthlyPayments(List<MonthlyPaymentDTO> monthlyPayments) {
		this.monthlyPayments = monthlyPayments;
	}

}
