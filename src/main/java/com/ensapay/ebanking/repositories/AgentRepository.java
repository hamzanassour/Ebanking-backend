package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent , Long> {


    Optional<Agent> findAgentById(Long Id);

    Optional<Agent> findAgentByEmail(String email);
    Optional<Agent> findAgentByUsername(String username);

    Optional<Agent> findAgentByCIN(String CIN);


}
