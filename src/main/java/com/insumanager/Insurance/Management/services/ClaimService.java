package com.insumanager.Insurance.Management.services;

import com.insumanager.Insurance.Management.Dto.ClaimDto;

import java.util.List;

public interface ClaimService {

    ClaimDto createClaim(ClaimDto claim);

    ClaimDto savedClaim(ClaimDto claimDto);

    ClaimDto updateClaim(ClaimDto client, Long id);
    ClaimDto getClaimById(Long claimId);
    List<ClaimDto> getAllClaims();
    void deleteClaim(Long claimID);
    boolean findById(Long id);
}
