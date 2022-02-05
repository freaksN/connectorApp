package com.demiconconnectorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemiconConnectorAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemiconConnectorAppApplication.class, args);
    }

}
