package com.hexaware.spring_automobile.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.hexaware.spring_automobile.entity.ClaimEntity;
import com.hexaware.spring_automobile.pojo.Claim;
import com.hexaware.spring_automobile.service.interfaces.IClaimService;

@RestController
@RequestMapping("/api/v1/claims")
public class ClaimController {

    @Autowired
    private IClaimService claimService;

    // USER files claim
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/file")
    public int fileClaim(@Valid @RequestBody Claim claim) {
        return claimService.fileClaim(claim);
    }

    // USER and OFFICER can view claim
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @GetMapping("/{claimId}")
    public ClaimEntity getClaimById(@PathVariable Long claimId) {
        return claimService.getClaimById(claimId);
    }

    // USER and OFFICER can view claims of a user
    @PreAuthorize("hasAnyRole('USER','OFFICER')")
    @GetMapping("/user/{userId}")
    public List<ClaimEntity> getClaimsByUser(@PathVariable Long userId) {
        return claimService.getClaimsByUser(userId);
    }

    // Only OFFICER can view all claims
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/all")
    public List<ClaimEntity> getAllClaims() {
        return claimService.getAllClaims();
    }

    // Only OFFICER can approve claim
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/approve/{claimId}")
    public int approveClaim(@PathVariable Long claimId) {
        return claimService.approveClaim(claimId);
    }

    // Only OFFICER can reject claim
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/reject/{claimId}")
    public int rejectClaim(@PathVariable Long claimId) {
        return claimService.rejectClaim(claimId);
    }

    // Only OFFICER can process claim payment
    @PreAuthorize("hasRole('OFFICER')")
    @PutMapping("/process-payment/{claimId}")
    public int processClaimPayment(@PathVariable Long claimId) {
        return claimService.processClaimPayment(claimId);
    }

    // Only OFFICER can filter claims
    @PreAuthorize("hasRole('OFFICER')")
    @GetMapping("/status/{status}")
    public List<ClaimEntity> findClaimsByStatus(@PathVariable String status) {
        return claimService.findClaimsByStatus(status);
    }
}