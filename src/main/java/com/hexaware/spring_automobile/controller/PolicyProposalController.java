package com.hexaware.spring_automobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hexaware.spring_automobile.entity.PolicyProposalEntity;
import com.hexaware.spring_automobile.pojo.PolicyProposal;
import com.hexaware.spring_automobile.service.interfaces.IPolicyProposalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/proposals")
public class PolicyProposalController {

    @Autowired
    private IPolicyProposalService proposalService;

    // USER creates proposal
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/create")
    public int createProposal(@Valid @RequestBody PolicyProposal proposal) {

        return proposalService.createProposal(proposal);
    }

    // USER and OFFICER can view proposal
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @GetMapping("/{proposalId}")
    public PolicyProposalEntity getProposalById(@PathVariable Long proposalId) {

        return proposalService.getProposalById(proposalId);
    }

    // USER and OFFICER can view proposals of a user
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @GetMapping("/user/{userId}")
    public List<PolicyProposalEntity> getProposalsByUser(@PathVariable Long userId) {

        return proposalService.getProposalsByUser(userId);
    }

    // Only OFFICER can view all proposals
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/all")
    public List<PolicyProposalEntity> getAllProposals() {

        return proposalService.getAllProposals();
    }

    // Only OFFICER can approve proposal
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/approve/{proposalId}")
    public int approveProposal(@PathVariable Long proposalId) {

        return proposalService.approveProposal(proposalId);
    }

    // Only OFFICER can reject proposal
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/reject/{proposalId}")
    public int rejectProposal(@PathVariable Long proposalId) {

        return proposalService.rejectProposal(proposalId);
    }

    // Only OFFICER can update proposal status
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/status/{proposalId}/{status}")
    public int updateProposalStatus(@PathVariable Long proposalId, @PathVariable String status) {

        return proposalService.updateProposalStatus(proposalId, status);
    }

    // Only OFFICER can filter proposals by status
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/status/{status}")
    public List<PolicyProposalEntity> findProposalsByStatus(@PathVariable String status) {

        return proposalService.findProposalsByStatus(status);
    }
}