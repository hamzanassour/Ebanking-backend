package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AgentRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgentService {


   private final AgentRepository agentRepository;
   private final UserRepository userRepository;

   private  final  AdminService adminService;


    public AgentService(AgentRepository agentRepository, UserRepository userRepository, AdminService adminService, AdminService adminService1) {
        this.agentRepository = agentRepository;
        this.userRepository = userRepository;

        this.adminService = adminService1;
    }

    public List<Agent> findAllAgents()
    {
        return agentRepository.findAll();
    }

    public Agent findAgentById(Long Id)
    {
        return agentRepository.findAgentById(Id).orElseThrow(
                () -> new NotFoundExcepton("this agent doesn't exist")
        );
    }

    public Agent findAgentByUsername(String username)
    {
        return agentRepository.findAgentByUsername(username).orElseThrow(
                () -> new NotFoundExcepton("this agent doesn't exist")
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
       Admin creator=adminService.getByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
       agent.setBackoffice_creator(creator);
       agentRepository.save(agent);
    }

    public void updateAgent(Long id,Agent agent)
    {
        Agent updated=agentRepository.findAgentById(id).orElseThrow(
                ()->new NotFoundExcepton("Agent not found")
        );
        if(agentRepository.findAgentByUsername(agent.getUsername()).isPresent())
        {
            throw  new AlreadyexistException("this username is already taken");
        }
        if(!agent.getNom().isEmpty()) updated.setNom(agent.getNom());
        if(!agent.getPrenom().isEmpty()) updated.setPrenom(agent.getPrenom());
        if(!agent.getUsername().isEmpty()) updated.setCIN(agent.getCIN());
        if(!agent.getUsername().isEmpty()) updated.setUsername(agent.getUsername());
        if(!agent.getEmail().isEmpty() )   updated.setEmail(agent.getEmail());
        if(!agent.getTelephone().isEmpty()) updated.setTelephone(agent.getTelephone());
        if(!agent.getPassword().isEmpty())  updated.setPassword(new BCryptPasswordEncoder().encode(agent.getPassword()));
        updated.setRole("Admin");
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
