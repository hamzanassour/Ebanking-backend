package com.ensapay.ebanking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeClient;
    private String nom ;
    private String prenom;
    private String email;
    private String tel ;
    private String adresse;
    @OneToMany(mappedBy = "client")
    List<Compte> comptes ;
    @ManyToOne
    private Agent agent;

}
