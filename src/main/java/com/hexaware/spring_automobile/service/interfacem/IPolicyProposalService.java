package com.hexaware.spring_automobile.service.interfacem;

import java.util.List;



import com.hexaware.spring_automobile.entity.PolicyProposal.Status;
import com.hexaware.spring_automobile.entity.PolicyProposal;
public interface IPolicyProposalService 
{

    int submitProposal(PolicyProposal proposal);

    PolicyProposal getProposalById(Long proposalId);

    List<PolicyProposal> getProposalsByUser(Long userId);

    int approveProposal(Long proposalId);

    int rejectProposal(Long proposalId);

    int requestAdditionalInfo(Long proposalId, String message);

    int updateProposalStatus(Long proposalId, Status status);
}
