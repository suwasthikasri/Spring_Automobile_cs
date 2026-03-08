package com.hexaware.spring_automobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.spring_automobile.entity.PolicyProposalEntity;

@Repository
public interface PolicyProposalRepository extends JpaRepository<PolicyProposalEntity, Long> {

    @Query(value="SELECT * FROM policy_proposals WHERE user_id = ?1", nativeQuery=true)
    List<PolicyProposalEntity> findByUserId(Long userId);

    @Query(value="SELECT * FROM policy_proposals WHERE status = ?1", nativeQuery=true)
    List<PolicyProposalEntity> findProposalsByStatus(String status);

}