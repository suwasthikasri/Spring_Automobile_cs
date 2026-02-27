package com.hexaware.spring_automobile.service.interfacem;

import java.util.List;


 import com.hexaware.spring_automobile.entity.PremiumPayment;
public interface IPremiumPaymentService 
{
	int makePayment(PremiumPayment payment);

    PremiumPayment getPaymentById(Long paymentId);

    List<PremiumPayment> getPaymentsByProposal(Long proposalId);

    int verifyPayment(Long paymentId);

}
