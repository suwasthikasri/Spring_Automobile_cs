package com.hexaware.spring_automobile.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
public class Claim 
{
	private Long claimId;
	
	@NotNull(message = "Proposal must be provided")
    private PolicyProposal proposal;

    @NotBlank(message = "Claim reference cannot be empty")
    @Size(min = 5, max = 50, message = "Claim reference must be between 5 and 50 characters")
    private String claimReference;

    @NotBlank(message = "Claim reason cannot be empty")
    @Size(min = 5, max = 200, message = "Claim reason must be between 5 and 200 characters")
    private String claimReason;

    @NotNull(message = "Claim amount is required")
    @Positive(message = "Claim amount must be greater than zero")
    private BigDecimal claimAmount;
	private ClaimStatus claimStatus;
	private String officerComments;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	 public Claim () {}
	
	
	
	
	
	
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
