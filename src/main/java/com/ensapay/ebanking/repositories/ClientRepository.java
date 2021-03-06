package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


    Optional<Client> findClientById(Long Id);
    Optional<Client> findClientByUsername(String username);
    Optional<Client> findClientByCIN(String cin);



}
