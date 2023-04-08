package com.insumanager.Insurance.Management.services;

import com.insumanager.Insurance.Management.Dto.ClientDto;
import com.insumanager.Insurance.Management.Dto.InsurancePolicyDto;

import java.util.List;

public interface InsurancePolicyService {


    InsurancePolicyDto createInsurancePolicy(InsurancePolicyDto insurancePolicy);

    InsurancePolicyDto savedInsurance(InsurancePolicyDto insurancePolicyDto);

    InsurancePolicyDto updateInsurancePolicy(InsurancePolicyDto insurancePolicy, Long id);
    InsurancePolicyDto getInsurancePolicyByID(Long insurancePolicyId);
    List<InsurancePolicyDto> getAllInsurancePolicies();
    void deleteClient(Long insurancePolicyId);

    boolean findById(Long id);

}
