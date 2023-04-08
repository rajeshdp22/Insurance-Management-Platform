package com.insumanager.Insurance.Management.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;

@NoArgsConstructor
@Setter
@Getter
public class ClaimDto {

    private Long id;

    @NotBlank(message = "Description cannot be blank")
    @Size(min=5,message = "description must be 10 characters")
    private String description;

    @NotNull
    @PastOrPresent(message = "Start date must be in the past or present")
    private Date claimDate;


    @NotBlank(message = "Claim status cannot be blank")
    @Pattern(regexp = "(Pending|Approved|Denied)", message = "Claim status must be one of: Pending, Approved, Denied")
    private String claimStatus;


}
