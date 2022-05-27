package com.ensapay.ebanking.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "ID_BACKOFFICE")),
        @AttributeOverride(name = "nom", column = @Column(name = "NOM_BACKOFFICE")),
        @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_BACKOFFICE")),
        @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_BACKOFFICE")),
        @AttributeOverride(name = "email", column = @Column(name = "EMAIL_BACKOFFICE")),
        @AttributeOverride(name = "username", column = @Column(name = "USERNAME_BACKOFFICE")),
        @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_BACKOFFICE")),
        @AttributeOverride(name = "role", column = @Column(name = "ROLE_BACKOFFICE"))
})


public  class BackOffice extends user {

    @JsonIgnore
    @OneToMany(mappedBy = "Backoffice_creator")
    List<Agent> Agents;
}
