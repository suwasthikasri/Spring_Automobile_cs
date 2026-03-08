package com.hexaware.spring_automobile.service.implementation;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.spring_automobile.entity.PolicyProposalEntity;
import com.hexaware.spring_automobile.entity.PolicyProposalEntity.Status;
import com.hexaware.spring_automobile.exception.ResourceNotFoundException;
import com.hexaware.spring_automobile.pojo.PolicyProposal;
import com.hexaware.spring_automobile.repository.PolicyProposalRepository;
import com.hexaware.spring_automobile.service.interfaces.IPolicyProposalService;
import com.hexaware.spring_automobile.util.PremiumCalculator;
@Service
public class PolicyProposalServiceImpl implements IPolicyProposalService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyProposalServiceImpl.class);

    @Autowired
    private PolicyProposalRepository proposalRepository;

    @Override
    public int createProposal(PolicyProposal proposal) {

        logger.info("Creating policy proposal for vehicle: {} {}", 
                    proposal.getVehicleMake(), proposal.getVehicleModel());

        PolicyProposalEntity entity = new PolicyProposalEntity();

        entity.setVehicleMake(proposal.getVehicleMake());
        entity.setVehicleModel(proposal.getVehicleModel());
        entity.setVehicleYear(proposal.getVehicleYear());
        entity.setRegistrationNumber(proposal.getRegistrationNumber());
        entity.setVehicleValue(proposal.getVehicleValue());

        double premium = PremiumCalculator.calculateBasePremium(proposal.getVehicleValue());

        logger.info("Calculated premium amount: {}", premium);

        entity.setQuoteAmount(premium);

        proposalRepository.save(entity);

        logger.info("Policy proposal created successfully");

        return 1;
    }

    @Override
    public PolicyProposalEntity getProposalById(Long proposalId) {

        logger.info("Fetching proposal with id: {}", proposalId);

        return proposalRepository.findById(proposalId)
                .orElseThrow(() -> {
                    logger.error("Proposal not found with id {}", proposalId);
                    return new ResourceNotFoundException("Proposal not found");
                });
    }

    @Override
    public List<PolicyProposalEntity> getProposalsByUser(Long userId) {

        logger.info("Fetching proposals for user id: {}", userId);

        return proposalRepository.findByUserId(userId);
    }

    @Override
    public int approveProposal(Long proposalId) {

        logger.info("Approving proposal with id: {}", proposalId);

        PolicyProposalEntity entity = getProposalById(proposalId);

        entity.setStatus(Status.GENERATED);

        proposalRepository.save(entity);

        logger.info("Proposal approved successfully");

        return 1;
    }

    @Override
    public int rejectProposal(Long proposalId) {

        logger.warn("Rejecting proposal with id: {}", proposalId);

        PolicyProposalEntity entity = getProposalById(proposalId);

        entity.setStatus(Status.DOWNLOADED);

        proposalRepository.save(entity);

        logger.info("Proposal rejected successfully");

        return 1;
    }

    @Override
    public List<PolicyProposalEntity> findProposalsByStatus(String status) {

        logger.info("Fetching proposals with status: {}", status);

        return proposalRepository.findProposalsByStatus(status);
    }

    @Override
    public List<PolicyProposalEntity> getAllProposals() {

        logger.info("Fetching all policy proposals");

        return proposalRepository.findAll();
    }

    @Override
    public int updateProposalStatus(Long proposalId, String status) {

        logger.info("Updating proposal status for id {} to {}", proposalId, status);

        PolicyProposalEntity proposal = proposalRepository.findById(proposalId)
                .orElseThrow(() -> {
                    logger.error("Proposal not found with id {}", proposalId);
                    return new RuntimeException("Proposal not found");
                });

        proposal.setStatus(Status.valueOf(status));

        proposalRepository.save(proposal);

        logger.info("Proposal status updated successfully");

        return 1;
    }
}