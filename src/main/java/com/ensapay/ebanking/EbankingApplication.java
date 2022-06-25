package com.ensapay.ebanking;

import com.ensapay.ebanking.entities.Admin;
import com.ensapay.ebanking.exceptions.AlreadyexistException;
import com.ensapay.ebanking.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class EbankingApplication  {

    //Field injection (for test )

    AdminService adminService;

    public static void main(String[] args) {
        SpringApplication.run(EbankingApplication.class, args);
    }




   // Creating a default admin


}
