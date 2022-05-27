package com.ensapay.ebanking.services;


import com.ensapay.ebanking.entities.BackOffice;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.BackOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BackofficeService {

    @Autowired
    BackOfficeRepository backOfficeRepository;


    public Optional<BackOffice> findBackofficeByUserName(String username)
    {
        return Optional.ofNullable(
                backOfficeRepository.findByUsername(username).orElseThrow(
                        () -> new NotFoundExcepton("ce utilisateure n'existe pas")
                )
        );
    }

    public Optional<BackOffice> findBackofficeByEmail(String email)
    {
        return Optional.ofNullable(
                backOfficeRepository.findByEmail(email).orElseThrow(
                        ()->new NotFoundExcepton("ce utilisateur deja exist")
                )
        );
    }
}
