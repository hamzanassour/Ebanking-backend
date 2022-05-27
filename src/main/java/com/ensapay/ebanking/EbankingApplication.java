package com.ensapay.ebanking;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.entities.BackOffice;
import com.ensapay.ebanking.repositories.AgentRepository;
import com.ensapay.ebanking.repositories.BackOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EbankingApplication implements CommandLineRunner {

    //Field injection (for test )


    public static void main(String[] args) {
        SpringApplication.run(EbankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {



    }
}
