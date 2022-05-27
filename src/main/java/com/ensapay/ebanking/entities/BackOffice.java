package com.ensapay.ebanking.entities;

import lombok.*;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
}
