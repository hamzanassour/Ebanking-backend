package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<user,Long> {

    Optional<user> findUserByUsername(String username);

    Optional<user> findUserByCIN(String CIN);
}
