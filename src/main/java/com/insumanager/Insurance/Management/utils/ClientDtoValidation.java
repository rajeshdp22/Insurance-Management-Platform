package com.insumanager.Insurance.Management.utils;

import com.insumanager.Insurance.Management.Dto.ClientDto;

import java.util.ArrayList;
import java.util.List;

public class ClientDtoValidation {

    public static List<String> validate(ClientDto clientDto) {
        List<String> errors = new ArrayList<>();

        if (clientDto.getName() == null || clientDto.getName().isEmpty()) {
            errors.add("Name cannot be empty");
        } else if (clientDto.getName().length() < 4) {
            errors.add("Name should be at least 4 characters long");
        }

        if (clientDto.getAddress() == null || clientDto.getAddress().isEmpty()) {
            errors.add("Address cannot be empty");
        }

        if (clientDto.getContactInformation() == null || clientDto.getContactInformation().isEmpty()) {
            errors.add("Contact information cannot be empty");
        } else if (clientDto.getContactInformation().length() != 10) {
            errors.add("Contact information should be 10 digits long");
        }

        return errors;
    }
}

