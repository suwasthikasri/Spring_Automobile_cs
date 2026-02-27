package com.hexaware.spring_automobile.service.interfacem;

import java.util.List;


import com.hexaware.spring_automobile.entity.InsurancePolicy;
public interface IInsurancePolicyService {
	int addPolicy(InsurancePolicy policy);

    int updatePolicy(InsurancePolicy policy);

    int deletePolicy(Long policyId);

    InsurancePolicy getPolicyById(Long policyId);

    List<InsurancePolicy> getAllPolicies();

    List<InsurancePolicy> getPoliciesByCategory(String category);

}
