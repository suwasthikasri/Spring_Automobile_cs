package com.hexaware.spring_automobile.service.implementation;

import java.util.List;


import com.hexaware.spring_automobile.entity.Claim;
import com.hexaware.spring_automobile.entity.Claim.ClaimStatus;

import  com.hexaware.spring_automobile.service.interfacem.IClaimService;
public class ClaimServiceImpl implements IClaimService {

	@Override
	public int fileClaim(IClaimService claim) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Claim getClaimById(Long claimId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Claim> getClaimsByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveClaim(Long claimId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rejectClaim(Long claimId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateClaimStatus(Long claimId, ClaimStatus status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
