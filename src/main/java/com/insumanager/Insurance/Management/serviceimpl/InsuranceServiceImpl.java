package com.insumanager.Insurance.Management.serviceimpl;

import com.insumanager.Insurance.Management.Dto.InsurancePolicyDto;
import com.insumanager.Insurance.Management.exceptions.ResourceNotFoundException;
import com.insumanager.Insurance.Management.model.InsurancePolicy;
import com.insumanager.Insurance.Management.repositories.InsurancePolicyRepository;
import com.insumanager.Insurance.Management.services.InsurancePolicyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImpl implements InsurancePolicyService {

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public InsurancePolicyDto createInsurancePolicy(InsurancePolicyDto insurancePolicyDto) {
        InsurancePolicy insurancePolicy1 = this.dtoToInsurancePolicy(insurancePolicyDto);
        InsurancePolicy savedPolicy = this.insurancePolicyRepository.save(insurancePolicy1);
        return this.insurancePolicyToDto(savedPolicy);
    }

    @Override
    public InsurancePolicyDto savedInsurance(InsurancePolicyDto insurancePolicyDto){
        InsurancePolicy insurancePolicy = this.dtoToInsurancePolicy(insurancePolicyDto);
        InsurancePolicy savedPolicy = this.insurancePolicyRepository.save(insurancePolicy);
        return this.insurancePolicyToDto(savedPolicy);
    }



    @Override
    public InsurancePolicyDto updateInsurancePolicy(InsurancePolicyDto insurancePolicyDto, Long policyId)
    {
        InsurancePolicy insurancePolicy1 = this.insurancePolicyRepository.findById(policyId).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy","id",policyId));
        insurancePolicy1.setType(insurancePolicyDto.getType());
        insurancePolicy1.setCoverageAmount(insurancePolicyDto.getCoverageAmount());
        insurancePolicy1.setPremium(insurancePolicyDto.getPremium());
        insurancePolicy1.setStartDate(insurancePolicyDto.getStartDate());
        insurancePolicy1.setEndDate(insurancePolicyDto.getEndDate());
        InsurancePolicy updatePolicy = this.insurancePolicyRepository.save(insurancePolicy1);
        InsurancePolicyDto insurancePolicyDto1 = this.insurancePolicyToDto(updatePolicy);
        return insurancePolicyDto1;
    }

    @Override
    public InsurancePolicyDto getInsurancePolicyByID(Long policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy","id",policyId));
        return insurancePolicyToDto(insurancePolicy);
    }

    @Override
    public List<InsurancePolicyDto> getAllInsurancePolicies() {
        List<InsurancePolicy> insurancePolicies = this.insurancePolicyRepository.findAll();
        List<InsurancePolicyDto> insurancePolicyDtos = insurancePolicies.stream().map(insurancePolicy -> this.insurancePolicyToDto(insurancePolicy)).collect(Collectors.toList());
        return insurancePolicyDtos;
    }

    @Override
    public void deleteClient(Long policyId) {
        InsurancePolicy insurancePolicy = this.insurancePolicyRepository.findById(policyId).orElseThrow(() -> new ResourceNotFoundException("insurancePolicy","id",policyId));
        this.insurancePolicyRepository.delete(insurancePolicy);
    }

    @Override
    public boolean findById(Long id) {

        return this.insurancePolicyRepository.findById(id).isPresent();
    }
    public InsurancePolicy dtoToInsurancePolicy(InsurancePolicyDto insurancePolicyDto){
        InsurancePolicy insurancePolicy = this.modelMapper.map(insurancePolicyDto,InsurancePolicy.class);
        return insurancePolicy;
    }

    public InsurancePolicyDto insurancePolicyToDto(InsurancePolicy insurancePolicy){
        InsurancePolicyDto insurancePolicyDto = this.modelMapper.map(insurancePolicy,InsurancePolicyDto.class);
        return insurancePolicyDto;
    }


}
