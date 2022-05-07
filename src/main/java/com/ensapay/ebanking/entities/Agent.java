package com.ensapay.ebanking.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Agent {
    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name ;
    private String prenom;
    private String email;
    private  String phone ;

}
