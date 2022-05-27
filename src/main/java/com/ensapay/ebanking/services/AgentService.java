package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    @Autowired
    AgentRepository agentRepository;


    public List<Agent> findAllAgents()
    {
        return agentRepository.findAll();
    }

    public Optional<Agent> findAgentById(Long Id)
    {
        return agentRepository.findAgentById(Id);
    }

    public Optional<Agent> findAgentByUsername(String username)
    {
        return agentRepository.findAgentByUsername(username);
    }



}
