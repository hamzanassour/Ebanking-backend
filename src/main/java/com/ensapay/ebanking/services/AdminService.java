package com.ensapay.ebanking.services;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AdminRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public Admin getByUsername(String username)
    {
        return  adminRepository.findByUsername(username).orElseThrow(
                () -> new NotFoundExcepton("l'agent n'exist pas")
        );
    }

    public void addAdmin(Admin admin)
    {
        if(userRepository.findUserByUsername(admin.getUsername()).isPresent())
        {
            throw new AlreadyexistException("an amdin with the same username already exist");
        }
        if(adminRepository.findByCIN(admin.getCIN()).isPresent())
        {
            throw new AlreadyexistException("admin with the same CIN"+ admin.getCIN()+"already exist");
        }
        admin.setRole("Admin");
        String Crypted_password=admin.getPassword();
        admin.setPassword(new BCryptPasswordEncoder().encode(Crypted_password));
        adminRepository.save(admin);

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
        if(admin.getPassword()!=null )
        {
            String Crypted_password=admin.getPassword();
            updated.setPassword(new BCryptPasswordEncoder().encode(Crypted_password));
        }
        admin.setRole("Admin");

        userRepository.save(admin);
    }



}
