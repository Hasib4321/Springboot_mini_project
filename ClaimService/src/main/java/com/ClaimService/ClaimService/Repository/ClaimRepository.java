package com.ClaimService.ClaimService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ClaimService.ClaimService.model.Claim;


public interface ClaimRepository extends JpaRepository<Claim,Long>{



}
