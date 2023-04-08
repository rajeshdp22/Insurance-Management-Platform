package com.insumanager.Insurance.Management.utils;

import com.insumanager.Insurance.Management.Dto.ClaimDto;

import java.util.ArrayList;
import java.util.List;

public class ClaimDtoValidation {

    public static List<String> validate(ClaimDto claimDto) {
        List<String> errors = new ArrayList<>();

        if (claimDto.getId() == null) {
            errors.add("Claim number cannot be null");
        } else if (claimDto.getId() <= 0) {
            errors.add("Claim number should be positive");
        }

        if (claimDto.getDescription() == null || claimDto.getDescription().isBlank()) {
            errors.add("Description cannot be blank");
        }

        if (claimDto.getClaimDate() == null) {
            errors.add("Claim date cannot be null");
        }

        if (claimDto.getClaimStatus() == null || claimDto.getClaimStatus().isBlank()) {
            errors.add("Claim status cannot be blank");
        } else if (!claimDto.getClaimStatus().matches("^(ACTIVE|INACTIVE)$")) {
            errors.add("Claim status must be either 'ACTIVE' or 'INACTIVE'");
        }

        return errors;
    }
}

