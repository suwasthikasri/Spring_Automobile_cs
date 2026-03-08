package com.hexaware.spring_automobile.service.implementation;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.hexaware.spring_automobile.entity.PolicyDocumentEntity;
import com.hexaware.spring_automobile.pojo.PolicyDocument;
import com.hexaware.spring_automobile.repository.PolicyDocumentRepository;

@ExtendWith(MockitoExtension.class)
class PolicyDocumentServiceImplTest {

    @Mock
    private PolicyDocumentRepository documentRepository;

    @InjectMocks
    private PolicyDocumentServiceImpl documentService;

    @Test
    void testGeneratePolicyDocument() {

        PolicyDocument doc = new PolicyDocument();
        doc.setFileName("policy.pdf");
        doc.setFilePath("/documents/policy.pdf");

        int result = documentService.generatePolicyDocument(doc);

        assertEquals(1, result);

        verify(documentRepository, times(1))
                .save(any(PolicyDocumentEntity.class));
    }

    @Test
    void testGetDocumentByProposal() {

        PolicyDocumentEntity entity = new PolicyDocumentEntity();
        entity.setDocumentId(1L);

        when(documentRepository.findByProposalId(1L)).thenReturn(entity);

        PolicyDocumentEntity result = documentService.getDocumentByProposal(1L);

        assertEquals(1L, result.getDocumentId());
    }

    @Test
    void testGetAllDocuments() {

        PolicyDocumentEntity doc1 = new PolicyDocumentEntity();
        PolicyDocumentEntity doc2 = new PolicyDocumentEntity();

        when(documentRepository.findAll()).thenReturn(Arrays.asList(doc1, doc2));

        List<PolicyDocumentEntity> result = documentService.getAllDocuments();

        assertEquals(2, result.size());
    }

    @Test
    void testFindDocumentsByUser() {

        PolicyDocumentEntity doc1 = new PolicyDocumentEntity();
        PolicyDocumentEntity doc2 = new PolicyDocumentEntity();

        when(documentRepository.findDocumentsByUser(1L))
                .thenReturn(Arrays.asList(doc1, doc2));

        List<PolicyDocumentEntity> result = documentService.findDocumentsByUser(1L);

        assertEquals(2, result.size());
    }
}