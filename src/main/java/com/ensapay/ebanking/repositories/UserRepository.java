package com.ensapay.ebanking.repositories;

import com.ensapay.ebanking.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long> {

    Optional<AppUser> findUserByUsername(String username);

    Optional<AppUser> findUserByCIN(String CIN);
}
