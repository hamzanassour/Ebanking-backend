package com.ensapay.ebanking.controller;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Admin")
public class AdminController {


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

    @PostMapping("/add-admin")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAdmin(@RequestBody Admin admin)
    {
        adminService.addAdmin(admin);
    }

    @PostMapping("/update/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateAdmin(@PathVariable("id") Long id,@RequestBody Admin admin)
    {
        adminService.updateAdmin(id,admin);
    }


    @GetMapping("/find/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Admin findAdminByUsername(@PathVariable("username") String username)
    {
        return  adminService.getByUsername(username);
    }










}
