package com.ensapay.ebanking.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public   abstract class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nom;
    String prenom;
    String telephone;
    String email;

    String CIN;
    @Column(unique=true,nullable=false)
    String username;
    @Column(nullable=false)
    String password;
    @Column(nullable=false)
    String role;

}
