package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AgentRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {


   private final AgentRepository agentRepository;
   private final UserRepository userRepository;


    public AgentService(AgentRepository agentRepository, UserRepository userRepository, AdminService adminService) {
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;

    }

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

    public void AddAgent(Agent agent)
    {
       if(userRepository.findUserByUsername(agent.getUsername()).isPresent())
       {
           throw new AlreadyexistException("this username is already taken");
       }
       if(agentRepository.findAgentByCIN(agent.getCIN()).isPresent())
       {
           throw new AlreadyexistException("agent already exist");
       }

       agentRepository.save(agent);
    }

    public void updateAgent(Long id,Agent agent)
    {
        Agent updated=agentRepository.findAgentById(id).orElseThrow(
                ()->new NotFoundExcepton("Agent not found")
        );
        if(agentRepository.findAgentByUsername(agent.getUsername()).isPresent())
        {
            throw  new AlreadyexistException("the username you selected already exist ");
        }
        if(!agent.getNom().isEmpty()) updated.setNom(agent.getNom());
        if(!agent.getPrenom().isEmpty()) updated.setPrenom(agent.getPrenom());
        if(!agent.getUsername().isEmpty()) updated.setCIN(agent.getCIN());
        if(!agent.getUsername().isEmpty()) updated.setUsername(agent.getUsername());
        if(!agent.getEmail().isEmpty() )   updated.setEmail(agent.getEmail());
        if(!agent.getTelephone().isEmpty()) updated.setTelephone(agent.getTelephone());
        if(!agent.getPassword().isEmpty())  updated.setPassword(agent.getPassword());



        agentRepository.save(updated);

    }

    public void deleteAgent(Long id)
    {
        Agent agent_to_delete=agentRepository.findAgentById(id).orElseThrow(
                () -> new NotFoundExcepton("the agent not exist already")
        );
        agentRepository.deleteAgentById(id);
    }



}
