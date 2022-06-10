package com.ensapay.ebanking.controller;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private final AdminService backofficeService;

    public AdminController(AdminService backofficeService)
    {

        this.backofficeService = backofficeService;
    }






}
