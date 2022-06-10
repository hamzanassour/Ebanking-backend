package com.ensapay.ebanking.services;


import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.exceptions.NotFoundExcepton;
import com.ensapay.ebanking.repositories.AdminRepository;
import com.ensapay.ebanking.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {


    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    public AdminService(AdminRepository adminRepository,UserRepository userRepository)
    {
        this.adminRepository = adminRepository;
        this.userRepository=userRepository;
    }


    public Admin findAdminById(Long id)
    {
        return  adminRepository.findById(id).orElseThrow(
                () -> new NotFoundExcepton("admin doesnt exist")
        );
    }
    public void updateAdmin(Admin admin)
    {
        if(adminRepository.findByUsername(admin.getUsername()).isPresent())
        {
            throw new AlreadyexistException("the username is already exist");
        }
        if(userRepository.findUserByCIN(admin.getCIN()).isPresent())
        {
            throw new AlreadyexistException("an admin with the same cin is already exist");
        }
        admin.setRole("Admin");

        userRepository.save(admin);
    }



}
