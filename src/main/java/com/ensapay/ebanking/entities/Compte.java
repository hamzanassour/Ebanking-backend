package com.ensapay.ebanking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Compte implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  id ;
    private Date createdAt;
    private double balance;
    private String curr;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "compte")
    List<Transaction> transactions;
}
