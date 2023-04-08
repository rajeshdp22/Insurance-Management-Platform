package com.insumanager.Insurance.Management.repositories;

import com.insumanager.Insurance.Management.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
