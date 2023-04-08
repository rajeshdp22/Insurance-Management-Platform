package com.insumanager.Insurance.Management.serviceimpl;

import com.insumanager.Insurance.Management.Dto.ClaimDto;
import com.insumanager.Insurance.Management.exceptions.ResourceNotFoundException;
import com.insumanager.Insurance.Management.model.Claim;
import com.insumanager.Insurance.Management.repositories.ClaimRepository;
import com.insumanager.Insurance.Management.services.ClaimService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClaimServiceImpl implements ClaimService {

    @Autowired
    private ClaimRepository claimRepository;


    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClaimDto createClaim(ClaimDto claimDto) {
        Claim claim1 = this.dtoToClaim(claimDto);
        Claim savedClaim = this.claimRepository.save(claim1);
        return this.claimToDto(savedClaim);
    }

    @Override
    public ClaimDto savedClaim(ClaimDto claimDto) {
        Claim claim = this.dtoToClaim(claimDto);
        Claim savedClaim = this.claimRepository.save(claim);
        return this.claimToDto(savedClaim);
    }

    @Override
    public ClaimDto updateClaim(ClaimDto claimDto, Long claimId) {
        Claim claim = this.claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim","id",claimId));

        claim.setDescription(claimDto.getDescription());
        claim.setClaimDate(claimDto.getClaimDate());
        claim.setClaimStatus(claimDto.getClaimStatus());
        Claim updateClaim = this.claimRepository.save(claim);
        ClaimDto claimDto1 = this.claimToDto(updateClaim);
        return claimDto1;
    }

    @Override
    public ClaimDto getClaimById(Long claimId) {
        Claim claim = this.claimRepository.findById(claimId).orElseThrow(() -> new ResourceNotFoundException("claim","id",claimId));
        return claimToDto(claim);
    }

    @Override
    public List<ClaimDto> getAllClaims() {
        List<Claim> claims = this.claimRepository.findAll();
        List<ClaimDto> claimDtos = claims.stream().map(claim -> this.claimToDto(claim)).collect(Collectors.toList());
        return  claimDtos;
    }

    @Override
    public void deleteClaim(Long claimID) {
        Claim claim = this.claimRepository.findById(claimID).orElseThrow(() -> new ResourceNotFoundException("claim","id",claimID));
        this.claimRepository.delete(claim);
    }

    @Override
    public boolean findById(Long id) {
        return this.claimRepository.findById(id).isPresent();
    }

    public Claim dtoToClaim(ClaimDto claimDto){
        Claim claim = this.modelMapper.map(claimDto,Claim.class);
        return claim;
    }

    public ClaimDto claimToDto(Claim claim){
        ClaimDto claimDto = this.modelMapper.map(claim,ClaimDto.class);
        return claimDto;
    }


}
