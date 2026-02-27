package com.hexaware.spring_automobile.entity;

import java.time.LocalDateTime;

public class PremiumPayment {
	private Long paymentId;
	private PolicyProposal proposal;
	private String paymentReference;
	private Double amount;
	private PaymentStatus paymentStatus;
	private PaymentMethod paymentMethod;
	private String transactionId;
	private LocalDateTime paidAt;
	private LocalDateTime createdAt;
	public PremiumPayment(Long paymentId, PolicyProposal proposal, String paymentReference, Double amount,
			PaymentStatus paymentStatus, PaymentMethod paymentMethod, String transactionId, LocalDateTime paidAt,
			LocalDateTime createdAt) {
		super();
		this.paymentId = paymentId;
		this.proposal = proposal;
		this.paymentReference = paymentReference;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.paidAt = paidAt;
		this.createdAt = createdAt;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public PolicyProposal getProposal() {
		return proposal;
	}
	public void setProposal(PolicyProposal proposal) {
		this.proposal = proposal;
	}
	public String getPaymentReference() {
		return paymentReference;
	}
	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDateTime getPaidAt() {
		return paidAt;
	}
	public void setPaidAt(LocalDateTime paidAt) {
		this.paidAt = paidAt;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "PremiumPayment [paymentId=" + paymentId + ", proposal=" + proposal + ", paymentReference="
				+ paymentReference + ", amount=" + amount + ", transactionId=" + transactionId + "]";
	}
	public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED,
        REFUNDED
    }

    public enum PaymentMethod {
        CARD,
        UPI,
        NET_BANKING,
        WALLET
    }
	
	
}
