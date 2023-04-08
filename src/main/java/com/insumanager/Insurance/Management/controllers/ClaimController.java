package com.insumanager.Insurance.Management.controllers;

import com.insumanager.Insurance.Management.Dto.ClaimDto;
import com.insumanager.Insurance.Management.model.Client;
import com.insumanager.Insurance.Management.model.InsurancePolicy;
import com.insumanager.Insurance.Management.repositories.ClientRepository;
import com.insumanager.Insurance.Management.repositories.InsurancePolicyRepository;
import com.insumanager.Insurance.Management.services.ClaimService;
import com.insumanager.Insurance.Management.services.InsurancePolicyService;
import com.insumanager.Insurance.Management.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    ClaimService claimService;



    //create
    @PostMapping("/")
    public ResponseEntity<ClaimDto> creteClaim(@Valid @RequestBody ClaimDto claimDto){
        ClaimDto creteClaimDto = this.claimService.createClaim(claimDto);
        return new ResponseEntity<>(creteClaimDto, HttpStatus.CREATED);
    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<ClaimDto> updateClaim(@Valid @RequestBody ClaimDto claimDto, @PathVariable Long id){
        ClaimDto updatedClaim = this.claimService.updateClaim(claimDto,id);
        return ResponseEntity.ok(updatedClaim);
    }


    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteClaim(@PathVariable Long id){
        this.claimService.deleteClaim(id);
        return new ResponseEntity<>(new ApiResponse(true,"claim deleted successfully"),HttpStatus.OK);
    }

    //get
    @GetMapping("/")
    public ResponseEntity<List<ClaimDto>> getAllClaim(){
        return ResponseEntity.ok(this.claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaimDto> getClaimBYId(@PathVariable Long id){
        return ResponseEntity.ok(this.claimService.getClaimById(id));
    }




}
