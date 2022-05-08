package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {

}
