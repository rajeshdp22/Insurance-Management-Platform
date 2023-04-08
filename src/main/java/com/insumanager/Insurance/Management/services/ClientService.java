package com.insumanager.Insurance.Management.services;

import com.insumanager.Insurance.Management.Dto.ClientDto;
import com.insumanager.Insurance.Management.model.Client;

import java.util.List;

public interface ClientService {

    ClientDto createClient(ClientDto client);

    ClientDto savedClient(ClientDto clientDto);

    ClientDto updateClient(ClientDto client, Long id);
    ClientDto getClientById(Long clientId);
    List<ClientDto> getAllClients();
    void deleteClient(Long clientID);

    boolean findById(Long id);
}
