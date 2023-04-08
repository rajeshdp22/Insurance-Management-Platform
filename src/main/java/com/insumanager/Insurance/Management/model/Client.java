package com.insumanager.Insurance.Management.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
@Table(name = "clients")
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name ="client_name")
    private String name;
    private Date dateOfBirth;
    private String address;
    private String contactInformation;

    @OneToMany
    private Set<InsurancePolicy> insurancePolicies;


}