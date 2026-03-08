package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.ClaimEntity;
import com.hexaware.spring_automobile.entity.ClaimEntity.ClaimStatus;
import com.hexaware.spring_automobile.pojo.Claim;
import com.hexaware.spring_automobile.repository.ClaimRepository;

@ExtendWith(MockitoExtension.class)
class ClaimServiceImplTest {

    @Mock
    private ClaimRepository claimRepository;

    @InjectMocks
    private ClaimServiceImpl claimService;

    @Test
    void testFileClaim() {

        Claim claim = new Claim();
        claim.setClaimReference("REF123");
        claim.setClaimReason("Accident");
        claim.setClaimAmount(new BigDecimal("5000"));

        int result = claimService.fileClaim(claim);

        assertEquals(1, result);

        verify(claimRepository, times(1)).save(any(ClaimEntity.class));
    }

    @Test
    void testGetClaimById() {

        ClaimEntity claim = new ClaimEntity();
        claim.setClaimId(1L);

        when(claimRepository.findById(1L)).thenReturn(Optional.of(claim));

        ClaimEntity result = claimService.getClaimById(1L);

        assertEquals(1L, result.getClaimId());
    }

    @Test
    void testApproveClaim() {

        ClaimEntity claim = new ClaimEntity();
        claim.setClaimId(1L);

        when(claimRepository.findById(1L)).thenReturn(Optional.of(claim));

        int result = claimService.approveClaim(1L);

        assertEquals(1, result);
        assertEquals(ClaimStatus.APPROVED, claim.getClaimStatus());
    }

    @Test
    void testRejectClaim() {

        ClaimEntity claim = new ClaimEntity();
        claim.setClaimId(1L);

        when(claimRepository.findById(1L)).thenReturn(Optional.of(claim));

        int result = claimService.rejectClaim(1L);

        assertEquals(1, result);
        assertEquals(ClaimStatus.REJECTED, claim.getClaimStatus());
    }

    @Test
    void testProcessClaimPayment() {

        ClaimEntity claim = new ClaimEntity();
        claim.setClaimId(1L);

        when(claimRepository.findById(1L)).thenReturn(Optional.of(claim));

        int result = claimService.processClaimPayment(1L);

        assertEquals(1, result);
        assertEquals(ClaimStatus.PAID, claim.getClaimStatus());
    }

    @Test
    void testGetAllClaims() {

        ClaimEntity claim1 = new ClaimEntity();
        ClaimEntity claim2 = new ClaimEntity();

        when(claimRepository.findAll()).thenReturn(Arrays.asList(claim1, claim2));

        List<ClaimEntity> result = claimService.getAllClaims();

        assertEquals(2, result.size());
    }

}