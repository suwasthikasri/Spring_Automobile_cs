package com.hexaware.spring_automobile.service.implementation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.spring_automobile.entity.PremiumPaymentEntity;
import com.hexaware.spring_automobile.pojo.PremiumPayment;
import com.hexaware.spring_automobile.repository.PremiumPaymentRepository;
import com.hexaware.spring_automobile.service.interfaces.IPremiumPaymentService;
@Service
public class PremiumPaymentServiceImpl implements IPremiumPaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PremiumPaymentServiceImpl.class);

    @Autowired
    private PremiumPaymentRepository paymentRepository;

    @Override
    public int makePayment(PremiumPayment payment) {

        logger.info("Processing premium payment with transaction ID: {}", payment.getTransactionId());

        PremiumPaymentEntity entity = new PremiumPaymentEntity();

        entity.setAmount(payment.getAmount());
        entity.setTransactionId(payment.getTransactionId());

        paymentRepository.save(entity);

        logger.info("Payment saved successfully for transaction ID: {}", payment.getTransactionId());

        return 1;
    }

    @Override
    public PremiumPaymentEntity getPaymentByProposal(Long proposalId) {

        logger.info("Fetching payment for proposal ID: {}", proposalId);

        return paymentRepository.findByProposalId(proposalId);
    }

    @Override
    public List<PremiumPaymentEntity> getAllPayments() {

        logger.info("Fetching all premium payments");

        return paymentRepository.findAll();
    }

    @Override
    public List<PremiumPaymentEntity> findPaymentsByStatus(String status) {

        logger.info("Fetching payments with status: {}", status);

        return paymentRepository.findPaymentsByStatus(status);
    }
}