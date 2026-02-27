package com.hexaware.spring_automobile.service.interfacem;

public interface IEmailNotificationService 
{
	int sendQuoteEmail(Long proposalId);

    int sendPremiumReminder(Long proposalId);

    int sendClaimStatusEmail(Long claimId);
}
