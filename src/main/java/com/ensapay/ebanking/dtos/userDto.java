package com.ensapay.ebanking.dtos;


import lombok.Data;

@Data
public class userDto {
    private long id;
    private String nome;
    private String prenom;
    private  String email;
    private String phone;
    private String username;
    private String role;
}
