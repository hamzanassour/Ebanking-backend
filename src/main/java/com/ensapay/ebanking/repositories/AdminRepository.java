package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByUsername(String username);
    Optional<Admin> findById(Long Id);
    Optional<Admin> findByCIN(String CIN);
}
