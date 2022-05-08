package com.ensapay.ebanking.entities;

import com.ensapay.ebanking.help.TypeTransaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Date dateOperation ;
    private double montant;
    private TypeTransaction type;
    @ManyToOne
    Compte compte;

}
