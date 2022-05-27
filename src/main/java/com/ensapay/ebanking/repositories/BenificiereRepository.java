package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Benificiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BenificiereRepository extends JpaRepository<Benificiere,Long> {

}
