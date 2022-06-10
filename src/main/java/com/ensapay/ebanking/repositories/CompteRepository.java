package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CompteRepository extends JpaRepository<Compte , String> {

    Optional<Compte> findByNumero(String numero);

    void deleteCompteByNumero(String numero);
}
