package com.insumanager.Insurance.Management.repositories;

import com.insumanager.Insurance.Management.model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {
}
