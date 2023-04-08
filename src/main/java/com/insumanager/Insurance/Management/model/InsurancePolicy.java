package com.insumanager.Insurance.Management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "insurance_policies")
public class InsurancePolicy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policyNumber")
    private Long id;

    private String type;
    private Double coverageAmount;
    private Double premium;
    private Date startDate;
    private Date endDate;

    @OneToMany
    private Set<Claim> claims;


}

