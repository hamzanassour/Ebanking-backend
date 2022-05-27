package com.ensapay.ebanking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface Benificiere extends JpaRepository<Benificiere,Long> {
    Optional<Benificiere> findBenificiereByid();
    void deleteBenificiereByid();
}
