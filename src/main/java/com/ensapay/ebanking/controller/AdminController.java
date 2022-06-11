package com.ensapay.ebanking.controller;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService)
    {

        this.adminService = adminService;
    }

    @GetMapping("/admins")
    @ResponseStatus(HttpStatus.OK)
    public List<Admin> findAdmins()
    {
        return  adminService.findAllAdmin();
    }






}
