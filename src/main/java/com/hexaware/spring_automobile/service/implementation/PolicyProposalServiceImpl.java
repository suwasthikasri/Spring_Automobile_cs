package com.hexaware.spring_automobile.service.implementation;

import java.util.List;

import com.hexaware.spring_automobile.entity.PolicyProposal;
import com.hexaware.spring_automobile.entity.PolicyProposal.Status;
import com.hexaware.spring_automobile.service.interfacem.IPolicyProposalService;


public class PolicyProposalServiceImpl implements IPolicyProposalService {

	@Override
	public int submitProposal(PolicyProposal proposal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PolicyProposal getProposalById(Long proposalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PolicyProposal> getProposalsByUser(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int approveProposal(Long proposalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int rejectProposal(Long proposalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int requestAdditionalInfo(Long proposalId, String message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateProposalStatus(Long proposalId, Status status) {
		// TODO Auto-generated method stub
		return 0;
	}

}
