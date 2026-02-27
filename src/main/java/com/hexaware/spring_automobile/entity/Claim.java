package com.hexaware.spring_automobile.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Claim 
{
	private Long claimId;
	private PolicyProposal proposal;
	private String claimReference;
	private String claimReason;
	private BigDecimal claimAmount;
	private ClaimStatus claimStatus;
	private String officerComments;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	Claim () {}
	
	
	
	
	
	
	public Claim(Long claimId, PolicyProposal proposal, String claimReference, String claimReason,
			BigDecimal claimAmount, ClaimStatus claimStatus, String officerComments, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.claimId = claimId;
		this.proposal = proposal;
		this.claimReference = claimReference;
		this.claimReason = claimReason;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
		this.officerComments = officerComments;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}






	public Long getClaimId() {
		return claimId;
	}






	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}






	public PolicyProposal getProposal() {
		return proposal;
	}






	public void setProposal(PolicyProposal proposal) {
		this.proposal = proposal;
	}






	public String getClaimReference() {
		return claimReference;
	}






	public void setClaimReference(String claimReference) {
		this.claimReference = claimReference;
	}






	public String getClaimReason() {
		return claimReason;
	}






	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}






	public BigDecimal getClaimAmount() {
		return claimAmount;
	}






	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}






	public ClaimStatus getClaimStatus() {
		return claimStatus;
	}






	public void setClaimStatus(ClaimStatus claimStatus) {
		this.claimStatus = claimStatus;
	}






	public String getOfficerComments() {
		return officerComments;
	}






	public void setOfficerComments(String officerComments) {
		this.officerComments = officerComments;
	}






	public LocalDateTime getCreatedAt() {
		return createdAt;
	}






	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}






	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}






	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}






	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", proposal=" + proposal + ", claimReference=" + claimReference
				+ ", claimReason=" + claimReason + ", claimAmount=" + claimAmount + ", claimStatus=" + claimStatus
				+ ", officerComments=" + officerComments + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ "]";
	}






	public enum ClaimStatus {

	    INITIATED,
	    UNDER_REVIEW,
	    APPROVED,
	    REJECTED,
	    PAID
	}
	
}
