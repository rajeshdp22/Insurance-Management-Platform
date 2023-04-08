package com.insumanager.Insurance.Management.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@NoArgsConstructor
@Getter
@Setter
public class InsurancePolicyDto {

    @Column(name = "policy_number")
    @Positive(message = "number should be positive")
    private Long id;

    @NotEmpty
    private String type;
    @NotNull
    private Double coverageAmount;

    @NotNull
    private Double premium;

    @NotNull
    @PastOrPresent(message = "Start date must be in the past or present")
    private Date startDate;
    @NotNull
    @FutureOrPresent(message = "End date must be in the future or present")
    private Date endDate;
}
