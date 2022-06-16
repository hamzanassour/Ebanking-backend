package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.entities.Client;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.ClientRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

public class ClientService {

  private final   UserRepository userRepository;
  private  final  ClientRepository clientRepository;
  private final AgentService agentService;


  @Autowired
    public ClientService(UserRepository userRepository, ClientRepository clientRepository, AgentService agentService) {
        this.userRepository = userRepository;
        this.clientRepository = clientRepository;
        this.agentService = agentService;
  }


    public List<Client> findAlClients()
    {
      return   clientRepository.findAll();

    }

    public Client findClientByUsername(String username)
    {
        return  clientRepository.findClientByUsername(username).orElseThrow(
                ()->new NotFoundExcepton("the client doesn't exist")
        );
    }

    public void addClient(Client client)
    {
        if(!clientRepository.findClientByCIN(client.getCIN()).isPresent())
        {
            throw new AlreadyexistException("a client with the same CIN already exist");
        }
        if(!userRepository.findUserByUsername(client.getUsername()).isPresent())
        {
            throw  new AlreadyexistException("a user with the same username Already exist");
        }
        Agent creator=agentService.findAgentByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        client.setAgent_creator(creator);
        client.setRole("Client");
        clientRepository.save(client);
    }

    public void updateClient(Long id,Client client) throws NotFoundException {

        if(userRepository.findUserByUsername(client.getUsername()).isPresent())
        {
                if(clientRepository.findClientById(id).isPresent())
                {
                    Client toUpdate=clientRepository.getById(id);
                    if(!client.getNom().isEmpty()) toUpdate.setNom(client.getNom());
                    if(!client.getPrenom().isEmpty()) toUpdate.setPrenom(client.getPrenom());
                    if(!client.getUsername().isEmpty()) toUpdate.setUsername(client.getUsername());
                    if(!client.getCIN().isEmpty()) toUpdate.setCIN(client.getCIN());
                    if(!client.getEmail().isEmpty()) toUpdate.setEmail(client.getEmail());
                    if(!client.getTelephone().isEmpty()) toUpdate.setTelephone(client.getTelephone());
                    if(!client.getPassword().isEmpty()) toUpdate.setPassword(new BCryptPasswordEncoder().encode(client.getNom()));
                    if(client.getRole().isEmpty()) toUpdate.setRole("Client");
                    clientRepository.save(toUpdate);


                }
                else
                {
                    throw new NotFoundException("le client n'exist pas");
                }

        }
        else {
            throw  new NotFoundException("user with the username doesn't exist");
        }
    }

    public  void deleteClient(Long id)
    {
        if(clientRepository.findClientById(id).isPresent())
        {
            clientRepository.deleteById(id);
        }
        else {
            throw new NotFoundExcepton("the user u choose doesn't exist");
        }
    }

}
