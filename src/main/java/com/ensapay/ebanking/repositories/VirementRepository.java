package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VirementRepository extends JpaRepository<Virement,Long> {
}
