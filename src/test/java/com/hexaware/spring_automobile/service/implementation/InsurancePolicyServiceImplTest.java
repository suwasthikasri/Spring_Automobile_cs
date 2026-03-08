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

import com.hexaware.spring_automobile.entity.InsurancePolicyEntity;
import com.hexaware.spring_automobile.pojo.InsurancePolicy;
import com.hexaware.spring_automobile.repository.InsurancePolicyRepository;

@ExtendWith(MockitoExtension.class)
class InsurancePolicyServiceImplTest {

    @Mock
    private InsurancePolicyRepository policyRepository;

    @InjectMocks
    private InsurancePolicyServiceImpl policyService;

    @Test
    void testAddPolicy() {

        InsurancePolicy policy = new InsurancePolicy();
        policy.setPolicyName("Car Insurance");
        policy.setDescription("Full coverage");
        policy.setBasePremium(5000.0);

        int result = policyService.addPolicy(policy);

        assertEquals(1, result);
        verify(policyRepository, times(1)).save(any(InsurancePolicyEntity.class));
    }

    @Test
    void testGetAllPolicies() {

        InsurancePolicyEntity p1 = new InsurancePolicyEntity();
        InsurancePolicyEntity p2 = new InsurancePolicyEntity();

        when(policyRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        List<InsurancePolicyEntity> result = policyService.getAllPolicies();

        assertEquals(2, result.size());
    }

    @Test
    void testGetPolicyById() {

        InsurancePolicyEntity policy = new InsurancePolicyEntity();
        policy.setPolicyId(1L);

        when(policyRepository.findById(1L)).thenReturn(Optional.of(policy));

        InsurancePolicyEntity result = policyService.getPolicyById(1L);

        assertEquals(1L, result.getPolicyId());
    }

    @Test
    void testActivatePolicy() {

        InsurancePolicyEntity policy = new InsurancePolicyEntity();
        policy.setPolicyId(1L);

        when(policyRepository.findById(1L)).thenReturn(Optional.of(policy));

        int result = policyService.activatePolicy(1L);

        assertEquals(1, result);
        assertTrue(policy.getIsActive());
    }

    @Test
    void testDeactivatePolicy() {

        InsurancePolicyEntity policy = new InsurancePolicyEntity();
        policy.setPolicyId(1L);

        when(policyRepository.findById(1L)).thenReturn(Optional.of(policy));

        int result = policyService.deactivatePolicy(1L);

        assertEquals(1, result);
        assertFalse(policy.getIsActive());
    }

}