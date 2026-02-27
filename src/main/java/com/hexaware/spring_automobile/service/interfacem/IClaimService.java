package com.hexaware.spring_automobile.service.interfacem;

import java.util.List;

import com.hexaware.spring_automobile.entity.Claim;

import com.hexaware.spring_automobile.entity.Claim.ClaimStatus;
import com.hexaware.spring_automobile.entity.Claim;
public interface IClaimService {
	int fileClaim(IClaimService claim);
    Claim getClaimById(Long claimId);
    List<Claim> getClaimsByUser(Long userId);
    int approveClaim(Long claimId);
    int rejectClaim(Long claimId);
    int updateClaimStatus(Long claimId, ClaimStatus status);

}
