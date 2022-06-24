package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.entities.Client;
import com.ensapay.ebanking.entities.Compte;
import com.ensapay.ebanking.entities.Virement;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class CompteService {

    private final CompteRepository compteRepository;
    private final  ClientService clientService;
    private  final AgentService agentService;


    public CompteService(CompteRepository compteRepository, ClientService clientService, AgentService agentService) {
        this.compteRepository = compteRepository;
        this.clientService = clientService;
        this.agentService = agentService;
    }



    public List<Compte> gatAllComptes(Long id)
    {
        List<Compte> client_comptes= new ArrayList<>();

        if(id!=null)
        {
                   client_comptes.add( compteRepository.findById(id)
                           .orElseThrow(()
                           -> new NotFoundExcepton("compte dont exist")));
        }
        else {
            client_comptes=compteRepository.findAll();
        }
        return  client_comptes;
    }

    public Compte findCompteBynumero(String numero)
    {
        if(!numero.isEmpty())
        {
            return  compteRepository.findByNumero(numero).orElseThrow(
                    ()-> new NotFoundExcepton("the account you chosen doesnt exist")
            );
        }
        else {
            return null;
        }
    }

    public List<Virement> virementsEnvoyer(Long id)
    {


        if(id!=null)
        {
            return  compteRepository.findById(id).orElseThrow(
                    ()-> new NotFoundExcepton("the account doesnt exist")
            ).getEnvoyes();
        }
        else {
            throw  new NotFoundExcepton("there is no sent virment");
        }
    }

    public List<Virement> virementsRecus(Long id)
    {


        if(id!=null)
        {
            return  compteRepository.findById(id).orElseThrow(
                    ()-> new NotFoundExcepton("the account doesnt exist")
            ).getRecus();
        }
        else {
            throw  new NotFoundExcepton("there is no recu virment");
        }
    }


    public void addCompte(Compte compte,String CIN)
    {
        if(compteRepository.findByNumero(compte.getNumero()).isPresent()) throw  new AlreadyexistException("this account is al");
        Client proprietaire=clientService.findClientByCIN(CIN);
        Agent creator=agentService.findAgentByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        compte.setCreationAgent(creator);
        compte.setProprietaire(proprietaire);
        compte.setNumero( generateAcountNumber());
        compte.setCreationDate(LocalDateTime.now());


        compteRepository.save(compte);

    }

    public  void updateCompteSolde(Long id, double new_Solde)
    {
        Compte to_update=compteRepository.findById(id).orElseThrow( () -> new NotFoundExcepton("the account doesnt exist"));

        to_update.setSolde(to_update.getSolde()+new_Solde);

        compteRepository.save(to_update);

    }


    public void removeAcount(Long id)
    {
        Compte to_remove=compteRepository.findById(id).orElseThrow( ()-> new NotFoundExcepton("the account doesnt exist"));

        compteRepository.delete(to_remove);
    }



    public String generateAcountNumber()
    {
        String start = "07";
        Random value = new Random();

        //Generate two values to append to 'BE'
        int r1 = value.nextInt(10);
        int r2 = value.nextInt(10);
        start += Integer.toString(r1) + Integer.toString(r2) + " ";

        int count = 0;
        int n = 0;
        for(int i =0; i < 12;i++)
        {
            if(count == 4)
            {
                start += " ";
                count =0;
            }
            else
                n = value.nextInt(10);
            start += Integer.toString(n);
            count++;

        }
        return start;
    }




}
