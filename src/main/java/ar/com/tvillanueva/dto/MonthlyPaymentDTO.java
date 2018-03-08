package ar.com.tvillanueva.dto;

import java.time.LocalDate;

public class MonthlyPaymentDTO {
	
	private LocalDate paymentDate;
	private Double payment;
	private Double principal;
	private Double interest;
	private Double remainingPrincipal;
	
	public MonthlyPaymentDTO() {
	
	}
	
	public MonthlyPaymentDTO(LocalDate paymentDate, Double payment, Double principal, Double interest,
			Double remainingPrincipal) {
		this.paymentDate = paymentDate;
		this.payment = payment;
		this.principal = principal;
		this.interest = interest;
		this.remainingPrincipal = remainingPrincipal;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public Double getPayment() {
		return payment;
	}
	public void setPayment(Double payment) {
		this.payment = payment;
	}
	public Double getPrincipal() {
		return principal;
	}
	public void setPrincipal(Double principal) {
		this.principal = principal;
	}
	public Double getInterest() {
		return interest;
	}
	public void setInterest(Double interest) {
		this.interest = interest;
	}
	public Double getRemainingPrincipal() {
		return remainingPrincipal;
	}
	public void setRemainingPrincipal(Double remainingPrincipal) {
		this.remainingPrincipal = remainingPrincipal;
	}
	
	

}
