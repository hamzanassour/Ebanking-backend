package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.BackOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BackOfficeRepository extends JpaRepository<BackOffice,Long> {

    Optional<BackOffice> findByUsername(String username);
    Optional<BackOffice> findById(Long Id);

    Optional<BackOffice> findByEmail(String email);
}
