package com.ensapay.ebanking;

import com.ensapay.ebanking.entities.Agent;
import com.ensapay.ebanking.repositories.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EbankingApplication implements CommandLineRunner {

    //Field injection (for test )
    //@Autowired
    //AgentRepository agentRepository;

    public static void main(String[] args) {
        SpringApplication.run(EbankingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


       // test par hajar & hamza
       //agentRepository.save(new Agent(null , "hamza" , "nassour" , "fghdjkjhgdhihd" , "ghdiykjfhak" ));


    }
}
