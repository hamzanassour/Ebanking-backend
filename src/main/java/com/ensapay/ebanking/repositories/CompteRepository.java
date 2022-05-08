package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte , String> {

}
