package com.hexaware.spring_automobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hexaware.spring_automobile.entity.ClaimEntity;
@Repository
public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {

    @Query(value = "SELECT * FROM claims WHERE user_id = ?1", nativeQuery = true)
    List<ClaimEntity> findClaimsByUser(Long userId);

    @Query(value = "SELECT * FROM claims WHERE claim_status = ?1", nativeQuery = true)
    List<ClaimEntity> findClaimsByStatus(String status);

    @Query(value = "SELECT * FROM claims WHERE proposal_id = ?1", nativeQuery = true)
    List<ClaimEntity> findClaimsByProposal(Long proposalId);
}