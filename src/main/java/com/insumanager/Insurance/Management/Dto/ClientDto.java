package com.insumanager.Insurance.Management.Dto;

import com.insumanager.Insurance.Management.model.InsurancePolicy;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Set;


@NoArgsConstructor
@Setter
@Getter
public class ClientDto {

    private Long id;

    @NotEmpty
    @Size(min=4,message = "name should be above 4 chars")
    private String name;
    private Date dateOfBirth;
    @NotEmpty
    private String address;
    @NotEmpty
    @Size(min=10,max = 10,message = "contact number should be 10 digits")
    private String contactInformation;


}
