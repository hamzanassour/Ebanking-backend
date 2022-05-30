package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {

    @Autowired
    AgentRepository agentRepository;


    public List<Agent> findAllAgents()
    {
        return agentRepository.findAll();
    }

    public Agent findAgentById(Long Id)
    {
        return agentRepository.findAgentById(Id).orElseThrow(
                () -> new NotFoundExcepton("this agent n'exist pas")
        );
    }

    public Agent findAgentByUsername(String username)
    {
        return agentRepository.findAgentByUsername(username).orElseThrow(
                () -> new NotFoundExcepton("this agnet doesnt exist")
        );
    }

    public void updateAgent(Long id,Agent agent)
    {
        if(agentRepository.findAgentByUsername(agent.getUsername()).isPresent())
        {
            throw new AlreadyexistException("this agent with the id ", id, "all ready exist");
        }
        if(agentRepository.findAgentByCIN(agent.getCIN()).isPresent())
        {
            throw new AlreadyexistException("this agent with the CIN ", agent.getCIN(), "all ready exist");
        }

        String password= agent.getPassword();
        agent.setPassword(new BCryptPasswordEncoder().encode(agent.getPassword()));
        agent.setRole("Agent");
    }



}
