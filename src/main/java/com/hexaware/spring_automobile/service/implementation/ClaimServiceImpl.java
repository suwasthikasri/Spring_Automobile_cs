package com.hexaware.spring_automobile.service.implementation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.spring_automobile.entity.ClaimEntity;
import com.hexaware.spring_automobile.entity.ClaimEntity.ClaimStatus;
import com.hexaware.spring_automobile.exception.ResourceNotFoundException;
import com.hexaware.spring_automobile.pojo.Claim;
import com.hexaware.spring_automobile.repository.ClaimRepository;
import com.hexaware.spring_automobile.service.interfaces.IClaimService;
@Service
public class ClaimServiceImpl implements IClaimService {

    private static final Logger logger = LoggerFactory.getLogger(ClaimServiceImpl.class);

    @Autowired
    private ClaimRepository claimRepository;

    @Override
    public int fileClaim(Claim claim) {

        logger.info("Filing new claim with reference: {}", claim.getClaimReference());

        ClaimEntity entity = new ClaimEntity();

        entity.setClaimReference(claim.getClaimReference());
        entity.setClaimReason(claim.getClaimReason());
        entity.setClaimAmount(claim.getClaimAmount());
        entity.setClaimStatus(ClaimStatus.INITIATED);
        entity.setCreatedAt(LocalDateTime.now());

        claimRepository.save(entity);

        logger.info("Claim filed successfully");

        return 1;
    }

    @Override
    public ClaimEntity getClaimById(Long claimId) {

        logger.info("Fetching claim with id: {}", claimId);

        return claimRepository.findById(claimId)
                .orElseThrow(() -> {
                    logger.error("Claim not found with id {}", claimId);
                    return new ResourceNotFoundException("Claim not found");
                });
    }

    @Override
    public int approveClaim(Long claimId) {

        logger.info("Approving claim with id {}", claimId);

        ClaimEntity entity = getClaimById(claimId);

        entity.setClaimStatus(ClaimStatus.APPROVED);

        claimRepository.save(entity);

        logger.info("Claim approved successfully");

        return 1;
    }

    @Override
    public int rejectClaim(Long claimId) {

        logger.warn("Rejecting claim with id {}", claimId);

        ClaimEntity entity = getClaimById(claimId);

        entity.setClaimStatus(ClaimStatus.REJECTED);

        claimRepository.save(entity);

        logger.info("Claim rejected successfully");

        return 1;
    }

    @Override
    public int processClaimPayment(Long claimId) {

        logger.info("Processing payment for claim id {}", claimId);

        ClaimEntity claim = claimRepository.findById(claimId)
                .orElseThrow(() -> {
                    logger.error("Claim not found for payment with id {}", claimId);
                    return new ResourceNotFoundException("Claim not found");
                });

        claim.setClaimStatus(ClaimStatus.PAID);

        claimRepository.save(claim);

        logger.info("Claim payment processed successfully");

        return 1;
    }

    @Override
    public List<ClaimEntity> getAllClaims() {

        logger.info("Fetching all claims");

        return claimRepository.findAll();
    }

    @Override
    public List<ClaimEntity> getClaimsByUser(Long userId) {

        logger.info("Fetching claims for user id {}", userId);

        return claimRepository.findClaimsByUser(userId);
    }

    @Override
    public List<ClaimEntity> findClaimsByStatus(String status) {

        logger.info("Fetching claims with status {}", status);

        return claimRepository.findClaimsByStatus(status);
    }
}