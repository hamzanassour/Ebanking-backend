package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface VirementRepository extends JpaRepository<Long, Virement> {


     List<Virement> findAllVirement();

    Optional<Virement> findVirementByDate(LocalDateTime date);


    Optional<Virement> findById(Long id);
}
