package ar.com.tvillanueva.dto;

public class LoanInformationDTO {
	
	private Double loan;
	//In months
	private Integer term;
	//Number of months with firstInterest. (term - firsInterestTerm) is applied to secondInterest  
	private Integer firstInterestTerm;
	private Double firstInterest;
	private Double secondInterest;
	
	public LoanInformationDTO() {

	}
	
	public Double getLoan() {
		return loan;
	}
	public void setLoan(Double loan) {
		this.loan = loan;
	}
	public Integer getTerm() {
		return term;
	}
	public void setTerm(Integer term) {
		this.term = term;
	}
	public Integer getFirstInterestTerm() {
		return firstInterestTerm;
	}
	public void setFirstInterestTerm(Integer firstInterestTerm) {
		this.firstInterestTerm = firstInterestTerm;
	}
	public Double getFirstInterest() {
		return firstInterest;
	}
	public void setFirstInterest(Double firstInterest) {
		this.firstInterest = firstInterest;
	}
	public Double getSecondInterest() {
		return secondInterest;
	}
	public void setSecondInterest(Double secondInterest) {
		this.secondInterest = secondInterest;
	}
	
	

}
