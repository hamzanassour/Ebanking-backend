package com.ensapay.ebanking.entities;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public  class Virement {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID_VIREMENT")
    Long id;

    @Column(name = "CODE_VIREMENT")
    String code;

    @JoinColumn(name="CREANCIER_VIREMENT")
    @ManyToOne
    Compte creancier;

    @JoinColumn(name="DEBITEUR_VIREMENT")
    @ManyToOne
    Compte debiteur;

    @Column(name="DATE_VIREMENT")
    LocalDateTime date;

    @Column(name="SOMME_ENV_VIREMENT")
    double sommeEnv;

    @Column(name="SOMME_RECU_VIREMENT")
    double sommeRecu;
}
