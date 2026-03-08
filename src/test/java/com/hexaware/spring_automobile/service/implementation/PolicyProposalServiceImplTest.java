package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.PolicyProposalEntity;
import com.hexaware.spring_automobile.entity.PolicyProposalEntity.Status;
import com.hexaware.spring_automobile.pojo.PolicyProposal;
import com.hexaware.spring_automobile.repository.PolicyProposalRepository;

@ExtendWith(MockitoExtension.class)
class PolicyProposalServiceImplTest {

    @Mock
    private PolicyProposalRepository proposalRepository;

    @InjectMocks
    private PolicyProposalServiceImpl proposalService;

    @Test
    void testCreateProposal() {

        PolicyProposal proposal = new PolicyProposal();
        proposal.setVehicleMake("Toyota");
        proposal.setVehicleModel("Innova");
        proposal.setVehicleYear(2023);
        proposal.setRegistrationNumber("TN01AB1234");
        proposal.setVehicleValue(500000.0);

        int result = proposalService.createProposal(proposal);

        assertEquals(1, result);

        verify(proposalRepository, times(1))
                .save(any(PolicyProposalEntity.class));
    }

    @Test
    void testGetProposalById() {

        PolicyProposalEntity entity = new PolicyProposalEntity();
        entity.setProposalId(1L);

        when(proposalRepository.findById(1L)).thenReturn(Optional.of(entity));

        PolicyProposalEntity result = proposalService.getProposalById(1L);

        assertEquals(1L, result.getProposalId());
    }

    @Test
    void testApproveProposal() {

        PolicyProposalEntity entity = new PolicyProposalEntity();
        entity.setProposalId(1L);

        when(proposalRepository.findById(1L)).thenReturn(Optional.of(entity));

        int result = proposalService.approveProposal(1L);

        assertEquals(1, result);
        assertEquals(Status.GENERATED, entity.getStatus());
    }

    @Test
    void testRejectProposal() {

        PolicyProposalEntity entity = new PolicyProposalEntity();
        entity.setProposalId(1L);

        when(proposalRepository.findById(1L)).thenReturn(Optional.of(entity));

        int result = proposalService.rejectProposal(1L);

        assertEquals(1, result);
        assertEquals(Status.DOWNLOADED, entity.getStatus());
    }

    @Test
    void testGetAllProposals() {

        PolicyProposalEntity p1 = new PolicyProposalEntity();
        PolicyProposalEntity p2 = new PolicyProposalEntity();

        when(proposalRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<PolicyProposalEntity> result = proposalService.getAllProposals();

        assertEquals(2, result.size());
    }

}