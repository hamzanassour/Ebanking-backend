package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface VirementRepository extends JpaRepository<Virement,Long> {


    Optional<Virement> findById(Long aLong);

    Optional<Virement> findVirementByDate_crreation(LocalDateTime date_creation);

}
