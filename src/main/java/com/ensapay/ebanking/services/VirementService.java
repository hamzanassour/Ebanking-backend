package com.ensapay.ebanking.services;

import com.ensapay.ebanking.entities.Compte;
import com.ensapay.ebanking.entities.Virement;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VirementService {

    private final VirementRepository virementRepository;
    private final  CompteService compteService;


    public VirementService(VirementRepository virementRepository,
                           CompteService compteService
                           ) {
        this.virementRepository = virementRepository;
        this.compteService = compteService;
    }

    public List<Virement> getAllVirements(Long id)
    {
        List<Virement> virements=new ArrayList<>();
        if(id!=null)
        {
            try
            {
                virements.add(virementRepository.findById(id).orElseThrow(
                        () -> new NotFoundExcepton("error")
                ));
            }
            catch (NotFoundExcepton e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            virements=virementRepository.findAllVirement();
        }
        return virements;
    }

    public void addVirement(Virement virement)
    {
        Compte debiteur=compteService.gatAllComptes(virement.getDebiteur().getId()).get(0);
        Compte creancier=compteService.gatAllComptes(virement.getDebiteur().getId()).get(0);

    }
}
