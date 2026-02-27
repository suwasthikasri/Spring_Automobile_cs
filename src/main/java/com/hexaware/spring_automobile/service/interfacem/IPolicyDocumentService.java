package com.hexaware.spring_automobile.service.interfacem;

import com.hexaware.spring_automobile.entity.PolicyDocument;

public interface IPolicyDocumentService 
{
	int generatePolicyDocument(Long proposalId);

    PolicyDocument getDocumentById(Long documentId);

    int sendPolicyDocument(Long documentId);

}
