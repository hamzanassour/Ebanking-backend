package com.ensapay.ebanking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="CLIENT")
@Getter
@Setter
@NoArgsConstructor

@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID_CLIENT")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM_CLIENT")),
        @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_CLIENT")),
        @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_CLIENT")),
        @AttributeOverride(name = "CIN", column = @Column(name = "CIN_AGENT")),
        @AttributeOverride(name = "email", column = @Column(name = "EMAIL_CLIENT")),
        @AttributeOverride(name = "username", column = @Column(name = "USERNAME_CLIENT")),
        @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_CLIENT")),
        @AttributeOverride(name = "role", column = @Column(name = "ROLE_CLIENT"))
})
public  class Client extends AppUser {

    @JsonIgnore
    @Column(name="COMPTES_CLIENT")
    @OneToMany(mappedBy="proprietaire",cascade=CascadeType.ALL)
    List<Compte> comptes;

    @JsonIgnore
    @ManyToOne
    Agent agent_creator;



    @JsonIgnore
    @Column(name="COMPTES_BENEFICIAIRE")
    @OneToMany(mappedBy="parent")
    List<Benificiere> beneficiaires;

}
