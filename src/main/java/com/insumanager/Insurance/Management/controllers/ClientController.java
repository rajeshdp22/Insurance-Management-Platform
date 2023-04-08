package com.insumanager.Insurance.Management.controllers;


import com.insumanager.Insurance.Management.Dto.ClientDto;
import com.insumanager.Insurance.Management.model.Client;
import com.insumanager.Insurance.Management.model.InsurancePolicy;
import com.insumanager.Insurance.Management.repositories.ClientRepository;
import com.insumanager.Insurance.Management.repositories.InsurancePolicyRepository;
import com.insumanager.Insurance.Management.services.ClientService;
import com.insumanager.Insurance.Management.utils.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequestMapping("/api/clients")
@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    InsurancePolicyRepository insurancePolicyRepository;

    @Autowired
    ClientRepository clientRepository;

    //post
    @PostMapping("/")
    public ResponseEntity<ClientDto> creteClient(@Valid @RequestBody ClientDto clientDto){
        ClientDto creteClientDto = this.clientService.createClient(clientDto);
        return new ResponseEntity<>(creteClientDto, HttpStatus.CREATED);
    }
    //put
    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> updateClient(@Valid @RequestBody ClientDto clientDto, @PathVariable Long id){
        ClientDto updatedUser = this.clientService.updateClient(clientDto,id);
        return ResponseEntity.ok(updatedUser);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteClient(@PathVariable Long id){
        this.clientService.deleteClient(id);
        return new ResponseEntity<>(new ApiResponse(true,"client deleted successfully"),HttpStatus.OK);
        }

    //get
    @GetMapping("/")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientBYId(@PathVariable Long id){
                Optional<Client> client = clientRepository.findById(id);
        return ResponseEntity.ok(client.get());
    }

    @PutMapping("/policypurchase/{clientID}/{policyId}")
    public ResponseEntity<Map<String,String>> purchasePolicy(@PathVariable("clientID") Long clientID, @PathVariable("policyId") Long policyId){
        Map<String,String> response = new HashMap<>();
        Optional<Client> clientCheck = clientRepository.findById(clientID);
        if(clientCheck.isPresent()){
            Optional<InsurancePolicy> insurancePolicy = insurancePolicyRepository.findById(policyId);
            if(insurancePolicy.isPresent()){
                Set<InsurancePolicy> insurancePoliciesSet = new HashSet<>();
                insurancePoliciesSet.add(insurancePolicy.get());
                Client client = clientCheck.get();
                client.setInsurancePolicies(insurancePoliciesSet);
                clientRepository.save(client);
                response.put("Status","Success");
                response.put("Message","Policy purchase Successfully");
            }else {
                response.put("Status","Failure");
                response.put("Message","Policy id is not valid");
            }

        }else {
            response.put("Status","Failure");
            response.put("Message","Client id is not valid");
        }
        return ResponseEntity.ok(response);
    }
}
