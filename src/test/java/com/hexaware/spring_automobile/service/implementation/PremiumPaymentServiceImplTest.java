package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.PremiumPaymentEntity;
import com.hexaware.spring_automobile.pojo.PremiumPayment;
import com.hexaware.spring_automobile.repository.PremiumPaymentRepository;

@ExtendWith(MockitoExtension.class)
class PremiumPaymentServiceImplTest {

    @Mock
    private PremiumPaymentRepository paymentRepository;

    @InjectMocks
    private PremiumPaymentServiceImpl paymentService;

    @Test
    void testMakePayment() {

        PremiumPayment payment = new PremiumPayment();
        payment.setAmount(5000.0);
        payment.setTransactionId("TXN123");

        int result = paymentService.makePayment(payment);

        assertEquals(1, result);

        verify(paymentRepository, times(1))
                .save(any(PremiumPaymentEntity.class));
    }

    @Test
    void testGetPaymentByProposal() {

        PremiumPaymentEntity entity = new PremiumPaymentEntity();
        entity.setPaymentId(1L);

        when(paymentRepository.findByProposalId(1L)).thenReturn(entity);

        PremiumPaymentEntity result = paymentService.getPaymentByProposal(1L);

        assertEquals(1L, result.getPaymentId());
    }

    @Test
    void testGetAllPayments() {

        PremiumPaymentEntity p1 = new PremiumPaymentEntity();
        PremiumPaymentEntity p2 = new PremiumPaymentEntity();

        when(paymentRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<PremiumPaymentEntity> result = paymentService.getAllPayments();

        assertEquals(2, result.size());
    }

    @Test
    void testFindPaymentsByStatus() {

        PremiumPaymentEntity p1 = new PremiumPaymentEntity();
        PremiumPaymentEntity p2 = new PremiumPaymentEntity();

        when(paymentRepository.findPaymentsByStatus("COMPLETED"))
                .thenReturn(Arrays.asList(p1, p2));

        List<PremiumPaymentEntity> result = paymentService.findPaymentsByStatus("COMPLETED");

        assertEquals(2, result.size());
    }
}