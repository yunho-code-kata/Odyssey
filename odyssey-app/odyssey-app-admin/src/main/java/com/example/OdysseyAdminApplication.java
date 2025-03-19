package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class OdysseyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(OdysseyAdminApplication.class, args);
    }

}