package com.ensapay.ebanking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public  class Compte implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPTE")
    Long id;

    @Column(name = "NUMERO_COMPTE", unique = true)
    String numero;

    @Column(name = "SOLDE_COMPTE")
    double solde;
    @Column(name = "CREATION_DATE_COMPTE")
    LocalDateTime creationDate;


    @JoinColumn(name = "PROPRIETAIRE_COMPTE")
    @ManyToOne
    Client proprietaire;

    @JoinColumn(name = "CREATION_AGENT_COMPTE")
    @ManyToOne
    Agent creationAgent;
    @JsonIgnore
    @Column(name = "VIREMENTS_ENVOYES_COMPTE")
    @OneToMany(mappedBy = "debiteur", cascade = CascadeType.ALL)
    List<Virement> Envoyes;


    @JsonIgnore
    @Column(name="VIREMENTS_RECUS_COMPTE")
    @OneToMany(mappedBy="creancier",cascade=CascadeType.ALL)
    List<Virement> Recus;
}