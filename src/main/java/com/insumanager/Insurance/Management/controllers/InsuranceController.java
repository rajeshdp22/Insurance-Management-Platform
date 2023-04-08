package com.insumanager.Insurance.Management.controllers;


import com.insumanager.Insurance.Management.Dto.InsurancePolicyDto;
import com.insumanager.Insurance.Management.model.Claim;
import com.insumanager.Insurance.Management.model.Client;
import com.insumanager.Insurance.Management.model.InsurancePolicy;
import com.insumanager.Insurance.Management.repositories.ClaimRepository;
import com.insumanager.Insurance.Management.repositories.InsurancePolicyRepository;
import com.insumanager.Insurance.Management.services.InsurancePolicyService;
import com.insumanager.Insurance.Management.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/policies")
@RestController
public class InsuranceController {

    @Autowired
    private InsurancePolicyService insurancePolicyService;

    @Autowired
    private InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    private ClaimRepository claimRepository;

    @GetMapping("/")
    public ResponseEntity<List<InsurancePolicy>> getAllPolicies(){
        List<InsurancePolicy> insurancePolicies = insurancePolicyRepository.findAll();
        return ResponseEntity.ok(insurancePolicies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InsurancePolicy> getInsurancePolicyById(@PathVariable Long id){
        Optional<InsurancePolicy> insurancePolicy = insurancePolicyRepository.findById(id);
        return ResponseEntity.ok(insurancePolicy.get());
    }

    @PostMapping("/")
        public ResponseEntity<InsurancePolicyDto> creteInsurancePolicy(@Valid @RequestBody InsurancePolicyDto insurancePolicyDto){
        InsurancePolicyDto creteInsurance = this.insurancePolicyService.createInsurancePolicy(insurancePolicyDto);
        return new ResponseEntity<>(creteInsurance, HttpStatus.CREATED);
    }

    //put
    @PutMapping("/{id}")
    public ResponseEntity<InsurancePolicyDto> updateInsurancePolicy(@Valid @RequestBody InsurancePolicyDto insurancePolicyDto,@PathVariable Long id){
        InsurancePolicyDto updatePolicy = this.insurancePolicyService.updateInsurancePolicy(insurancePolicyDto,id);
        return ResponseEntity.ok(updatePolicy);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deletePolicy(@PathVariable Long id){
        this.insurancePolicyService.deleteClient(id);
        return new ResponseEntity<>(new ApiResponse(true,"policy deleted successfully"),HttpStatus.OK);
    }


    @PutMapping("/addclaims/{policyId}/{claimId}")
    public ResponseEntity<Map<String,String>> purchasePolicy(@PathVariable("policyId") Long policyId, @PathVariable("claimId") Long claimId){
        Map<String,String> response = new HashMap<>();
        Optional<InsurancePolicy> policyCheck = insurancePolicyRepository.findById(policyId);
        if(policyCheck.isPresent()){
            Optional<Claim> claim = claimRepository.findById(claimId);
            if(claim.isPresent()){
                Set<Claim> clamSet = new HashSet<>();
                clamSet.add(claim.get());
                InsurancePolicy insurancePolicy = policyCheck.get();
                insurancePolicy.setClaims(clamSet);
                insurancePolicyRepository.save(insurancePolicy);
                response.put("Status","Success");
                response.put("Message","Claim added Successfully");
            }else {
                response.put("Status","Failure");
                response.put("Message","Claim id is not valid");
            }

        }else {
            response.put("Status","Failure");
            response.put("Message","Policy id is not valid");
        }
        return ResponseEntity.ok(response);
    }





}
