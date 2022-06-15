package com.ensapay.ebanking;

import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EbankingApplication implements CommandLineRunner {

    //Field injection (for test )
    @Autowired
    AdminService adminService;

    public static void main(String[] args) {
        SpringApplication.run(EbankingApplication.class, args);
    }




   // Creating a default admin
    public void init()
    {



            Admin admin = new Admin();
            admin.setUsername("admin");
            admin.setNom("admin");
            admin.setCIN("");
            admin.setEmail("ensapay@gmail.com");
            admin.setPrenom("admin");
            admin.setTelephone("0500000000");
            admin.setRole("Admin");
            admin.setPassword("Admin");
            adminService.addAdmin(admin);

    }
    @Override
    public void run(String... args) throws Exception {
        if(adminService.findAllAdmin().isEmpty())
        {
            init();
        }
    }
}
