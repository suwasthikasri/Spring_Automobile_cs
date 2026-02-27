package com.hexaware.spring_automobile.entity;

import java.time.LocalDateTime;

public class EmailNotification {
	private Long notificationId;
	private PolicyProposal proposal;
	private User user;
	private EmailType emailType;
	private String recipientEmail;
	private String subject;
	private Status status;
	private LocalDateTime sentAt;
	private LocalDateTime createdAt;
	
	
	
	public EmailNotification(Long notificationId, PolicyProposal proposal, User user, EmailType emailType,
			String recipientEmail, String subject, Status status, LocalDateTime sentAt, LocalDateTime createdAt) {
		super();
		this.notificationId = notificationId;
		this.proposal = proposal;
		this.user = user;
		this.emailType = emailType;
		this.recipientEmail = recipientEmail;
		this.subject = subject;
		this.status = status;
		this.sentAt = sentAt;
		this.createdAt = createdAt;
	}
	@Override
	public String toString() {
		return "EmailNotification [notificationId=" + notificationId + ", proposal=" + proposal + ", user=" + user
				+ ", recipientEmail=" + recipientEmail + ", subject=" + subject + "]";
	}
	public Long getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}
	public PolicyProposal getProposal() {
		return proposal;
	}
	public void setProposal(PolicyProposal proposal) {
		this.proposal = proposal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public EmailType getEmailType() {
		return emailType;
	}
	public void setEmailType(EmailType emailType) {
		this.emailType = emailType;
	}
	public String getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public LocalDateTime getSentAt() {
		return sentAt;
	}
	public void setSentAt(LocalDateTime sentAt) {
		this.sentAt = sentAt;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public enum EmailType {
        QUOTE_SENT,
        POLICY_ISSUED,
        PREMIUM_REMINDER,
        ADDITIONAL_INFO_REQUEST,
        STATUS_UPDATE
    }

    public enum Status {
        SENT,
        FAILED,
        PENDING
    }
	
	
}
