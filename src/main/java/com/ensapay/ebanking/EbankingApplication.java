package com.ensapay.ebanking;

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
