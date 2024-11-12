package com.cakecafe.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cakecafe.backend.repository")
@EntityScan(basePackages = "com.cakecafe.backend.model")
public class CakeCafeBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CakeCafeBackendApplication.class, args);
    }

}
