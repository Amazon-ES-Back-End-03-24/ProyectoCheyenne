package com.ironhack;

import com.ironhack.inventorytool.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class InventoryAppApplication {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(InventoryAppApplication.class, args);
    }

    @Bean
    CommandLineRunner run() {
        return args -> {
            // Eliminar usuarios duplicados si existen
            if (userService.existsByUsername("john")) {
                userService.deleteByUsername("john");
            }
            if (userService.existsByUsername("admin")) {
                userService.deleteByUsername("admin");
            }

            // Registrar nuevos usuarios
            userService.registerUser("john", "password");
            userService.registerUser("admin", "adminpass");
        };
    }
}
