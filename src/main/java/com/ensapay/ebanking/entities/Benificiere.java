package com.ensapay.ebanking.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public  class Benificiere {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String penom;
    private int numero;
}
