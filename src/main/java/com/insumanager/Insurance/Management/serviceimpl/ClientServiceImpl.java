package com.insumanager.Insurance.Management.serviceimpl;

import com.insumanager.Insurance.Management.Dto.ClientDto;
import com.insumanager.Insurance.Management.exceptions.ResourceNotFoundException;
import com.insumanager.Insurance.Management.model.Client;
import com.insumanager.Insurance.Management.repositories.ClientRepository;
import com.insumanager.Insurance.Management.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ClientDto createClient(ClientDto clientDto) {
        Client client = this.dtoToClient(clientDto);
        Client savedUser = this.clientRepository.save(client);
        return this.clientToDto(savedUser);
    }

    @Override
    public ClientDto savedClient(ClientDto clientDto) {
        Client client = this.dtoToClient(clientDto);
        Client savedClient = this.clientRepository.save(client);
        return this.clientToDto(savedClient);
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, Long clientId) {
        Client client1 = this.clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("client","id",clientId));
        client1.setName(clientDto.getName());
        client1.setAddress(clientDto.getAddress());
        client1.setDateOfBirth(clientDto.getDateOfBirth());
        client1.setContactInformation(clientDto.getContactInformation());
        Client updatedClient = this.clientRepository.save(client1);
        ClientDto clientDto1 = this.clientToDto(updatedClient);
        return clientDto1;
    }

    @Override
    public ClientDto getClientById(Long clientId) {
        Client client = this.clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("client","id",clientId));
        return clientToDto(client);
    }

    @Override
    public List<ClientDto> getAllClients() {
        List<Client> clients = this.clientRepository.findAll();
        List<ClientDto>  clientDtos  = clients.stream().map(client -> this.clientToDto(client)).collect(Collectors.toList());
        return clientDtos;
    }

    @Override
    public void deleteClient(Long clientID) {
        Client client = this.clientRepository.findById(clientID).orElseThrow(() -> new ResourceNotFoundException("client","id",clientID));
        this.clientRepository.delete(client);
    }

    @Override
    public boolean findById(Long id) {

        return this.clientRepository.findById(id).isPresent();
    }

    public Client dtoToClient(ClientDto clientDto){
        Client client= this.modelMapper.map(clientDto,Client.class);
        return client;
    }

    public ClientDto clientToDto(Client client){
        ClientDto clientDto= this.modelMapper.map(client,ClientDto.class);
        return clientDto;
    }

}
