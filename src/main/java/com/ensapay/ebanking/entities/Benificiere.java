package com.ensapay.ebanking.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "BENIFICIERE")

public  class Benificiere {
    @Id
    @GeneratedValue
    Long id;
     String nom;
     String penom;

    @ManyToOne
    Client parent;
    String numero;
}
