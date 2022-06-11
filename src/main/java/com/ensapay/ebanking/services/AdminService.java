package com.ensapay.ebanking.services;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AdminRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public AdminService(AdminRepository adminRepository,UserRepository userRepository)
    {
        this.adminRepository = adminRepository;
        this.userRepository=userRepository;
    }


    public List<Admin> findAllAdmin()
    {
        return adminRepository.findAll();
    }


    public Admin findAdminById(Long id)
    {
        return  adminRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepton("admin doesnt exist")
        );
    }
    public void updateAdmin(Long id,Admin admin)
    {
        Admin updated= adminRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepton("the admin you trying to update doesnt exist")
        );


        if(userRepository.findUserByUsername(admin.getCIN()).isPresent())
        {
            throw new AlreadyexistException("an admin with the same username is already exist");
        }

        if(admin.getNom()!=null ) updated.setNom(admin.getNom());
        if(admin.getPrenom()!=null  ) updated.setPrenom(admin.getPrenom());
        if(admin.getCIN()!=null  ) updated.setCIN(admin.getCIN());
        if(admin.getTelephone()!=null ) updated.setTelephone(admin.getTelephone());
        if(admin.getUsername()!=null ) updated.setUsername(admin.getUsername());
        if(admin.getEmail()!=null ) updated.setEmail(admin.getEmail());
        if(admin.getPassword()!=null ) updated.setPassword(admin.getPassword());
        admin.setRole("Admin");

        userRepository.save(admin);
    }



}
