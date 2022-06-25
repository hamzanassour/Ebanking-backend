package com.ensapay.ebanking.controller;


import com.ensapay.ebanking.entities.Client;
import com.ensapay.ebanking.services.ClientService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Client")
public class ClientController {

    private  final ClientService clientService;


    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Client> findAllAgents()
    {
        return  clientService.findAlClients();
    }

    @GetMapping("/client/{username}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Client getAgentByUsername(@PathVariable("username") String username)
    {
        return  clientService.findClientByUsername(username);
    }

    @GetMapping("/client/{CIN}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Client getClientByCIN(@PathVariable("CIN") String CIN)
    {
        return clientService.findClientByCIN(CIN);
    }

    @PostMapping("/addClient")
    @ResponseStatus(HttpStatus.CREATED)
    public void AddClient(@RequestBody  Client client)
    {
        clientService.addClient(client);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateClient(@PathVariable("id") Long id, @RequestBody Client client ) throws NotFoundException {
        clientService.updateClient(id,client);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable("id") Long id)
    {
        clientService.deleteClient(id);
    }
}
