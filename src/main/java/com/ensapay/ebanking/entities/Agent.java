package com.ensapay.ebanking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="AGENT")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID_AGENT")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM_AGENT")),
        @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_AGENT")),
        @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_AGENT")),
        @AttributeOverride(name = "CIN", column = @Column(name = "CIN_AGENT")),
        @AttributeOverride(name = "email", column = @Column(name = "EMAIL_AGENT")),
        @AttributeOverride(name = "username", column = @Column(name = "USERNAME_AGENT")),
        @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_AGENT")),
        @AttributeOverride(name = "role", column = @Column(name = "ROLE_AGENT"))
})


public @Data class Agent extends user {

    @ManyToOne
    @JsonIgnore
    Admin Backoffice_creator;

    @OneToMany(mappedBy = "agent_creator")
    List<Client> Clients;


}
